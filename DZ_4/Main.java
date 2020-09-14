package DZ_4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 3;

    public static final String DOT_EMPTY = "*";
    public static final String DOT_HUMAN = "X";
    public static final String DOT_AI = "0";
    public static final String EMPTY = " ";
    public static final String EMPTY_FIRST = "  ";


    public static final String[][] map = new String[SIZE][SIZE];
    public static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();

    public static void main(String[] args) {
        init_map();
        show_map();
        play_game();


    }


    public static void init_map() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void show_map() {
        show_map_header();
        show_map_row();
    }


    private static void show_map_header() {
        System.out.print(EMPTY_FIRST);
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + EMPTY);
        }
    }

    private static void show_map_row() {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + EMPTY);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + EMPTY);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void play_game() {
        while (true) {
            human_turn();
            show_map();
            if (check_end(DOT_HUMAN)) {
                System.exit(0);
            }
            ai_turn();
            show_map();
            if (check_end(DOT_AI)) {
                System.exit(0);
            }
        }
    }


    private static void human_turn() {
        int row_number, column_number;
        do {
            System.out.println("Ход человека");
            System.out.print("Ведите Х = ");
            column_number = scanner.nextInt();
            System.out.print("Ведите Y = ");
            row_number = scanner.nextInt();
        } while (!is_cell_valid(row_number, column_number));
        map[row_number - 1][column_number - 1] = DOT_HUMAN;
    }


    private static boolean is_cell_valid(int row_number, int column_number, boolean is_AI) {
        // проверка диапазонов
        if (!is_AI && ((row_number < 1) || (row_number > SIZE) || (column_number < 1) || (column_number > SIZE))) {
            System.out.printf("Проверьте диавазоны значений входных данных они не должны привышать %d\n", SIZE);
            return false;
        }
        // Проверка сбободных ячеик
        if (map[row_number - 1][column_number - 1] != DOT_EMPTY) {
            if (!is_AI)
                System.out.printf("Вы выбрали %d, %d Уже занятую ячейку, выбирете другую ячейку\n\n", row_number, column_number);
            return false;
        }

        return true;
    }

    private static boolean is_cell_valid(int row_number, int column_number) {
        return is_cell_valid(row_number, column_number, false);
    }

    private static void ai_turn() {
        int row_number, column_number;
        System.out.println("Ход компьютера");
        do {
            row_number = random.nextInt(SIZE) + 1;
            column_number = random.nextInt(SIZE) + 1;
        } while (!is_cell_valid(row_number, column_number, true));
        map[row_number - 1][column_number - 1] = DOT_AI;
    }

    private static boolean check_end(String dot) {
        if (check_win(dot)) {
            String win_message;
            if (dot == DOT_HUMAN) {
                win_message = "Поздравляем Вы победили !!!";
            } else {
                win_message = "Компьютер победил";
            }
            System.out.println(win_message);
            return true;
        }
        if (is_map_full()) {
            System.out.println("Ишра законченна ничьей!");
            return true;
        }
        return false;
    }

    private static boolean check_win(String dot) {
        if (checking_horizontal(dot)) {
            return true;
        }
        if (checking_vertical(dot)) {
            return true;
        }
        if (checking_diagonal_1(dot)) {
            return true;
        }
        if (checking_diagonal_2(dot)) {
            return true;
        }
        return false;
    }

    private static boolean checking_horizontal(String dot) {
        int check_count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == dot) {
                    check_count++;
                    if (check_count == DOTS_TO_WIN) {
                        // System.out.printf("Совпало количество %d, что проверяем " + dot+"\n", SIZE);
                        return true;
                    }
                } else {
                    check_count = 0;
                }
            }
            check_count = 0;
        }
        return false;
    }

    private static boolean checking_vertical(String dot) {
        int check_count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == dot) {
                    check_count++;
                    if (check_count == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    check_count = 0;
                }
            }
            check_count = 0;
        }
        return false;
    }

    private static boolean checking_diagonal_1(String dot) {
        if (checking_diagonal_1_main(dot)) {
            return true;
        }
        if(SIZE > 3){
            if (checking_diagonal_1_left(dot)) {
                return true;
            }
        }
        if (SIZE > 4){
            if (checking_diagonal_1_left2(dot)) {
                return true;
            }
        }
        if (checking_diagonal_1_right(dot)) {
            return true;
        }
        if (checking_diagonal_1_right2(dot)) {
            return true;
        }
        return false;
    }

    private static boolean checking_diagonal_1_main(String dot) {
        int check_count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == dot) {
                check_count++;
                if (check_count == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                check_count = 0;
            }
        }
        return false;
    }

    private static boolean checking_diagonal_1_left(String dot) {
        int check_count_left = 0;
        for (int i = 0; i < SIZE - 1; i++) {
            // map[i+ 1][i] = "5";
            if (map[i + 1][i] == dot) {

                check_count_left++;
                if (check_count_left == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                check_count_left = 0;
            }
        }
        if (map[SIZE-1][SIZE-1] == dot) {
                check_count_left++;
                if (check_count_left == DOTS_TO_WIN) {
                    return true;
                }
            }
        return false;
    }

    private static boolean checking_diagonal_1_left2(String dot) {
        int check_count_left = 0;
        for (int i = 0; i < SIZE - 2; i++) {
            // map[i+ 2][i] = "6";
            if (map[i + 2][i] == dot) {
                check_count_left++;
                if (check_count_left == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        if (map[SIZE-1][SIZE-1] == dot) {
            check_count_left++;
            if (check_count_left == DOTS_TO_WIN) {
                return true;
            }
        }

        return false;
    }

    private static boolean checking_diagonal_1_right(String dot) {
        int check_count_left = 0;
        for (int i = 0; i < SIZE - 1; i++) {
            // map[i][i+ 1] = "7";
            if (map[i ][i + 1] == dot) {

                check_count_left++;
                if (check_count_left == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                check_count_left = 0;
            }
        }
        if (map[SIZE-1][SIZE-1] == dot) {
            check_count_left++;
            if (check_count_left == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    private static boolean checking_diagonal_1_right2(String dot) {
        int check_count_left = 0;
        for (int i = 0; i < SIZE - 2; i++) {
            // map[i][i+ 2] = "8";
            if (map[i][i + 2] == dot) {
                check_count_left++;
                if (check_count_left == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        if (map[SIZE-1][SIZE-1] == dot) {
            check_count_left++;
            if (check_count_left == DOTS_TO_WIN) {
                return true;
            }
        }

        return false;
    }

    private static boolean checking_diagonal_2(String dot) {
        if (checking_diagonal_2_main(dot)) {
            return true;
        }
        if(SIZE > 3){
            if (checking_diagonal_2_left(dot)) {
                return true;
            }
        }
        if (SIZE > 4){
            if (checking_diagonal_2_left2(dot)) {
                return true;
            }
        }
        if (checking_diagonal_2_right(dot)) {
            return true;
        }
        if (checking_diagonal_2_right2(dot)) {
            return true;
        }
        return false;
    }

    private static boolean checking_diagonal_2_main(String dot) {
        int check_count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[SIZE - 1 - i][i] == dot) {
                check_count++;
                if (check_count == DOTS_TO_WIN) {
                    return true;
                } else {
                    check_count = 0;
                }
            }
        }
        return false;
    }

    private static boolean checking_diagonal_2_left(String dot) {
        int check_count_left = 0;
        for (int i = 0; i < SIZE - 1; i++) {
            // map[SIZE - 2 - i][i] = "5";
            if (map[SIZE - 2 - i][i] == dot) {

                check_count_left++;
                if (check_count_left == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                check_count_left = 0;
            }
        }
        return false;
    }

    private static boolean checking_diagonal_2_left2(String dot) {
        int check_count_left = 0;
        for (int i = 0; i < SIZE - 2; i++) {
            // map[SIZE - 3- i][i] = "6";
            if (map[SIZE - 3- i][i] == dot) {
                check_count_left++;
                if (check_count_left == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checking_diagonal_2_right(String dot) {
        int check_count_left = 0;
        for (int i = 0; i < SIZE - 1; i++) {
            // map[SIZE - 1 - i][i+ 1] = "7";
            if (map[SIZE - 1 - i][i + 1] == dot) {

                check_count_left++;
                if (check_count_left == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                check_count_left = 0;
            }
        }
        return false;
    }

    private static boolean checking_diagonal_2_right2(String dot) {
        int check_count_left = 0;
        for (int i = 0; i < SIZE - 2; i++) {
            // map[SIZE - 1 - i][i+ 2] = "8";
            if (map[SIZE - 1 - i][i + 2] == dot) {
                check_count_left++;
                if (check_count_left == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean is_map_full() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

}

