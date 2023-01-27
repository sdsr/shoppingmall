package shoppingmall.example.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "shoppingmall.example.core.member",
        basePackageClasses = AutoAppConfig.class, // 지정 안하면 default shoppingmall.example.core 부터 시작해서 하위 다 찾음
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
