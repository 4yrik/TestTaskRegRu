import org.junit.runner.JUnitCore;
import tests.TestClass;

public class MainClass {

    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        runner.run(TestClass.class);
        /*TestClass testClass = new TestClass();
        testClass.beforeTest();
        testClass.testCase();
        testClass.afterTest();*/
    }
}
