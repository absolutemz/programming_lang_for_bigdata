// Интерфейс Фильм (Film)
interface Film {
    void play();
}

// Класс ОтечественныйФильм (DomesticFilm), реализует интерфейс Фильм (Film)
class DomesticFilm implements Film {
    private String title;

    public DomesticFilm(String title) {
        this.title = title;
    }

    public void play() {
        System.out.println("Проигрывание отечественного фильма: " + title);
    }
}

// Класс Комедия (Comedy), наследуется от класса ОтечественныйФильм (DomesticFilm)
class Comedy extends DomesticFilm {
    public Comedy(String title) {
        super(title);
    }

    // Дополнительные методы или поведение для класса Комедия (Comedy)
    public void laugh() {
        System.out.println("Смех в комедии");
    }
}

// Пример использования классов
public class Main {
    public static void main(String[] args) {
        Film film1 = new DomesticFilm("Фильм 1");
        film1.play();  // Полиморфное использование метода play() интерфейса Фильм (Film)

        Comedy comedy1 = new Comedy("Комедия 1");
        comedy1.play();  // Вызов метода play() класса ОтечественныйФильм (DomesticFilm)
        comedy1.laugh(); // Вызов дополнительного метода laugh() класса Комедия (Comedy)
    }
}