import com.hyouka.entity.User;
import com.hyouka.entity.UserRole;
import com.hyouka.service.IRoleService;
import com.hyouka.service.IUserRoleService;
import com.hyouka.service.IUserService;
import com.hyouka.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.management.relation.RoleList;
import java.util.List;
import java.util.Random;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:xml/applicationContext.xml"})

public class IUserServiceTest {

    private static Logger logger = LoggerFactory.getLogger(IUserServiceTest.class);

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IUserRoleService iUserRoleService;

    @Autowired
    private IUserService iUserService;

    @Test
    public void TestSelectAll() {
        long starttime = System.currentTimeMillis();
        // PropertyConfigurator.configure(System.getProperty("logging.config", "classpath:properties/log4j.properties"));
        User user = new User();
        user.setId("1");
        // System.out.println(user.toString());

        //  System.out.println(iUserService.getAllUser());
        System.out.println("-------------");
        //   System.out.println(iUserService.select(user));
        System.out.println("-------------");
        System.out.println(iUserService.selectAll());

/*
        for (int i = 0; i < 10; i++) {
            if (i < 9) {
                try {
                    if (i == 5) {
                        String a = "a";
                        Integer.parseInt(a);
                    }
                    logger.info("种第" + (i + 1) + "棵树");

                } catch (Exception e) {
                    logger.error("第" + (i + 1) + "课树有问题");
                } finally {
                    logger.warn("还在植树中");
                }
            } else {
                logger.info("树种完了");
            }
        }
        logger.debug("运行时间：" + (System.currentTimeMillis() - starttime));*/
    }

    @Test
    public void TestInsert() {
        for (int i = 0; i < 10; i++) {
            User user = new User("ceshi" + i, new Random().nextInt(100), "男", "account" + i, "passwd" + i, DateUtil.getCurrentDateTime());
            System.out.println(iUserService.insert(user));
        }
    }


    @Test
    public void TestUpdate() {
        User user = new User();
        user.setId("1ba8f1f22a3344aeaa605d311b70c1c5");
        user.setName("tttttttttttttttttttttt");

        System.out.println(iUserService.updateById(user));


    }

    @Test
    public void TestUserDuty() {
        System.out.println(iUserService.getUserDuty());
    }


    @Test
    public void TestUserAddRoles() {
        List<User> userList = iUserService.getAllUser();
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            String userid = user.getId();

            UserRole userRole = new UserRole();
            userRole.setUserid(userid);
            userRole.setRoleid("c52a100fd3044de1a2085a2ecd6c6c9b");

            int size = iUserRoleService.selectCount(userRole);
            if (size == 0) {
                iUserRoleService.insert(userRole);
            }else {
                System.out.println("已存在");
            }
        }
    }

}
