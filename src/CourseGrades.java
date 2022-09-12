import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class CourseGrades {

    public void displayMenu() {
        int menuChoice = 0;
        
        GradeBook gradebook = new GradeBook();
        File gradebookFile = new File("gradebook.txt");
        FileOutputStream fileOutput;
        ObjectOutputStream objectOutput;
        
        try {

            fileOutput = new FileOutputStream(gradebookFile);
        	objectOutput = new ObjectOutputStream(fileOutput);
        	objectOutput.writeObject(gradebook);
        	

            do {
                System.out.println();
                System.out.println("[1] Input grades");
                System.out.println("[2] Display all grades");
                System.out.println("[3] Display student grade average");
                System.out.println("[4] Display test score average");
                System.out.println("[5] Exit");

                System.out.print("Enter Choice: ");
                menuChoice = Integer.valueOf(Driver.scanner.nextLine());

                switch (menuChoice) {
                    case 1 -> {
                        gradebook.getGrades();
                    }

                    case 2 -> {;
                        gradebook.showGrades(gradebookFile);
                    }

                    case 3 -> {
                        int studentId = 0;

                        System.out.print("Enter Student Number: ");
                        studentId = Integer.valueOf(Driver.scanner.nextLine());
                
                        gradebook.studentAvg(studentId, gradebookFile);

                    }

                    case 4 -> {
                        int testId = 0;

                        System.out.print("Enter Test Number: ");
                        testId = Integer.valueOf(Driver.scanner.nextLine());
                
                        gradebook.testAvg(testId, gradebookFile);
                    }

                    default -> {
                        break;
                    }
                }

            } while (menuChoice != 5);
            System.out.println("System exit. Thank you!");

            Driver.scanner.close();
            objectOutput.close();
        	fileOutput.close();
            
        } catch (Exception e) {
            System.out.println("Please choose from [1] to [5].");
            menuChoice = 0;
            displayMenu();
        }
    }
}
