package de.starvalcity.base.background.def;

/**
 * Das {@link Scheduleable} Interface sorgt für die zeitliche Konfiguration von einem {@link Task} oder von
 * der Paper API definierten Klassen, wie etwa von einem {@link org.bukkit.command.Command}.
 *
 * Das {@link Scheduleable} Interface ist somit eine benutzerdefinierte Implementation vom
 * {@link org.bukkit.scheduler.BukkitScheduler} bzw. der {@link org.bukkit.scheduler.BukkitRunnable} Klasse.
 */
public interface Scheduleable {

    void setScheduleDelay(long delay);

    long getScheduleDelay();

}
