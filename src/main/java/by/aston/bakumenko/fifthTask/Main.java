package by.aston.bakumenko.fifthTask;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "111-22-33");
        phoneBook.add("Петров", "991-00-89");
        phoneBook.add("Иванов", "563-76-93");
        phoneBook.add("Иванов", "418-01-03");
        phoneBook.add("Сидоров", "270-90-85");
        List<String> ivanovPhoneNumbers = phoneBook.get("Иванов");
        System.out.println("Иванов: " + ivanovPhoneNumbers);
        List<String> petrovPhoneNumber = phoneBook.get("Петров");
        System.out.println("Петров: " + petrovPhoneNumber);
        List<String> sidorovPhoneNumber = phoneBook.get("Сидоров");
        System.out.println("Сидоров: " + sidorovPhoneNumber);
    }
}