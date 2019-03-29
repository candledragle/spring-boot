/*
package sample.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sample.async.AsyncTaskService;

import javax.annotation.Resource;

@Component
public class AsyncJob {

    @Resource
    AsyncTaskService service;

    @Scheduled(fixedDelay = 86400000)
    public void run(){
        for (int i = 0; i < 10; i++) {
            service.executeAsyncTask(i);
            service.executeAsyncTaskPlus(i);
        }
    }
}
*/
