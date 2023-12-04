package org.example.days;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3 {

    public static long solvePart1(Path path) throws IOException {
        int[] scoreArray = new int[52];
        
        for (String line : Files.readAllLines(path)) {
            Set<Character> setOfCharactersInFirstHalf = new HashSet<>();
            
            for (int i = 0; i < line.length() / 2; i++) {
                setOfCharactersInFirstHalf.add(line.charAt(i));
            }
            for (int i = line.length()/2; i < line.length(); i++) {
                if (setOfCharactersInFirstHalf.contains(line.charAt(i))) {
                    if(Character.isLowerCase(line.charAt(i))) {
                        scoreArray[line.charAt(i) - 'a']++;
                    } else {
                        scoreArray[line.charAt(i) - 'A' + 26]++;
                    }
                    break;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < scoreArray.length; i++) {
            sum += (i+1) * scoreArray[i];
        }
        return sum;
    }

    public static long solvePart2(Path path) throws IOException {
        int[] scoreArray = new int[52];

        Set<Character> setOfCharactersInFirstLine = new HashSet<>();
        Set<Character> setOfCharactersInTwoFirstLines = new HashSet<>();


        List<String> lines = Files.readAllLines(path);
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if(i%3 == 0) {
                setOfCharactersInFirstLine = new HashSet<>();
                setOfCharactersInTwoFirstLines = new HashSet<>();
            }

            if(i%3==0){
                for (int index = 0; index < line.length(); index++) {
                    setOfCharactersInFirstLine.add(line.charAt(index));
                }
            }

            if(i%3==1){
                for (int index = 0; index < line.length(); index++) {
                    if (setOfCharactersInFirstLine.contains(line.charAt(index))) {
                        setOfCharactersInTwoFirstLines.add(line.charAt(index));
                    }
                }
            }

            if(i%3==2){
                for (int index = 0; index < line.length(); index++) {
                    if (setOfCharactersInTwoFirstLines.contains(line.charAt(index))) {
                        if(Character.isLowerCase(line.charAt(index))) {
                            scoreArray[line.charAt(index) - 'a']++;
                        } else {
                            scoreArray[line.charAt(index) - 'A' + 26]++;
                        }
                        break;
                    }
                }

            }
        }
        
        int sum = 0;
        for (int i = 0; i < scoreArray.length; i++) {
            sum += (i+1) * scoreArray[i];
        }
        return sum;
    }
}
