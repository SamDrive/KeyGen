import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * The Menu for the Windowbar.
 * 
 * 
 * @author Hesse D.
 * @version 0.1
 */
@SuppressWarnings("serial")
public class MyMenuBar extends JMenuBar
{

   private JMenuBar menu;

   private JMenu datei;

   private JMenuItem exit;

   private JMenu design;

   private JMenuItem designList; // evtl. anpassen

   private JMenu hilfe;

   private JMenuItem info;

   private Action exitAction;

   private Action hilfAction;

   private Action infoAction;

   private Action designAction;

   /**
    * Constructor.
    * 
    * @param frame
    *           main frame
    */
   public MyMenuBar(JFrame frame)
   {
      JMenu datei = new JMenu("File");
      JMenu hilf = new JMenu("Help");

      add(datei);
      add(new LaFMenu(frame));
      hilf.add(hilfAction = new HilfAction());
      hilf.add(infoAction = new InfoAction());
      add(hilf);

      datei.add(new ExitAction());

   }

   /**
    * Action for the "Design" Menu.
    * 
    * @author Hesse D.
    * @version 0.1
    */
   private class LaFMenu extends JMenu
   {
      public LaFMenu(final JFrame lookandfeelframe)
      {
         super("Design");
         for (final LookAndFeelInfo lookandfeelinfo : UIManager
               .getInstalledLookAndFeels())
         {
            add(new AbstractAction(lookandfeelinfo.getName())
            {
               @Override
               public void actionPerformed(ActionEvent ae)
               {
                  try
                  {
                     UIManager.setLookAndFeel(lookandfeelinfo.getClassName());
                     SwingUtilities.updateComponentTreeUI(lookandfeelframe);
                  }
                  catch (UnsupportedLookAndFeelException e)
                  {
                     JOptionPane.showMessageDialog(lookandfeelframe,
                           e.toString(), e.getClass().toString(),
                           JOptionPane.ERROR_MESSAGE);
                     // handle exception
                  }
                  catch (ClassNotFoundException e)
                  {
                     JOptionPane.showMessageDialog(lookandfeelframe,
                           e.toString(), e.getClass().toString(),
                           JOptionPane.ERROR_MESSAGE);
                     // handle exception
                  }
                  catch (InstantiationException e)
                  {
                     JOptionPane.showMessageDialog(lookandfeelframe,
                           e.toString(), e.getClass().toString(),
                           JOptionPane.ERROR_MESSAGE);
                     // handle exception
                  }
                  catch (IllegalAccessException e)
                  {
                     JOptionPane.showMessageDialog(lookandfeelframe,
                           e.toString(), e.getClass().toString(),
                           JOptionPane.ERROR_MESSAGE);
                     // handle exception
                  }
               }
            });
         }
      }

   }

   /**
    * Action for the "Exit" Menuitem.
    * 
    * @author Hesse D.
    * @version 0.1
    */
   private final class ExitAction extends AbstractAction
   {
      private ExitAction()
      {
         putValue(Action.NAME, "Exit");
         putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(
               KeyEvent.VK_Q, Toolkit.getDefaultToolkit()
                     .getMenuShortcutKeyMask()));
      }

      @Override
      public void actionPerformed(ActionEvent arg0)
      {
         System.exit(0);
      }
   }

   /**
    * Action for the "Info" Menuitem.
    * 
    * @author Hesse D.
    * @version 0.1
    */
   private final class HilfAction extends AbstractAction
   {
      private HilfAction()
      {
         putValue(Action.NAME, "Info");
         putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(
               KeyEvent.VK_I, Toolkit.getDefaultToolkit()
                     .getMenuShortcutKeyMask()));
      }

      @Override
      public void actionPerformed(ActionEvent arg0)
      {
         JOptionPane.showMessageDialog(getRootPane(),
               "Create by: Hesse Dominik\n" + "Version: 0.1");
      }
   }

   /**
    * Action for the "Info" Menuitem.
    * 
    * @author Hesse D.
    * @version 0.1
    */
   private final class InfoAction extends AbstractAction
   {
      private InfoAction()
      {
         putValue(Action.NAME, "Help");
         putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(
               KeyEvent.VK_H, Toolkit.getDefaultToolkit()
                     .getMenuShortcutKeyMask()));
      }

      @Override
      public void actionPerformed(ActionEvent arg0)
      {
         JOptionPane.showMessageDialog(getRootPane(),
               "Number system: in progress\n"
                     + "Key length: How long is the new key.\n");
      }
   }

}
