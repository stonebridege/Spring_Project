import com.atguigu.aop.api.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:springContext.xml"})
public class AOPTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void testLogAspect() {
        int add = calculator.add(10, 2);
        System.out.println("add = " + add);
    }
}
