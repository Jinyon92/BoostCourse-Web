package kr.or.connect.boostcourse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"kr.or.connect.boostcourse.dao", "kr.or.connect.boostcourse.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
