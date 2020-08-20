import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.academiadecodigo.org.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    @Parameters({"12653, 5216", "25, 8453", "3425, 0", "436, -251", "-343, -324"})
    public void sumsCorrectly(int value1, int value2) {
        Assert.assertEquals(value1 + value2, calculator.sum(value1, value2));
    }
}
