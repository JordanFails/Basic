package me.jordanfails.basic;

import LorexMC.us.utils.internal.com.bruce.base.BasePlugin;
import com.minnymin.command.CommandFramework;
import lombok.Getter;
import me.jordanfails.basic.Commands.*;
import me.jordanfails.basic.Manager.*;
import me.jordanfails.basic.PartnerPackage.Listener.Package;
import me.jordanfails.basic.PartnerPackage.PartnerPackageCommand;
import me.jordanfails.basic.Rank.RankCommand;
import me.jordanfails.basic.Rank.RankExecutor;
import me.jordanfails.basic.Strikes.StrikeExecutor;
import me.jordanfails.basic.Utils.CC;
import me.jordanfails.basic.Utils.ConfigurationService;
import me.jordanfails.basic.Utils.Cooldown;
import me.jordanfails.basic.Utils.DateTimeFormats;
import me.jordanfails.basic.Vouchers.VouchersCommand;
import me.qiooip.lazarus.config.Config;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.Calendar.HOUR;
import static java.util.Calendar.MINUTE;

@Getter
public final class Basic extends JavaPlugin {
    private static Basic basic;

    private CommandFramework commandFramework;
    public static ArrayList<UUID> staff = new ArrayList<>();


    private static Permission perms = null;
    private static Chat chat = null;

    public static final String PREFIX;
    public static final String NOPLAYER;
    public static final String PREFIXNOPERMS;
    public static final String NOPERMS;
    public static final String RANKPREFIX;
    public static final String PLAYERONLY;
    public static final String ERROR;
    public static final String SUCCESS;
    public static final String TOOMANYARGS;

    public static final String TOOLITTLEARGS;

