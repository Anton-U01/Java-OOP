package football.core;

import football.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine{
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();//TODO implement first
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("Exit")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }
    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(0).toArray(String[]::new);

        switch (command) {
            case AddField:
                result = addField(data);
                break;
            case DeliverySupplement:
                result = deliverySupplement(data);
                break;
            case SupplementForField:
                result = supplementForField(data);
                break;
            case AddPlayer:
                result = addPlayer(data);
                break;
            case DragPlayer:
                result = dragPlayer(data);
                break;
            case CalculateStrength:
                result = calculateStrength(data);
                break;
            case GetStatistics:
                result = getStatistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }
    private String addField(String[] data) {
        return controller.addField(data[1],data[2]);
    }

    private String deliverySupplement(String[] data) {
        return controller.deliverySupplement(data[1]);
    }

    private String supplementForField(String[] data) {
         //TODO
        return controller.supplementForField(data[1],data[2]);
    }

    private String addPlayer(String[] data) {
        //TODO
        return controller.addPlayer(data[1],data[2],data[3],data[4],Integer.parseInt(data[5]));
    }

    private String dragPlayer(String[] data) {
        //TODO
        return controller.dragPlayer(data[1]);
    }

    private String calculateStrength(String[] data) {
        //TODO
        return controller.calculateStrength(data[1]);
    }

    private String getStatistics() {
        //TODO
        return controller.getStatistics();
    }
}
