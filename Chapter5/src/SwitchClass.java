/**
 * Created by 乐成 on 2016/3/14.
 */
public class SwitchClass {
    public static void main(String[] args) {
        String loanType = "Commercial";
        double interestRate;
        switch (loanType) {
            case "Residential":
                interestRate = 0.055;
                break;
            case "Commercial":
                interestRate = 0.062;
                break;
            case "Investment":
                interestRate = 0.059;
                break;
            default:
                interestRate = 0;
        }
        System.out.println(loanType + " loans have an annual interest rate of "
            + interestRate * 100 + "%.");
    }
}
