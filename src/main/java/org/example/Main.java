package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import org.example.days.*;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        long solution = Day4.solvePart1(Path.of(Main.class.getClassLoader().getResource("day_4").toURI()));
        System.out.println(solution);
    }
}