public class Main {
    public static void main(String[] args) {
        Park.Attraction[] attractions = new Park.Attraction[3];
        attractions[0] = new Park("Fun Park", attractions).new Attraction("Roller Coaster", "10:00 - 18:00", 10.99);
        attractions[1] = new Park("Fun Park", attractions).new Attraction("Ferris Wheel", "09:00 - 20:00", 5.99);
        attractions[2] = new Park("Fun Park", attractions).new Attraction("Water Slide", "11:00 - 17:00", 7.99);

        Park park = new Park("Fun Park", attractions);
        park.displayAttractions();
    }
}