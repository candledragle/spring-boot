package sample.async;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

    private static final Log log = LogFactory.getLog(AsyncTaskService.class);

    @Async("asyncExecutor")
    public void executeAsyncTask(Integer i) {
        log.info("执行异步任务：　" + i);
    }

    @Async("asyncExecutor")
    public void executeAsyncTaskPlus(Integer i) {
        log.info("执行异步任务＋１：　" + (i + 1));
    }
}
