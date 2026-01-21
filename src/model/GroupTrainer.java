package model;

public class GroupTrainer extends Trainer implements Trainable {
    public int maxGroupSize;

    public GroupTrainer(int Id, String name, int age, int experienceYears, double salary, int maxGroupSize) {
        super(Id, name, age, experienceYears, salary);
        this.maxGroupSize = maxGroupSize;

    }

    public void work() {
        System.out.println("group trainer is working  ");
    }

    public String getType() {
        return "GroupTrainer" + "maxGroupSize " + maxGroupSize;
    }

    @Override
    public void train() {
        System.out.println("groupTrainer " + super.getName() + " with maxGroupSize " + maxGroupSize +  " is training ");

    }
}
