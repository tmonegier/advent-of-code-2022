package org.example.days;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 {
    public static long solvePart1(Path path) throws IOException {
        int maxCalories = 0;
        int currentCalories = 0;

        List<String> lines = Files.readAllLines(path);
        lines.add("");
        for (String line : lines) {
            if(line.isEmpty()) {
                maxCalories = Math.max(currentCalories, maxCalories);
                currentCalories = 0;
            } else {
                currentCalories += Integer.parseInt(line);
            }
        }
        maxCalories = Math.max(currentCalories, maxCalories);
        return maxCalories;
    }

    public static long solvePart2(Path path) throws IOException {
        int currentCalories = 0;
        List<Integer> caloriesByElves = new ArrayList<>();

        List<String> lines = Files.readAllLines(path);
        lines.add("");
        for (String line : lines) {
            if(line.isEmpty()) {
                caloriesByElves.add(currentCalories);
                currentCalories = 0;
            } else {
                currentCalories += Integer.parseInt(line);
            }
        }

        return caloriesByElves.stream().sorted(Comparator.reverseOrder()).limit(3).reduce(0, Integer::sum);
    }
}
