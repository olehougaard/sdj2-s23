package multiton.date;

import java.util.HashMap;
import java.util.Objects;

/*
This is an example of a Multiton that has more than one parameter in the constructor.
When the multiton has more than one parameter, you have to find a way to combine the parameters into one key.
You have to compute the key without creating a new object as that would defeat the purpose.
 */
public class MyDate {
    private final int year;
    private final int month;
    private final int day;

    private static final HashMap<Integer, MyDate> instances = new HashMap<>();

    private MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * @return A unique key for a particular date.
     */
    private static int computeKey(int year, int month, int day) {
        return 10000 * year + 100 * month + day;
    }

    public static synchronized MyDate getInstance(int year, int month, int day) {
        int key = computeKey(year, month, day);
        if (!instances.containsKey(key)) {
            instances.put(key, new MyDate(year, month, day));
        }
        return instances.get(key);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public boolean isLeapYear() {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 == 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
