package ch3wiring.animals;

import ch3wiring.animals.components.Leg;
import ch3wiring.animals.components.Mouth;
import org.springframework.beans.factory.annotation.Autowired;

public class Person {

    private String name;
    private Parrot parrot;
    private Leg leg;
    @Autowired
    private Mouth mouth;

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", parrot=" + parrot +
                ", mouth=" + mouth +
                ", leg=" + leg +
                '}';
    }
}
