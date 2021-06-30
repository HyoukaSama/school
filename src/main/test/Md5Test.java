import com.hyouka.utils.Md5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:xml/applicationContext.xml"})*/
public class Md5Test {
//e10adc3949ba59abbe56e057f20f883e

    @Test
    public void TestMd5() {
        try {
            System.out.println(Md5Util.md5Encode("ls12345!"));
            System.out.println(Md5Util.md5Encode("ls123456"));
            System.out.println(Md5Util.md5Encode("ls123456!"));
            System.out.println(Md5Util.md5Encode("123456"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
