package sample.async;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Async
public class AsyncTask {

    private Log logger = LogFactory.getLog("AsyncTask");

    public void task1() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        long id = Thread.currentThread().getId();

        logger.info(id + "  :"+(end - begin));
    }

    public void task2() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        long id = Thread.currentThread().getId();

        logger.info(id + "  :"+(end - begin));
    }

    public Future<String> task3() throws InterruptedException {

        long begin = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();

        long id = Thread.currentThread().getId();

        logger.info(id + "  :"+(end - begin));
        return new AsyncResult<String>("任务４");
    }
}
