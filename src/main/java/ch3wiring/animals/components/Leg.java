package ch3wiring.animals.components;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Leg {
    private boolean hasHair;

    @PostConstruct
    void initLeg() {
        this.hasHair = true;
    }

    @Override
    public String toString() {
        return hasHair ? "has hair" : "has no hair";
    }
}
