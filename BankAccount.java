public class BankAccount {
    private long balance = 0;   

    public void deposit(long amount){
        synchronized(this){
            balance += amount ;
        }
    } 

    public void withdraw(long amount){
        if (balance >= amount) {
            synchronized(this){
                balance -= amount;
            }
           
        }
    }

    public long getBalance(){
        return balance;
    }
}