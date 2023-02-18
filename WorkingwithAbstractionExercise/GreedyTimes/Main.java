
package WorkingwithAbstractionExercise.GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int vhod = Integer.parseInt(scanner.nextLine());
        String[] seif = scanner.nextLine().split("\\s+");

        var torba = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        int zlato = 0;
        int kamuni = 0;
        int mangizi = 0;

        for (int i = 0; i < seif.length; i += 2) {
            String name = seif[i];
            int broika = Integer.parseInt(seif[i + 1]);

            String element = "";

            if (name.length() == 3) {
                element = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                element = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                element = "Gold";
            }

            if (element.equals("")) {
                continue;
            } else if (vhod < torba.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + broika) {
                continue;
            }

            if (addOrMiss(torba, broika, element)) continue;

            if (!torba.containsKey(element)) {
                torba.put((element), new LinkedHashMap<String, Long>());
            }

            if (!torba.get(element).containsKey(name)) {
                torba.get(element).put(name, 0L);
            }


            torba.get(element).put(name, torba.get(element).get(name) + broika);
            if (element.equals("Gold")) {
                zlato += broika;
            } else if (element.equals("Gem")) {
                kamuni += broika;
            } else if (element.equals("Cash")) {
                mangizi += broika;
            }
        }

        Print(torba);
    }

    private static void Print(LinkedHashMap<String, LinkedHashMap<String, Long>> torba) {
        for (var x : torba.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static boolean addOrMiss(LinkedHashMap<String, LinkedHashMap<String, Long>> torba, int broika, String element) {
        switch (element) {
            case "Gem":
                if (!torba.containsKey(element)) {
                    if (torba.containsKey("Gold")) {
                        if (broika > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else if (torba.get(element).values().stream().mapToLong(e -> e).sum() + broika > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                    return true;
                }
                break;
            case "Cash":
                if (!torba.containsKey(element)) {
                    if (torba.containsKey("Gem")) {
                        if (broika > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else if (torba.get(element).values().stream().mapToLong(e -> e).sum() + broika > torba.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                    return true;
                }
                break;
        }
        return false;
    }
}