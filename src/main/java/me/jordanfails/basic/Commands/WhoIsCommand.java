package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.activated.core.plugin.AquaCore;
import me.activated.core.plugin.AquaCoreAPI;
import me.jordanfails.basic.Utils.*;
import me.qiooip.lazarus.Lazarus;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class WhoIsCommand{
    @Command(
            name = "whois",
            description = "Check information about a player.",
            usage = "Usage: /whois (player)"
    )

    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();
        if(args.length() < 1) {
            sender.sendMessage(args.getCommand().getUsage());
            return;
        }

        Player target = Bukkit.getPlayer(args.getArgs(0));
        if(target == null || !canSee(sender, target)){
            sender.sendMessage(String.format(BaseConstants.PLAYER_WITH_NAME_OR_UUID_NOT_FOUND, args.getArgs(0)));
            return;
        }

        Location location = target.getLocation();
        World world = location.getWorld();
        boolean isVanished = AquaCoreAPI.INSTANCE.getPlayerData(target.getUniqueId()).isVanished();
        boolean isStaffChatAlerts = AquaCoreAPI.INSTANCE.getGlobalPlayer(target.getUniqueId()).isStaffChatAlerts();
        boolean isInStaffMode = AquaCoreAPI.INSTANCE.getPlayerData(target.getUniqueId()).isInStaffMode();



        sender.sendMessage( ChatColor.GRAY + BukkitUtils.STRAIGHT_LINE_DEFAULT);
        sender.sendMessage(ChatColor.GREEN + " [" + target.getDisplayName() + ChatColor.GREEN + ']');
        sender.sendMessage(ChatColor.YELLOW + "  Hunger: " + ChatColor.AQUA + target.getFoodLevel() + '/' + 20 + " (" + target.getSaturation() + " saturation)");
        sender.sendMessage(ChatColor.YELLOW + "  Exp/Level: " + ChatColor.AQUA + target.getExp() + '/' + target.getLevel());
        sender.sendMessage(ChatColor.YELLOW + "  Location: " + ChatColor.AQUA + world.getName() + ' ' + (Object)ChatColor.GRAY + '[' + WordUtils.capitalizeFully((String)world.getEnvironment().name().replace('_', ' ')) + "] " + (Object)ChatColor.GOLD + '(' + location.getBlockX() + ", " + location.getBlockY() + ", " + location.getBlockZ() + ')');
        sender.sendMessage(ChatColor.YELLOW + "  Vanished: " + ChatColor.AQUA + isVanished + " (priority=" + StaffPriority.of(target).getPriorityLevel() + ')');
        sender.sendMessage(ChatColor.YELLOW + "  Staff Chat: " + ChatColor.AQUA + isStaffChatAlerts);
        sender.sendMessage(ChatColor.YELLOW + "  Operator: " + ChatColor.AQUA + target.isOp());
        sender.sendMessage(ChatColor.YELLOW + "  Permission: " + (AquaCore.INSTANCE.getPlayerManagement().getPlayerData(target.getUniqueId()).hasPermission("*") ? new StringBuilder().append((Object)ChatColor.AQUA).append("true").toString() : new StringBuilder().append((Object)ChatColor.AQUA).append("false").toString()));
        sender.sendMessage(ChatColor.YELLOW + "  Staff Mode: " + ChatColor.AQUA + isInStaffMode);
        sender.sendMessage(ChatColor.YELLOW + "  GameMode: " + ChatColor.AQUA + WordUtils.capitalizeFully((String)target.getGameMode().name().replace('_', ' ')));
        sender.sendMessage(ChatColor.YELLOW + "  Idle Time: " + ChatColor.AQUA + DurationFormatUtils.formatDurationWords((long)BukkitUtils.getIdleTime(target), (boolean)true, (boolean)true));
        sender.sendMessage(ChatColor.YELLOW + "  IP4 Address: " + ChatColor.AQUA + (sender.hasPermission(new StringBuilder().append(args.getCommand().getPermission()).append(".ip").toString()) ? target.getAddress().getHostString() : new StringBuilder().append((Object)ChatColor.STRIKETHROUGH).append("1.1.1.1").toString()));
        if (Lazarus.getInstance().getUserdataManager().getUserdata(target).getNotes() != null) {
            if (!Lazarus.getInstance().getUserdataManager().getUserdata(target).getNotes().isEmpty()) {
                if (Lazarus.getInstance().getUserdataManager().getUserdata(target).getNotes().size() > 1) {
                    new Text((Object)ChatColor.YELLOW + "  Note: " + (Object)ChatColor.AQUA + Lazarus.getInstance().getUserdataManager().getUserdata(target).getNotes().get(0) + (Object)ChatColor.GRAY + " [Click for more notes]").setHoverText((Object)ChatColor.AQUA + "Click me to view " + target.getName() + "'s " + Lazarus.getInstance().getUserdataManager().getUserdata(target).getNotes().size() + " more notes.").setClick(ClickAction.RUN_COMMAND, "/notes check " + target.getName()).send(sender);
                } else {
                    sender.sendMessage((Object)ChatColor.YELLOW + "  Notes: " + (Object)ChatColor.AQUA + Lazarus.getInstance().getUserdataManager().getUserdata(target).getNotes().get(0));
                }
            } else {
                sender.sendMessage((Object)ChatColor.YELLOW + "  Notes: " + (Object)ChatColor.RED + "none");
            }
        } else {
            sender.sendMessage((Object)ChatColor.YELLOW + "  Notes: " + (Object)ChatColor.RED + "none");
        }
        int version = ((CraftPlayer)target).getHandle().playerConnection.networkManager.getVersion();
        sender.sendMessage((Object)ChatColor.GRAY + BukkitUtils.STRAIGHT_LINE_DEFAULT);
        return;
    }

    public static boolean canSee(CommandSender sender, Player target) {
        return (target != null) && ((!(sender instanceof Player)) || (((Player) sender).canSee(target)));
    }
}

