import java.util.Scanner;

/**
 * Class representing a student.
 * 
 * @author yc2o
 * @version 1.0.0
 * @since 1.0.0
 */
public class Student {
    // Weight Constants
    private static final double TASK_WEIGHT = 30/100.0;
    private static final double UTS_WEIGHT = 30/100.0;
    private static final double UAS_WEIGHT = 40/100.0;
    private static final int MIN_GRADE = 0;
    private static final int MAX_GRADE = 100;

    // Label Constant
    private static final String GRADE_ERROR_LABEL = "Nilai tidak valid. Silakan masukkan nilai antara " + MIN_GRADE + " dan " + MAX_GRADE + ".";
    private static final String GRADE_MISMATCH_ERROR_LABEL = "Input harus berupa angka. Silakan coba lagi.";
    private static final String NAME_ERROR_LABEL = "Nama tidak boleh kosong dan hanya boleh mengandung huruf dan spasi. Silakan coba lagi.";

    // Instance Variables
    private String name;
    private int taskGrade;
    private int utsGrade;
    private int uasGrade;
    private double totalGrade;

    /**
     * Collect the students data.
     * 
     * @param scanner the scanner to read user input
     */
    public void askStudentData(Scanner scanner) {
        askValidName(scanner);
        askGrade(scanner, "tugas", "task");
        askGrade(scanner, "UTS", "uts");
        askGrade(scanner, "UAS", "uas");
        this.totalGrade = calculateTotalGrade();
    }

    /**
     * Ask for a valid name.
     * 
     * @param scanner the scanner to read user input
     */
    private void askValidName(Scanner scanner) {
        while (true) {
            System.out.print("Masukkan nama: ");
            this.name = scanner.nextLine();
            
            if (isValidName(this.name)) {
                break;
            } else {
                System.err.println(NAME_ERROR_LABEL);
            }
        }
    }

    /**
     * Check if the given name is valid.
     * The name should not be null, empty, or less than 2 characters
     * and should only contain letters and spaces.
     * 
     * @param name the name to check
     * @return true if the name is valid, false otherwise
     */
    private boolean isValidName(String name) {
        return name != null && 
            !name.trim().isEmpty() && 
            name.trim().length() >= 2 &&
            name.matches("[a-zA-Z\\s]+");
    }

    /**
     * Ask for a valid grade.
     * 
     * @param scanner the scanner to read user input
     * @param gradeType the type of grade (e.g., "tugas", "UTS", "UAS")
     * @param fieldName the field name to set the grade (e.g., "task", "uts", "uas")
     */
    private void askGrade(Scanner scanner, String gradeType, String fieldName) {
        while (true) {
            try {
                System.out.print("Masukkan nilai " + gradeType + ": ");
                int grade = scanner.nextInt();
                scanner.nextLine(); //clear buffer

                if (isValidGrade(grade)) {
                    setGradeByType(fieldName, grade);
                    break;
                } else {
                    System.err.println(GRADE_ERROR_LABEL);
                }
            } catch (java.util.InputMismatchException e) {
                System.err.println(GRADE_MISMATCH_ERROR_LABEL);
                scanner.nextLine(); //clear buffer
            }
        }
    }

    /**
     * Set the grade for the specified field.
     * 
     * @param fieldName the field name to set the grade (e.g., "task", "uts", "uas")
     * @param grade the grade to set
     */
    private void setGradeByType(String fieldName, int grade) {
        switch (fieldName) {
            case "task" -> this.taskGrade = grade;
            case "uts" -> this.utsGrade = grade;
            case "uas" -> this.uasGrade = grade;
        }
    }

    /**
     * Check if the given grade is valid.
     * The grade should be between MIN_GRADE and MAX_GRADE.
     * 
     * @param grade the grade to check
     * @return true if the grade is valid, false otherwise
     */
    private boolean isValidGrade(int grade) {
        return grade >= MIN_GRADE && grade <= MAX_GRADE;
    }

    /**
     * Calculate the total grade based on weighted averages.
     * 
     * @return the calculated total grade
     */
    private double calculateTotalGrade() {
        return (this.taskGrade * TASK_WEIGHT) +
               (this.utsGrade * UTS_WEIGHT) +
               (this.uasGrade * UAS_WEIGHT);
    }

    /**
     * Print the student's information.
     */
    public void printInfo() {
        System.out.println("Nama : " + this.name);
        System.out.println("Nilai Tugas : " + this.taskGrade);
        System.out.println("Nilai UTS : " + this.utsGrade);
        System.out.println("Nilai UAS : " + this.uasGrade);
        System.out.printf("Nilai Akhir : %.1f%n", this.totalGrade);
    }
}
