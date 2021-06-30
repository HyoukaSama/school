import com.hyouka.entity.UserRole;
import com.hyouka.service.IUserRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:xml/applicationContext.xml"})
public class IUserRoleServiceTest {
    @Autowired
    private IUserRoleService iUserRoleService;

    @Test
    public void TestInsert() {
        UserRole userRole = new UserRole();
        userRole.setRoleid("c52a100fd3044de1a2085a2ecd6c6c9b");
        userRole.setUserid("22b14a6f30bc4a21a695c98781282e05");

        System.out.println(iUserRoleService.insert(userRole));

    }
}
