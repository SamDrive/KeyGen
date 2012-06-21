

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Create a new JFrame.
 * 
 * @author Hesse D.
 * @version 0.1
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
   static TextField sysTF;
   static TextField keyLengthTF;
   static JTextField keyTF;
   /**
    * Constructor. Setup the window items.
    * 
    */
   public MainFrame()
   {
      super("Key generator");
      JFrame.setDefaultLookAndFeelDecorated(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setJMenuBar(new MyMenuBar(this));

      JPanel panel = new JPanel();
      JPanel northPanel = new JPanel();
      JPanel formPanel = new JPanel();
      JPanel inputPanel = new JPanel();
      keyTF = new JTextField();
      sysTF = new TextField();
      keyLengthTF = new TextField();
      
      panel.setLayout(new BorderLayout(5, 5));
      formPanel.setLayout(new BorderLayout(2,5));
      inputPanel.setLayout(new GridLayout(2, 2));
      northPanel.setLayout(new BorderLayout());
      
      northPanel.add(new JLabel("Dein neuer Key:"), BorderLayout.NORTH);
      northPanel.add(keyTF, BorderLayout.SOUTH); //key.createKey()

      
      inputPanel.add(new JLabel("Zahlensystem (Zahlen):"));
      inputPanel.add(sysTF);
      inputPanel.add(new JLabel("Key Länge (Zahlen):"));
      inputPanel.add(keyLengthTF);

      formPanel.add(northPanel, BorderLayout.NORTH);
      formPanel.add(inputPanel, BorderLayout.SOUTH);
      panel.add(formPanel, BorderLayout.CENTER);
      
      panel.add(new GenButton(), BorderLayout.SOUTH);
      
      add(panel);
   }
   
   /**
    * Return the "Zahlensystem".
    * 
    * @return
    *       Zahlensystem
    */
   public static String getZahlenSystem()
   {
      return sysTF.getText();
   }
   
   /**
    * Return the key length.
    * 
    * @return
    *       Key länge
    */
   public static String getLength()
   {
      return keyLengthTF.getText();
   }
   
   /**
    * Set the Key.
    * 
    * @param key
    *           Neuer Schlüssel
    */
   public static void setKey(String key)
   {
      keyTF.setText(key);
   }
}
