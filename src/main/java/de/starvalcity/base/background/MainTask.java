package de.starvalcity.base.background;

import de.starvalcity.base.Core;
import de.starvalcity.base.background.def.Scheduleable;
import de.starvalcity.base.background.def.Task;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class MainTask extends Task implements Scheduleable {

    private final String taskName;
    private final int taskId;
    private long scheduleDelay;
    private boolean isRunning = false;

    private final JavaPlugin plugin = JavaPlugin.getPlugin(Core.class);

    public MainTask(String name, int id, long delay) {
        this.taskName = name;
        this.taskId = id;
        this.scheduleDelay = delay;
    }

    @Override
    public void execute() {
        new BukkitRunnable() {
            @Override
            public void run() {
                System.out.println("[Task] Starting Main Task ...");
            }
        }.runTaskLater(plugin, 200L);
    }

    @Override
    public void terminate() {
        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskLater(plugin, 100L);
    }

    @Override
    public void setScheduleDelay(long delay) {
        this.scheduleDelay = delay;
    }

    @Override
    public long getScheduleDelay() {
        return this.scheduleDelay;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTaskId() {
        return taskId;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
