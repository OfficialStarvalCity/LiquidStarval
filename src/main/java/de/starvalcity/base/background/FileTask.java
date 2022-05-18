package de.starvalcity.base.background;

import de.starvalcity.base.Core;
import de.starvalcity.base.background.def.CustomizedFile;
import de.starvalcity.base.background.def.Scheduleable;
import de.starvalcity.base.background.def.Task;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class FileTask extends Task implements Scheduleable {

    private final String name = "FileTask";
    private final int id = 2;
    private boolean isRunning;

    @Override
    public void start() {
        System.out.println("[Task] Executing File Task ...");
        new BukkitRunnable() {
            @Override
            public void run() {
                setRunning();
                createDefaultFiles();
                System.out.println("[Task] File Task executed!");
            }
        }.runTaskLater(Core.getPlugin(), 100L);
    }

    @Override
    public void stop() {
        System.out.println("[Task] Stopping File Task ...");
        new BukkitRunnable() {
            @Override
            public void run() {
                setSleeping();
                System.out.println("[Task] File Task stopped!");
            }
        }.runTaskLater(Core.getPlugin(), 100L);
    }

    @Override
    public void setScheduleDelay(long delay) {
        delay = 60L;
    }

    @Override
    public long getScheduleDelay(long delay) {
        return 60L;
    }

    @Override
    public void setRunning() {
        JavaPlugin.getPlugin(Core.class).getTaskHandler().setActiveTask(id, this);
        this.isRunning = true;
    }

    @Override
    public void setSleeping() {
        Core.getPlugin().getTaskHandler().setInactiveTask(id, this);
        this.isRunning = false;
    }

    @Override
    public String getTaskName() {
        return this.name;
    }

    @Override
    public int getTaskId() {
        return this.id;
    }

    @Override
    public boolean isRunning() {
        return this.isRunning;
    }

    public void createDefaultFiles() {
        CustomizedFile taskConfiguration = new CustomizedFile("plugins//LiquidAPI//Files", "TaskConfiguration.yml");
        if (!taskConfiguration.exist()) {
            taskConfiguration.setDefaultValue("Prequel",
                    "#This is the configuration file for configuring tasks and process related to the startup and shutdown of the server." +
                            "Please note that any changes you make in the configuration can have a significant impact on the server.");
            taskConfiguration.setDefaultValue("Configuration.Testing", false);
        }
        taskConfiguration.save();
    }
}
