class PersonsTest {
    static void main() {
        System.out.println("== Fragen 1-5");

        Person charlie = new Teacher("Charlie", "char@hhu.de", 1200_00, "Mathematik");
        System.out.println(charlie);

        System.out.println("== Aufgaben 6-8");

        Person sascha = new Student("Sascha", "sasch@hhu.de", 12345);
        Student alex = new Student("Alex", "alwa042@hhu.de", 12345);

        System.out.println(sascha.equals(alex));

        System.out.println("== Aufgaben 9-10");

        Person karim = new Student("Karim", "kakro014@hhu.de");

        System.out.println(karim);

        System.out.println("== Aufgabe 11");

        // Klappt das? Employee erbt von Person und Person hat einen Konstruktor mit 2 Parametern.
//        Employee martin = new Employee("Martin", "mauve@hhu.de");

        System.out.println("== Aufgaben 12-13");

        Teacher anna = new Teacher("Anna", "anna@hhu.de", 1500_00, "Informatik");
        Employee bo = new Teacher("Bo", "bo@hhu.de", 1300_00, "Informatik");
        Person kira = new Teacher("Kira", "kira@hhu.de", 1100_00, "Informatik");

        // Welche der vier Varianten funktioniert?
//        System.out.println(Teacher.CURRENCY);
//        System.out.println(anna.CURRENCY);
//        System.out.println(bo.CURRENCY);
//        System.out.println(kira.CURRENCY);

        System.out.println("== Aufgaben 14-15");

        Teacher hanna = new Teacher("Hanna", "hanna@hhu.de", 1500_00, "Computerlinguistik");
        Employee bob = new Employee("Bob", "bob@hhu.de", 1300_00);
        Person kim = new Person("Kim", "kim@hhu.de");
        Person eve = new Person("eve", "eve@hhu.de");
        Person bob2 = bob;
        
        // Welche der drei Varianten funktioniert?
//        System.out.println(Employee.richerPerson(hanna, bob));
//        System.out.println(Employee.richerPerson(kim, eve));
//        System.out.println(Employee.richerPerson(hanna, bob2));
    }
}
