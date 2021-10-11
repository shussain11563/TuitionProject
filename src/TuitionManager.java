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
            if(runProject == false)
            {
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
            rosterCollection.printByPaymentsMadeByPaymentDate();
        else if(commandLineInput.charAt(0) == 'A')
            runAddStudent(commandLineInput, rosterCollection);
        else if(commandLineInput.charAt(0) == 'R')
            runRemoveStudent(commandLineInput, rosterCollection);
        else if(commandLineInput.charAt(0) == 'C')
            runCalculateTuitionDues(rosterCollection);
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
        String addType, name, major, credits, additionalInfo = "";

        if(checkAddStudent(rosterDetails)) {
            addType = stringTokenizer.nextToken();
            name = stringTokenizer.nextToken();
            major = stringTokenizer.nextToken().toUpperCase();
            credits = stringTokenizer.nextToken();
        }
        else
            return;

        try {
            intCredits = Integer.parseInt(credits);
        }
        catch (NumberFormatException ex) {
            System.out.println("Invalid credit hours.");
            return;
        }
        if(!checkMinMaxCredits(intCredits))
            return;

        try {
            additionalInfo = stringTokenizer.nextToken();
        }
        catch (NoSuchElementException ex1) {
        }

        Major addMajor = Major.valueOf(major);
        runProcessAddStudent(rosterCollection, addType, name, addMajor, intCredits, additionalInfo);
    }

    private void runProcessAddStudent(Roster rosterCollection, String addType, String name, Major addMajor, int intCredits, String additionalInfo) {
        if(addType.equals("AR")) {
            Student newResidentStudent = new Resident(name, addMajor, intCredits);
            finalizeAddStudent(rosterCollection, newResidentStudent);
        }
        else if(addType.equals("AN")) {
            Student newNonResidentStudent = new NonResident(name, addMajor, intCredits);
            finalizeAddStudent(rosterCollection, newNonResidentStudent);
        }
        else if(addType.equals("AT")) {
            additionalInfo = additionalInfo.toUpperCase();
            if(additionalInfo.equals("NY") || additionalInfo.equals("CT")) {
                State addState = State.valueOf(additionalInfo);
                Student newTriStateStudent = new TriState(name, addMajor, intCredits, addState);
                finalizeAddStudent(rosterCollection, newTriStateStudent);
            }
            else if(additionalInfo.equals(""))
            {
                System.out.println("Missing data in command line.");
                return;
                //Missing data in command line.
                //ADD TRY CATCH OR SOMETHING
                //ADD AN EXCEPTION FOR THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            }
            else
            {
                System.out.println("Not part of the tri-state area.");
                return;
            }
        }
        else if(addType.equals("AI")) {
            if(intCredits < 12) {
                System.out.println("International students must enroll at least 12 credits.");
                return;
            }
            else {
                boolean isInternational = Boolean.parseBoolean(additionalInfo.toLowerCase());
                Student newInternationalStudent = new International(name, addMajor, intCredits, isInternational);
                finalizeAddStudent(rosterCollection, newInternationalStudent);
            }
        }
    }

    private void finalizeAddStudent(Roster rosterCollection, Student student) {
        if(rosterCollection.add(student))
            System.out.println("Student added.");
        else {
            System.out.println("Student is already in the roster.");
        }
    }

    private boolean checkAddStudent(String rosterDetails) {
        StringTokenizer stringTokenizer = new StringTokenizer(rosterDetails, ",");
        String addType, name, major, originalMajorParameter, credits = "";

        addType = stringTokenizer.nextToken();

        try {
            name = stringTokenizer.nextToken();
        }
        catch (NoSuchElementException ex1) {
            System.out.println("Missing data in command line.");
            return false;
        }

        try {
            major = stringTokenizer.nextToken();
            originalMajorParameter = major;
            major = major.toUpperCase();
        }
        catch (NoSuchElementException ex){
            System.out.println("Missing data in command line.");
            return false;
        }

        try {
            credits = stringTokenizer.nextToken();
        }
        catch (NoSuchElementException ex1) {
            System.out.println("Credit hours missing.");
            return false;
        }

        if(!(major.equals("CS") || major.equals("IT") || major.equals("BA") || major.equals("EE") || major.equals("ME"))) {
            System.out.println("'" + originalMajorParameter + "' is not a valid major.");
            return false;
        }

        return true;
    }

    private boolean checkMinMaxCredits(int intCredits) {
        if(intCredits < 0) {
            System.out.println("Credit hours cannot be negative.");
            return false;
        }
        else if(intCredits < 3) {
            System.out.println("Minimum credit hours is 3.");
            return false;
        }
        else if(intCredits > 24) {
            System.out.println("Credit hours exceed the maximum 24.");
            return false;
        }
        return true;
    }

    /**
     * Method that tokenizes the album string and runs the remove method in the Collection Class.
     */
    public void runRemoveStudent(String rosterDetails, Roster rosterCollection) {
        StringTokenizer stringTokenizer = new StringTokenizer(rosterDetails, ",");
        String name, major = "";

        stringTokenizer.nextToken();
        name = stringTokenizer.nextToken();
        major = stringTokenizer.nextToken().toUpperCase();
        Major addMajor = Major.valueOf(major);

        Student tempStudent = new Student(name,addMajor);

        if(rosterCollection.remove(tempStudent))
            System.out.println("Student removed from the roster.");
        else
            System.out.println("Student is not in the roster.");
    }

    public void runCalculateTuitionDues(Roster rosterCollection) {
        rosterCollection.calculateTuition();
        System.out.println("Calculation completed.");
    }

    public void runPayTuition(String rosterDetails, Roster rosterCollection) {
        StringTokenizer stringTokenizer = new StringTokenizer(rosterDetails, ",");
        String name, major, amount, date = "";
        Date paymentDate = null;
        double paymentAmount = 0;
        stringTokenizer.nextToken();
        name = stringTokenizer.nextToken();
        major = stringTokenizer.nextToken().toUpperCase();
        Major addMajor = Major.valueOf(major);

        try {
            amount = stringTokenizer.nextToken();
        }
        catch (NoSuchElementException ex1) {
            System.out.println("Payment amount missing.");
            return;
        }

        Student tempStudent = new Student(name,addMajor);
        paymentAmount = Double.parseDouble(amount);

        try {
            date = stringTokenizer.nextToken();
            paymentDate = new Date(date);
        }
        catch (NoSuchElementException ex1) {
        }

        Student outputStudent = rosterCollection.getStudent(tempStudent);

        if(outputStudent.getTuitionDue() < paymentAmount)
        {
            System.out.println("Amount is greater than amount due.");
            return;
        }
        else if(paymentAmount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        else if(!paymentDate.isValid() ) {
            System.out.println("Payment date invalid.");
            return;
        }

        if(outputStudent != null) {
            outputStudent.payTuiton(paymentAmount, paymentDate);
            System.out.println("Payment applied.");
        }
    }

    public void runSetStudyAbroadStatus(String rosterDetails, Roster rosterCollection) {
        StringTokenizer stringTokenizer = new StringTokenizer(rosterDetails, ",");
        String name, major = "";

        stringTokenizer.nextToken();
        name = stringTokenizer.nextToken();
        major = stringTokenizer.nextToken().toUpperCase();
        Major addMajor = Major.valueOf(major);

        Student tempStudent = new Student(name,addMajor);

        Student outputStudent = rosterCollection.getStudent(tempStudent);
        if(outputStudent instanceof International) {
            ((International) outputStudent).setIsStudyAbroad();
            System.out.println("Tuition updated.");
        }
        else {
            System.out.println("Couldn't find the international student.");
        }


    }
    public void runSetFinancialAidAmount(String rosterDetails, Roster rosterCollection) {
        StringTokenizer stringTokenizer = new StringTokenizer(rosterDetails, ",");
        String name, major, amount = "";
        double financialAidAmount = 0;

        stringTokenizer.nextToken();
        name = stringTokenizer.nextToken();
        major = stringTokenizer.nextToken();

        try {
            amount = stringTokenizer.nextToken();

        }
        catch (NoSuchElementException ex1) {
            System.out.println("Missing the amount.");
            return;
        }

        financialAidAmount = Double.parseDouble(amount);


        if(financialAidAmount < 0 || financialAidAmount > 10000)
            System.out.println("Invalid amount.");
        else {

        }
    }
    public static void main(String args[]) {

        /*
        AR,Jane Doe,cS,10
        AR,Jane Doe
        AR,Jane Doe,CS
        AR,Jane Doe,CS,2
        AR,Jane Doe,CS,-10
        AR,Jane Doe,CS,hi
         */

        Roster xd = new Roster();
        String temp = "AR,Jane Doe,CS,hi";
        TuitionManager run = new TuitionManager();
        run.runAddStudent(temp, xd);
    }
}
