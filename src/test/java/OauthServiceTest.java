import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import static org.mockito.Mockito.*;

/**
 * Created by jojoldu@gmail.com on 2016-04-12.
 */

@RunWith( MockitoJUnitRunner.class )
public class OauthServiceTest {

    @Test
    public void redisSession(){
        String key = "id";
        String value = "jojoldu";

        Jedis jedis = mock(Jedis.class);
        Client client = mock(Client.class);
        Transaction transaction = spy(new Transaction(client));
        when(jedis.multi()).thenReturn(transaction);
        doNothing().when(client).set(anyString(), anyString());

        this.run(jedis);
        verify(client, times(1)).set(key,value);
        verify(client, times(1)).expire(key, 100);
    }

    public void run(Jedis jedis){
        Transaction t = jedis.multi();
        t.set("id", "jojoldu");
        t.expire("id", 100);
        t.exec();
    }
}
