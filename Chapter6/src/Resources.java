import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by 乐成 on 2016/3/14.
 */
public class Resources {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter the loan amount: ");
            double principle = scan.nextDouble();
            System.out.println("Enter the interest rate: ");
            double rate = scan.nextDouble();
            System.out.println("Enter the loan term (int years): ");
            double years = scan.nextInt();

            double interest = principle * rate * years;
            double total = principle + interest;
            double payment = total / years / 12;

            DecimalFormat df = new DecimalFormat("0.##");
            System.out.println("Monthly payment: $" + df.format(payment));
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
