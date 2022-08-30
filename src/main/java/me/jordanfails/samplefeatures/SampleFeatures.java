package me.jordanfails.samplefeatures;

import com.minnymin.command.CommandFramework;
import me.jordanfails.samplefeatures.Commands.*;
import me.jordanfails.samplefeatures.Manager.ChatManager;
import me.jordanfails.samplefeatures.Manager.JoinLeaveManager;
import me.jordanfails.samplefeatures.Manager.LFFManager;
import me.jordanfails.samplefeatures.Manager.PunishListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public final class SampleFeatures extends JavaPlugin {

    private CommandFramework commandFramework;

    private static SampleFeatures plugin;

    public static ArrayList<UUID> staff = new ArrayList<>();

    @Override
    public void onEnable() {
        plugin = this;
        this.commandFramework = new CommandFramework(this);
        registerCommands();
        registerManagers();
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[SampleFeatures]" + ChatColor.GREEN + " Plugin has been enabled successfully.");
    }
    public static SampleFeatures get() {
        return plugin;
    }

    @Override
    public void onDisable() {
        SampleFeatures.plugin = null;
    }

    private void registerCommands(){
        this.commandFramework.registerCommands(new AbilityGUICommand());
        this.commandFramework.registerCommands(new PlayerInfoCommand());
        this.commandFramework.registerCommands(new MuteChatCommand());
        this.commandFramework.registerCommands(new LFACommand());
        getCommand("arevive").setExecutor(new AdminReviveCommand());
        getCommand("discord").setExecutor(new DiscordCommand());
        getCommand("serverinfo").setExecutor(new InfoCommand());
        getCommand("lunaramount").setExecutor(new LunarAmountCommand());
        getCommand("staffinfo").setExecutor(new StaffInfoCommand());
        getCommand("timeline").setExecutor(new TimelineCommand());
        getCommand("staffonline").setExecutor(new OnlineStaffCommand());
        getCommand("youtube").setExecutor(new YouTubeCommand());
    }

    private void registerManagers(){

        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new JoinLeaveManager(), this);
        manager.registerEvents(new PunishListener(), this);
        manager.registerEvents(new ChatManager(), this);
        manager.registerEvents(new LFFManager(), this);

    }

}
