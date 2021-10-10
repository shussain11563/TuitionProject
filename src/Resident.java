public class Resident extends Student
{
    private boolean alreadyAwarded;
    private static final double RESIDENTIAL_FINANCIAL_AID_LIMIT = 10000; // UPPER LIMIT
    private double awardedFinancialAid;

    public Resident(String name, Major major, int creditHours) {


        super(name, major, creditHours); //change this
        this.alreadyAwarded = false;
        this.awardedFinancialAid = 0;
    }

    //constant for successful
    //boolean?? or void
    //add exception
    public boolean setFinancialAid(double financialAid)
    {
        //validatation required....remove magic number
        if(alreadyAwarded == false)
        {
            awardedFinancialAid = financialAid;
            double newTuition = (getTuitionDue()-financialAid > 0) ? (getTuitionDue() - financialAid) : 0 ;
            setTuitionDue(newTuition);

            this.alreadyAwarded = true;

            return true;

        }

        return false;

    }



    @Override
    public void tuitionDue() {
        // Full-Time and Credits > 16
        if(this.getStatus() == FULL_TIME && this.getCreditHours() > CREDIT_HOURS_MAX) {
            this.setTuitionDue(Student.RES_FULL_TIME_TUITION + Student.UNIVERSITY_FEE +
                    Student.RES_PART_TIME_TUITION_RATE * (this.getCreditHours()  - CREDIT_HOURS_MAX));
        }
        // Full-Time and Credits Between 12 and 16
        else if(this.getStatus() == FULL_TIME) {
            this.setTuitionDue(Student.RES_FULL_TIME_TUITION + Student.UNIVERSITY_FEE);
        }
        // Part-Time
        else if(this.getStatus() == PART_TIME) {
            this.setTuitionDue((Student.UNIVERSITY_FEE * PART_TIME_FEE_REDUCTION) +
                    (Student.RES_PART_TIME_TUITION_RATE * this.getCreditHours()));
        }

        /*
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

        if(FULL_TIME == true && creditHours > 16) {
            // Student.RES_FULL_TIME_TUITION + Student.UNIVERSITY_FEE + Student.RES_PART_TIME_TUITION_RATE * (creditHours - 16);
        }
        else if(FULL_TIME == true) {
            // Student.RES_FULL_TIME_TUITION + Student.UNIVERSITY_FEE;
        }
        else if(FULL_TIME == false) {
            // (Student.RES_UNIVERSITY_FEE * PART_TIME_FEE_REDUCTION) + (Student.RES_PART_TIME_TUITION_RATE * creditHours);

        }
        */
    } 

    @Override
    public String toString() {
        return String.format("%s:resident", super.toString());
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        Student s1 = new Resident("Sharia Hussain", Major.CS, 12);
        //System.out.println(s1.test());
    }

}