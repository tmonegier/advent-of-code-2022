package org.example.days;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class Day6 {

    public static long solve(Path path, boolean isPart2) throws IOException {
        String line = Files.readString(path);
        int sizeOfMarker = isPart2?14:4;
        for(int i = sizeOfMarker; i < line.length(); i++) {
            boolean isMarker = true;
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < sizeOfMarker; j++) {
                if(!set.add(line.charAt(i-j))){
                    isMarker = false;
                    break;
                }
            }

            if(isMarker) {
                return i+1;
            }
        }
        return 0;
    }
}
