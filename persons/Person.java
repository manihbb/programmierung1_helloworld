class Person {
    private final String name;
    private final String mailAddress;
    
    Person(String name, String mailAddress) {
        System.out.println("> Konstruktor Person(String, String)");
        this.name = name;
        this.mailAddress = mailAddress;
    }
    
    String getName() {
        return name;
    }
    
    String getMailAddress() {
        return mailAddress;
    }
    
    @Override
    public String toString() {
        return name + ", " + mailAddress;
    }
}
