public class Shuffle {
    static void main() {
        int[] numbers = {5,3,9,2,4,6};

        shuffle(numbers);

        int shuffledNumbers = shuffled(numbers);

        printArray(numbers);
        printArray(shuffledNumbers);
    }

    static int[] shuffled(int[] zahlen){
        int[] ergebnis = new int[zahlen.length];
        for(int i = 0; i < zahlen.length; i++){
            ergebnis[i] = zahlen[i];
        }
        shuffle(ergebnis);
        return ergebnis;
    }

    static void shuffle(int[] zahlen){
        int position1 = (int)(Math.random() * zahlen.lenght);
        int position2 = (int)(Math.random() * zahlen.lenght);
        swap(zahlen, position1, position2);

    }

    static void swap(int[] ){

    }
}