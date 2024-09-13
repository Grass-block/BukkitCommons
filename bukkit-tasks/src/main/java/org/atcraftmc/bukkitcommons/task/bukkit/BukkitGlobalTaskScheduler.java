package org.atcraftmc.bukkitcommons.task.bukkit;

import org.atcraftmc.bukkitcommons.task.TaskManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public final class BukkitGlobalTaskScheduler extends BukkitTaskScheduler {
    BukkitGlobalTaskScheduler(Plugin owner, TaskManager provider) {
        super(owner, provider);
    }

    @Override
    protected BukkitTask runInternal(Runnable action) {
        return wrap(action).runTask(this.owner);
    }

    @Override
    protected BukkitTask delayInternal(long delay, Runnable action) {
        return wrap(action).runTaskLater(this.owner, delay);
    }

    @Override
    protected BukkitTask timerInternal(long delay, long period, Runnable action) {
        return wrap(action).runTaskTimer(this.owner, delay, period);
    }
}
