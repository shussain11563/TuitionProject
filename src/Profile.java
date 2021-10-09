/**
 * @author Sharia Hussain, David Lam
 */

public class Profile {
    private String name;
    private Major major; //5 majors and 2-charater each: CS, IT, BA, EE, ME

    public Profile(String name, Major major) {
        this.name = name;
        this.major = major;

        //this.major = Major.valueOf(major); add valueOf to TutionManager
    }

    /*
    public void setName(String name)
    {
        this.name = name;
    }

    public void setMajor(Major major)
    {
        this.major = major;
    }

     */
    public String getName() {
        return this.name;
    }

    public String getMajor() {
        return this.major.toString();
    }
}
