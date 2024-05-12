package by.aston.bakumenko.thirdTask;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isHungry;

    public Cat() {
        catCount++;
        isHungry = false;
    }

    public static int getCatCount() {
        return catCount;
    }

    public void eat(FoodBowl foodBowl, int amount) {
        if (foodBowl.getFoodAmount() >= amount) {
            foodBowl.decreaseFood(amount);
            isHungry = true;
            System.out.println("Кот поел.");
        } else {
            System.out.println("В миске недостаточно еды для кота.");
        }
    }

    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот пробежал " + distance + " м.");
        } else {
            System.out.println("Кот не может пробежать такое расстояние.");
        }
    }

    public void swim(int distance) {
        System.out.println("Кот не умеет плавать.");
    }
}