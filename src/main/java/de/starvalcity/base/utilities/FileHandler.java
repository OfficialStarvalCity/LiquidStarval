package de.starvalcity.base.utilities;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class FileHandler {

    public static void save(File file, FileConfiguration cfg) {
        try {
            cfg.save(file);
            cfg.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
