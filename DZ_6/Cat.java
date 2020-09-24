package DZ_6;

public class Cat extends Animals implements Run, Sail, Jump {
    public static final int CAT_RUN_MAX = 200;
    public static final int CAT_SAIL_MAX = 0;
    public static final double CAT_JUMP_MAX = 2;

    public Cat(String tip, int run, int sail, double jump) {

        super(tip, run, sail, jump);
    }

    @Override
    public void run(int meters) {
        if (meters <= CAT_RUN_MAX) {
            System.out.println("Кошка сможет бежать " + meters + " м.");
        } else {
            System.out.println("Кошка не сможет бежать " + meters + " м. она пойдет по своим делам");
        }

    }

    @Override
    public void sail(int meters) {
        System.out.println("Кошки вообще не умеют плавать");
    }

    @Override
    public void jump(double height) {
        if (height <= CAT_JUMP_MAX) {
            System.out.println("Кошка сможет прыгнуть на " + height + " м.");
        }
        else {
            System.out.println("Кошка не резиновый мячь она не сможет прыгнуть на " + height + " м.");
        }
    }
}
