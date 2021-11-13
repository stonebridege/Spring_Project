import com.stonebridge.proxy.api.Calculate;
import com.stonebridge.proxy.api.SoldierService;
import com.stonebridge.proxy.impl.CalculatorPureImpl;
import com.stonebridge.proxy.impl.LogDynamicProxyFactory;
import com.stonebridge.proxy.impl.SoldierServiceImpl;
import org.junit.Test;

public class testDynamicProxy {
    @Test
    public void testDynamicProxy() {

        // 1.创建被代理的目标对象
        Calculate target = new CalculatorPureImpl();

        // 2.创建能够生产代理对象的工厂对象
        LogDynamicProxyFactory<Calculate> factory = new LogDynamicProxyFactory<>(target);

        // 3.通过工厂对象生产目标对象的代理对象
        Calculate proxy = factory.getProxy();

        // 4.通过代理对象间接调用目标对象
        int addResult = proxy.add(10, 2);
        System.out.println("方法外部 addResult = " + addResult + "\n");

        int subResult = proxy.sub(10, 2);
        System.out.println("方法外部 subResult = " + subResult + "\n");

        int mulResult = proxy.mul(10, 2);
        System.out.println("方法外部 mulResult = " + mulResult + "\n");

        int divResult = proxy.div(10, 2);
        System.out.println("方法外部 divResult = " + divResult + "\n");
    }

    @Test
    public void testSoldierServiceDynamicProxy() {
        // 1.创建被代理的目标对象
        SoldierService soldierService = new SoldierServiceImpl();
        // 2.创建生产代理对象的工厂对象
        LogDynamicProxyFactory<SoldierService> factory = new LogDynamicProxyFactory<>(soldierService);
        // 3.生产代理对象
        SoldierService proxy = factory.getProxy();
        // 4.通过代理对象调用目标方法
        String soldierName = proxy.getSoldierNameById(1);
        System.out.println("soldierName = " + soldierName);
    }
}