public class ProductManager {
    private Product[] products;

    public ProductManager(int size) {
        products = new Product[size];
    }

    public void addProduct(Product product, int index) {
        if (index >= 0 && index < products.length) {
            products[index] = product;
        } else {
            System.out.println("Некорректный индекс");
        }
    }

    public void printProducts() {
        try {
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product);
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка ввода/вывода при печати товаров: " + e.getMessage());
        }
    }

    public Product[] getProducts() {
        return products;
    }

    public static void main(String[] args) throws InvalidProductException {
        ProductManager manager = new ProductManager(5);

        manager.addProduct(new Product(1, "Телефон", "1234567890", "Apple", 999.99, 365, 10), 0);
        manager.addProduct(new Product(2, "Ноутбук", "0987654321", "Dell", 1499.99, 730, 5), 1);
        manager.addProduct(new Product(3, "Наушники", "5678901234", "Sony", 199.99, 180, 20), 2);
        manager.addProduct(new Product(4, "Телевизор", "5432109876", "Samsung", 799.99, 1095, 8), 3);
        manager.addProduct(new Product(5, "Планшет", "1357902468", "Lenovo", 499.99, 365, 15), 4);

        Product test_prod = new Product(6, "test", "5678901234", "Sony", 199.99, 180, 20);
        test_prod.setPrice(-40);


        System.out.println("Все товары:");
        manager.printProducts();
        System.out.println();

        // a) Список товаров для заданного наименования
        String searchName = "Телефон";
        System.out.println("Товары с наименованием '" + searchName + "':");
        for (Product product : manager.getProducts()) {
            if (product.getName().equals(searchName)) {
                System.out.println(product);
            }
        }
        System.out.println();

        // b) Список товаров для заданного наименования, цена которых не превосходит заданную
        String searchName2 = "Ноутбук";
        double maxPrice = 1500.0;
        System.out.println("Товары с наименованием '" + searchName2 + "', цена которых не превосходит " + maxPrice + ":");
        for (Product product : manager.getProducts()) {
            if (product.getName().equals(searchName2) && product.getPrice() <= maxPrice) {
                System.out.println(product);
            }
        }
        System.out.println();

        // c) Список товаров, срок хранения которых больше заданного
        int minShelfLife = 365;
        System.out.println("Товары, срок хранения которых больше " + minShelfLife + " дней:");
        for (Product product : manager.getProducts()) {
            if (product.getShelfLife() > minShelfLife) {
                System.out.println(product);
            }
        }
    }
}
