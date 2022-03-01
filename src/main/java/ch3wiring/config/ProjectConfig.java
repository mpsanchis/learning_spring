package ch3wiring.config;

import ch3wiring.animals.Parrot;
import ch3wiring.animals.Person;
import ch3wiring.animals.components.Leg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ch3wiring.animals")
public class ProjectConfig {

    @Bean //tells Spring that it should load a Parrot object in the Context
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    /**
     * Person's attributes are set in different ways to show different ways of linking objects by Spring
     *   - Leg: passed by parameter
     *   - Parrot: @Bean method executed inside
     *   - Mouth: not shown here, but noted with @Autowired inside Person class
     * */
    @Bean
    Person person(Leg leg) {
        Person p = new Person();
        p.setName("Ella");
        p.setParrot(parrot()); //doesn't create a new parrot, but rather obtains it from the context as parrot() has already been called
        p.setLeg(leg);
        return p;
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }
}
