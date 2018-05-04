package junit.code;

import junit.framework.TestCase;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestClients.class,
        TestOperations.class,
        TestQueue.class,
        TestOrders.class,
        TestIntagration.class
})

public class RunTest extends TestCase {

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(RunTest.class);

        System.out.println(result.getRunCount());
        System.out.println(result.wasSuccessful());
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

    }














}
