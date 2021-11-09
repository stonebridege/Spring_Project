package com.stonebridge.ioc;

import com.stonebridge.controller.HappyController;
import com.stonebridge.domain.HappyComponent;
import com.stonebridge.domain.HappyMachine;
import com.stonebridge.domain.HappyTeam;
import com.stonebridge.domain.PropValue;
import com.stonebridge.service.HappyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class IocTest {
    // 创建IOC容器对象
    // 为了各个实验测试方法方便使用这个对象，声明成成员变量


    @Test
    public void testExperiment01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HappyComponent component = (HappyComponent) context.getBean("happyComponent");
        System.out.println("component=" + component);
//        component.doWork();
    }

    /**
     * 根据类型获取
     */
    @Test
    public void testExperiment02() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 如果IOC容器中接口类型的bean只有一个
        // 那么这个接口类型的bean对象对接口类型执行instanceof判断能够返回true
        // 那就能够获取到，这是面向对象多态性的一个体现
        // 所以根据类型获取bean的依据其实就是“对象 instanceof 指定的类型”，返回true就能获取到
        // 如果IOC容器中接口类型的bean不止一个，那还是会抛出NoUniqueBeanDefinitionException异常
        HappyComponent component = context.getBean(HappyComponent.class);
        System.out.println("component=" + component.toString());
//        component.doWork();
    }

    @Test
    public void testExperiment03() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HappyComponent happyComponent3 = (HappyComponent) context.getBean("happyComponent3");
        String happyName = happyComponent3.getName();
        System.out.println("happyName = " + happyName);
    }

    @Test
    public void testExperiment04() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HappyComponent happyComponent4 = (HappyComponent) context.getBean("happyComponent4");
        HappyMachine happyMachine = happyComponent4.getMachine();
        String machineName = happyMachine.getMachineName();
        System.out.println("machineName = " + machineName);
    }

    @Test
    public void testExperiment05() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HappyComponent happyComponent5 = (HappyComponent) context.getBean("happyComponent5");
        HappyMachine happyMachine = happyComponent5.getMachine();
        String machineName = happyMachine.getMachineName();
        System.out.println("machineName = " + machineName);
    }

    @Test
    public void testExperiment06() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = context.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }

    @Test
    public void testExperiment07() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HappyComponent happyComponent7 = (HappyComponent) context.getBean("happyComponent7");
        String machineName = happyComponent7.getMachine().getMachineName();
        System.out.println("machineName = " + machineName);
    }

    @Test
    public void testExperiment08() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HappyTeam happyTeam = context.getBean(HappyTeam.class);
        System.out.println("happyTeam = " + happyTeam);
    }

    @Test
    public void testExperiment09() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        PropValue propValue = (PropValue) context.getBean("propValue1");

        PropValue propValue = (PropValue) context.getBean("propValue2");
//        PropValue propValue = context.getBean(PropValue.class);
        System.out.println("propValue = " + propValue);
    }

    @Test
    public void testExperiment10() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PropValue propValue = (PropValue) context.getBean("propValue3");
        System.out.println("propValue = " + propValue);
    }

    @Test
    public void testExperiment11() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HappyTeam happyTeam = (HappyTeam) context.getBean("happyTeam3");
        System.out.println("happyTeam = " + happyTeam);
    }

    @Test
    public void testExperiment12() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HappyController happyController = context.getBean(HappyController.class);
        HappyService happyService = happyController.getHappyService();
        System.out.println("happyService = " + happyService);
    }

    @Test
    public void testExperiment14() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HappyMachine happyMachine3 = (HappyMachine) context.getBean("happyMachine3");
        String machineName = happyMachine3.getMachineName();
        System.out.println("machineName = " + machineName);
    }

    @Test
    public void testExperiment15() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HappyMachine happyMachine01 = (HappyMachine) context.getBean("happyMachine4");
        HappyMachine happyMachine02 = (HappyMachine) context.getBean("happyMachine4");
        System.out.println(happyMachine01 == happyMachine02);
        System.out.println("happyMachine01.hashCode() = " + happyMachine01.hashCode());
        System.out.println("happyMachine02.hashCode() = " + happyMachine02.hashCode());
    }
    @Test
    public void testExperiment16() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 给IOC容器对象转换类型，然后调用close()方法关闭
        ((ClassPathXmlApplicationContext)context).close();

    }
}
