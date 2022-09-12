import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class GradeBook {
    private int[][] grades;

    // Number of students and tests
    public GradeBook() {
        this.grades = new int[3][5]; // row, column : student number, test score
    }

    // prompt for the grades for each student
    public void getGrades() {
        int gradeInput = 0;

        // Displaying each student
        for (int i = 0; i < this.grades.length; i++) {
            Driver.scanner.reset();
            System.out.print("\nStudent " + (i + 1) + "\n");

            // Entering test scores for each test
            for (int j = 0; j < this.grades[i].length; j++) {
                System.out.print("Enter test score " + (j + 1) + ": ");
                gradeInput = Integer.valueOf(Driver.scanner.nextLine());

                this.grades[i][j] = gradeInput;
            }
        }
    }

    // displays grades
    public void showGrades(File file) {
        GradeBook gradebook;
        FileInputStream fileInput;
        ObjectInputStream objectInput;

        try {
            fileInput = new FileInputStream(file);
            objectInput = new ObjectInputStream(fileInput);
            gradebook = (GradeBook) objectInput.readObject();

            // Displaying each students
            for (int i = 0; i < this.grades.length; i++) {
                String showGrades = "";
                System.out.println("\nStudent " + (i + 1) + " (" + grades[i].length + " Test scores): ");

                // Displaying test scores per student
                for (int j = 0; j < this.grades[i].length; j++) {
                    showGrades = showGrades + grades[i][j] + "\n";
                }
                System.out.print(showGrades);
            }

            fileInput.close();
            objectInput.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // has student number parameter, displays average grade for that student
    public void studentAvg(int student, File file) {
        GradeBook gradebook;
        FileInputStream fileInput;
        ObjectInputStream objectInput;
        double studentAvg = 0;
        double total = 0;

        try {
            fileInput = new FileInputStream(file);
            objectInput = new ObjectInputStream(fileInput);
            gradebook = (GradeBook) objectInput.readObject();

            for (int i = 0; i < grades[student - 1].length; i++) {
                total += grades[student - 1][i];
            }
            studentAvg = total / 5;
            System.out.printf("Average grade for Student %d: %.2f\n", student, studentAvg);

            fileInput.close();
            objectInput.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // has test number parameter, displays the average grade for the test
    public void testAvg(int test, File file) {
        GradeBook gradebook;
        FileInputStream fileInput;
        ObjectInputStream objectInput;
        double testAvg = 0;
        double total = 0;

        try {
            fileInput = new FileInputStream(file);
            objectInput = new ObjectInputStream(fileInput);
            gradebook = (GradeBook) objectInput.readObject();

            for (int i = 0; i < grades.length; i++) {
                total += grades[i][test - 1];
            }
            testAvg = total / 3;
            System.out.printf("Average score for Test %d: %.2f\n", test, testAvg);

            fileInput.close();
    		objectInput.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
