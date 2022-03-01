package ch3wiring.mainch3;

import ch3wiring.animals.Cat;
import ch3wiring.animals.Parrot;
import ch3wiring.animals.Person;
import ch3wiring.animals.components.Wing;
import ch3wiring.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainWiringBeans {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot p = context.getBean("parrot", Parrot.class);
        Wing w = context.getBean(Wing.class);
        Person ella = context.getBean(Person.class);

        Cat cat = context.getBean(Cat.class);
        System.out.println(cat);
        System.out.println(p.getName());
        System.out.println(ella);
        System.out.println(w.getHowMuchDoIFly());
    }
}
