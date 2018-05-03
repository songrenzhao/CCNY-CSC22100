import java.time.*;
public class HeartRates
{
    String firstName, lastName;
    int day, month, year;
    public HeartRates()
    {
        firstName = null;
        lastName = null;
        day = 0;
        month = 0;
        year = 0;
    }
    public HeartRates(String firstName, String lastName, int month, int day, int year)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public int getDay() {return day;}
    public void setDay(int day) {this.day = day;}
    public int getMonth() {return month;}
    public void setMonth(int month) {this.month = month;}
    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}

    public int getAge()
    {
        LocalDate birth = LocalDate.of(getYear(),getMonth(),getDay());
        LocalDate now = LocalDate.now();
        return Period.between(birth,now).getYears();
    }
    public int getHeartRate() {return 220 - getAge();}
    public double getLowerTargetHeartRate() {return getHeartRate()*0.5;}
    public double getUpperTargetHeartRate() {return getHeartRate()*0.85;}
}
