public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(3);
        list.add(5);
        list.add(1);

        System.out.println(list);
        
        list.sort();
        
        System.out.println(list);
    }
}