    public static final String INFO;
    @Override
    public void onEnable() {
        basic = this;
        long timeAtStart = System.currentTimeMillis();
        registerManagers();
        setupPermissions();
        getCommand("srank").setExecutor(new RankExecutor(this));
        getCommand("lettingin").setExecutor(new LettingInCommand());
        getCommand("strike").setExecutor(new StrikeExecutor(this));
        getCommand("arevive").setExecutor(new AdminReviveCommand());
        getCommand("runningin").setExecutor(new RunningInCommand());
        this.commandFramework = new CommandFramework(this);
        setupChat();
        autoDiscord();
        autoTip1();
        Plugin aquacore = getServer().getPluginManager().getPlugin("AquaCore");
        ConfigurationService.setup();
        ConfigurationService.save();
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        long timeAtEnd = System.currentTimeMillis();
        long timeTakenInMS = timeAtEnd - timeAtStart;
        Cooldown.createCooldown("lff_cooldown");
        Cooldown.createCooldown("youtube_cooldown");
        Cooldown.createCooldown("partner_cooldown");
        Cooldown.createCooldown("twitch_cooldown");
        Cooldown.createCooldown("lettingin_cooldown");
        Cooldown.createCooldown("runningin_command");
        if(!getDescription().getName().equals("Basic") && getDescription().getAuthors().toString().equals("JordanFails")){
            getServer().getPluginManager().disablePlugin(this);
        }

        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[Basic]" + ChatColor.GREEN + " Plugin loaded in " + timeTakenInMS + "ms.");
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
    public static Basic get() {
        return basic;
    }

    public static Basic getInstance(){
        return basic;
    }


    @Override
    public void onDisable() {
        basic = null;
    }

    private void registerCommands(){
        this.commandFramework.registerCommands(new AbilityGUICommand());
        this.commandFramework.registerCommands(new PlayerInfoCommand());
        this.commandFramework.registerCommands(new MuteChatCommand());
        if(me.qiooip.lazarus.config.Config.FACTION_MAX_ALLIES == 0){
        }else if(me.qiooip.lazarus.config.Config.FACTION_MAX_ALLIES > 0){
            this.commandFramework.registerCommands(new LFACommand());
        }
        if(Config.FACTION_NAME_MAXIMUM_LENGTH == 15){
        }else if(Config.FACTION_NAME_MAXIMUM_LENGTH > 15){
            this.commandFramework.registerCommands(new FreeRankCommand());
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
        this.commandFramework.registerCommands(new VouchersCommand());
        this.commandFramework.registerCommands(new PartnerPackageCommand());
        this.commandFramework.registerCommands(new SoundsCommand());
        this.commandFramework.registerCommands(new TopRankCommand());
        this.commandFramework.registerCommands(new FreeRankCommand());
        this.commandFramework.registerCommands(new StartRebootCommand());
        this.commandFramework.registerCommands(new ProfileCommand());
        this.commandFramework.registerCommands(new FriendsCommand());
        this.commandFramework.registerCommands(new CraftCommand());
        this.commandFramework.registerCommands(new SetSlotsCommand());
        this.commandFramework.registerCommands(new PunishmentWipeCommand());
        this.commandFramework.registerCommands(new FakeBanCommand());
        this.commandFramework.registerCommands(new RandomTeleportCommand());
        this.commandFramework.registerCommands(new GrantStatusCommand());
        this.commandFramework.registerCommands(new SkullCommand());
        this.commandFramework.registerCommands(new CurrentRankCommand());
        this.commandFramework.registerCommands(new ServerTimeCommand());
        this.commandFramework.registerCommands(new VoteCommand());
        this.commandFramework.registerCommands(new WhoIsCommand());
        this.commandFramework.registerCommands(new PingCommand());
        this.commandFramework.registerCommands(new TwitchCommand());
        this.commandFramework.registerCommands(new PartnerCommand());

    }

    private void registerManagers(){
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new JoinLeaveManager(), this);
        manager.registerEvents(new PunishListener(), this);
        manager.registerEvents(new ChatManager(), this);
        manager.registerEvents(new LFFManager(), this);
        //manager.registerEvents(new RedeemManager(), this);
        //manager.registerEvents(new CraftingPerk(), this);
        //manager.registerEvents(new FlyPerk(), this);
        //manager.registerEvents(new FeedPerk(), this);
        //manager.registerEvents(new Package(), this);
        //manager.registerEvents(new ClearTimerPerk(), this);
        manager.registerEvents(new ProfileManager(), this);
        manager.registerEvents(new InventoryManager(), this);
        manager.registerEvents(new SkullListener(), this);
    }

    public static String getReaming(long millis) {
        return getRemaining(millis, true, true);
    }

    public static String getRemaining(long millis, boolean milliseconds) {
        return getRemaining(millis, milliseconds, true);
    }

    public void autoDiscord(){
        new BukkitRunnable(){

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
            @SuppressWarnings("deprecation")
            @Override
            public void run() {
                Bukkit.getServer().broadcastMessage(CC.translate("&8[&4Alert&8]&r Our brand new &6&lSampleFeatures Discord&r!&r Join at &ediscord.gg/samplefeatures&r."));
            }
        }.runTaskTimerAsynchronously(this, 0, 20*TimeUnit.MINUTES.toSeconds(30));
    }

    public void autoTip1(){
        new BukkitRunnable() {
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
            @Override
            public void run() {
                TextComponent message = new TextComponent(CC.translate("&6&l[TIP] &8» &e SOTW on Squads takes place every Saturday at &a55PM EST&e. &a[Hover]"));
                message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Join out discord to learn more.").color(net.md_5.bungee.api.ChatColor.WHITE).create()));
                message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/discord"));

                for(Player player : Bukkit.getOnlinePlayers()){
                    player.spigot().sendMessage(message);
                }
            }
        }.runTaskTimerAsynchronously(this, 0, 20*TimeUnit.MINUTES.toSeconds(60));
    }

    public static String getRemaining(long duration, boolean milliseconds, boolean trail) {
        if ((milliseconds) && (duration < MINUTE)) {
            return ((DecimalFormat) (trail ? DateTimeFormats.REMAINING_SECONDS_TRAILING
                    : DateTimeFormats.REMAINING_SECONDS).get()).format(duration * 0.001D) + 's';
        }
        return DurationFormatUtils.formatDuration(duration, (duration >= HOUR ? "HH:" : "") + "mm:ss");
    }

    static{
        PREFIX = ChatColor.GOLD + ChatColor.BOLD.toString() + "Basic §7» " + ChatColor.WHITE;
        RANKPREFIX = ChatColor.GOLD + ChatColor.BOLD.toString() + "Rank §7» " + ChatColor.WHITE;
        ERROR = CC.translate("&6&lBasic §7»&c Error&7 |&c ");
        SUCCESS = CC.translate("&6&lBasic §7»&a Success&7 |&a ");
        INFO = CC.translate("&6&lBasic §7»&e Info&7 |&e ");
        TOOMANYARGS = CC.translate("&6&lBasic §7»&c Error&7 |&cYou've added too many arguments!");
        NOPLAYER = CC.translate("&6&lBasic §7»&c Error&7 |&c We're having trouble finding this player in our database!");
        PREFIXNOPERMS = ChatColor.RED + "&6&lBasic §7»&c Error&7 |&You lack the sufficient permissions to use this prefix.";
        NOPERMS = CC.translate("&6&lBasic §7»&c Error&7 |&cYou lack the permissions to execute this command.");
        PLAYERONLY = CC.translate("&6&lBasic §7»&c Error&7 |&cThis command is for players only!");
        TOOLITTLEARGS = CC.translate("&6&lBasic §7»&c Error&7 |&cYou've added too little arguments!");

    }

}
