import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Lotto {

    static int[] ziehung(int n, int m) {
        
        List<Integer> pool = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            pool.add(i);
        }

        Collections.shuffle(pool);

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = pool.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] lottoDraw = ziehung(6, 49);
        System.out.println("Lotto 6 aus 49 Ziehung:");
        System.out.println(Arrays.toString(lottoDraw));

        int[] anotherDraw = ziehung(10, 45);
        System.out.println("\nLotto 10 aus 45 Ziehung:");
        System.out.println(Arrays.toString(anotherDraw));
    }
}