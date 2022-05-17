package de.starvalcity.base.background;

import de.starvalcity.base.Core;
import de.starvalcity.base.background.def.Scheduleable;
import de.starvalcity.base.background.def.Task;
import org.bukkit.scheduler.BukkitRunnable;

public class FileTask extends Task implements Scheduleable {

    private final String name = "FileTask";
    private final int id = 2;
    private boolean isRunning;

    @Override
    public void start() {
        new BukkitRunnable() {
            @Override
            public void run() {
                setRunning();
            }
        }.runTaskLater(Core.getPlugin(), 100L);
    }

    @Override
    public void stop() {
        new BukkitRunnable() {
            @Override
            public void run() {
                setSleeping();
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
        Core.getPlugin().getTaskHandler().setActiveTask(id, this);
        this.isRunning = true;
    }

    @Override
    public void setSleeping() {
        Core.getPlugin().getTaskHandler().setInactiveTask(id, this);
        this.isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return this.isRunning;
    }
}
