package com.restkeeper.operator;

import com.restkeeper.operator.entity.OperatorUser;
import com.restkeeper.operator.service.IOperatorUserService;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OperatorUserTest {

    /*@Autowired
    @Qualifier("operatorUserService")*/
    @Reference(version = "1.0.0",check = false)
    private IOperatorUserService operatorUserService;



    //新增用户
    @Test
    @Rollback(false)
    public void addTest(){
        OperatorUser operatorUser = new OperatorUser();
        operatorUser.setLoginname("list");
        //operatorUser.setLoginpass("123456");
        String crypt = Md5Crypt.md5Crypt("123456".getBytes());
        operatorUser.setLoginpass(crypt);
        operatorUserService.save(operatorUser);
    }


    @Test
    public  void test001(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"hello");
        map.put(2,"world");
        map.put(3,"good");
        System.out.println("hello world");

        String s = map.computeIfAbsent(4, v -> v + "haha");

    }
}
