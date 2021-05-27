package myatm;

import javax.swing.*;
import java.util.ArrayList;
public class MyATM {
    
    String vuid;
        int pin;
        String op;
                        
      private DbHelper dbhelper;
       private DebitCard debitCard;

    public static void main(String[] args) {
        
        MyATM m = new MyATM();
    }
    
     MyATM() // this the main class constructor 
        {
             dbhelper = new DbHelper();
         debitCard = new DebitCard();

  
            this.initLoginGUI();
        }
     
   public void  initLoginGUI()
   {
               this.vuid = JOptionPane.showInputDialog(null, "Welcom to My ATM \n Please Enter your CardNO:"); //Get user input on the textfield as a String
               this.pin = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter PIN"));     
   
               String vid= null;
               int pi=0;
               ArrayList<DebitCard> data = DbHelper.loadData();
               
               for(DebitCard c : data)
               {
                   vid=c.getCardNo();
                   pi=c.getPin();
               }
               
               if(vuid.equals (vid) && pin ==pi)
                   
               {
                   initServicesGUI();
               }
               else 
               {
                                 JOptionPane.showMessageDialog(null, "Invalid Card or Pin number please Reenter");
                                 
                                initLoginGUI();
               }
               
   }
   
   public void depositAmoount()
   {
       String inp = (JOptionPane.showInputDialog(null,"Please Enter amoutn to deposit\n Amount must be multiple of 500 and limit 500 to 25000"));
long am = Long.parseLong(inp);
String card; int pin; long bal;
if((am %500 ==0) && (am<=25000))
{
   ArrayList<DebitCard> data = DbHelper.loadData();
               
               for(DebitCard c : data)
               {
                   card=c.getCardNo();
                   pin=c.getPin();
                   bal = c.getBalance();
                   bal +=am;
                   DbHelper.savedata(card, pin, bal);
              JOptionPane.showMessageDialog(null, "$" + am + " has  been deposited ");
 
               }                    
    
}
else
{
                  JOptionPane.showMessageDialog(null,"Invalid Amount or amount must range of 500 to 25000");

}
        
   }
   
   public void cashWithdraw() 
   
   { 
   String inp = (JOptionPane.showInputDialog(null, "Please Enter amoutn to Withdraw \n Amount must be multiple of 500 and limit 500 to 25000"));
long am = Long.parseLong(inp);
    
String card; int pin; long bal;
if((am %500 ==0) && (am <=25000))
{
   ArrayList<DebitCard> data = DbHelper.loadData();
               
               for(DebitCard c : data)
               {
                   card=c.getCardNo();
                   pin=c.getPin();
                   bal = c.getBalance();
                   if (am<=bal){
                   bal -=am;
                   DbHelper.savedata(card, pin, bal);
              JOptionPane.showMessageDialog(null, "$" + am + " has  been withdraw ");
 
   
   }
                   else if (am>bal)
                   {
                    JOptionPane.showMessageDialog(null, "Your Balance is Insufficient");

                   }
                      
                       
               }
}
else              
{  
                    JOptionPane.showMessageDialog(null, "invalid ammount");
                      cashWithdraw(); 
}
   
   }
  public void  initServicesGUI()
  {
      boolean flag = false;
      while(!flag)
      {
      this.op = (JOptionPane.showInputDialog(null, "Please Enter \n 1. Deposit Amount\n 2. Withdraw Cash\n 3. Check Balance \n 4. Exit the Program"));
      if (op == null)
      {
          flag = true;
      }
      else
      {
          
          int n =0;
          try
          {
              n = Integer.parseInt(op);
            
          }
          catch(NumberFormatException ex)
          {              JOptionPane.showMessageDialog(null, ex);

              
          }
      
          
      switch (n)
      {
          case 1:
              this.depositAmoount();
              break;
              case 2:
              this.cashWithdraw();
              break;
              case 3:
              this.checkBalance();
              break;
              case 4:
                  showDeveloperInfo();
              flag =true;
              break;
              default:
           JOptionPane.showMessageDialog(null, "Invalid option inputed");

      }
  }
      }
  }
   public void checkBalance()
   {
   
    ArrayList<DebitCard> data = DbHelper.loadData();
               long bal=0;
               for(DebitCard c : data)
               {
                   bal = c.getBalance();
               }
               JOptionPane.showMessageDialog(null, "Your Balance is : " + bal);

   
   }
   
   
   public void showDeveloperInfo() {     JOptionPane.showMessageDialog(null, "Develope By: KAMRAN SAIF");  
} 
   
   
   
}
