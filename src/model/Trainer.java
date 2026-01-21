package model;

public abstract class Trainer {
    private int Id;
    private String name;
    private int age;
    private int experienceYears;
    private double salary;

    public Trainer(int Id, String name, int age, int experienceYears, double salary) {
        this.Id = Id;
        this.name = name;
        this.age = age;
        this.experienceYears = experienceYears;
        this.salary = salary;

    }

    public String getName() { return name; }

    public int getId() { return Id; }
    public void setId(int Id) { this.Id = Id; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    public boolean isSenior() {
        return experienceYears >= 5;
    }

    public void giveRaise(double percent) {
       double newSalary =  salary * (1 + percent / 100);
       setSalary(newSalary);
    }

    @Override
    public String toString() {
        return "model.Trainer{" +
                "trainerId=" + Id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", experienceYear=" + experienceYears +
                ", salary=" + salary +
                '}';
    }

}
