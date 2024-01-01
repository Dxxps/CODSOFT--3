import java.util.Scanner;

public class ATMinterface {

    private UserAccount userAccount;
    private Scanner scanner;

    public ATMinterface(UserAccount userAccount) {
        this.userAccount = userAccount;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Please choose an option: ");
        System.out.println("1. Withdraw Cash");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    withdrawCash();
                    break;
                case 2:
                    depositCash();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }

    private void withdrawCash() {
        System.out.println("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > userAccount.getBalance()) {
            System.out.println("Insufficient balance. Transaction failed.");
        } else {
            userAccount.withdraw(amount);
            System.out.println("Cash withdrawn successfully.");
        }
    }

    private void depositCash() {
        System.out.println("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
        System.out.println("Cash deposited successfully.");
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + userAccount.getBalance());
    }

    public static void main(String[] args) {
        UserAccount userAccount = new UserAccount(1234567, 5000);
        ATMinterface atm = new ATMinterface(userAccount);
        atm.start();
    }
}

class UserAccount {

    private int accountNumber;
    private double balance;

    public UserAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}