package DZ_8_fin;

public class logics {
    public static final int RANGE = 9;
    public static int number = start();
    public static int cycle = 1;

    public logics(int user_number) {
        logics.main(user_number);
    }

    public static void main(int user_number) {
        System.out.println("cycle = " +cycle);
        if (cycle > 3) {
        }else{
            doCycle(user_number);
            cycle++;
        }
    }


    public static int start() {
        System.out.println("\nВведите число от 0 до 9: ");
        return (int) (Math.random() * RANGE);
    }




    private static void doCycle(int user_number) {
        String info = "загаданное число = "+user_number;
        if (user_number == number) {
            info = "Вы угадали загаданное число = "+user_number;
            System.out.printf("Вы угадали загаданное число = %d \n", number);
            cycle = 3;
        } else if (user_number > number) {
            info = "загаданное число меньше";
            System.out.printf("Попробуйте еще раз, загаданное число меньше.\nУ Вас осталось еще %d попыток\n", 3 - cycle);
        } else {
            info = "загаданное число больше";
            System.out.printf("Попробуйте еще раз, загаданное число больше.\nУ Вас осталось еще %d попыток\n", 3 - cycle);
        }
        //Label_result.setText(info);
        // И ВОТ ТУТ ПРОБЛЕМА ЗАРЫТА
    }
}
