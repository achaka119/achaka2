public class Car {
    String brand;
    int year;

    public Car(String brand, int year){
        this.brand = brand;
        this.year = year;
    }

    void start() {
        System.out.println("car started");
    }

    public String toString(){
        return ("brand - " + brand +  " year - " + year);

    }
}
