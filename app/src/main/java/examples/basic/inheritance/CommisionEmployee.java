package examples.basic.inheritance;

public class CommisionEmployee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales;
    private double commisionRate;

    public CommisionEmployee(String first, String last, String ssn, double sales, double rate) {
        firstName = first;
        lastName = last;
        socialSecurityNumber = ssn;
        grossSales = sales;
        commisionRate = rate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first) {
        firstName = first;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last) {
        lastName = last;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String ssn) {
        socialSecurityNumber = ssn; // should validate
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double sales) {
        if (sales >= 0.0) {
            grossSales = sales;
        } else {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }
    }

    public void setCommissionRate(double rate) {
        if (rate > 0.0 && rate < 1.0) {
            commisionRate = rate;
        } else {
            throw new IllegalArgumentException("Commision rate must be > 0.0 and  1.0");
        }
    }

    public double getCommisionRate() {
        return commisionRate;
    }

    public double earnings() {
        return commisionRate * grossSales;
    }

    @Override
    public String toString() {
        return String.format("%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f",
                "commision employee", firstName, lastName,
                "social security number", socialSecurityNumber,
                "gross sales", grossSales,
                "commision rate", commisionRate);
    }
}
