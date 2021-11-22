import com.stonebridge.dao.EmpDao;
import com.stonebridge.service.EmpService;
import com.stonebridge.service.TopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:springContext.xml"})
public class JDBCTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmpDao empDao;

    @Autowired
    private EmpService empService;

    @Test
    public void testJdbcTemplateUpdate() {
        // 1.编写 SQL 语句
        String sql = "select * from t_emp where emp_id=?";
        // 2.调用 jdbcTemplate 的方法执行查询
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{8});
        System.out.println("list = " + list);
    }

    @Test
    public void testJdbcTemplate() {
        String name = empDao.selectEmpNameById(2);
        System.out.println(name);
    }

    @Test
    public void testJdbcTemplate2() {
        empDao.updateEmpNameById(2, "张三");
    }

    @Test
    public void testJdbcTemplate3() {
        empDao.updateEmpSalaryById(2, 999.99);
    }

    @Test
    public void testJdbcTemplate4() {
        Integer empId4EditName = 700;
        String newName = "Trump";
        Integer empId4EditSalary = 800;
        Double newSalary = 8989.00;
        empService.updateTwice(empId4EditName, newName, empId4EditSalary, newSalary);
    }

    @Test
    public void testJdbcTemplate5() {
        System.out.println(empService.getEmpName(700));
    }

    @Test
    public void testTxReadOnly() {
        String empName = empService.getEmpName(700);
        System.out.println("empName = " + empName);
    }

    @Test
    public void testIsolation() {
        Integer empId = 700;
        String empName = "aaaaaaaa";
        empService.updateEmpName(empId, empName);
    }

    @Autowired
    private TopService topService;

    @Test
    public void testPropagation() {
        // 调用外层方法
        topService.topTxMethod();
    }
}
