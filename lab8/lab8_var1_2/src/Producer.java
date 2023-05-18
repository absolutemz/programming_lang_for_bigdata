public class Producer implements Runnable {
    private Shop shop;

    public Producer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true) {
            int product = (int) (Math.random() * 100); // Случайное число в качестве товара
            shop.produce(product);

            try {
                Thread.sleep(1000); // Ждем 1 секунду перед следующей поставкой
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
