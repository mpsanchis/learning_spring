package ch3wiring.animals.components;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Mouth {
    private int numOfTeeth;

    @PostConstruct
    public void initMouth() {
        this.numOfTeeth = 25;
    }

    @Override
    public String toString() {
        return String.format("Mouth with %s teeth", this.numOfTeeth);
    }
}
