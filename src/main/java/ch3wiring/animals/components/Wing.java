package ch3wiring.animals.components;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Wing {
    private Integer howMuchDoIFly;

    public Integer getHowMuchDoIFly() {
        return howMuchDoIFly;
    }

    public void setHowMuchDoIFly(Integer howMuchDoIFly) {
        this.howMuchDoIFly = howMuchDoIFly;
    }

    @PostConstruct
    public void setDefaultValue() {
        this.howMuchDoIFly = 99;
    }
}
