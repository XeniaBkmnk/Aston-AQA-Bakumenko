package by.aston.bakumenko.secondTask;

public class Park {
    private Attraction[] attractions;

    public Park() {
        this.attractions = new Attraction[5];
    }

    public void addAttraction(int index, String attractionName, String workHour, String cost) {
        attractions[index] = new Attraction(attractionName, workHour, cost);
    }

    public void displayAttractions() {
        for (Attraction attraction : attractions) {
            attraction.display();
            System.out.println("-------------------");
        }
    }

    public class Attraction {
        private String attractionName;
        private String workHour;
        private String cost;

        public Attraction(String attractionName, String workHour, String cost) {
            this.attractionName = attractionName;
            this.workHour = workHour;
            this.cost = cost;
        }

        private void display() {
            System.out.println("Название аттракциона: " + attractionName);
            System.out.println("Время работы: " + workHour);
            System.out.println("Цена: " + cost);
        }
    }
}