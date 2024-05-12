package by.aston.bakumenko.thirdTask;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat();
        cats[1] = new Cat();
        cats[2] = new Cat();

        Dog dog = new Dog();

        cats[0].run(150);
        cats[1].run(250);
        cats[2].run(100);
        dog.run(300);

        cats[0].swim(7);
        dog.swim(7);
        cats[1].swim(10);

        FoodBowl foodBowl = new FoodBowl(10);

        cats[0].eat(foodBowl, 5);
        cats[1].eat(foodBowl, 10);
        cats[2].eat(foodBowl,14);
        foodBowl.addFood(19);
        cats[1].eat(foodBowl, 10);
        cats[2].eat(foodBowl,14);

        System.out.println("Количество созданных котов: " + Cat.getCatCount());
        System.out.println("Количество созданных собак: " + Dog.getDogCount());
        System.out.println("Общее количество созданных животных: " + (Cat.getCatCount() + Dog.getDogCount()));
    }
}