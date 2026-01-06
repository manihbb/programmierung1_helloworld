record Cylinder(double radius, double height) {

    double volume() {
        return Math.PI * radius * radius * height;
    }

    static Cylinder[] sorted(Cylinder[] input) {
        if (input == null) {
            throw new NullPointerException();
        }

        Cylinder[] sortedArray = new Cylinder[input.length];

        for (int i = 0; i < input.length; i++) {
            if (input[i] == null) {
                throw new NullPointerException();
            }
            sortedArray[i] = input[i];
        }

        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = 0; j < sortedArray.length - 1 - i; j++) {
                if (sortedArray[j].volume() > sortedArray[j + 1].volume()) {
                    Cylinder temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }

        return sortedArray;
    }
}