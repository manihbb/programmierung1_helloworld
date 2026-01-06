class SortObjects {

    static <T extends Comparable<T>> void sort(T[] objects) {
        for(int currentIndex = 0; currentIndex < objects.length; currentIndex++) {
            T currentObject = objects[currentIndex];
            int insertionPosition = currentIndex;
            while(insertionPosition > 0 && objects[insertionPosition - 1].compareTo(currentObject) > 0) {
                objects[insertionPosition] = objects[insertionPosition - 1];
                insertionPosition--;
            }
            objects[insertionPosition] = currentObject; 
        }
    }

    static <T> void sort(T[] objects, java.util.Comparator<T> comparator) {
        for(int currentIndex = 0; currentIndex < objects.length; currentIndex++) {
            T currentObject = objects[currentIndex];
            int insertionPosition = currentIndex;
            while(insertionPosition > 0 && comparator.compare(objects[insertionPosition - 1], currentObject) > 0) {
                objects[insertionPosition] = objects[insertionPosition - 1];
                insertionPosition--;
            }
            objects[insertionPosition] = currentObject; 
        }
    }
    
    public static void main(String[] args) {
    
        Studi[] studis = {new Studi("Emma", 1_755_152), new Studi("Mei", 8_624_151), new Studi("Aisha", 4_852_110), new Studi("Raj", 1_250_025)};
        
        sort(studis); 
        
        System.out.println(java.util.Arrays.toString(studis));
        
        
        java.util.Comparator<Studi> nachName = new NameComparator();
        
        System.out.println(nachName.compare(new Studi("A", 1), new Studi("B", 1))); 
        System.out.println(nachName.compare(new Studi("C", 1), new Studi("C", 1))); 
        System.out.println(nachName.compare(new Studi("D", 1), new Studi("A", 1))); 
        
        sort(studis, new NameComparator()); 
        
        System.out.println(java.util.Arrays.toString(studis));
    
        java.util.Comparator<String> nachLaenge = new StringLengthComparator();
        
        String[] namen = {"Emma", "Mei", "Aisha", "Raj"};
        
        java.util.Arrays.sort(namen, nachLaenge);
        
        System.out.println(java.util.Arrays.toString(namen));
    }
}