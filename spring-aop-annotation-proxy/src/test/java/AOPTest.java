import com.stonebridge.aop.api.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class AOPTest {

    @Autowired
    @Qualifier("calculatorPureImpl")
    private Calculator calculator;

    @Test
    public void testAnnotationAOP() {
//        int add = calculator.div(9, 0);
        int add = calculator.add(9, 0);
        System.out.println("方法外部 add = " + add);
    }
}
