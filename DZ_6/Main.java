package DZ_6;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Кошка", 200, 0, 2.0);
        Dog dog = new Dog("Собака",500, 10, 0.5);

        start(cat, dog);

        checks_animals(cat, dog);
    }


    private static void start(Cat cat, Dog dog) {
        System.out.println("Максимальные характеристики ");
        cat.print_info();
        dog.print_info();
    }

    private static void checks_animals(Cat cat, Dog dog) {

        cat.run(100);
        cat.sail(20);
        cat.jump(1.5);

        dog.run(300);
        dog.sail(10);
        dog.jump(6);
    }

}
