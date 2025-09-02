/*
 * GradeCalculator.java
 *
 * Simple calculator for student grades
 *
 * Copyright (c) 2025 YC2O. All rights reserved.
 * Author: yc2o
 * Version: 1.0.0
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class for calculating and displaying student grades.
 * 
 * @author yc2o
 * @version 1.0.0
 * @since 1.0.0
 */
public class GradeCalculator {
    //UI Constants
    private static final String WELCOME_MESSAGE = "=        Selamat Datang di Kalkulator Nilai Mahasiswa!         =";
    private static final String ADD_STUDENT_PROMPT = "Apakah Kamu ingin menambahkan mahasiswa lain? (ya/tidak): ";
    private static final String THANK_YOU_MESSAGE = "=  Terima kasih telah menggunakan Kalkulator Nilai Mahasiswa!  =";
    private static final String STUDENT_DATA_HEADER = "=" + " ".repeat(24) + "Data Mahasiswa" + " ".repeat(24) + "=";
    private static final String SEPARATOR_LINE = "=".repeat(64);
    private static final String DASH_LINE = "-".repeat(64);

    //instance variables
    private List<Student> students;
    private Scanner scanner;

    public GradeCalculator(Scanner scanner) {
        this.students = new ArrayList<>();
        this.scanner = scanner;
    }

    /**
     * Main method to start the Grade Calculator application.
     * 
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            GradeCalculator gradeCalculator = new GradeCalculator(scanner);
            gradeCalculator.startProgram();
        }
    }

    /**
     * Run the main program flow.
     */
    public void startProgram() {
        printWelcomeMessage();
        collectStudentData();
        printAllStudentData();
        exitProgram();
    }

    /**
     * Print the welcome message.
     */
    private void printWelcomeMessage() {
        System.out.println(SEPARATOR_LINE);
        System.out.println(WELCOME_MESSAGE);
        System.out.println(SEPARATOR_LINE);
    }

    /**
     * Collect the student data from user.
     */
    private void collectStudentData() {
        while (true) {
            try {
                Student student = new Student();
                student.askStudentData(this.scanner);
                addStudentToList(student);

                if (!shouldContinueAddingStudents()) {
                    break;
                }
                System.out.println(DASH_LINE);
            } catch (Exception e) {
                System.err.println("Terjadi error: " + e.getMessage());
                break;
            }
        }
    }

    /**
     * Add a student to the list.
     * 
     * @param student the student to add
     */
    private void addStudentToList(Student student) {
        this.students.add(student);
    }

    /**
     * Check if the user wants to continue adding students.
     * 
     * @return true if the user wants to add more students, false otherwise
     */
    private boolean shouldContinueAddingStudents() {
        System.out.print(ADD_STUDENT_PROMPT);
        String response = this.scanner.nextLine();

        return response.equalsIgnoreCase("ya") || response.equalsIgnoreCase("y");
    }

    /**
     * Print all student data.
     */
    private void printAllStudentData() {
        if (students == null || students.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa untuk ditampilkan.");
            return;
        }

        System.out.println(SEPARATOR_LINE);
        System.out.println(STUDENT_DATA_HEADER);
        System.out.println(SEPARATOR_LINE);

        for (Student student : students) {
            if (student != null) {
                student.printInfo();
                System.out.println(DASH_LINE);
            }
        }
    }

    /**
     * Exit the program.
     */
    private void exitProgram() {
        System.out.println(SEPARATOR_LINE);
        System.out.println(THANK_YOU_MESSAGE);
        System.out.println(SEPARATOR_LINE);
    }
}
