package ch3wiring.animals;

import ch3wiring.animals.components.Tail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cat {
    private final Tail tail;
    private final String name;

    @Autowired
    public Cat(Tail t) {
        this.tail = t;
        this.name = "Mici";
    }

    public Tail getTail() {
        return tail;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "tail=" + tail +
                ", name='" + name + '\'' +
                '}';
    }
}
