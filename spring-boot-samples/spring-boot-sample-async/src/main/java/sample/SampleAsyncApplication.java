package sample;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SampleAsyncApplication {
    private static Log logger = LogFactory.getLog(SampleAsyncApplication.class);

    public static void main(String args[]) {
        SpringApplication.run(SampleAsyncApplication.class, args);
        logger.info("server start!");
    }
}
