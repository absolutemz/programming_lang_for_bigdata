public class Main {
    public static void main(String[] args) {
        Cinema.Address[] addresses = new Cinema.Address[2];
        addresses[0] = new Cinema("Cineplex", addresses).new Address("123 Main St", "Cityville", "State A");
        addresses[1] = new Cinema("Cineplex", addresses).new Address("456 Elm St", "Townsville", "State B");

        Cinema cinema = new Cinema("Cineplex", addresses);
        cinema.displayAddresses();

        Cinema.Showtime showtime1 = new Cinema.Showtime("Movie A", "12:00 PM");
        Cinema.Showtime showtime2 = new Cinema.Showtime("Movie B", "3:00 PM");

        System.out.println("Movie: " + showtime1.getMovie());
        System.out.println("Time: " + showtime1.getTime());
        System.out.println();
        System.out.println("Movie: " + showtime2.getMovie());
        System.out.println("Time: " + showtime2.getTime());
    }
}