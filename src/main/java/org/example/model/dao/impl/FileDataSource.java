package org.example.model.dao.impl;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileDataSource {

    private static final Logger LOGGER = Logger.getLogger(FileDataSource.class);

    public static List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return list;
    }
}
