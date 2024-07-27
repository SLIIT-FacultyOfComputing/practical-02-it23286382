package lab02;
import java.util.Scanner;

public class Marks {
    private static final int MAX_STUDENTS = 20;
    private static final int SUBJECTS = 3;
    private static int[][] stdsubArray = new int[MAX_STUDENTS][SUBJECTS + 1];  // +1 for student ID
    private static int count = 0;  // Number of students added

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int studentID = -1;  // Default to an invalid ID
        int subjectID;
        int mark;

        do {
            System.out.println("Choose an option:");
            System.out.println("1. Enter a student");
            System.out.println("2. Update marks of a student");
            System.out.println("3. Get the average marks for a subject");
            System.out.println("4. Get the average marks for a student");
            System.out.println("5. Get the total marks for a student");
            System.out.println("6. Get the grading for a student");
            System.out.println("7. Exit");

            choice = scanner.nextInt();

            if (choice != 3 && choice != 6 && choice != 7) {
                System.out.println("Enter the student ID (between 1 and 20):");
                studentID = scanner.nextInt();
                if (studentID < 1 || studentID > 20) {
                    System.out.println("Invalid ID");
                    choice = 9;  // Invalid choice to skip the operation
                    continue;
                } else {
                    System.out.println("You entered a valid ID");
                }
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter the student ID:");
                    int newStudentID = scanner.nextInt();
                    add(newStudentID);
                    break;
                case 2:
                    System.out.println("Enter the subject (1. Maths, 2. Chemistry, 3. Physics):");
                    subjectID = scanner.nextInt();
                    System.out.println("Enter the mark:");
                    mark = scanner.nextInt();
                    update(studentID, subjectID, mark);
                    break;
                case 3:
                    System.out.println("Enter the subject (1. Maths, 2. Chemistry, 3. Physics):");
                    subjectID = scanner.nextInt();
                    averageSubject(subjectID);
                    break;
                case 4:
                    averageStudent(studentID);
                    break;
                case 5:
                    total(studentID);
                    break;
                case 6:
                    grading(studentID);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please enter a valid number.");
                    break;
            }
        } while (choice != 7);

        scanner.close();
    }

    public static void add(int studentID) {
        if (count >= MAX_STUDENTS) {
            System.out.println("Cannot add more students. Array is full.");
            return;
        }

        stdsubArray[count][0] = studentID;
        for (int j = 1; j <= SUBJECTS; j++) {
            stdsubArray[count][j] = 0;  // Initialize marks to 0
        }
        count++;
        System.out.printf("Student with ID %d added successfully.%n", studentID);
    }

    public static void update(int studentID, int subjectID, int marks) {
        boolean found = false;
        for (int i = 0; i < count; i++) {  // Use `count` to iterate over added students
            if (stdsubArray[i][0] == studentID) {
                if (subjectID >= 1 && subjectID <= SUBJECTS) {
                    stdsubArray[i][subjectID] = marks;
                    System.out.printf("Student %d's marks were updated to %d for the subject %d.%n", studentID, marks, subjectID);
                } else {
                    System.out.println("Invalid subject ID.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Incorrect ID");
        }
    }

    public static void averageSubject(int subjectID) {
        if (subjectID < 1 || subjectID > SUBJECTS) {
            System.out.println("Invalid subject ID.");
            return;
        }

        int total = 0;
        int studentCount = 0;
        for (int i = 0; i < count; i++) {  // Use `count` to iterate over added students
            total += stdsubArray[i][subjectID];
            studentCount++;
        }

        if (studentCount > 0) {
            int average = total / studentCount;
            System.out.printf("The average marks for subject %d is %d.%n", subjectID, average);
        } else {
            System.out.println("No students found.");
        }
    }

    public static void averageStudent(int studentID) {
        boolean found = false;
        for (int i = 0; i < count; i++) {  // Use `count` to iterate over added students
            if (stdsubArray[i][0] == studentID) {
                int total = 0;
                for (int j = 1; j <= SUBJECTS; j++) {
                    total += stdsubArray[i][j];
                }
                int average = total / SUBJECTS;
                System.out.printf("The average marks for student %d is %d.%n", studentID, average);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Incorrect ID");
        }
    }

    public static void total(int studentID) {
        boolean found = false;
        for (int i = 0; i < count; i++) {  // Use `count` to iterate over added students
            if (stdsubArray[i][0] == studentID) {
                int total = 0;
                for (int j = 1; j <= SUBJECTS; j++) {
                    total += stdsubArray[i][j];
                }
                System.out.printf("The total marks for student %d is %d.%n", studentID, total);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Incorrect ID");
        }
    }

    public static void grading(int studentID) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (stdsubArray[i][0] == studentID) {
                System.out.println("Grading for student ID " + studentID + ":");
                for (int j = 1; j <= SUBJECTS; j++) {
                    String grade;
                    int marks = stdsubArray[i][j];
                    if (marks >= 90) {
                        grade = "A";
                    } else if (marks >= 80) {
                        grade = "B";
                    } else if (marks >= 70) {
                        grade = "C";
                    } else if (marks >= 60) {
                        grade = "D";
                    } else {
                        grade = "F";
                    }
                    System.out.printf("The grade for subject %d is %s.%n", j, grade);
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Incorrect ID");
        }
    }
}

