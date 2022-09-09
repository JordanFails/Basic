package me.jordanfails.samplefeatures;

import com.minnymin.command.CommandFramework;
import lombok.Getter;
import me.jordanfails.samplefeatures.Commands.*;
import me.jordanfails.samplefeatures.Manager.*;
import me.jordanfails.samplefeatures.PartnerPackage.Listener.Package;
import me.jordanfails.samplefeatures.PartnerPackage.PartnerPackageCommand;
import me.jordanfails.samplefeatures.Tasks.RebootTask;
import me.jordanfails.samplefeatures.Utils.ConfigurationService;
import me.jordanfails.samplefeatures.Vouchers.VouchersCommand;
import me.jordanfails.samplefeatures.Vouchers.listeners.ClearTimerPerk;
import me.jordanfails.samplefeatures.Vouchers.listeners.CraftingPerk;
import me.jordanfails.samplefeatures.Vouchers.listeners.FeedPerk;
import me.jordanfails.samplefeatures.Vouchers.listeners.FlyPerk;
import me.qiooip.lazarus.factions.FactionsManager;
import net.luckperms.api.model.user.User;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.UUID;

@Getter
public final class SampleFeatures extends JavaPlugin {
    private static SampleFeatures plugin;

    private CommandFramework commandFramework;
    public static ArrayList<UUID> staff = new ArrayList<>();


    private static Permission perms = null;
    private static Chat chat = null;

    @Override
    public void onEnable() {
        plugin = this;
        this.commandFramework = new CommandFramework(this);
        long timeAtStart = System.currentTimeMillis();
        registerCommands();
        registerManagers();
        setupPermissions();
        setupChat();
        ConfigurationService.setup();
        ConfigurationService.save();
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        long timeAtEnd = System.currentTimeMillis();
        long timeTakenInMS = timeAtEnd - timeAtStart;
        if(!getDescription().getName().equals("SampleFeatures") && getDescription().getAuthors().equals("JordanFails")){
            getServer().getPluginManager().disablePlugin(this);
        }

        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[SampleFeatures]" + ChatColor.GREEN + " Plugin loaded in " + timeTakenInMS + "ms.");

        BukkitTask rebootTask = new RebootTask(this).runTaskLater(this, 20 * 5L);

        BukkitScheduler scheduler = getServer().getScheduler();


    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    public static boolean hasPermission(User user, String permission){
        return user.getCachedData().getPermissionData().checkPermission(permission).asBoolean();
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public static Chat getChat() {
        return chat;
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
        if(me.qiooip.lazarus.config.Config.FACTION_MAX_ALLIES == 0){
        }else if(me.qiooip.lazarus.config.Config.FACTION_MAX_ALLIES > 0){
            this.commandFramework.registerCommands(new LFACommand());
        }
        this.commandFramework.registerCommands(new NitroCommand());
        this.commandFramework.registerCommands(new SupportCommand());
        this.commandFramework.registerCommands(new DiscordCommand());
        this.commandFramework.registerCommands(new LunarAmountCommand());
        this.commandFramework.registerCommands(new OnlineStaffCommand());
        this.commandFramework.registerCommands(new SaleCommand());
        this.commandFramework.registerCommands(new StaffInfoCommand());
        this.commandFramework.registerCommands(new YouTubeCommand());
        this.commandFramework.registerCommands(new StoreCommand());
        this.commandFramework.registerCommands(new TimelineCommand());
        this.commandFramework.registerCommands(new HatCommand());
        this.commandFramework.registerCommands(new DelayCommand());
        this.commandFramework.registerCommands(new InfoCommand());
        this.commandFramework.registerCommands(new GiveawayCommand());
        this.commandFramework.registerCommands(new ChatColorCommand());
        this.commandFramework.registerCommands(new PingCommand());
        this.commandFramework.registerCommands(new SampleFeatureCommand());
        this.commandFramework.registerCommands(new VouchersCommand());
        this.commandFramework.registerCommands(new PartnerPackageCommand());
        this.commandFramework.registerCommands(new SoundsCommand());
        this.commandFramework.registerCommands(new TopRankCommand());
        this.commandFramework.registerCommands(new FreeRankCommand());
        this.commandFramework.registerCommands(new StartRebootCommand());
        this.commandFramework.registerCommands(new ProfileCommand());
        this.commandFramework.registerCommands(new FriendsCommand());
        getCommand("arevive").setExecutor(new AdminReviveCommand());
    }

    private void registerManagers(){

        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new JoinLeaveManager(), this);
        manager.registerEvents(new PunishListener(), this);
        manager.registerEvents(new ChatManager(), this);
        manager.registerEvents(new LFFManager(), this);
        manager.registerEvents(new RedeemManager(), this);
        manager.registerEvents(new CraftingPerk(), this);
        manager.registerEvents(new FlyPerk(), this);
        manager.registerEvents(new FeedPerk(), this);
        manager.registerEvents(new Package(), this);
        manager.registerEvents(new ClearTimerPerk(), this);
        manager.registerEvents(new ProfileManager(), this);
    }

}
