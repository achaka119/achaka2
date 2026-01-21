package model;

public class PersonalTrainer extends Trainer implements Trainable {
    private String specialization;

    public PersonalTrainer(int Id, String name, int age, int experienceYears, double salary, String specialization) {
        super(Id, name, age, experienceYears, salary);
        this.specialization = specialization;

    }

    public void work() {
        System.out.println("personal trainer is Working ");
    }

    public String getType() {
        return "PersonalTrainer " + "specialization:  " + specialization;
    }

    @Override
    public void train() {
        System.out.println("PersonalTrainer " + super.getName() + " specialization " + specialization + " is training ");
    }
}
