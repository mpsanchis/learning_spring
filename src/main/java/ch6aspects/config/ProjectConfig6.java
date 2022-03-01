package ch6aspects.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages =
        {"ch6aspects",
        "ch4abstractions.models",
        "ch4abstractions.services",
        "ch4abstractions.proxies",
        "ch4abstractions.repositories"})
@EnableAspectJAutoProxy
public class ProjectConfig6 {
}
