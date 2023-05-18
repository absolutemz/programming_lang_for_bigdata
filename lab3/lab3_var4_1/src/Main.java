import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class Order {
    private List<Product> products;
    private boolean paid;

    public Order() {
        this.products = new ArrayList<>();
        this.paid = false;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void pay() {
        paid = true;
    }

    public boolean isPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                ", paid=" + paid +
                '}';
    }
}

class Administrator {
    private List<Order> sales;
    private List<User> blacklist;

    public Administrator() {
        this.sales = new ArrayList<>();
        this.blacklist = new ArrayList<>();
    }

    public void addProductInfo(Product product) {
        // Добавление информации о товаре
        System.out.println("Информация о товаре добавлена: " + product);
    }

    public void registerSale(Order order) {
        // Регистрация продажи
        sales.add(order);
        System.out.println("Продажа зарегистрирована: " + order);
    }

    public void addToBlacklist(User user) {
        // Добавление пользователя в черный список
        blacklist.add(user);
        System.out.println("Пользователь добавлен в черный список: " + user);
        user.setBlacklisted(true);
    }

    public void displaySales() {
        // Вывод списка продаж
        System.out.println("Список продаж:");
        for (Order order : sales) {
            System.out.println(order);
        }
    }
}

class User {
    private String name;
    private boolean blacklisted;

    public User(String name) {
        this.name = name;
        this.blacklisted = false;
    }

    public String getName() {
        return name;
    }

    public boolean isBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(boolean blacklisted) {
        this.blacklisted = blacklisted;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", blacklisted=" + blacklisted +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание объектов
        Product product1 = new Product("Телефон", 1000);
        Product product2 = new Product("Ноутбук", 2000);

        Order order = new Order();
        order.addProduct(product1);
        order.addProduct(product2);

        Administrator admin = new Administrator();

        User user1 = new User("Иван");
        User user2 = new User("Петр");

        // Добавление информации о товаре
        admin.addProductInfo(product1);
        admin.addProductInfo(product2);

        // Заказ товаров
        System.out.println("Заказ пользователя " + user1.getName() + ":");
        System.out.println(order);

        // Оплата заказа
        order.pay();
        System.out.println("Заказ оплачен: " + order.isPaid());

        // Регистрация продажи
        admin.registerSale(order);

        // Добавление пользователя в черный список
        admin.addToBlacklist(user1);

        // Вывод списка продаж
        admin.displaySales();

        // Проверка нахождения пользователя в черном списке
        System.out.println(user1.getName() + " находится в черном списке: " + user1.isBlacklisted());
        System.out.println(user2.getName() + " находится в черном списке: " + user2.isBlacklisted());
    }
}