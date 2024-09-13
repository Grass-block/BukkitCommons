package org.atcraftmc.bukkitcommons.task.bukkit;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.atcraftmc.bukkitcommons.task.Task;

public final class BukkitTaskWrapper implements Task {
    private BukkitTask handle;

    public void setHandle(BukkitTask handle) {
        this.handle = handle;
    }

    @Override
    public Plugin getOwner() {
        if (this.handle == null) {
            return null;
        }
        return this.handle.getOwner();
    }

    @Override
    public void cancel() {
        if (this.handle == null) {
            return;
        }
        this.handle.cancel();
    }

    @Override
    public boolean isCancelled() {
        if (this.handle == null) {
            return false;
        }
        return this.handle.isCancelled();
    }
}
