package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    //private static final Logger logger = LoggerFactory.getLogger(Application.class);
    //static String s = "Testsds";

    public static void main(String[] args) {
        //logger.info("Prindin välja %s", s);
        SpringApplication.run(Application.class, args);
    }

}
