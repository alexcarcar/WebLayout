package examples.basic.inheritance;

public class CommisionEmployeeTest {
    public static void main(String[] args) {
        CommisionEmployee employee = new CommisionEmployee("Sue", "Jones", "222-22-2222", 10000, .06);
        System.out.println("Employee information obtained by get methods:\n");
        System.out.printf("%s %s\n", "First name is", employee.getFirstName());
        System.out.printf("%s %s\n", "Last name is", employee.getLastName());
        System.out.printf("%s %s\n", "Social security number is", employee.getSocialSecurityNumber());
        System.out.printf("%s %s\n", "Gross sales is", employee.getGrossSales());
        System.out.printf("%s %s\n", "Commision rate is", employee.getCommisionRate());

        employee.setGrossSales(500);
        employee.setCommissionRate(.1);
        System.out.printf("\n%s:\n\n%s\n", "Updated employee", employee);
    }
}
