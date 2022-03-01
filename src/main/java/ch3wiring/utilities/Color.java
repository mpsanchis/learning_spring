package ch3wiring.utilities;

public enum Color {
    RED("red", true),
    BLUE("blue", false),
    BROWN("brown", false),
    GREEN("green", true);

    private final String name;
    private final boolean canColorblindSee;

    Color(String name, boolean canColorblindSee) {
        this.name = name;
        this.canColorblindSee = canColorblindSee;
    }

    public String getName() {
        return this.name;
    }
}
