class Teacher extends Employee {
    private final String subject;
    static final String CURRENCY = "SWS";

    Teacher(String name, String mail, int salary, String subject) {
        System.out.println("> Konstruktor Teacher(String, String, int, String)");
        super(name, mail, salary);
        this.subject = subject;
    }
    
    String getSubject() {
        return subject;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n  Subject: " + subject;
    }
}
