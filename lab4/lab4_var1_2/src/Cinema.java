public class Cinema {
    private String name;
    private Address[] addresses;

    public Cinema(String name, Address[] addresses) {
        this.name = name;
        this.addresses = addresses;
    }

    public void displayAddresses() {
        System.out.println("Addresses of " + name + " cinema:");
        for (Address address : addresses) {
            System.out.println("Street: " + address.getStreet());
            System.out.println("City: " + address.getCity());
            System.out.println("State: " + address.getState());
            System.out.println();
        }
    }

    public class Address {
        private String street;
        private String city;
        private String state;

        public Address(String street, String city, String state) {
            this.street = street;
            this.city = city;
            this.state = state;
        }

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }
    }

    public static class Showtime {
        private String movie;
        private String time;

        public Showtime(String movie, String time) {
            this.movie = movie;
            this.time = time;
        }

        public String getMovie() {
            return movie;
        }

        public String getTime() {
            return time;
        }
    }
}
