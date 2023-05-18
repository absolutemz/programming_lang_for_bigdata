import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Passenger {
    private String destinationStation;
    private String departureTime;
    private String departureDate;
    private Request request;
    private Invoice invoice;

    public Passenger(String destinationStation, String departureTime, String departureDate) {
        this.destinationStation = destinationStation;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.request = null;
        this.invoice = null;
    }

    public void registerRequest() {
        this.request = new Request(this, null);
        System.out.println("Заявка зарегистрирована.");
    }

    public Train chooseTrain(List<Train> availableTrains) {
        if (this.request == null) {
            System.out.println("Зарегистрируйте заявку перед выбором поезда.");
            return null;
        }

        List<Train> suitableTrains = new ArrayList<>();
        for (Train train : availableTrains) {
            if (train.getEndStation().equals(destinationStation)) {
                suitableTrains.add(train);
            }
        }

        if (suitableTrains.isEmpty()) {
            System.out.println("Нет доступных поездов для выбранной станции назначения.");
            return null;
        }

        System.out.println("Доступные поезда:");
        for (int i = 0; i < suitableTrains.size(); i++) {
            Train train = suitableTrains.get(i);
            System.out.println((i + 1) + ". Номер поезда: " + train.getTrainNumber() + ", Цена: " + train.getPrice());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите номер поезда: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > suitableTrains.size()) {
            System.out.println("Некорректный выбор поезда.");
            return null;
        }

        Train chosenTrain = suitableTrains.get(choice - 1);
        this.request.setTrain(chosenTrain);
        this.invoice = new Invoice(this, chosenTrain);
        System.out.println("Поезд выбран.");
        return chosenTrain;
    }

    public void receiveInvoice() {
        if (this.invoice == null) {
            System.out.println("Сначала выберите поезд.");
            return;
        }

        System.out.println("Счет на оплату:");
        System.out.println("Пассажир: " + this.toString());
        System.out.println("Номер поезда: " + this.invoice.getTrain().getTrainNumber());
        System.out.println("Цена: " + this.invoice.getTrain().getPrice());
        System.out.println("Оплатите счет в ближайшем отделении Железнодорожной кассы.");
    }

    @Override
    public String toString() {
        return "Пассажир{" +
                "станция_назначения='" + destinationStation + '\'' +
                ", время_поездки='" + departureTime + '\'' +
                ", дата_поездки='" + departureDate + '\'' +
                '}';
    }
}

class Administrator {
    private List<Train> trains;

    public Administrator() {
        this.trains = new ArrayList<>();
    }

    public void enterTrainDetails(String trainNumber, List<String> intermediateStations, String endStation, int price) {
        Train train = new Train(trainNumber, intermediateStations, endStation, price);
        this.trains.add(train);
        System.out.println("Информация о поезде добавлена.");
    }

    public void showAvailableTrains() {
        if (this.trains.isEmpty()) {
            System.out.println("Нет доступных поездов.");
        } else {
            System.out.println("Доступные поезда:");
            for (int i = 0; i < this.trains.size(); i++) {
                Train train = this.trains.get(i);
                System.out.println((i + 1) + ". Номер поезда: " + train.getTrainNumber() + ", Цена: " + train.getPrice());
            }
        }
    }

    public List<Train> getTrains() {
        return this.trains;
    }
}

class Request {
    private Passenger passenger;
    private Train train;

    public Request(Passenger passenger, Train train) {
        this.passenger = passenger;
        this.train = train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}

class Train {
    private String trainNumber;
    private List<String> intermediateStations;
    private String endStation;
    private int price;

    public Train(String trainNumber, List<String> intermediateStations, String endStation, int price) {
        this.trainNumber = trainNumber;
        this.intermediateStations = intermediateStations;
        this.endStation = endStation;
        this.price = price;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public List<String> getIntermediateStations() {
        return intermediateStations;
    }

    public String getEndStation() {
        return endStation;
    }

    public int getPrice() {
        return price;
    }
}

class Invoice {
    private Passenger passenger;
    private Train train;

    public Invoice(Passenger passenger, Train train) {
        this.passenger = passenger;
        this.train = train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Train getTrain() {
        return train;
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем объекты администратора и пассажира
        Administrator admin = new Administrator();
        Passenger passenger = new Passenger("Станция_Н", "12:00", "2023-05-20");

        // Администратор вводит информацию о поездах
        admin.enterTrainDetails("Поезд1", List.of("Станция_А", "Станция_Б", "Станция_Н"), "Станция_Н", 500);
        admin.enterTrainDetails("Поезд2", List.of("Станция_В", "Станция_Н"), "Станция_Н", 700);

        // Пассажир регистрирует заявку
        passenger.registerRequest();

        // Администратор показывает доступные поезда
        admin.showAvailableTrains();

        // Пассажир выбирает поезд
        Train chosenTrain = passenger.chooseTrain(admin.getTrains());

        // Пассажир получает счет на оплату
        passenger.receiveInvoice();
    }
}