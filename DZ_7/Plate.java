package DZ_7;

public class Plate {
    protected int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println(this);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "В миске есть " + food + " порций корма\n";
    }

    public void add_food(int food) {
        this.food += food;
        System.out.printf("   Хозяин отсыпал в миску %d порций корма \n", food);
    }

    public void decreaseFood(int food, String name) {
        this.food -= food;
        System.out.printf("   Кот " + name + " пожирает %d порций корма ", food);
    }

}
