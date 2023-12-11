package org.example.days;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {

    private static final Pattern MOVE_PATTERN = Pattern.compile("move (?<numberOfMoves>\\d+) from (?<origin>\\d+) to (?<destination>\\d+)");
    private static final Pattern STACK_PATTERN = Pattern.compile("^(.*\\[.]*)*$");
    public static String solve(Path path, boolean isPart2) throws IOException {
        List<String> lines = Files.readAllLines(path);
        Map<Integer, List<Character>> heaps = new HashMap<>();
        List<Character> tmpStack = new LinkedList<>();
        for (String line : lines) {
            var heapPattern = STACK_PATTERN.matcher(line);
            if (heapPattern.matches()) {
                addCratesOnCranes(line, heaps);
            }
            var moveMatcher = MOVE_PATTERN.matcher(line);
            if (moveMatcher.find()) {
                moveCrates(moveMatcher, tmpStack, heaps, !isPart2);
            }
        }
        return heaps.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(entry -> entry.getValue().getFirst()).collect(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append
        ).toString();
    }

    private static void moveCrates(Matcher moveMatcher, List<Character> tmpStack, Map<Integer, List<Character>> heaps, boolean isPart1) {
        int numberOfMoves = Integer.parseInt(moveMatcher.group("numberOfMoves"));
        int origin = Integer.parseInt(moveMatcher.group("origin"));
        int destination = Integer.parseInt(moveMatcher.group("destination"));
        for (int i = 0; i < numberOfMoves; i++) {
            if(isPart1) {
                tmpStack.addLast(heaps.get(origin-1).removeFirst());
            } else {
                tmpStack.addFirst(heaps.get(origin - 1).removeFirst());
            }
        }
        for (int i = 0; i < numberOfMoves; i++) {
            heaps.get(destination-1).addFirst(tmpStack.removeFirst());
        }
    }

    private static void addCratesOnCranes(String line, Map<Integer, List<Character>> heaps) {
        for (int crateIndex = 0; crateIndex < line.length(); crateIndex += 4) {
            if (line.substring(crateIndex, crateIndex + 3).matches("\\[(.)]")) {
                heaps.computeIfAbsent(crateIndex/4, key -> new LinkedList<>());
                heaps.get(crateIndex/4).add(line.charAt(crateIndex+1));
            }
        }
    }
}
