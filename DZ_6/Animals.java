package DZ_6;

public class Animals {

    protected String tip;
    protected int run;
    protected int sail;
    protected double jump;

    public Animals(String tip, int run, int sail, double jump) {
        this.tip = tip;
        this.run = run;
        this.sail = sail;
        this.jump = jump;
    }

    public void print_info(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Животные типа: " + tip +
                "\n Максимальная дистанция для бега = " + run +
                " м.\n Максимальная дистанция для плавания = " + sail +
                " м.\n Максимальная высота для прыжка = " + jump+"\n";
    }
}
