import com.stonebridge.component.CommonComponent;
import com.stonebridge.component.SoldierController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// junit的@RunWith注解：指定Spring为Junit提供的运行器
@RunWith(SpringJUnit4ClassRunner.class)
// Spring的@ContextConfiguration指定Spring配置文件的位置
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class AnnotationTest {

    @Autowired
    private SoldierController soldierController;

    @Test
    public void testIntegration() {
        System.out.println("soldierController = " + soldierController);
    }
}
