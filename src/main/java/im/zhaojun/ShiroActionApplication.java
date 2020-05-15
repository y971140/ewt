package im.zhaojun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("im.zhaojun.system.mapper")
public class ShiroActionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiroActionApplication.class, args);
    }
}