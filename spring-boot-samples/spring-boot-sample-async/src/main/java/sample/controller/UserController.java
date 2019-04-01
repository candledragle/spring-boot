package sample.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.async.AsyncTask;
import sample.bean.TestBean;
import sample.domain.User;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class UserController {

    private final Log logger = LogFactory.getLog(UserController.class);

    @Resource
    AsyncTask asyncTask;

    @Resource
    TestBean testBean;

    @RequestMapping("testbean")
    public String testBean(){
        return testBean.sayHello();
    }



    @RequestMapping("find")
    public User findUser(int id,String name){

        try {
            asyncTask.task1();
            asyncTask.task2();
            Future<String> future = asyncTask.task3();
            String s = future.get();
            logger.info(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }
}
