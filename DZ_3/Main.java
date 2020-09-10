package DZ_3;

import java.util.Scanner;

public class Main {
    public static final int RANGE = 9;
    public static int number = start();
    public static int cycle = 1;

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            if (cycle > 3) {
                doQuestion();
            }else{
                doCycle();
                cycle++;
            }
        }
    }



    private static void doCycle() {
        int user_number = in.nextInt();
        if (user_number == number) {
            System.out.printf("Вы угадали загаданное число = %d", number);
            cycle = 3;
        } else if (user_number > number) {
            System.out.printf("Попробуйте еще раз, загаданное число меньше.\nУ Вас осталось еще %d попыток\n", 3 - cycle);
        } else {
            System.out.printf("Попробуйте еще раз, загаданное число больше.\nУ Вас осталось еще %d попыток\n", 3 - cycle);
        }
    }

    private static void doQuestion() {
            System.out.println("\nПовторить игру еще раз? 1 – да / 0 – нет");
            int user_number_exit = in.nextInt();
            switch (user_number_exit) {
                case 1:
                    number = start();
                    cycle = 1;
                    break;
                case 0:
                    doExit();
                default:
                    System.out.println("Выберите или 0 или 1, Повторить игру еще раз? 1 – да / 0 – нет\n");
            }
    }

    private static int start() {
        System.out.println("\nВведите число от 0 до 9: ");
        return (int) (Math.random() * RANGE);
    }

    private static void doExit() {
        System.out.println("Вы точно хотите выйти? y/n");
        if (in.next().equals("y")){
            System.exit(0);
        }
    }

}
