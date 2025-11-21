interface Resistor {
    double resistance();
    int resistorCount();
}

class SingleResistor implements Resistor {
    private final double value;

    SingleResistor(double value) {
        this.value = value;
    }

    @Override
    public double resistance() {
        return value;
    }

    @Override
    public int resistorCount() {
        return 1;
    }
}

class SeriesCircuit implements Resistor {
    private final Resistor left;
    private final Resistor right;

    SeriesCircuit(Resistor left, Resistor right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double resistance() {
        return left.resistance() + right.resistance();
    }

    @Override
    public int resistorCount() {
        return left.resistorCount() + right.resistorCount();
    }
}

class ParallelCircuit implements Resistor {
    private final Resistor left;
    private final Resistor right;

    ParallelCircuit(Resistor left, Resistor right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double resistance() {
        double a = left.resistance();
        double b = right.resistance();
        return (a * b) / (a + b);
    }

    @Override
    public int resistorCount() {
        return left.resistorCount() + right.resistorCount();
    }
}