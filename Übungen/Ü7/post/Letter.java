class Letter implements Sendable {
    private final Location sender;
    private final Location receiver;
    private static final double WEIGHT = 80.0;

    Letter(Location sender, Location receiver) {
        this.sender = sender;
        this.receiver = receiver;
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
        return WEIGHT;
    }
}