package shoppingmall.example.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import shoppingmall.example.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
        basePackages = "shoppingmall.example.core.member",
        basePackageClasses = AutoAppConfig.class, // 지정 안하면 default shoppingmall.example.core 부터 시작해서 하위 다 찾음
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //componentScan 에서 제외
)
public class AutoAppConfig {
//    @Bean(name = "memoryMemberRepository")
//    MemoryMemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
