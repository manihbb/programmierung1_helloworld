class Employee extends Person {
    private final int salary;
    static final String CURRENCY = "€";
    
    Employee(String name, String mail, int salary) {
        System.out.println("> Konstruktor Employee(String, String, double)");
        super(name, mail);
        this.salary = salary;
    }

    int getSalary() {
        return salary;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + salary + CURRENCY; 
    }
    
    static Employee richerPerson(Employee employee1, Employee employee2) {
        if(employee1.salary < employee2.salary) {
            return employee2;
        }
        return employee1;
    }
}
