import com.stonebridge.domain.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:springContext.xml"})
public class JDBCTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbcTemplateUpdate() {
        // 1.编写 SQL 语句
        String sql = "select * from t_emp where emp_id=?";
        // 2.调用 jdbcTemplate 的方法执行查询
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{8});
        System.out.println("list = " + list);
    }

    @Test
    public void testJdbcTemplateUpdate1() {
        // 1.编写 SQL 语句。需要传参的地方写问号占位符
        String sql = "update t_emp set emp_salary=? where emp_id=?";
        // 2.调用 jdbcTemplate 的 update() 方法执行 update 语句
        int count = jdbcTemplate.update(sql, 999.99, 3);
        System.out.println("count = " + count); //1
    }

    @Test
    public void testJdbcTemplateSelectOne() {
        // 1.编写 SQL 语句
        String sql = "select emp_name from t_emp where emp_id=?";
        // 2.调用 jdbcTemplate 的方法执行查询
        String empName = jdbcTemplate.queryForObject(sql, String.class, new Object[]{6});
        System.out.println(empName);
    }

    @Test
    public void testJdbcTemplateQueryForEntity() {
        // 1.编写 SQL 语句
        String sql = "select emp_id,emp_name,emp_salary from t_emp where emp_id=?";
        // 2.准备 RowMapper 对象
        RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class);
        // 3.调用 jdbcTemplate 的方法执行查询
        Emp emp = jdbcTemplate.queryForObject(sql, rowMapper, new Object[]{9});
        System.out.println("emp = " + emp);//emp = Emp(empId=4, empName=pott, empSalary=9999.9)
    }

    @Test
    public void testJdbcTemplateQueryListEntity() {
        // 1.编写 SQL 语句
        String sql = "select emp_id,emp_name,emp_salary from t_emp where emp_id=?";
        // 2.准备 RowMapper 对象
        RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class);
        // 3.调用 jdbcTemplate 的方法执行查询
        List<Emp> empList = jdbcTemplate.query(sql, rowMapper, new Object[]{4});
        System.out.println("empList = " + empList);
    }

    @Test
    public void testJdbcTemplateQueryList() {
        // 1.编写 SQL 语句
        String sql = "select emp_id,emp_name,emp_salary from t_emp where emp_id=?";
        List<Map<String, Object>> empList = jdbcTemplate.queryForList(sql, new Object[]{5});
        System.out.println("empList = " + empList);
    }

    @Test
    public void testJdbcTemplatebatchAdd() {
        //批量添加测试
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {700, "Tom", 111};
        Object[] o2 = {800, "Jerry", 222.33};
        Object[] o3 = {900, "Trump", 778.0};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        String sql = "insert into t_emp(emp_id,emp_name,emp_salary) values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));//[1, 1, 1]
    }
}
