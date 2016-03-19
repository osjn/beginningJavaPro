import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApacheLogging {
    static final Logger log = LogManager.getLogger(ApacheLogging.class.getName());

    public static void main(String[] args) {
        int age = 60;
        double retirementFund = 10000;
        int yearsInRetirement = 20;
        String name = "David Johnson";
        for (int i = age; i <= 65; i++) {
            recalculate(retirementFund, 0.1);
        }
        double monthlyPension = retirementFund / yearsInRetirement / 12;
        System.out.println(name + " will have $" + monthlyPension
            + " per month for retirement.");
        if (monthlyPension < 100) {
            System.out.println("monthlyPension is too low.");
        }

        // create a series of log entries to show which
        // levels are printed to which handler's log
        log.trace("finely detailed TRACE message");
        log.debug("detailed DEBUG message");
        log.info("informational message");
        log.warn("warning message");
        log.error("error message");
        log.fatal("fatal message");
    }

    public static void recalculate(double fundAmount, double rate) {
        log.entry();
        fundAmount = fundAmount * (1 + rate);
        log.info("fundAmount = " + fundAmount);
        log.exit();
    }
}
