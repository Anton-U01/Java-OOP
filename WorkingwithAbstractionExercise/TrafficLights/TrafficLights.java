package WorkingwithAbstractionExercise.TrafficLights;

public enum TrafficLights {
    RED("GREEN"),GREEN("YELLOW"),YELLOW("RED");
    private String signal;

    TrafficLights(String signal) {
        this.signal = signal;
    }

    public String getSignal() {
        return signal;
    }
}
