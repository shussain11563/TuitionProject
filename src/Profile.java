public class Profile {
    private String name;
    private Major major; //5 majors and 2-charater each: CS, IT, BA, EE, ME

    public Profile(String name, String major) {
        this.name = name;
        this.major = Major.valueOf(major);
    }

    public String getName() {
        return this.name;
    }

    public String getMajor() {
        return this.major.toString();
    }
}
