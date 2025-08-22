import java.util.ArrayList;

public class BankTest {
    public static void main(String[] args) {
        BankAccount A = new BankAccount() ;
        ArrayList<Thread> t = new ArrayList<>();
        int Num_Depositor = 3;
        int Num_Withdrawer = 0;
        int Value = 1;
        int Round = 10000;

        for (int i = 0; i < Num_Depositor; i++) {
            Thread x = new Thread(new Depositor(A, Value, Round));
            t.add(x);
        }

        for (int i = 0; i < Num_Withdrawer; i++) {
            Thread y = new Thread(new Withdrawer(A, Value, Round));
            t.add(y);
        }

        for (Thread thread : t) {
            thread.start();
        }

        try {
            for (Thread thread : t) {
            thread.join();
        }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Final balance : " + A.getBalance());
        System.out.println("Exeption value : " + ((Num_Depositor - Num_Withdrawer) * Value * Round));
    }
}
