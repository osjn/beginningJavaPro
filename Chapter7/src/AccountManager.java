public class AccountManager {
    public static void main(String[] args) {
        Account mySavings = new SavingsAccount("Save001", "10.00");

        try {
            mySavings.withdraw("5.00");
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid Withdrawal");
        }

        Account myChecking = new CheckingAccount("Check002", "10.00", 1);
        try {
            myChecking.withdraw("5.00");
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid Withdrawal");
        }

        myChecking.deposit("500.00");
        try {
            myChecking.withdraw("5.00");
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid Withdrawal");
        }
//        Account myAccount = new Account("FirstAccount", "10.00");
//        System.out.println("Account Created: " + myAccount.getName());
//        System.out.println("Balance: " + myAccount.getAmount());
//
//        try {
//            myAccount.withdraw("20.00");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Invalid withdrawal");
//        } finally {
//            System.out.println("New Balance: " + myAccount.getAmount());
//        }
    }
}
