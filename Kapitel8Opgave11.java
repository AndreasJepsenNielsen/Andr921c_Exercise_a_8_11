import java.util.Scanner;
public class Kapitel8Opgave11 {

    /*
    Add a field to the BankAccount class named transactionFee for a real number representing an amount of money
to deduct every time the user withdraws money. The default value is $0.00, but the client can change the value.
Deduct the transaction fee money during every withdraw call (but not from deposits). Make sure that the balance
cannot go negative during a withdrawal. If the withdrawal (amount plus transaction fee) would cause it to become
negative, don’t modify the balance at all.
     */
    public static void main(String[] args) {
        BankAccount bank = new BankAccount("Andreas Jepsen Nielsen", 100, 0.00);
        BankAccount bank2 = new BankAccount("Lukas Nielsen", 250, 0.00);

          bank.withdraw(0); // fjern kommentar for at teste withdraw

        //  System.out.println(bank); // fjernkommentar for at teste tostring

        // bank.transfer(bank2,120); // fjernkommentar for at teste transfer
    }


    public static class BankAccount {
        Scanner sc = new Scanner(System.in);
        String name;
        double balance = 100;
        double transacionFee = 0.00;

        public void deposit(double amount) {
            balance = balance + amount;
        }

        // withdraw = kapitel 8 opgave 11
        public void withdraw(double amount) {
            System.out.println("Please enter withdraw amount");
            amount = sc.nextDouble();
            System.out.println("Please enter fee amount");
            transacionFee = sc.nextDouble();
            balance = balance - amount - transacionFee;
            if (balance < 0) {
                System.out.println("You have tried to withdraw more money than you currently have in your bank account, please try again");
                balance = balance + amount + transacionFee;
            }
            System.out.println("You have withdrawn " + amount);
        }

        public BankAccount(String name, double balance, double transacionFee) {
            this.name = name;
            this.balance = balance;
            this.transacionFee = transacionFee;
        }
    }
}