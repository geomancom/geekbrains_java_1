package DZ_6;

public class Dog extends Animals implements Run, Sail, Jump{
    public static final int DOG_RUN_MAX = 500;
    public static final int DOG_SAIL_MAX = 10;
    public static final double DOG_JUMP_MAX = 0.5;

    public  Dog(String tip, int run, int sail, double jump){

        super(tip, run, sail, jump);
    }

    @Override
    public void run(int meters) {
        if (meters <= DOG_RUN_MAX){
            System.out.println("Собака сможет пробежать "+meters+" м.");
        }
        else{
            System.out.println("Собака не сможет пробежать "+meters+" м.");
        }
    }

    @Override
    public void sail(int meters) {
        if (meters <= DOG_SAIL_MAX ){
            System.out.println("Собака сможет проплыть "+meters+" м.");
        }
        else{
            System.out.println("Собака не сможет проплыть "+meters+" м.");
        }
    }

    @Override
    public void jump(double height) {
        if (height <= DOG_JUMP_MAX){
            System.out.println("Собака сможет прыгнуть на "+height+" м.");
        } else {
            System.out.println("Собака не сможет прыгнуть на "+height+" м.");
        }

    }
}
