

import javax.swing.SwingUtilities;

/**
 * Main for the KeyGen.
 * 
 * @author Hesse D.
 * @version 0.1, 21.02.2012, 22:18
 */
public class Main
{
   /**
    * Main.
    * 
    * @param args
    *           Argumente.
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            MainFrame frame = new MainFrame();

            frame.setSize(420, 181);
            frame.setVisible(true);
         }
      });
      
   }

}
