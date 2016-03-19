import java.text.DecimalFormat;

/**
 * Created by 乐成 on 2016/3/14.
 */
public class Errors {
    public static void main(String[] args) {
        System.out.println("100 at 10% annual interest is: " + recalculate(100, 0.1));

        int age = 30;
        double retirementFund = 10000;
        int yearsInRetirement = 20;
        String name = "David Johnson";
        for (int i = age; i <= 65; i++) {
            retirementFund = recalculate(retirementFund, 0.1);
        }
        double monthlyPension = retirementFund / yearsInRetirement / 12;

        // create a decimal format with two decimal points
        DecimalFormat df = new DecimalFormat("0.##");

        // use the df.format() method to format the double
        System.out.println(name + " will have $" + df.format(monthlyPension)
            + " pre month for retirement.");
    }

    public static double recalculate(double fundAmount, double rate) {
        return fundAmount * (1 + rate);
    }
}
