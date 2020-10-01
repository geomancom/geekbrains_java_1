package DZ_7;

public class Main {

    public static void main(String[] args) {
        final int  NUMBERS_CATS = 3;
        final int TIME_INTERVAL = 4;

        Cat cat_1 = new Cat("tom", 5, 0, 4);
        Cat cat_2 = new Cat("kitty", 3, 0, 7);
        Cat cat_3 = new Cat("zarapka", 4, 0, 5);
        Plate plate = new Plate(7);
        Cat [] array_cat = new Cat[NUMBERS_CATS];
        array_cat[0] = cat_1;
        array_cat[1] = cat_2;
        array_cat[2] = cat_3;

        int horas = 24;
        while (horas > 0){
            for (Cat cat : array_cat) {
                plate.info();
                cat.eat(plate);
            }
            plate.info();
            horas = horas - TIME_INTERVAL;
            System.out.printf("Прошло %d часа коты голодают\n", TIME_INTERVAL);
            for (Cat cat : array_cat) {
                cat.starve();
            }



        }
    }
}
