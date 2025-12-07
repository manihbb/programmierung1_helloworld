class Sort {

    private static void sort(String[] objects, int startIndex, int endIndex) {
        if (endIndex - startIndex <= 1) {
            return;
        }

        int middleIndex = startIndex + (endIndex - startIndex) / 2;
    
        sort(objects, startIndex, middleIndex);
        sort(objects, middleIndex, endIndex);
        
        // hier wissen wir: startIndex-middleIndex sortiert, middleIndex-endIndex sortiert
        merge(objects, startIndex, middleIndex, endIndex);
    }
    
    private static void merge(String objects[], int startIndex, int middleIndex, int endIndex) {
        int indexA = startIndex;
        int indexB = middleIndex;
        String merged[] = new String[endIndex - startIndex];
        int mergePosition = 0;
        
        while(indexA < middleIndex || indexB < endIndex) {
            if(indexA == middleIndex) {
                merged[mergePosition] = objects[indexB];
                indexB++;
            } else if(indexB == endIndex) {
                merged[mergePosition] = objects[indexA];
                indexA++;
            } else if(objects[indexB].compareTo(objects[indexA]) <= 0) {
                merged[mergePosition] = objects[indexB];
                indexB++;
            } else if(objects[indexA].compareTo(objects[indexB]) <= 0) {
                merged[mergePosition] = objects[indexA];
                indexA++;
            }
            mergePosition++;
        }
        
        for(int i = 0; i < merged.length; i++) {
            objects[startIndex + i] = merged[i];
        }
    }
    
    private static void sort(String[] objects) {
        sort(objects, 0, objects.length);
    }

    static void main() {
        String[] namen = {"Markus", "Mareike", "Niklas", "Kata"};
        sort(namen);
        System.out.println(java.util.Arrays.toString(namen));
        
        System.out.println("Aa".compareTo("Ab"));
        System.out.println("Ab".compareTo("Ab"));
        System.out.println("Ab".compareTo("Aa"));
    }

}
