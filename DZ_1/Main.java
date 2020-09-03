package DZ_1;

public class Main {

    public static void main (String[] args){

        // task_2
        int val_1 = 1;
        double val_2 = 2.0;
        char val_3 = '#';
        boolean isReal = false;
        String name = "Boris";

        // task_3
        int a = 3;
        int b = 6;
        double c = (double) -2;
        int d = -5;
        System.out.println("task_3: Результат a * (b + (c / d)) = "+ task_3(a, b, c, d));
        // task_4
        System.out.println("task_4: a + b IS BETWEEN 10 AND 20 = "+ task_4(a, b));
        // task_5
        System.out.println("task_5: d = "+ task_5(d));
        // task_6
        System.out.println("task_6: d IS Negative = "+ task_6(d));
        // task_7
        System.out.println("task_7: "+ task_7(name));
        // task_8
        int age = 2020;
        System.out.println("task_8: ГОД "+age+" является високосным? - "+ task_9(age));
    }

    private static double task_3(int a, int b, double c, int d) {
        return a * (b + (c / d));
    }

    private static boolean task_4(int a, int b) {
        return (a+b >= 10 && a+b <= 20);
    }
    private static String task_5(int d) {
        if (d < 0) return "отрицательное";
        else return "положительное";
    }

    private static boolean task_6(int d) {
        return (d < 0);

    }

    private static String task_7(String name) {
        return "Привет, " + name + "!";

    }

    private static boolean task_9(int age) {
        return (age%400 == 0 || (age%4 == 0 && age%100 != 0));

    }


}
