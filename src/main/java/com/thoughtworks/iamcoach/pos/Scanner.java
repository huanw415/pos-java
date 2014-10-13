package com.thoughtworks.iamcoach.pos;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class Scanner {

    public ArrayList<String> getInputs(){
        ArrayList<String> inputs = new ArrayList<String>();

        try {
            Path path = FileSystems.getDefault().getPath("src/main/resources/", "cart.txt");
            inputs = (ArrayList<String>) Files.readAllLines(path);
        } catch (IOException ex) {
            System.out.println("fail read file!");
        }

        return inputs;
    }
}
