package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class) // Configuration은 component이기 때문에 우리가 수동으로 만든 AppConfig랑 충돌이 일어날 수 있어서 제외시켜줌
)
public class AutoAppConfig {
    
}
 