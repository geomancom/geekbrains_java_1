package DZ_7;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("tom", 5, 0);
        Plate plate = new Plate(5);

        plate.info();
        cat.eat(plate);
        plate.info();
        plate.add_food(6);
        plate.info();
        int horas = 24;
        while (horas > 0){
            cat.eat(plate);
            plate.info();
            horas--;
            System.out.println("Прошел час кот(ы) голодают");
            cat.starve();
        }
    }
}
