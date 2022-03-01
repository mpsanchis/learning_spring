package ch3wiring.animals.components;

import org.springframework.stereotype.Component;
import ch3wiring.utilities.Color;

import javax.annotation.PostConstruct;

@Component
public class Tail {
    private Color furColor;

    public Color getFurColor() {
        return this.furColor;
    }

    public void setFurColor(Color c) {
        this.furColor = c;
    }

    @PostConstruct
    void initTail() {
        this.furColor = Color.BROWN;
    }

    @Override
    public String toString() {
        return "fur color: " + furColor.getName();
    }
}
