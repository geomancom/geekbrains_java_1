/*
* Домашка № 2
* Борис M.
* */

package DZ_2;

import java.util.Arrays;

public class Main {
    public static final int SIZE = 8;

    public static void main(String[] args) {

        // task_1
        int[] data_1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        task_1(data_1);
        // task_2
        int[] data_2 = new int[SIZE];
        task_2(data_2);
        // task_3
        int[] data_3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        task_3(data_3);
        // task_4
        int[][] data_4 = new int[SIZE][SIZE];
        task_4(data_4);
        // task_5
        task_5(data_3);

    }
    private static void task_5(int[] data) {
        System.out.println("task_5 исходный массив data_3 = " + Arrays.toString(data));
        int i = 0;
        int i_max = data[i];
        int i_min = data[i];
        while (i < data.length) {
            if (data[i] < i_min) {
                i_min = data[i];
            }
            if (data[i] > i_max) {
                i_max = data[i];
            }
            i++;
        }
        System.out.println("i_max = " + i_max);
        System.out.println("i_min = " + i_min);

    }


    private static void task_4(int[][] data) {
        System.out.println("task_4");
        int i = 0;
        while (i < data.length) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    data[i][j] = 1;
                }
                if (j == (data.length-1) - i) {
                    data[i][j] = 1;
                }
            }
            i++;
        }
        //System.out.println("task_4 NEW " + Arrays.toString(data));
        for (int[] datum : data) {
            for (int i1 : datum) {
                System.out.print(i1+" ");
            }
            System.out.println("");
        }


    }


    private static void task_3(int[] data) {
        System.out.println("task_3 OLD " + Arrays.toString(data));
        int i = 0;
        while (i < data.length) {
            if (data[i] < 6) {
                data[i] = data[i] * 2;
            }
            i++;
        }
        System.out.println("task_3 NEW " + Arrays.toString(data));

    }


    private static void task_2(int[] data) {
        System.out.println("task_2 OLD " + Arrays.toString(data));
        int i = 0;
        while (i < data.length - 1) {
            i++;
            data[i] = data[i - 1] + 3;
        }
        System.out.println("task_2 NEW " + Arrays.toString(data));

    }

    private static void task_1(int[] data) {
        System.out.println("task_1 OLD " + Arrays.toString(data));
        for (int i = 0; i < data.length; i++) {
            switch (data[i]) {
                case 0: {
                    data[i] = 1;
                    break;
                }
                case 1:
                    data[i] = 0;
            }
        }
        System.out.println("task_1 NEW " + Arrays.toString(data));
    }
}
