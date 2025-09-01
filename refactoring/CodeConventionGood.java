/*
 * CodeConventionGood.java
 * 
 * Simple Application for calculating employee and manager salaries.
 * a Clean Code implementation modification for CodeConventionBad.java.
 * 
 * Copyright (c) 2025 YC2O. All rights reserved.
 * Author: yc2o
 * Version: 1.0.0
 */

/**
 * Class for running the main program.
 * 
 * @author yc2o
 * @version 1.0.0
 * @since 1.0.0
 */
public class CodeConventionGood {
    //UI Constants
    private static final String SEPARATOR_LINE = "=".repeat(40);
    
    /**
     * Main method for running the application.
     * 
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        Employee employee = new Employee("Budi", 40, 50000);
        Employee employee2 = new Employee("Ani", 38, 45000);
        Manager manager = new Manager("Toni", 45, 60000);

        System.out.println(SEPARATOR_LINE);
        System.out.println("=          Program Hitung Gaji         =");
        System.out.println(SEPARATOR_LINE);

        employee.displayInfo();
        employee2.displayInfo();
        manager.displayInfo();
    }
}
