/**
 * TuitionManager is a user interface class that handles I/O with Collection
 * and Album. Contains an initialized Collection ready to manipulate Album objects.
 * @author Sharia Hussain, David Lam
 */

import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TuitionManager {
    /**
     * Method that is called by the RunProject1 driver and starts the Collection Manager.
     * Initializes Collection object and takes input from console to perform actions.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Boolean runProject = false;
        Roster rosterCollection = new ColRosterlection();


        while(scanner.hasNextLine()) {
            if(runProject == false) {
                System.out.println("Tuition Manager starts running.");
                runProject = true;
            }

            String commandLineInput = scanner.nextLine();
            commandLineInput = commandLineInput.trim();

            if(commandLineInput.equals(""))
                continue;
            else if(commandLineInput.equals("Q")) {
                System.out.println("Tuition Manager terminated.");
                break;
            }
            else
                runAlbumCommands(commandLineInput, rosterCollection);
        }
    }

    /**
     * Helper method that runs the album commands and checks the commandLineInput
     * and matches the command with the input
     */
    public void runAlbumCommands(String commandLineInput, Roster rosterCollection) {
        if(commandLineInput.equals("P"))
            rosterCollection.print();
        else if(commandLineInput.equals("PN"))
            rosterCollection.printByNames();
        else if(commandLineInput.equals("PT"))
            rosterCollection.printByPaymentsMade();
        else if(commandLineInput.charAt(0) == 'A')
            runAddStudent(commandLineInput, rosterCollection);
        else if(commandLineInput.charAt(0) == 'D')
            runRemoveStudent(commandLineInput, rosterCollection);
        else if(commandLineInput.charAt(0) == 'C')
            runCalculateTuitionDues(commandLineInput, rosterCollection);
        else if(commandLineInput.charAt(0) == 'T')
            runPayTuition(commandLineInput, rosterCollection);
        else if(commandLineInput.charAt(0) == 'S')
            runSetStudyAbroadStatus(commandLineInput, rosterCollection);
        else if(commandLineInput.charAt(0) == 'F')
            runSetFinancialAidAmount(commandLineInput, rosterCollection);
        else
            System.out.println("Command '" + commandLineInput + "' not supported!");
    }

    /**
     * Method that tokenizes the album string and runs the add method in the Collection Class
     * The method also checks the genre with the enum values and also validates the date in the
     * given string.
     */
    public void runAddStudent(String rosterDetails, Roster rosterCollection) {
        StringTokenizer stringTokenizer = new StringTokenizer(rosterDetails, ",");

        String addType, name, major, credits = "";

        stringTokenizer.nextToken();
        addType = stringTokenizer.nextToken();
        name = stringTokenizer.nextToken();
        major = stringTokenizer.nextToken().toUpperCase();
        credits = stringTokenizer.nextToken();


        // Checks if the string genre is one of the Genre's Enum Values, If not then set to Unknown
        if(!(major.equals("CS") || major.equals("IT") || major.equals("BA") || major.equals("EE") || major.equals("ME"))) {
            System.out.println("'" + major + "' is not a valid major.");
        }

        Major addMajor = Major.valueOf(major);

        //Check Type of Add
    }

    /**
     * Method that tokenizes the album string and runs the remove method in the Collection Class.
     */
    public void runRemoveStudent(String albumDetails, Roster rosterCollection) {
        StringTokenizer stringTokenizer = new StringTokenizer(albumDetails, ",");
        String name, major = "";

        stringTokenizer.nextToken();
        name = stringTokenizer.nextToken();
        major = stringTokenizer.nextToken();

        Student tempStudent = new Student(name, major);

        if(rosterCollection.remove(tempStudent))
            System.out.println("Student removed from the roster.");
        else
            System.out.println("Student is not in the roster.");
    }



}
