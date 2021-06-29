import com.hyouka.service.impl.JedisClientPool;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class RedisTest {
    @Autowired
    private JedisClientPool iJedisClientPool;


    @Test
    public void getJedis() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:xml/applicationContext.xml");
        JedisPool jedisPool = (JedisPool) applicationContext.getBean("jedisPool");
        Jedis jedis = jedisPool.getResource();
        jedis.set("name", "yyf");

        System.out.println(jedis.get("name"));
        jedis.close();
    }

    @Test
    public void TestGetJedis() {
        iJedisClientPool.set("name", "yyf");
        System.out.println(iJedisClientPool.get("name"));
    }


}
