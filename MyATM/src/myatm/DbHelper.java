
package myatm;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class DbHelper {
    
     final static String FILE_NAME="d:\\COMPUTER SCIENCE\\Projects\\semester3\\abc.txt";
     public static ArrayList<DebitCard> loadData()
{
ArrayList<DebitCard> lst = new ArrayList();
String token[] = null;
String vuid,vupin,vubalance;
try 
{
    FileReader fr = new FileReader(FILE_NAME);  //Creation of File Reader object
      BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
       String s=br.readLine();
       token=s.split(",");  //Split the word using comma
        vuid=token[0];
        vupin = token[1];
        vubalance = token[2];
        
        // typecasting string to int 
        
        
        int rpin=Integer.parseInt(vupin);
        long rbal=Long.parseLong(vubalance);
        
        DebitCard card=new DebitCard(vuid,rpin,rbal);
        
        lst.add(card);
        
        br.close();
        fr.close();
}
  catch(IOException e)
  {
     JOptionPane.showMessageDialog(null,e);
  }
  return lst;
}
        public static void savedata(String id, int p, long b)
    {
        try
        {
            String mod= id + "," + p + "," + b;
            File file= new File (FILE_NAME);
            file.delete();
            FileWriter write =new FileWriter(FILE_NAME);
            write.write(mod);
            write.close();
        }
        catch(IOException e)
        {
               JOptionPane.showMessageDialog(null,e);
  
            
        }
    }
}
