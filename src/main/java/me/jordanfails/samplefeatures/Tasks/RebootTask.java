package me.jordanfails.samplefeatures.Tasks;

import me.jordanfails.samplefeatures.SampleFeatures;
import org.bukkit.scheduler.BukkitRunnable;

public class RebootTask extends BukkitRunnable {

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */

    SampleFeatures plugin;

    public RebootTask(SampleFeatures plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {


    }
}
