abstract class Parcel implements Sendable {
    protected final Location sender;
    protected final Location receiver;
    protected final double weight;

    Parcel(Location sender, Location receiver, double weight) {
        this.sender = sender;
        this.receiver = receiver;
        this.weight = weight;
    }

    @Override
    public Location senderLocation() {
        return sender;
    }

    @Override
    public Location receiverLocation() {
        return receiver;
    }

    @Override
    public double weight() {
        return weight;
    }
}