package DZ_5;

public class Employee {
    String full_name;
    String position;
    String email;
    String telephone;
    int salary;
    int age;

    public Employee(String full_name, String position, String email, String telephone, int salary, int age) {
        this.full_name = full_name;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    void ptint_info(){
        System.out.println(this);
    }

    @Override
    public String toString(){
        return "Сотрудник:\nФИО: "+full_name+"\nдолжность: "+position+"\nemail: "+email+"\nтелефон: "+telephone+"\nзарплата: "+salary+"\nвозраст "+age+"\n\n";
    }
}
