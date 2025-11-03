static void main() {
                             // Speicher für ein Array mit 50 Plätzen für double-Werte anfordern
    double[] randomNumbers = new double[50];
    
    for(int i=0; i<50; i++) {
        randomNumbers[i] = Math.random();
    }
    
    double sum = 0;
    for(double number: randomNumbers) {
        sum += number;
    }
    
    System.out.println(sum / 50);
}
