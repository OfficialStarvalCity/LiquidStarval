package de.starvalcity.base.background;

import de.starvalcity.base.Core;
import de.starvalcity.base.background.def.CustomizedFile;
import de.starvalcity.base.background.def.Scheduleable;
import de.starvalcity.base.background.def.Task;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class FileTask extends Task implements Scheduleable {

    private final String taskName;
    private final int taskId;
    private long scheduleDelay;

    public CustomizedFile dbConfiguration = new CustomizedFile
            ("plugins//Liquid//Configuration", "DatabaseConfiguration.yml");
    public CustomizedFile taskConfiguration = new CustomizedFile
            ("plugins//Liquid//Configuration", "TaskConfiguration.yml");

    private final JavaPlugin plugin = JavaPlugin.getPlugin(Core.class);

    public static List<CustomizedFile> customizedFiles = new ArrayList<>();

    public FileTask(String name, int id, long delay) {
        this.taskName = name;
        this.taskId = id;
        this.scheduleDelay = delay;
    }

    @Override
    public void execute() {
        new BukkitRunnable() {
            @Override
            public void run() {
                createDefaultFiles();
            }
        }.runTaskLater(plugin, 100L);
    }

    @Override
    public void terminate() {
        new BukkitRunnable() {
            @Override
            public void run() {
            }
        }.runTaskLater(plugin, 20L);
    }

    @Override
    public void setScheduleDelay(long delay) {
        this.scheduleDelay = delay;
    }

    @Override
    public long getScheduleDelay() {
        return this.scheduleDelay;
    }

    @Override
    public void setTaskStatus(boolean status) {
        this.isRunning = status;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void createDefaultFiles() {
        if (!taskConfiguration.exist()) {
            taskConfiguration.setDefaultValue("Testing", true);
            taskConfiguration.save();
            customizedFiles.add(1, taskConfiguration);
        }
        taskConfiguration.save();

        if (!dbConfiguration.exist()) {
            dbConfiguration.setDefaultValue("Use_Threads", false);
            dbConfiguration.save();
            customizedFiles.add(2, dbConfiguration);
        }
        dbConfiguration.save();
    }
}
