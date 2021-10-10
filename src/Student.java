import java.text.DecimalFormat;

public class Student {
    //private int tuitionDue;
    //TuitionPay
    private Profile profile;
    private int creditHours;  //maybe double
    private double tuitionDue;
    private double totalPayment;
    private Date lastPaymentDate;
    private boolean isStatus; //redundant ----> cant internationa;

    private static final double CREDIT_HOURS_MAX = 16;

    public Profile getProfile()
    {
        return this.profile;
    }

    public int getCreditHours()
    {
        return this.creditHours;
    }

    public double getTuitionDue()
    {
        return this.tuitionDue;
    }

    public double getTotalPayment()
    {
        return this.totalPayment;
    }

    public Date getLastPaymentDate()
    {
        return this.lastPaymentDate;
    }

    public boolean getStatus()
    {
        return this.isStatus;
    }

    public void setTuitionDue(double tuitionDue)
    {
        this.tuitionDue = tuitionDue;
    }

    public void setCreditHours(int creditHours)
    {
        this.creditHours = creditHours;
    }

    public static final boolean FULL_TIME = true;
    public static final boolean PART_TIME = false;
    public static final double UNIVERSITY_FEE_FULL_TIME = 3268;
    public static final double UNIVERSITY_FEE_PART_TIME = .8 * UNIVERSITY_FEE_FULL_TIME;




    /**
     * CHANGE THIS JAVA DOCS!
     * Constructs and initializes an Student object for temporary use.
     * Used for lending, removing, and returning an Album.
     * @param name
     * @param major
     */
    public Student(String name, Major major, int creditHours)
    {
        this.profile = new Profile(name, major);
        this.creditHours = creditHours;
        this.totalPayment = 0;

        //remove?? or call exception in International
        if(this.creditHours >= 12)
        {
            isStatus = FULL_TIME;
        }
        else
        {
            isStatus = PART_TIME;
        }
        lastPaymentDate = null;

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