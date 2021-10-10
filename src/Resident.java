public class Resident extends Student
{
    public Resident(String name, Major major, int creditHours) {

        super(name, major, creditHours); //change this
    }

    @Override
    public void tuitionDue()
    {
        if(FULL_TIME == true && creditHours > 16) {
            // Student.RES_FULL_TIME_TUITION + Student.UNIVERSITY_FEE + Student.RES_PART_TIME_TUITION_RATE * (creditHours - 16);
        }
        else if(FULL_TIME == true) {
            // Student.RES_FULL_TIME_TUITION + Student.UNIVERSITY_FEE;
        }
        else if(FULL_TIME == false) {
            // (Student.RES_UNIVERSITY_FEE * PART_TIME_FEE_REDUCTION) + (Student.RES_PART_TIME_TUITION_RATE * creditHours);
        }

    }

    @Override
    public String toString()
    {
        return String.format("%s:resident", super.toString());
    }



}