public class Student {
    //private int tuitionDue;
    //TuitionPay
    private Profile profile;
    
    public static final int FULL_TIME = true;
    public static final int PART_TIME = false;

    /**
     * CHANGE THIS JAVA DOCS!
     * Constructs and initializes an Student object for temporary use.
     * Used for lending, removing, and returning an Album.
     * @param title the title of the Album.
     * @param artist the artist of the Album.
     */
    public Student()
    {
        
    }

    public String callProfileGetName() {
        return this.profile.getName();
    }

    public String callProfileGetMajor() {
        return this.profile.getMajor();
    }

    public void tuitionDue() {
    }
}