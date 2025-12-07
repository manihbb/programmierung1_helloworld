class SortBenchmark {

    private static void insertionSort(int[] numbers) {
        for(int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {
            int currentNumber = numbers[currentIndex];
            int insertionPosition = currentIndex;
            while(insertionPosition > 0 && numbers[insertionPosition - 1] > currentNumber) {
                numbers[insertionPosition] = numbers[insertionPosition - 1];
                insertionPosition--;
            }
            numbers[insertionPosition] = currentNumber; 
        }
    }
    
    static void main() {
    
        for(int size = 1_000; size < 1_100_000; size *= 2) {
            int[] numbers = new int[size];
            for(int i = 0; i < numbers.length; i++) {
                numbers[i] = (int)(Math.random() * 1000);
            }
            
            long start = System.currentTimeMillis();
            insertionSort(numbers);
            long end = System.currentTimeMillis();
            
            System.out.print(size);
            System.out.print(",");
            System.out.println(end - start);
        }
    
    }

}
