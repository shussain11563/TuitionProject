public class International extends NonResident
{
    private boolean isStudyAbroad;
    private int MIN_FULL_TIME_CREDIT = 12;

    //if study abroad, max is 12
    public International(String name, Major major, int creditHours, boolean isStudyAbroad) {
        super(name, major, creditHours);
        this.isStudyAbroad = isStudyAbroad;
    }

    //if study abroad, max is 12
    public void setIsStudyAbroad()
    {
        this.isStudyAbroad = true;
        //this.setCreditHours(MIN_FULL_TIME_CREDIT);
        this.tuitionDue();

        //recalculate tuition
    }
    /*

    @Override
    public void tuitionDue()
    {
        //call super method
        if(this.isStudyAbroad)
        {
            //remove tuition or just dont
        }
        //super.tuitionDue();
        isStudyAbroad = !isStudyAbroad;

    }

    */

    @Override
    public void tuitionDue()
    {
        // Studies Abroad
        if(isStudyAbroad == true) {
            this.setTuitionDue( Student.UNIVERSITY_FEE + Student.ADDITIONAL_FEE);
        }
        // Full-Time and Credits > 16 and Not Study Abroad
        else if(this.getStatus() == FULL_TIME && this.getCreditHours() > CREDIT_HOURS_MAX && isStudyAbroad == false) {
            this.setTuitionDue(Student.NON_RES_FULL_TIME_TUITION + Student.UNIVERSITY_FEE + Student.ADDITIONAL_FEE +
                    Student.NON_RES_PART_TIME_TUITION_RATE * (this.getCreditHours() - CREDIT_HOURS_MAX));
        }
        // Full-Time and Credits Between 12 and 16
        else if(this.getStatus() == FULL_TIME) {
            this.setTuitionDue(Student.RES_FULL_TIME_TUITION + Student.UNIVERSITY_FEE + Student.ADDITIONAL_FEE);
        }
        // Internationals cant do Part-Time


        /*

        if(this.getCreditHours() > CREDIT_HOURS_MAX) {
            // Student.NON_RES_FULL_TIME_TUITION + Student.UNIVERSITY_FEE + ADDITIONAL_FEE + Student.NON_RES_PART_TIME_TUITION_RATE
            // * (creditHours - 16);
        }
        else if(isStudyAbroad == true) {
            // Student.UNIVERSITY_FEE + ADDITIONAL_FEE ;
        }
        else if(isStudyAbroad == false) {
            // Student.NON_RES_FULL_TIME_TUITION + Student.UNIVERSITY_FEE + ADDITIONAL_FEE ;
        }

        */

    }
    //use instance of in tuition manager to make sure it is an international student


    @Override
    public String toString()
    {
        return String.format("%s:international", super.toString());
    }




}