public class Search {

    private static int split(int[] haystack, int needle, int left, int right) {
        if (haystack[right] == haystack[left]) {
            return left;
        }
        long numerator = (long) (needle - haystack[left]) * (right - left);
        int denominator = haystack[right] - haystack[left];
        return left + (int) (numerator / denominator);
    }

    static int search(int[] haystack, int needle) {
        int left = 0;
        int right = haystack.length - 1;

        while (left <= right && needle >= haystack[left] && needle <= haystack[right]) {
            int pos = split(haystack, needle, left, right);

            if (haystack[pos] == needle) {
                return pos;
            }

            if (haystack[pos] < needle) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            int needle = Integer.parseInt(args[0]);
            int[] haystack = new int[args.length - 1];
            
            for (int i = 0; i < haystack.length; i++) {
                haystack[i] = Integer.parseInt(args[i + 1]);
            }
            
            System.out.println(search(haystack, needle));
        }
    }
}