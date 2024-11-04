package studentGradeTracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentGradeTracker 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
        String input;

        System.out.println("Welcome to the Student Grade Tracker!");

        // Input grades
        do {
            System.out.print("Enter a student's grade (or type 'exit' to finish): ");
            input = scanner.nextLine();

            if (!input.equalsIgnoreCase("exit")) {
                try {
                    double grade = Double.parseDouble(input);
                    if (grade >= 0 && grade <= 100) {
                        grades.add(grade);
                    } else {
                        System.out.println("Please enter a grade between 0 and 100.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric grade.");
                }
            }
        } while (!input.equalsIgnoreCase("exit"));

        // Calculate and display results
        if (!grades.isEmpty()) {
            double average = calculateAverage(grades);
            double highest = Collections.max(grades);
            double lowest = Collections.min(grades);

            System.out.println("\nGrade Report:");
            System.out.printf("Average Grade: %.2f%n", average);
            System.out.printf("Highest Grade: %.2f%n", highest);
            System.out.printf("Lowest Grade: %.2f%n", lowest);
        } else {
            System.out.println("No grades entered.");
        }

        scanner.close();
    }

    // Method to calculate the average of the grades
    private static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
