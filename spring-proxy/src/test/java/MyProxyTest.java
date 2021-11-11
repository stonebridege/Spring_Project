import com.stonebridge.proxy.api.Calculate;
import com.stonebridge.proxy.impl.CalculatorPureImpl;
import org.junit.Test;

public class MyProxyTest {
    @Test
    public void testPureImpl() {

        Calculate calculator = new CalculatorPureImpl();

        int addResult = calculator.add(10, 2);
        System.out.println("addResult = " + addResult);

        int subResult = calculator.sub(10, 2);
        System.out.println("subResult = " + subResult);

        int mulResult = calculator.mul(10, 2);
        System.out.println("mulResult = " + mulResult);

        int divResult = calculator.div(10, 2);
        System.out.println("divResult = " + divResult);
    }
}
