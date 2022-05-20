package de.starvalcity.base.background;

import de.starvalcity.base.Core;
import de.starvalcity.base.background.def.CustomizedFile;
import de.starvalcity.base.background.def.Scheduleable;
import de.starvalcity.base.background.def.Task;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class FileTask extends Task implements Scheduleable {

    private final String taskName;
    private final int taskId;
    private long scheduleDelay;
    private boolean isRunning = false;

    private final JavaPlugin plugin = JavaPlugin.getPlugin(Core.class);

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
                setRunning();
                createDefaultFiles();
            }
        }.runTaskLater(plugin, 100L);
    }

    @Override
    public void terminate() {
        new BukkitRunnable() {
            @Override
            public void run() {
                setSleeping();
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

    public void setRunning() {
        if (!isRunning) {
            isRunning = true;
        }
    }

    public void setSleeping() {
        if (isRunning) {
            isRunning = false;
        }
    }

    public int getTaskId() {
        return this.taskId;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void createDefaultFiles() {
        CustomizedFile taskConfiguration = new CustomizedFile("plugins//Liquid//Configuration", "TaskConfiguration.yml");
        if (!taskConfiguration.exist()) {
            taskConfiguration.setDefaultValue("Testing", true);
            taskConfiguration.save();
        }
        taskConfiguration.save();
    }
}
