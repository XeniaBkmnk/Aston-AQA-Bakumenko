package by.aston.bakumenko.thirdTask.task1;

public class FoodBowl {
    private int foodAmount;

    public FoodBowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
        } else {
            System.out.println("В миске недостаточно еды.");
        }
    }

    public void addFood(int amount) {
        foodAmount += amount;
        System.out.println("В миску добавлена еда: " + amount + " еды.");
    }
}