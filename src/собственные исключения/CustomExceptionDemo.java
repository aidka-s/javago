/**
 * Демонстрация собственного класса исключения
 * @author Student
 * @version 1.0
 */
class InsufficientFundsException extends Exception {
    private double attemptedAmount;
    private double currentBalance;

    public InsufficientFundsException() {
        super("Недостаточно средств");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }

    public InsufficientFundsException(double attemptedAmount, double currentBalance) {
        super("Недостаточно средств: " + attemptedAmount + " > " + currentBalance);
        this.attemptedAmount = attemptedAmount;
        this.currentBalance = currentBalance;
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount, balance);
        }
        balance -= amount;
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        try {
            account.withdraw(300);
            account.withdraw(800);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}