package be.kapture.christmaslights;

public enum  InstructionType {
    TURN_ON("turn on",
            (pair, lightGrid) -> lightGrid.increase(pair.getKey().x, pair.getKey().y, pair.getValue().x, pair.getValue().y)),
    TURN_OFF("turn off",
            (pair, lightGrid) -> lightGrid.decrease(pair.getKey().x, pair.getKey().y, pair.getValue().x, pair.getValue().y)),
    TOGGLE("toggle",
            (pair, lightGrid) -> lightGrid.doubleIncrease(pair.getKey().x, pair.getKey().y, pair.getValue().x, pair.getValue().y));

    private String prefix;
    private ControllerFunction controllerFunction;

    InstructionType(String prefix, ControllerFunction controllerFunction) {
        this.prefix = prefix;
        this.controllerFunction = controllerFunction;
    }

    public String getPrefix() {
        return prefix;
    }

    public ControllerFunction getControllerFunction() {
        return controllerFunction;
    }
}
