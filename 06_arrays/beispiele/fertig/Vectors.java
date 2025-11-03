static void main() {
    int[] a = {1, 2, 3};
    int[] b = {4, 5, 6};
    
    int[] sum = sum(a, b);
    printArray(sum);
}

static void printArray(int[] a) {
    for(int element: a) {
        System.out.print(element + ",");
    }
    System.out.println();
}

static int[] sum(int[] a, int[] b) {
    int[] sum = new int[a.length];
    
    for(int i = 0; i < a.length; i++) {
        sum[i] = a[i] + b[i];
    }
    
    return sum;
}
