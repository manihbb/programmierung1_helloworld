static void main() {
    int[] a = {1, 2};
    int[] b = {3, 4};
    
    a[0] = 10;
    
    printArray(a);
    
    a = b;
    
    printArray(a);
    
    b[0] = 20;
    
    printArray(a);
    printArray(b);
    
    System.out.println("======");
    
    int[] xs = {1, 2};
    int[] ys = {1, 2};
    
    System.out.println(xs == ys);
    
    System.out.println("======");
    
    int[] zahlen = {1, 2, 3, 4};
    
    change(zahlen);
    change(zahlen[1]);
    
    printArray(zahlen);
}

static void printArray(int[] xs) {
    System.out.print("[");
    for(int x: xs) {
        System.out.print(x + ",");
    }
    System.out.println("]");
}

static void change(int[] zs) {
    zs[0] *= 2;
}

static void change(int z) {
    z *= 2;
}
