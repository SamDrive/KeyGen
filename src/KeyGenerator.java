
import java.util.Random;

/**
 * Generate a new Key.
 * 
 * @author Hesse D.
 * @version 1.0
 */
public class KeyGenerator
{

   private int n = 0; // länge des Strings.
   private int zsys = 0; // zahlensystem (Auch a-z möglich (36)
   private Random r = new Random();

   /**
    * Constructor.
    * 
    * @param length
    *           Length of the Key.
    * @param zSys
    *           Number system.
    */
   public KeyGenerator(int length, int zSys)
   {
      if (length <= 1)
      {
         throw new IllegalArgumentException("Key length is too short!");
      }
      else if (zSys < 1)
      {
         throw new IllegalArgumentException("Number system is too small!");
      }
      n = length;
      zsys = zSys;
   }

   /**
    * Create the new Key.
    * 
    * @return String with generated key
    */
   public final String createKey()
   {
      StringBuffer buf = new StringBuffer();
      for (int i = 0; i <= n - 1; ++i)
      {
         buf.append(Integer.toString(r.nextInt(zsys), zsys));
      }
      return buf.toString();

   }
   
   /**
    * Set the "Zahlensystem".
    * 
    * @param sys
    *           zahlensystem.
    */
   public final void setZahlenSys(int sys)
   {
      zsys = sys;
   }
   
   /**
    * Set the length of the new key.
    * 
    * @param len
    *           Länge.
    */
   public final void setLength(int len)
   {
      n = len;
   }

}
