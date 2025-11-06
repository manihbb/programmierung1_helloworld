public class Plateau {

    // Das ist die Methode, die du für den Bughunt einreichen musst
    static void longestPlateau(int[] arr) {
        if (arr.length < 3) {
            System.out.println("ERROR: Bitte mindestens 3 Zahlen übergeben!");
            return;
        }

        int maxLength = 0;
        int maxStartIndex = -1;

        int i = 1;
        while (i < arr.length - 1) {
            
            if (arr[i - 1] < arr[i]) {
                int start = i;
                int length = 1;

                while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                    length++;
                    i++;
                }
                
                if (i + 1 < arr.length && arr[i + 1] < arr[i]) {
                    if (length > maxLength) {
                        maxLength = length;
                        maxStartIndex = start;
                    }
                }
            }
            
            i++;
        }

        if (maxLength > 0) {
            System.out.println(maxStartIndex + " " + maxLength);
        } else {
            System.out.println("Kein Plateau");
        }
    }

    // Das ist die korrekte Start-Methode, um die Datei selbst zu testen
    public static void main(String[] args) {
        System.out.print("> longestPlateau(new int[]{3, 5}); \n");
        longestPlateau(new int[]{3, 5});
        
        System.out.print("\n> longestPlateau(new int[]{2, 3, 3, 3, 1, 2, 2, 2, 1}); \n");
        longestPlateau(new int[]{2, 3, 3, 3, 1, 2, 2, 2, 1});
        
        System.out.print("\n> longestPlateau(new int[]{1, 2, 3, 4, 3, 2, 1}); \n");
        longestPlateau(new int[]{1, 2, 3, 4, 3, 2, 1});
        
        System.out.print("\n> longestPlateau(new int[]{1, 2, 3}); \n");
        longestPlateau(new int[]{1, 2, 3});

        // Hier sind die Tests, die vorher fehlgeschlagen sind:
        System.out.print("\n> longestPlateau(new int[]{1, 2, 1}); \n");
        longestPlateau(new int[]{1, 2, 1}); // Erwartet: 1 1

        System.out.print("\n> longestPlateau(new int[]{1, 2, 1, 1, 1, 0}); \n");
        longestPlateau(new int[]{1, 2, 1, 1, 1, 0}); // Erwartet: 1 1

        System.out.print("\n> longestPlateau(new int[]{2, 2, 1, 3, 1, 3, 3, 3}); \n");
        longestPlateau(new int[]{2, 2, 1, 3, 1, 3, 3, 3}); // Erwartet: 3 1
    }
}