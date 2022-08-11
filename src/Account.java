import java.util.Scanner;

public class Account {

    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    Account(String cName, String cId) {
       customerName = cName;
        customerId = cId;
    }

    //Method to deposit money into the account
    void deposit(int amount) {
        if(amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }
     //Method to withdraw money from the account
    void withdraw(int amount) {
        if(amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    //Method to show previous transaction
    void previousTransaction() {
        if(previousTransaction > 0) {
            System.out.println("Deposited " + previousTransaction);
        } else if(previousTransaction < 0) {
            System.out.println("Withdrawn " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction was made");
        }
    }

    //Method that calculates interest of current fund after a number of years
    void calculateInterest(int years) {
        double interestRate = .0295;
        double newBalance = (balance * years * interestRate) + balance;
        System.out.println("The current interest rate is " + (interestRate * 100) + "%");
        System.out.println("After " + years + " years, your new balance will be: " + newBalance);
    }

    //Method that shows the main menu
    void showMenu(){
        char option = '\0';
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Simple Bank Ltd " + customerName + "!");
        System.out.println("Your account number is " + customerId);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Check Previous Transaction");
        System.out.println("E. Calculate Interest");
        System.out.println("F. Exit");

    do {
        System.out.println();
        System.out.println("Enter your choice of transaction: ");
        char option1 = input.next().charAt(0);
        option = Character.toUpperCase(option1);
        System.out.println();

        switch(option) {
            //Case A allow customer to check balance
            case 'A':
                System.out.println("=====================================");
                System.out.println("Your balance is #" + balance);
                System.out.println("=====================================");
                System.out.println();
                break;

                //Case B allow customer to deposit money
            case 'B':
                System.out.println("Enter an amount to deposit: ");
                int amount = input.nextInt();
                deposit(amount);
                System.out.println();
                break;

                //Case C allow customer to withdraw money
            case 'C':
                System.out.println("Enter an amount to withdraw: ");
                int amount1 = input.nextInt();
                withdraw(amount1);
                System.out.println();
                break;

                //Case D allow customer to check previous transaction
            case 'D':
                System.out.println("=====================================");
                previousTransaction();
                System.out.println("=====================================");
                System.out.println();
                break;

                //Case E allow customer to calculate interest
            case 'E':
                System.out.println("Enter the number of years: ");
                int years = input.nextInt();
                calculateInterest(years);
                System.out.println();
                break;

                //Case F allow customer to exit the program
            case 'F':
                System.out.println("=====================================");
                break;

                //Default case notify customer if they enter an invalid option
            default:
                System.out.println("Invalid option, Please select option A, B, C, D, E, or F");
                break;
        }
    } while (option != 'F');
        System.out.println("Thank you for using Simple Bank Ltd!");
    }

}
