package org.example.days;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Day4 {

    public static final Pattern ASSIGNMENT_PATTERN = Pattern.compile("(?<minA>\\d+)-(?<maxA>\\d+),(?<minB>\\d+)-(?<maxB>\\d+)");

    public static long solve(Path path, boolean isPart2) throws IOException {
        return Files.lines(path).filter(
           line -> {
               var assignmentMatcher = ASSIGNMENT_PATTERN.matcher(line);
               if(assignmentMatcher.find()) {
                   int minA = Integer.parseInt(assignmentMatcher.group("minA"));
                   int maxA = Integer.parseInt(assignmentMatcher.group("maxA"));
                   int minB = Integer.parseInt(assignmentMatcher.group("minB"));
                   int maxB = Integer.parseInt(assignmentMatcher.group("maxB"));

                   return (isPart2 && Math.max(minA, minB) <= Math.min(maxA, maxB) ) ||
                           (!isPart2 && (minA <= minB && maxA >= maxB) || (minB<= minA && maxB >= maxA));
               }
               return false;
           }
       ).count();
    }
}
