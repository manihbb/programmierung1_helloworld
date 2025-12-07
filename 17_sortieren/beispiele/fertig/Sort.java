class Sort {

    private static void sort(int[] numbers, int startIndex, int endIndex) {
//         int startIndex = 0;
//         int endIndex = numbers.length;
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
    
    private static void sort(int[] numbers) {
        sort(numbers, 0, numbers.length);
    }

    public static void main() {
    
//         int[] numbers = {4, 6, 1, 7, 67, 8, 2, 9 };
//         
// //         sort(numbers, 0, numbers.length);
//         sort(numbers); // überladen
//         
//         System.out.println(java.util.Arrays.toString(numbers));
    
    
        for(int size = 1_000; size < 530_000_000; size *= 2) {
            int[] numbers = new int[size];
            for(int i = 0; i < numbers.length; i++) {
                numbers[i] = (int)(Math.random() * 1_000_000_000);
            }
            
            long start = System.currentTimeMillis();
            sort(numbers);
            long end = System.currentTimeMillis();
            
            System.out.print(size);
            System.out.print(",");
            System.out.println(end - start);
        }
    
    }


}
