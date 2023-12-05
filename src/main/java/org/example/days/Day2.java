package org.example.days;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Day2 {
    private static final Map<String, Integer> MAP_OF_SCORES_PART_1 = Map.of(
        "A X", 4,
        "B X", 1,
        "C X", 7,
        "A Y", 8,
        "B Y", 5,
        "C Y", 2,
        "A Z", 3,
        "B Z", 9,
        "C Z", 6
    );

    private static final Map<String, Integer> MAP_OF_SCORES_PART_2 = Map.of(
        "A X", 3,
        "B X", 1,
        "C X", 2,
        "A Y", 4,
        "B Y", 5,
        "C Y", 6,
        "A Z", 8,
        "B Z", 9,
        "C Z", 7
    );

    public static long solve(Path path, boolean isPart2) throws IOException {
        return calculateScoreFromMap(path, isPart2?MAP_OF_SCORES_PART_2:MAP_OF_SCORES_PART_1);
    }

    private static Integer calculateScoreFromMap(Path path, Map<String, Integer> mapOfScoresPart1) throws IOException {
        try (var lines = Files.lines(path)) {
            return lines.map(mapOfScoresPart1::get).reduce(0, Integer::sum);
        }
    }
}
