package me.jordanfails.samplefeatures;

import com.minnymin.command.CommandFramework;
import me.jordanfails.samplefeatures.Commands.*;
import me.jordanfails.samplefeatures.Manager.*;
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

    public static ArrayList<UUID> redeem = new ArrayList<>();

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
        this.commandFramework.registerCommands(new NitroCommand());
        this.commandFramework.registerCommands(new RedeemCommand());
        this.commandFramework.registerCommands(new DiscordCommand());
        this.commandFramework.registerCommands(new LunarAmountCommand());
        this.commandFramework.registerCommands(new OnlineStaffCommand());
        getCommand("arevive").setExecutor(new AdminReviveCommand());
        getCommand("serverinfo").setExecutor(new InfoCommand());
        getCommand("staffinfo").setExecutor(new StaffInfoCommand());
        getCommand("timeline").setExecutor(new TimelineCommand());
        getCommand("youtube").setExecutor(new YouTubeCommand());
    }

    private void registerManagers(){

        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new JoinLeaveManager(), this);
        manager.registerEvents(new PunishListener(), this);
        manager.registerEvents(new ChatManager(), this);
        manager.registerEvents(new LFFManager(), this);
        manager.registerEvents(new RedeemManager(), this);

    }

}
