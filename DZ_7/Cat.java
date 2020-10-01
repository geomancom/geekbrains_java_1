package DZ_7;

import java.util.Random;

public class Cat {
    final int STARVE_IN_HORA = 2;
    //final int WISH_STARVE = 4;
    public static final Random random = new Random();
    final int PORTION = 10;

    protected final String name;
    private int appetite;
    private int satiety;
    private int wish_stare;

    public Cat(String name, int appetite, int satiety, int wish_stare) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
        this.wish_stare = wish_stare;

    }

    public int getWish_stare() {
        return wish_stare;
    }

    public void setWish_stare(int wish_stare) {
        this.wish_stare = wish_stare;
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
        System.out.println("Кот  " + name + "  подходит к миске:");
        if (satiety <= wish_stare) {
            if (plate.getFood() >= appetite) {
                do_eat(plate);
            } else {
                System.out.println("   Коту " + name + " мало еды, он кричит 'Хозяин дай пожрать, конечно используя Мяу мяу':");
                plate.add_food(random.nextInt(PORTION) + 5);
                do_eat(plate);
            }
        } else {
            System.out.println("   Кот  " + name + "  смотрит на миску сытыми глазами, и идет спать':");
        }
    }

    private void do_eat(Plate plate) {
        plate.decreaseFood(appetite, name);
        satiety = satiety + appetite;
        System.out.printf("      Кот " + name + " имеет %d единиц сытости\n", satiety);
    }

    public void starve() {
        satiety = satiety - STARVE_IN_HORA;
        System.out.printf("      Кот  " + name + "  имеет %d единиц сытости\n", satiety);
    }
}
