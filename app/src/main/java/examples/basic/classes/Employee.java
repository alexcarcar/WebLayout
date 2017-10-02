package examples.basic.classes;

public class Employee {
    private static int count = 0;
    private String firstName;
    private String lastName;

    public Employee(String first, String last) {
        firstName = first;
        lastName = last;
        ++count;
        System.out.printf("Employee constructor: %s %s; count = %d\n", firstName, lastName, count);
    }

    public static int getCount() {
        return count;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
