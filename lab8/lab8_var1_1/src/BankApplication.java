public class BankApplication {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Runnable depositTask = () -> {
            while (true) {
                double amount = Math.random() * 100;
                account.deposit(amount);
                try {
                    Thread.sleep(1000); // Ждем 1 секунду между пополнениями
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable withdrawTask = () -> {
            while (true) {
                double amount = Math.random() * 100;
                account.withdraw(amount);
                try {
                    Thread.sleep(2000); // Ждем 2 секунды между снятиями
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Создаем и запускаем потоки для выполнения задач пополнения и снятия денег
        Thread depositThread = new Thread(depositTask);
        Thread withdrawThread = new Thread(withdrawTask);
        depositThread.start();
        withdrawThread.start();
    }
}
