public class MinMax {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("ERROR: Mindestens eine Zahl als Argument übergeben.");
            return;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String arg : args) {
            int num;
            try {
                num = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                continue;
            }
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println("ERROR: Mindestens eine Zahl als Argument übergeben.");
            return;
        }
        System.out.println(min);
        System.out.println(max);
    }
}