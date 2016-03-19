import java.time.LocalDate;
import java.time.Period;

public class Person {
    String name;
    LocalDate birthdate;

    public Person(String name, int year, int month, int day) {
        LocalDate tempBD = LocalDate.of(year, month, day);
        this.name = name;
        this.birthdate = tempBD;
    }

    public Person(String name) {
        this(name, 1900, 1, 1);
    }

    public int calculateAge() {
        Period p = Period.between(this.birthdate, LocalDate.now());
        return p.getYears();
    }

    public int calculateAge(LocalDate date) {
        Period p = Period.between(this.birthdate, date);
        return p.getYears();
    }

    public int calculateAge(int year, int month, int day) {
        Period p = Period.between(this.birthdate, LocalDate.of(year, month, day));
        return p.getYears();
    }
}
