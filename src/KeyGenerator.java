package server_keygen;

import java.util.Random;

/**
 * Generate a new Key.
 * 
 * @author Hesse D. Edited by Alex Wang
 * @version 1.0
 */
public class KeyGenerator
{

   private int n = 0; // l�nge des Strings.
   private int zsys = 0; // zahlensystem (Auch a-z m�glich (36)
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
    * Creates the new Key.
    * 
    * @return String with generated key
    */
   public final String createKey()
   {
      StringBuffer buf = new StringBuffer();
      for (int i = 0; i <= n - 1; ++i)
      {
         buf.append(Integer.toString(r.nextInt(zsys), zsys).toUpperCase());
      }
      return buf.toString();

   }
   
   /**
    * Set the "number system".
    * 
    * @param sys
    *           number system.
    */
   public final void setZahlenSys(int sys)
   {
      zsys = sys;
   }
   
   /**
    * Set the length of the new key.
    * 
    * @param len
    *           length
    */
   public final void setLength(int len)
   {
      n = len;
   }

}
