package org.example.days;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 {
    public static long solve(Path path, boolean isPart2) throws IOException {
        List<Integer> caloriesByElves = new ArrayList<>();
        int currentCalories = 0;

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
        return caloriesByElves.stream().sorted(Comparator.reverseOrder()).limit(isPart2?3:1).reduce(0, Integer::sum);
    }
}
