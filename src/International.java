public class International extends NonResident
{
    private boolean isStudyAbroad;

    public International(String name, Major major, int creditHours, boolean isStudyAbroad)
    {
        super(name, major, creditHours);
        this.isStudyAbroad = isStudyAbroad;
    }

    public void setIsStudyAbroad()
    {

        //change magic number
        //int minFullTimeCredit = 12;
        //if already true, return fa;se
        this.isStudyAbroad = true;
        //magic number
        this.setCreditHours(minFullTimeCredit);

        //.....



    }

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

    @Override
    public void tuitionDue()
    {
        if(creditHours > 16) {
            // Student.NON_RES_FULL_TIME_TUITION + Student.UNIVERSITY_FEE + ADDITIONAL_FEE + Student.NON_RES_PART_TIME_TUITION_RATE
            // * (creditHours - 16);
        }
        else if(isStudyAbroad == true) {
            // Student.UNIVERSITY_FEE + ADDITIONAL_FEE ;
        }
        else if(isStudyAbroad == false) {
            // Student.NON_RES_FULL_TIME_TUITION + Student.UNIVERSITY_FEE + ADDITIONAL_FEE ;
        }
    }
    //use instance of in tuition manager to make sure it is an international student


    @Override
    public String toString()
    {
        return String.format("%s:international", super.toString());
    }




}