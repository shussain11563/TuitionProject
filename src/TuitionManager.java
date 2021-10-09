/**
 * TuitionManager is a user interface class that handles I/O with Collection
 * and Album. Contains an initialized Collection ready to manipulate Album objects.
 * @author Sharia Hussain, David Lam
 */

import java.util.NoSuchElementException;
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
        Roster rosterCollection = new Roster();


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
        int intCredits = 0;
        String addType, name, major, credits = "";

        if(checkAddStudent(rosterDetails)) {
            addType = stringTokenizer.nextToken();
            name = stringTokenizer.nextToken();
            major = stringTokenizer.nextToken().toUpperCase();
            credits = stringTokenizer.nextToken();

        }

        try {
            intCredits = Integer.parseInt(credits);
        }
        catch (NumberFormatException ex) {
            System.out.println("Invalid Credit Hours.");
            return;
        }
        checkMinMaxCredits(intCredits);

        //Major addMajor = Major.valueOf(major);

        System.out.println("Student Added.");

        //Student newStudent = new Student(name, addMajor, intCredits);

        //Check Type of Add

        /*
        when we add we need to run Find: check for name and major
         */
    }

    private boolean checkAddStudent(String rosterDetails) {
        StringTokenizer stringTokenizer = new StringTokenizer(rosterDetails, ",");
        String addType, name, major, credits = "";

        addType = stringTokenizer.nextToken();
        name = stringTokenizer.nextToken();

        try {
            major = stringTokenizer.nextToken().toUpperCase();

            try {
                credits = stringTokenizer.nextToken();

            }
            catch (NoSuchElementException ex1) {
                System.out.println("Credits hours missing.");
                return false;
            }
        }
        catch (NoSuchElementException ex){
            System.out.println("Missing data in command line.");
            return false;
        }

        if(!(major.equals("CS") || major.equals("IT") || major.equals("BA") || major.equals("EE") || major.equals("ME"))) {
            System.out.println("'" + major + "' is not a valid major.");
            return false;
        }

        return true;
    }

    private void checkMinMaxCredits(int intCredits) {
        if(intCredits < 0) {
            System.out.println("Credit hours cannot be negative.");
        }
        else if(intCredits < 3) {
            System.out.println("Minimum credit hours is 3.");
        }
        else if(intCredits > 24) {
            System.out.println("Credit hours exceed the maximum 24.");
        }
    }

    /**
     * Method that tokenizes the album string and runs the remove method in the Collection Class.
     */
    public void runRemoveStudent(String rosterDetails, Roster rosterCollection) {
        StringTokenizer stringTokenizer = new StringTokenizer(rosterDetails, ",");
        String name, major = "";

        stringTokenizer.nextToken();
        name = stringTokenizer.nextToken();
        major = stringTokenizer.nextToken();


        Profile tempProfile = new Profile(name, major);

        /*

        if(rosterCollection.remove(tempStudent))
            System.out.println("Student removed from the roster.");
        else
            System.out.println("Student is not in the roster.");

         */
    }

    public void runCalculateTuitionDues(String rosterDetails, Roster rosterCollection) {
    }

    public void runPayTuition(String rosterDetails, Roster rosterCollection) {
        StringTokenizer stringTokenizer = new StringTokenizer(rosterDetails, ",");
        String name, major, paymentAmount, date = "";

        stringTokenizer.nextToken();
        name = stringTokenizer.nextToken();
        major = stringTokenizer.nextToken();
        paymentAmount = stringTokenizer.nextToken();
        date = stringTokenizer.nextToken();

        //Check if payment due is greater than payment amount
        /*

        if(rosterCollection.remove())
            System.out.println("Student removed from the roster.");
        else
            System.out.println("Student is not in the roster.");

         */
    }
    public void runSetStudyAbroadStatus(String albumDetails, Roster rosterCollection) {

    }
    public void runSetFinancialAidAmount(String albumDetails, Roster rosterCollection) {

    }
    public static void main(String args[]) {
        Roster xd = new Roster();
        String temp = "AR,Jane Doe,cS,10";
        TuitionManager run = new TuitionManager();
        run.runAddStudent(temp, xd);
    }
}
