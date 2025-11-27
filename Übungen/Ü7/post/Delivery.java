class Delivery {
    private final Sendable[] items;

    Delivery(Sendable[] items) {
        if (items == null) {
            throw new NullPointerException();
        }
        this.items = items.clone();
    }

    Delivery(Sendable item) {
        if (item == null) {
            throw new NullPointerException();
        }
        this.items = new Sendable[] { item };
    }

    private int postage(Sendable s) {
        if (!s.senderLocation().country().equals(s.receiverLocation().country())) {
            return 2;
        }
        return s.weight() < 100 ? 1 : 2;
    }

    int postage() {
        int sum = 0;
        for (Sendable s : items) {
            sum += postage(s);
        }
        return sum;
    }
}