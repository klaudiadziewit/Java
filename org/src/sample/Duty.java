package sample;

public class Duty {
    public String dutyName;
    public String dutyPriority;
    public String dutyDescription;
    public int day;
    public int month;
    public int year;

    public String getDutyName() {
        return dutyName;
    }

    public Duty(String name, String priority, String description, int day, int month, int year){
        this.dutyName = name;
        this.dutyPriority = priority;
        this.dutyDescription = description;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return dutyName;
    }

    public String getDutyPriority() {
        return dutyPriority;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getDutyDescription() {
        return dutyDescription;
    }
}
