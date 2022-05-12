package de.starvalcity.configuration;


import de.starvalcity.base.def.File;
import de.starvalcity.utilities.FileWriter;

public class TaskConfiguration extends File {

    private final FileWriter taskConfiguration = new FileWriter("plugins//StarvalCity//Configuration",
            "TaskConfiguration.yml");

    @Override
    public void setup() {

    }

}
