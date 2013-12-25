package KeyGen;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Creates a new JFrame.
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
      super("Key Generator");
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
      
      northPanel.add(new JLabel("Generated key:"), BorderLayout.NORTH);
      northPanel.add(keyTF, BorderLayout.SOUTH); //key.createKey()

      //TODO: Drop down menu
      inputPanel.add(new JLabel("Number system (Base Number):"));
      inputPanel.add(sysTF);
      inputPanel.add(new JLabel("Key length:"));
      inputPanel.add(keyLengthTF);

      formPanel.add(northPanel, BorderLayout.NORTH);
      formPanel.add(inputPanel, BorderLayout.SOUTH);
      panel.add(formPanel, BorderLayout.CENTER);
      
      panel.add(new CopyButton(), BorderLayout.SOUTH);
      panel.add(new GenButton(), BorderLayout.EAST);
      
      add(panel);
   }
   
   /**
    * Return the "number system".
    * 
    * @return
    *       number system
    */
   public static String getZahlenSystem()
   {
      return sysTF.getText();
   }
   
   /**
    * Return the key length.
    * 
    * @return
    *       key length
    */
   public static String getLength()
   {
      return keyLengthTF.getText();
   }
   
   /**
    * Sets the Key.
    * 
    * @param key
    *           New key
    */
   public static void setKey(String key)
   {
      keyTF.setText(key);
   }
   
   public static String getKey()
   {
       return keyTF.getText();
   }
}
