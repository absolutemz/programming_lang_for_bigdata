public class Park {
    private String name;
    private Attraction[] attractions;

    public Park(String name, Attraction[] attractions) {
        this.name = name;
        this.attractions = attractions;
    }

    public void displayAttractions() {
        System.out.println("Attractions in " + name + ":");
        for (Attraction attraction : attractions) {
            System.out.println("Name: " + attraction.getName());
            System.out.println("Working Hours: " + attraction.getWorkingHours());
            System.out.println("Price: " + attraction.getPrice());
            System.out.println();
        }
    }

    public class Attraction {
        private String name;
        private String workingHours;
        private double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getWorkingHours() {
            return workingHours;
        }

        public double getPrice() {
            return price;
        }
    }
}
