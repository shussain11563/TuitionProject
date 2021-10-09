import java.text.DecimalFormat;

public class Student {
    //private int tuitionDue;
    //TuitionPay
    public Profile profile;
    public int creditHours;  //maybe double
    public double tuitionDue;
    public double totalPayment;
    public Date lastPaymentDate;
    //public int tuitionDue; --> move this today
    public boolean isStatus; //redundant ----> cant internationa;

    //might set this to private
    //int credit
    
    public static final boolean FULL_TIME = true;
    public static final boolean PART_TIME = false;

    public static final double UNIVERSITY_FEE = 3268;


    /**
     * CHANGE THIS JAVA DOCS!
     * Constructs and initializes an Student object for temporary use.
     * Used for lending, removing, and returning an Album.
     * @param title the title of the Album.
     * @param artist the artist of the Album.
     */
    public Student(String name, Major major, int creditHours)
    {
        this.profile = new Profile(name, major);
        this.creditHours = creditHours;
        this.totalPayment = 0;

        //remove?? or call exception in International
        if(this.creditHours >= 12)
        {
            this.isStatus = FULL_TIME;
        }
        else
        {
            this.isStatus = PART_TIME;
        }



        this.lastPaymentDate = null;

    }


    @Override
    public String toString()
    {

        DecimalFormat df = new DecimalFormat("#,##0.00");
        return String.format("%s:%s:%d credit hours:tuition due:%s:total payment:%s:last payment date: %s", this.profile.getName(), this.profile.getMajor(), this.creditHours,
                df.format(this.tuitionDue),
                df.format(this.totalPayment),
                this.lastPaymentDate.toString());
    }
    /* redundant code, maybe not
    public String callProfileGetName() {
        return this.profile.getName();
    }

    public String callProfileGetMajor() {
        return this.profile.getMajor();
    }
     */

    public void tuitionDue() {
    }
}