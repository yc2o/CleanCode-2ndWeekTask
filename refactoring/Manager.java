/**
 * Class for storing manager data.
 * 
 * @author yc2o
 * @version 1.0.0
 * @since 1.0.0
 */
public class Manager extends Employee {

    /**
     * Constructor for Manager Class.
     * 
     * @param name manager's name
     * @param hoursWorked manager's hours worked
     * @param hourlyRate manager's hourly rate
     */
    public Manager(String name, int hoursWorked, int hourlyRate) {
        super(name, hoursWorked, hourlyRate);
    }

    /**
     * Display manager's name and salary.
     */
    @Override
    public void displayInfo() {
        System.out.println("Nama Manager: " + getName());
        System.out.println("Gaji Manager: " + getSalary() + "\n");
    }
}