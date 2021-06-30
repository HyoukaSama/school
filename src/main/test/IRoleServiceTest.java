
import com.hyouka.entity.Role;
import com.hyouka.service.IRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:xml/applicationContext.xml"})
public class IRoleServiceTest {
    @Autowired
    private IRoleService iRoleService;

    @Test
    public void TestInsert() {
        Role role = new Role();
        role.setName("学生");
        System.out.println(iRoleService.insert(role));

        Role role1 = new Role();

        role1.setName("老师");
        System.out.println(iRoleService.insert(role1));

        Role role2 = new Role();

        role2.setName("校长");
        System.out.println(iRoleService.insert(role2));
    }
}
