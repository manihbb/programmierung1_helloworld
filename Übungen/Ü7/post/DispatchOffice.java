public class DispatchOffice {
    public static void main(String[] args) {
        Letter letter = new Letter(
            new Location(40225, "Germany"),
            new Location(40530, "Sweden")
        );
        Delivery delivery = new Delivery(letter);
        System.out.println(delivery.postage());
    }
}