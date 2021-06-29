import com.hyouka.entity.User;
import com.hyouka.utils.ResultMapUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestMapper {
    @Autowired
    private ResultMapUtil resultMapUtil;

    @Test
    public void TestMapper(){
        System.out.println(resultMapUtil.getResultMap(User.class));
    }
}
