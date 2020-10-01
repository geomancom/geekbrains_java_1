package DZ_7;

import java.util.Random;

public class Cat {
    final int STARVE_IN_HORA = 2;
    final int WISH_STARVE = 4;
    public static final Random random = new Random();

    protected final String name;
    private int appetite;
    private int satiety;

    public Cat(String name, int appetite, int satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;

    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public void eat(Plate plate) {
        System.out.println("Кот подходит к миске: ");
        if (satiety <= WISH_STARVE) {
            if (plate.getFood() >= appetite) {
                do_eat(plate);
            } else {
                System.out.println("   Коту мало еды, он кричит 'Хозяин дай пожрать, конечно используя Мяу мяу': ");
                plate.add_food(random.nextInt(3) + 4);
            }
        }else {
            System.out.println("   Кот смотрит на миску сытыми глазами, и идет спать': ");
        }
    }

    private void do_eat(Plate plate) {
        plate.decreaseFood(appetite);
        satiety = satiety + appetite;
        System.out.printf("      Кот имеет %d единиц сытости ", satiety);
    }

    public void starve() {
        satiety = satiety - STARVE_IN_HORA;
        System.out.printf("      Кот имеет %d единиц сытости\n", satiety);
    }
}
