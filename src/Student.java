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
    public static final double ADDITIONAL_FEE = 2650;
    public static final double UNIVERSITY_FEE = 3268;
    public static final double RES_FULL_TIME_TUITION = 12536;
    public static final double NON_RES_FULL_TIME_TUITION = 29737;
    public static final double RES_PART_TIME_TUITION_RATE = 404;
    public static final double NON_RES_PART_TIME_TUITION_RATE = 966;
    public static final double PART_TIME_FEE_REDUCTION = .8;
    public static final double CREDIT_HOURS_MAX = 16;
    public static final double CREDIT_HOURS_MAX_PART_TIME = 12;



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
        if(this.creditHours >= CREDIT_HOURS_MAX_PART_TIME)
        {
            this.isStatus = FULL_TIME;
        }
        else
        {
            this.isStatus = PART_TIME;
        }

        this.lastPaymentDate = null;


    }

    public Student(String name, Major major) {
        this.profile = new Profile(name, major);
    }

    public void setTotalPayment(double totalPayment)
    {
        this.totalPayment = totalPayment;
    }

    public void payTuiton(double paidTuition, Date lastPaymentDate)
    {


        //add validation

        setTotalPayment(getTotalPayment() + paidTuition);
        setTuitionDue(getTuitionDue() - paidTuition);
        this.lastPaymentDate = lastPaymentDate;
    }



    @Override
    public String toString()
    {
        String date = (this.getLastPaymentDate() != null) ? this.lastPaymentDate.toString() : "--/--/--";
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return String.format("%s:%s:%d credit hours:tuition due:%s:total payment:%s:last payment date: %s", this.profile.getName(),
                this.profile.getMajor(), this.creditHours, df.format(this.tuitionDue), df.format(this.totalPayment), date);
    }

    public void tuitionDue() {
    }
}