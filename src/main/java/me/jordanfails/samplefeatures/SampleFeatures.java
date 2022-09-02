package me.jordanfails.samplefeatures;

import com.minnymin.command.CommandFramework;
import lombok.Getter;
import me.jordanfails.samplefeatures.Commands.*;
import me.jordanfails.samplefeatures.Manager.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

@Getter
public final class SampleFeatures extends JavaPlugin {

    private static SampleFeatures plugin;

    private CommandFramework commandFramework;

    public static ArrayList<UUID> staff = new ArrayList<>();

    public static ArrayList<UUID> redeem = new ArrayList<>();



    @Override
    public void onEnable() {
        plugin = this;
        this.commandFramework = new CommandFramework(this);
        long timeAtStart = System.currentTimeMillis();
        registerCommands();
        registerManagers();
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        if(Bukkit.getPluginManager().getPlugin("Lazarus") == null){
            Bukkit.getPluginManager().disablePlugin(this);
        }
        long timeAtEnd = System.currentTimeMillis();
        long timeTakenInMS = timeAtEnd - timeAtStart;
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[SampleFeatures]" + ChatColor.GREEN + " Plugin loaded in " + timeTakenInMS + "ms.");
    }
    public static SampleFeatures get() {
        return plugin;
    }


    @Override
    public void onDisable() {
        plugin = null;
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
        this.commandFramework.registerCommands(new SaleCommand());
        this.commandFramework.registerCommands(new StaffInfoCommand());
        this.commandFramework.registerCommands(new YouTubeCommand());
        this.commandFramework.registerCommands(new StoreCommand());
        this.commandFramework.registerCommands(new TimelineCommand());
        this.commandFramework.registerCommands(new HatCommand());
        getCommand("arevive").setExecutor(new AdminReviveCommand());
        getCommand("serverinfo").setExecutor(new InfoCommand());
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
