package com.stonebridge.ioc;

import com.stonebridge.domain.HappyComponent;
import com.stonebridge.domain.HappyMachine;
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
}
