package com.jordanfails.samplefeatures;

import com.jordanfails.samplefeatures.Commands.*;
import com.jordanfails.samplefeatures.Manager.JoinEvent;
import com.jordanfails.samplefeatures.Manager.PunishListener;
import com.jordanfails.samplefeatures.Utils.Lag;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class SampleFeatures extends JavaPlugin {

    private static SampleFeatures plugin;

    private Random random = new Random();

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 100L, 1L);
        registerCommands();
        registerManagers();
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if(provider != null){
            LuckPerms api = provider.getProvider();
        }

        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[SampleFeatures] Plugin has been enabled successfully.");


    }

    public static SampleFeatures get() {
        return plugin;
    }

    private void saveData(){

    }

    @Override
    public void onDisable() {
        SampleFeatures.plugin = null;
        saveData();
    }

    private void registerCommands(){
        getCommand("checkdeathban").setExecutor(new CheckDeathbanCommand());
        getCommand("currentrank").setExecutor(new CheckRankCommand());
        getCommand("adminrevive").setExecutor(new AdminReviveCommand());
        getCommand("discord").setExecutor(new DiscordCommand());
        getCommand("serverinfo").setExecutor(new InfoCommand());
        getCommand("staffinfo").setExecutor(new StaffInfoCommand());
        getCommand("lunaramount").setExecutor(new LunarAmountCommand());
        getCommand("delay").setExecutor(new DelayCommand());
        getCommand("lockdown").setExecutor(new LockdownCommand());
        getCommand("store").setExecutor(new StoreCommand());
    }

    private void registerManagers(){

        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new JoinEvent(), this);
        manager.registerEvents(new PunishListener(), this);

    }
}
