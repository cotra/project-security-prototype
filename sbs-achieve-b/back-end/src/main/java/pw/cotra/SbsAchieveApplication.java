package pw.cotra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
public class SbsAchieveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbsAchieveApplication.class, args);
    }

}
