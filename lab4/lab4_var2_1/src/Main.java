// Интерфейс Furniture (Мебель)
interface Furniture {
    void place();
}

// Абстрактный класс Cabinet (Шкаф)
abstract class Cabinet implements Furniture {
    protected int height;
    protected int width;

    public Cabinet(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public abstract void open();

    public void place() {
        System.out.println("Размещение шкафа");
    }
}

// Класс Bookcase (Книжный шкаф), наследуется от Cabinet (Шкаф)
class Bookcase extends Cabinet {
    private int numberOfShelves;

    public Bookcase(int height, int width, int numberOfShelves) {
        super(height, width);
        this.numberOfShelves = numberOfShelves;
    }

    public void open() {
        System.out.println("Открытие книжного шкафа");
    }

    public void placeBooks() {
        System.out.println("Размещение книг в книжном шкафе");
    }
}

// Пример использования классов
public class Main {
    public static void main(String[] args) {
        Bookcase bookcase = new Bookcase(200, 100, 5);
        bookcase.place();       // Полиморфное использование метода place()
        bookcase.open();        // Вызов метода open() класса Bookcase
        bookcase.placeBooks();  // Вызов метода placeBooks() класса Bookcase
    }
}