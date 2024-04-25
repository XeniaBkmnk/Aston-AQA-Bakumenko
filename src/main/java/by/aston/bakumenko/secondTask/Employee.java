package by.aston.bakumenko.secondTask;

public class Employee {
    private String name;
    private String surname;
    private String middleName;
    private String post;
    private String email;
    private String phoneNumber;
    private String salary;
    private int age;

    public Employee(String name, String surname, String middleName, String post, String email, String phoneNumber, String salary, int age) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("MiddleName: " + middleName);
        System.out.println("Post: " + post);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
    }
}