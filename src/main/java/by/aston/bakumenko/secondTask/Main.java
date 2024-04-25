package by.aston.bakumenko.secondTask;

public class Main {
    public static void main(String[] args) {

        System.out.println("Task 1");
        Employee employee = new Employee("Masha", "Bodrova", "Olegovna", "Manager", "mari.work@gmail.com", "+375442223344", "5000$", 39);
        employee.displayInfo();

        System.out.println("Task 2");
        Employee[] employees2 = new Employee[5];
        employees2[0] = new Employee("Misha", "Lee", "Leonov", "Derector", "misha.55@gmail.com", "+487777654000", "7000$", 50);
        employees2[1] = new Employee("Pasha", "Loon", "Pavlovich", "Intern", "kot.love@gmail.com", "+788908765", "500$", 20);
        employees2[2] = new Employee("Olga", "Panova", "Igorevna", "Builder", "builder.ru@gmail.com", "+5578654000", "3900$", 39);
        employees2[3] = new Employee("Ann", "Lung", "Luisovna", "Manager", "manage.home@gmail.com", "+37529888776", "1200$", 25);
        employees2[4] = new Employee("Luis", "Pup", "Loongin", "Derector", "derector@gmail.com", "+375336667758", "4500$", 41);

        for (Employee employee2 : employees2) {
            employee2.displayInfo();
            System.out.println("---------------------------------------------");
        }

        System.out.println("Task 3");
        Park park = new Park();
        park.addAttraction(0, "Фараон", "c 10 do 21", "10p");
        park.addAttraction(1, "Ракушки", "c 10 do 21", "15p");
        park.addAttraction(2, "Колесо обозрения", "c 10 do 21", "13p");
        park.addAttraction(3, "Клоун", "c 10 do 21", "9p");
        park.addAttraction(4, "Лифт", "c 10 do 21", "12p");
        park.displayAttractions();
    }
}