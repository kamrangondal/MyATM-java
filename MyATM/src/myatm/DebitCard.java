
package myatm;

public class DebitCard {
    
    private String  cardNo;
    private int pin;
   private long balance ;

   public DebitCard() // default constructor
   {
       
   }
   
   public DebitCard(String s, int p, long b ) // parametrized constructor
   {
       cardNo=s;
       pin = p;
       balance = b;
   }
   public DebitCard(DebitCard dc ) // copy constructor
   {
       this.cardNo=dc.cardNo;
       this.pin = dc.pin;
       this.balance = dc.balance;
   }
   
   
   public String getCardNo() {
        return cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getPin() {
        return pin;
    }

   
    public void setPin(int pin) {
        this.pin = pin;
    }

    
    public long getBalance() {
        return balance;
    }

        public void setBalance(long balance) {
        this.balance = balance;
    }
   
   
    
}
