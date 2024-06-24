package ynu.edu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(ConfigApplication.class, args);
    }
}
