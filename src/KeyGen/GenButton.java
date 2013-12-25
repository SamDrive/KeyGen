package server_keygen;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * Generator Button
 * 
 * @author Hesse D.
 * @version 0.1
 */
@SuppressWarnings("serial")
public class GenButton extends JButton
{
   private Action genAction;

   /**
    * Constructor.
    * 
    */
   public GenButton()
   {
      setAction(genAction = new GenerateAction());
   }

   /**
    * Action for the "Generate" button.
    * 
    * @author Hesse D.
    * @version 0.1
    */
   public final class GenerateAction extends AbstractAction
   {
      private GenerateAction()
      {
         putValue(Action.NAME, "Generate Key...");
         putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(
               KeyEvent.VK_ENTER, Toolkit.getDefaultToolkit()
                     .getMenuShortcutKeyMask()));
      }

      @Override
      public void actionPerformed(ActionEvent arg0)
      {
        /* if (MainFrame.getLength().length() == 0
               || MainFrame.getZahlenSystem().length() == 0)
         {
            // throw new IllegalArgumentException("Zu wenig Argumente!");
            JOptionPane.showMessageDialog(getRootPane(),
                  "Need more Input(number system/length)!", "Error!",
                  JOptionPane.ERROR_MESSAGE);
         }*/
          if (MainFrame.getLength().length() == 0)
          {
            JOptionPane.showMessageDialog(getRootPane(),
                    "Key Length is invalid/empty!", "Error!",
                    JOptionPane.ERROR_MESSAGE);
          }
         else if (MainFrame.getZahlenSystem().length() == 0)
         {
             JOptionPane.showMessageDialog(getRootPane(),
                    "Number System is invalid/empty!", "Error!",
                    JOptionPane.ERROR_MESSAGE);
         }
         else
         {
            try
            {
               int length = Integer.parseInt(MainFrame.getLength());
               int zahlensys = Integer.parseInt(MainFrame.getZahlenSystem());
               KeyGenerator key = new KeyGenerator(length, zahlensys);
               MainFrame.setKey(key.createKey());
            }
            catch (Exception e)
            {
               JOptionPane.showMessageDialog(getRootPane(), e.toString(), e
                     .getClass().toString(), JOptionPane.ERROR_MESSAGE);
            }
         }

      }
   }
}
