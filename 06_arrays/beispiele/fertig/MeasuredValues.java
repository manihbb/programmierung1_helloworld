static void main() {

    double[] values = {20.5, 21.1, 21.3, 21.5, 20.1};
    
    System.out.println(values.length); // Anzahl Elemente
    
    double sum = 0;
    
    // für alle int i mit den Werten 0 bis (ausschließlich) values.length, tu:
    // for(int i = 0; i < values.length; i++) {
                  // i-te Position in values (gezählt ab 0)
        // sum += values[i];
    // }
    
    // für alle double value ind values, tu:
    for(double value: values) {
        sum += value;
    }
    
    System.out.println(sum / values.length);
    
    System.out.println(values);  // :(  (klären wir später)
    
    for(double value: values) {
        System.out.print(value + ",");
    }

}
