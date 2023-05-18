public class Consumer implements Runnable {
    private Shop shop;

    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true) {
            int product = shop.consume();

            try {
                Thread.sleep(2000); // Ждем 2 секунды перед следующей покупкой
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
