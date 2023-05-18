import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private Lock lock;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
        lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println("Пополнение на сумму " + amount + ". Текущий баланс: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Снятие на сумму " + amount + ". Текущий баланс: " + balance);
            } else {
                System.out.println("Недостаточно денежных средств. Текущий баланс: " + balance);
            }
        } finally {
            lock.unlock();
        }
    }
}

