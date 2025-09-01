/**
 * Class for storing employee data.
 * 
 * @author yc2o
 * @version 1.0.0
 * @since 1.0.0
 */
public class Employee {
    // Instance Variables
    private String name;
    private int hoursWorked;
    private int hourlyRate;

    /**
     * Constructor for Employee Class.
     * 
     * @param name employee's name
     * @param hoursWorked employee's hours worked
     * @param hourlyRate employee's hourly rate
     */
    public Employee(String name, int hoursWorked, int hourlyRate) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Calculate and return employee's salary.
     * 
     * @return employee's salary
     */
    protected int getSalary() {
        return this.hoursWorked * this.hourlyRate;
    }

    /**
     * Display employee's name and salary.
     */
    public void displayInfo() {

        System.out.println("Nama : " + this.name);
        System.out.println("Gaji : " + getSalary() + "\n");
    }
}
