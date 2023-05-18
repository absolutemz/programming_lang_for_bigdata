import java.time.LocalTime;

public class TrainManager {
    private Train[] trains;

    public TrainManager(int size) {
        trains = new Train[size];
    }

    public void addTrain(Train train, int index) {
        if (index >= 0 && index < trains.length) {
            trains[index] = train;
        } else {
            System.out.println("Некорректный индекс");
        }
    }

    public void printTrains() {
        for (Train train : trains) {
            if (train != null) {
                System.out.println(train);
            }
        }
    }

    public Train[] getTrains() {
        return trains;
    }
    public static void main(String[] args) {
        TrainManager manager = new TrainManager(5);

        manager.addTrain(new Train("Москва", 123, LocalTime.of(8, 0), 200, 50, 100, 50), 0);
        manager.addTrain(new Train("Санкт-Петербург", 456, LocalTime.of(10, 30), 150, 30, 70, 20), 1);
        manager.addTrain(new Train("Екатеринбург", 789, LocalTime.of(12, 45), 180, 40, 90, 30), 2);
        manager.addTrain(new Train("Казань", 987, LocalTime.of(14, 15), 250, 60, 120, 70), 3);
        manager.addTrain(new Train("Новосибирск", 654, LocalTime.of(16, 30), 300, 70, 150, 80), 4);

        System.out.println("Все поезда:");
        manager.printTrains();
        System.out.println();

        // a) Список поездов, следующих до заданного пункта назначения
        String searchDestination = "Екатеринбург";
        System.out.println("Поезда, следующие до пункта назначения '" + searchDestination + "':");
        for (Train train : manager.getTrains()) {
            if (train.getDestination().equals(searchDestination)) {
                System.out.println(train);
            }
        }
        System.out.println();

        // b) Список поездов, следующих до заданного пункта назначения и отправляющихся после заданного времени
        String searchDestination2 = "Москва";
        LocalTime searchTime = LocalTime.of(9, 0);
        System.out.println("Поезда, следующие до пункта назначения '" + searchDestination2 + "' и отправляющиеся после " + searchTime + ":");
        for (Train train : manager.getTrains()) {
            if (train.getDestination().equals(searchDestination2) && train.getDepartureTime().isAfter(searchTime)) {
                System.out.println(train);
            }
        }
        System.out.println();

        // c) Список поездов, отправляющихся до заданного пункта назначения и имеющих общие места
        String searchDestination3 = "Санкт-Петербург";
        System.out.println("Поезда, отправляющиеся до пункта назначения '" + searchDestination3 + "' и имеющие общие места:");
        for (Train train : manager.getTrains()) {
            if (train.getDestination().equals(searchDestination3) && train.getTotalSeats() > 0) {
                System.out.println(train);
            }
        }
    }
}
