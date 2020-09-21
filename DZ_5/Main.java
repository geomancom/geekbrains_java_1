package DZ_5;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        task_1_3();

        task_4_5();
    }
    private static void task_1_3() {
        System.out.println("task_1-3 \n");
        Employee employee_1 = new Employee("Иван Иванович Иванов", "Инженер", "iii@compani.com", "32-20-20", 1000, 18);
        Employee employee_2 = new Employee("Петр Петрович Петров", "Старший инженер", "ppp@compani.com", "33-20-20", 2000, 42);

        employee_1.ptint_info();
        employee_2.ptint_info();
    }


    private static void task_4_5() {
        System.out.println("\ntask_4-5 \n");
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Иван Иванович Иванов", "Инженер", "iii@compani.com", "32-20-20", 1000, 18);
        persArray[1] = new Employee("Петр Петрович Петров", "Старший инженер", "ppp@compani.com", "33-20-20", 2000, 42);
        persArray[2] = new Employee("Светлана Святославовна Светлая", "дизайнер", "sssd@compani.com", "42-20-20", 1200, 34);
        persArray[3] = new Employee("Николай Николаевич Коляныч", "директор", "nnk@compani.com", "20-20-20", 10000, 44);
        persArray[4] = new Employee("Сергей Сергеевич Сергеев", "дембель", "sssl@compani.com", "20-20-20", 1000, 64);

        int i = 0;
        while (i < persArray.length) {
            if (persArray[i].age > 40) {
                persArray[i].ptint_info();

            }
            i++;
        }
    }

}
