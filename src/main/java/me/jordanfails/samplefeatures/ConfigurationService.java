package me.jordanfails.samplefeatures;

import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.timer.TimerManager;
import org.bukkit.plugin.java.JavaPlugin;
import us.doctordark.util.Config;

import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class ConfigurationService {

    public static Config config;

    public static void init(JavaPlugin plugin){
        config = new Config(plugin, "settings", plugin.getDataFolder().getAbsolutePath());

        SERVER_TIME_ZONE = TimeZone.getTimeZone(config.getString("server_time_zone", DEFAULT_SERVER_TIME_ZONE));
        DEFAULT_SALE_TIMER = config.getLong("default_sale_duration", DEFAULT_SALE_TIMER);


    }

    private static String DEFAULT_SERVER_TIME_ZONE = "GMT-5";
    private static long DEFAULT_SALE_TIMER = 84000;
    public static TimeZone SERVER_TIME_ZONE = TimeZone.getTimeZone(DEFAULT_SERVER_TIME_ZONE);

    public static long DEFAULT_DEATHBAN_DURATION = TimeUnit.DAYS.toSeconds(1L);




}
