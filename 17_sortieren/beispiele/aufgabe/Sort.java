class Sort {

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

    private static void mergesort(int[] numbers, int startIndex, int endIndex) {
        if (endIndex - startIndex <= 1) {
            return;
        }

        int middleIndex = startIndex + (endIndex - startIndex) / 2;
    
        sort(numbers, startIndex, middleIndex);
        sort(numbers, middleIndex, endIndex);
        
        // hier wissen wir: startIndex-middleIndex sortiert, middleIndex-endIndex sortiert
        merge(numbers, startIndex, middleIndex, endIndex);
    }
    
    private static void merge(int numbers[], int startIndex, int middleIndex, int endIndex) {
        int indexA = startIndex;
        int indexB = middleIndex;
        int merged[] = new int[endIndex - startIndex]; // hier ist exklusives endIndex praktisch
        int mergePosition = 0;
        
        while(indexA < middleIndex || indexB < endIndex) {
            if(indexA == middleIndex) {
                merged[mergePosition] = numbers[indexB];
                indexB++;
            } else if(indexB == endIndex) {
                merged[mergePosition] = numbers[indexA];
                indexA++;
            } else if(numbers[indexB] <= numbers[indexA]) {
                merged[mergePosition] = numbers[indexB];
                indexB++;
            } else if(numbers[indexA] <= numbers[indexB]) {
                merged[mergePosition] = numbers[indexA];
                indexA++;
            }
            mergePosition++;
        }
        
        for(int i = 0; i < merged.length; i++) {
            numbers[startIndex + i] = merged[i];
        }
    }
    
    private static void mergesort(int[] numbers) {
        mergesort(numbers, 0, numbers.length);
    }

    static void main() {
    
        // im Ordner »vorgabe« befindet sich der Benchmark-Code vom letzten Mal
        // Aufgabe: Messt auf eurem Computer, wie schnell Mergesort ist. Hängt die Geschwindigkeit auch quadratisch von der Array-Größe ab?
        
    }


}
