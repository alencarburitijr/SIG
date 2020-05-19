/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sig.util;

/**
 *
 * @author ALENCAR
 */

//Code from: http://www.orbital-computer.de/JComboBox/
/*
Inside JComboBox: adding automatic completion

Author: Thomas Bierhance
         thomas@orbital-computer.de
*/

import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.lang.reflect.Field;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class S20BinaryLookup extends PlainDocument {
     JComboBox comboBox;
     ComboBoxModel model;
     JTextComponent editor;
     // flag to indicate if setSelectedItem has been called
     // subsequent calls to remove/insertString should be ignored
     boolean selecting= false ;
     boolean hidePopupOnFocusLoss;
     boolean hitBackspace= false ;
     boolean hitBackspaceOnSelection;

     public S20BinaryLookup ( final JComboBox comboBox ) {
         this .comboBox = comboBox;
         model = comboBox.getModel () ;
         editor = ( JTextComponent ) comboBox.getEditor () .getEditorComponent () ;
         editor.setDocument ( this ) ;
         comboBox.addActionListener ( new ActionListener () {
             public void actionPerformed ( ActionEvent e ) {
                 if ( !selecting ) highlightCompletedText ( 0 ) ;
             }
         }) ;
         editor.addKeyListener ( new KeyAdapter () {
             public void keyPressed ( KeyEvent e ) {
                 if ( comboBox.isDisplayable ()) comboBox.setPopupVisible ( true ) ;
                 hitBackspace= false ;
                 switch ( e.getKeyCode ()) {
                     // determine if the pressed key is backspace (needed by the remove method)
                     case KeyEvent.VK_BACK_SPACE : hitBackspace= true ;
                     hitBackspaceOnSelection=editor.getSelectionStart () !=editor.getSelectionEnd () ;
                     break ;
                     // ignore delete key
                     case KeyEvent.VK_DELETE : e.consume () ;
                     comboBox.getToolkit () .beep () ;
                     break ;
                 }
             }
         }) ;
         // Bug 5100422 on Java 1.5: Editable JComboBox won't hide popup when tabbing out
         hidePopupOnFocusLoss=System.getProperty ( "java.version" ) .startsWith ( "1.5" ) ;
         // Highlight whole text when gaining focus
         editor.addFocusListener ( new FocusAdapter () {
             public void focusGained ( FocusEvent e ) {
                 highlightCompletedText ( 0 ) ;
             }
             public void focusLost ( FocusEvent e ) {
                 // Workaround for Bug 5100422 - Hide Popup on focus loss
                 if ( hidePopupOnFocusLoss ) comboBox.setPopupVisible ( false ) ;
             }
         }) ;
         setPrototypeValue () ;
         // Handle initially selected object
         Object selected = comboBox.getSelectedItem () ;
         if ( selected!= null ) setText ( selected.toString ()) ;
         highlightCompletedText ( 0 ) ;
     }

     public void setPrototypeValue () {
         JList list = getListBox () ;
         setPrototypeValue ( getPrototypeValue ( list ) , list ) ;
     }

     void setPrototypeValue ( Object value, JList list ) {
         comboBox.setPrototypeDisplayValue ( value ) ;
         list.setPrototypeCellValue ( value ) ;
     }

     Object getPrototypeValue ( JList list ) {
         Object prototypeValue= null ;
         double prototypeWidth= 0 ;
         ListCellRenderer renderer = comboBox.getRenderer () ;
         for ( int i= 0 , n=model.getSize () ; i<n; i++ ) {
             Object value = model.getElementAt ( i ) ;
             java.awt.Component c = renderer.getListCellRendererComponent ( list, value, i, false, false ) ;
             double width = c.getPreferredSize () .getWidth () ;
             if ( width>prototypeWidth ) {
                 prototypeWidth=width;
                 prototypeValue=value;
             }
         }
         return prototypeValue;
     }

     JList getListBox () {
         JList listBox;
         try {
             Field field = JComponent. class .getDeclaredField ( "ui" ) ;
             field.setAccessible ( true ) ;
             BasicComboBoxUI ui = ( BasicComboBoxUI ) field.get ( comboBox ) ;
             field = BasicComboBoxUI. class .getDeclaredField ( "listBox" ) ;
             field.setAccessible ( true ) ;
             listBox = ( JList ) field.get ( ui ) ;
         } catch ( NoSuchFieldException nsfe ) {
             throw new RuntimeException ( nsfe ) ;
         } catch ( IllegalAccessException iae ) {
             throw new RuntimeException ( iae ) ;
         }
         return listBox;
     }

     public void remove ( int offs, int len ) throws BadLocationException {
         // return immediately when selecting an item
         if ( selecting ) return ;
         if ( hitBackspace ) {
             // user hit backspace => move the selection backwards
             // old item keeps being selected
             if ( offs> 0 ) {
                 if ( hitBackspaceOnSelection ) offs--;
             } else {
                 // User hit backspace with the cursor positioned on the start => beep
                 comboBox.getToolkit () .beep () ; // when available use: UIManager.getLookAndFeel().provideErrorFeedback(comboBox);
             }
             highlightCompletedText ( offs ) ;
         } else {
             super .remove ( offs, len ) ;
         }
     }

     public void insertString ( int offs, String str, AttributeSet a ) throws BadLocationException {
         // return immediately when selecting an item
         if ( selecting ) return ;
         // insert the string into the document
         super .insertString ( offs, str, a ) ;
         // lookup and select a matching item
         Object item = lookupItem ( getText ( 0 , getLength ())) ;
         if ( item != null ) {
             setSelectedItem ( item ) ;
         } else {
             // keep old item selected if there is no match
             item = comboBox.getSelectedItem () ;
             // imitate no insert (later on offs will be incremented by str.length(): selection won't move forward)
             offs = offs-str.length () ;
             // provide feedback to the user that his input has been received but can not be accepted
             comboBox.getToolkit () .beep () ; // when available use: UIManager.getLookAndFeel().provideErrorFeedback(comboBox);
         }
         setText ( item.toString ()) ;
         // select the completed part
         highlightCompletedText ( offs+str.length ()) ;
     }

     private void setText ( String text ) {
         try {
             // remove all text and insert the completed string
             super .remove ( 0 , getLength ()) ;
             super .insertString ( 0 , text, null ) ;
         } catch ( BadLocationException e ) {
             throw new RuntimeException ( e.toString ()) ;
         }
     }

     private void highlightCompletedText ( int start ) {
         editor.setCaretPosition ( getLength ()) ;
         editor.moveCaretPosition ( start ) ;
     }

     private void setSelectedItem ( Object item ) {
         selecting = true ;
         model.setSelectedItem ( item ) ;
         selecting = false ;
     }

     private Object binaryLookup ( String pattern ) {
         int bottom= 0 , top=model.getSize () - 1 ;
         int pos= 0 ;
         Object item= null ;
         // search for a matching item
         while ( bottom<=top ) {
             pos = ( bottom + top ) >> 1 ;
             item=model.getElementAt ( pos ) ;
             int compare = compareStartIgnoreCase ( item.toString () , pattern ) ;
             if ( compare== 0 ) {
                 break ;
             } else if ( compare> 0 ) {
                 bottom=pos+ 1 ;
             } else {
                 top=pos- 1 ;
             }
         }
         // if no item matches bottom is greater than top
         if ( bottom>top ) return null ;
         // search for the _first_ matching item
         for ( int i=bottom; i<pos; i++ ) {
             Object anItem=model.getElementAt ( i ) ;
             if ( startsWithIgnoreCase ( anItem.toString () , pattern )) {
                 return anItem;
             }
         }
         return item;
     }

     private Object lookupItem ( String pattern ) {
         Object selectedItem = model.getSelectedItem () ;
         // only search for a different item if the currently selected does not match
         if ( selectedItem != null && startsWithIgnoreCase ( selectedItem.toString () , pattern )) {
             return selectedItem;
         }
         Object item = binaryLookup ( pattern ) ;
         return item;
     }

     // checks if str1 starts with str2 - ignores case
     private boolean startsWithIgnoreCase ( String str1, String str2 ) {
         return str1.toUpperCase () .startsWith ( str2.toUpperCase ()) ;
     }

     private static int compareStartIgnoreCase ( String str1, String str2 ) {
         char [] ch1 = str1.toCharArray () ;
         char [] ch2 = str2.toCharArray () ;
         for ( int i= 0 , n=ch2.length<ch1.length?ch2.length:ch1.length; i<n; i++ ) {
             int diff = Character.toUpperCase ( ch2 [ i ]) -Character.toUpperCase ( ch1 [ i ]) ;
             if ( diff != 0 ) {
                 return diff;
             }
         }
         if ( ch1.length<ch2.length ) return 1 ;
         return 0 ;
     }

     private static void createAndShowGUI () {
         // the combo box (add/modify items if you like to)
         JComboBox comboBox = new JComboBox ( new Object [] { "Ester" , "Jordi" , "Jordina" , "Jorge" , "Sergi" }) ;
         // has to be editable
         comboBox.setEditable ( true ) ;
         // change the editor's document
         new S20BinaryLookup ( comboBox ) ;

         // create and show a window containing the combo box
         JFrame frame = new JFrame () ;
         frame.setDefaultCloseOperation ( 3 ) ;
         frame.getContentPane () .add ( comboBox ) ;
         frame.pack () ; frame.setVisible ( true ) ;
     }


     public static void main ( String [] args ) {
         javax.swing.SwingUtilities.invokeLater ( new Runnable () {
             public void run () {
                 createAndShowGUI () ;
             }
         }) ;
     }
}



    
