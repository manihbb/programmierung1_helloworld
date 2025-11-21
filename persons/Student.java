class Student extends Person {
    private final int studentNumber;
    static final int INVALID_STUDENT_NUMBER = -1;
    
    Student(String name, String mail, int studentNumber) {
        System.out.println("> Konstruktor Student(String, String, int)");
        super(name, mail);
        this.studentNumber = studentNumber;
    }
    
    Student(String name, String mail) {
        System.out.println("> Konstruktor Student(String, String)");
        this(name, mail, INVALID_STUDENT_NUMBER);
    }
    
    int getStudentNumber() {
        return studentNumber;
    }
    
    @Override
    public String toString() {
        String studentNumberString = studentNumber == INVALID_STUDENT_NUMBER ? "<none>" : String.valueOf(studentNumber);
        return super.toString() + ", " + studentNumberString;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student student)) {
            return false;
        }
        return this.studentNumber == student.studentNumber;
    }
}
