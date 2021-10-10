public class Resident extends Student
{
    private boolean alreadyAwarded;

    private static final double FULL_TIME_TUITION = 12536;
    private static final double CREDIT_HOURS_MAX = 16;
    private static final double PART_TIME_TUITION_RATE = 404;
    private static final double RESIDENTIAL_FINANCIAL_AID_LIMIT = 10000; // UPPER LIMIT


    public Resident(String name, Major major, int creditHours)
    {
        super(name, major, creditHours); //change this
        this.alreadyAwarded = false;
    }

    public void setFinancialAid()
    {
        if(alreadyAwarded == false)
        {

        }
    }


    @Override
    public void tuitionDue()
    {
        //tuition + fee
        if(this.getStatus() == FULL_TIME)
        {
            this.setTuitionDue((this.getTuitionDue() + FULL_TIME_TUITION));
            this.setTuitionDue((this.getTuitionDue() + UNIVERSITY_FEE_FULL_TIME));
        }
        else if(this.getStatus() == PART_TIME)
        {
            this.setTuitionDue((this.getTuitionDue() + (this.getCreditHours() * PART_TIME_TUITION_RATE)));
            this.setTuitionDue(this.getTuitionDue() + UNIVERSITY_FEE_PART_TIME);
        }

        //extra credits
        if(this.getCreditHours() - CREDIT_HOURS_MAX > 0 && this.getStatus() == FULL_TIME)
        {
            this.setTuitionDue(this.getTuitionDue() + ((this.getCreditHours() - CREDIT_HOURS_MAX) * PART_TIME_TUITION_RATE));
        }

    }


    @Override
    public String toString()
    {
        return String.format("%s:resident", super.toString());
    }

    public static void main(String[] args)
    {
        System.out.println("Hello");
        Student s1 = new Resident("Sharia Hussain", Major.CS, 12);
        //System.out.println(s1.test());

    }

}