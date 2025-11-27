public class MaybeInt {

    private final boolean empty;
    private final int value;

    public MaybeInt(int value, boolean empty) {
        this.value = value;
        this.empty = empty;
    }

    public MaybeInt() {
        this.value = 0;
        this.empty = true;
    }

    public MaybeInt(int value) {
        this.value = value;
        this.empty = false;
    }

    public static MaybeInt empty() {
        return new MaybeInt();
    }

    public static MaybeInt of(int value) {
        return new MaybeInt(value);
    }

    public boolean isEmpty() {
        return empty;
    }

    public int value() {
        if (empty) {
            throw new IllegalStateException("Kein Wert vorhanden");
        }
        return value;
    }

    public MaybeInt modified(Int2IntFunction f) {
        if (empty) {
            return this;
        }
        return new MaybeInt(f.run(value));
    }

    public boolean fulfills(Int2BooleanFunction f) {
        if (empty) {
            return false;
        }
        return f.run(value);
    }
}
