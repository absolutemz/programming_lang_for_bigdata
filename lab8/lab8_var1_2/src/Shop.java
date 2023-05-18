import java.util.LinkedList;

public class Shop {
    private LinkedList<Integer> storage;
    private int capacity;

    public Shop(int capacity) {
        this.capacity = capacity;
        storage = new LinkedList<>();
    }

    public synchronized void produce(int product) {
        while (storage.size() >= capacity) {
            try {
                wait(); // Ждем, пока в магазине не появится свободное место
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        storage.add(product);
        System.out.println("Производитель поставил товар: " + product);

        notifyAll(); // Уведомляем покупателей, что появился товар в магазине
    }

    public synchronized int consume() {
        while (storage.isEmpty()) {
            try {
                wait(); // Ждем, пока в магазине не появится товар
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int product = storage.remove();
        System.out.println("Покупатель забрал товар: " + product);

        notifyAll(); // Уведомляем производителя, что в магазине появилось свободное место

        return product;
    }
}

