package me.jordanfails.basic.Commands;

import com.google.common.collect.ImmutableMap;
import jdk.javadoc.internal.doclets.formats.html.markup.Text;
import me.jordanfails.basic.Utils.BaseConstants;
import me.jordanfails.basic.Utils.BukkitUtils;
import me.jordanfails.basic.Utils.StaffPriority;
import me.qiooip.lazarus.commands.manager.BaseCommand;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class WhoIsCommand
        extends BaseCommand {
    private static final Map<Integer, String> CLIENT_PROTOCOL_IDS = ImmutableMap.of(4, "1.7.5", 5, "1.7.10", 47, "1.8");
    private final BasePlugin plugin;

    public WhoisCommand(BasePlugin plugin) {
        super("whois", "Check information about a player.");
        this.plugin = plugin;
        this.setUsage("/(command) [playerName]");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage(this.getUsage());
            return true;
        }
        Player target = BukkitUtils.playerWithNameOrUUID(args[0]);
        if (target == null || !BaseCommand.canSee(sender, target)) {
            sender.sendMessage(String.format(BaseConstants.PLAYER_WITH_NAME_OR_UUID_NOT_FOUND, args[0]));
            return true;
        }
        Location location = target.getLocation();
        World world = location.getWorld();
        BaseUser baseUser = this.plugin.getUserManager().getUser(target.getUniqueId());
        sender.sendMessage((Object) ChatColor.GRAY + BukkitUtils.STRAIGHT_LINE_DEFAULT);
        sender.sendMessage((Object)ChatColor.GREEN + " [" + target.getDisplayName() + (Object)ChatColor.GREEN + ']');
        sender.sendMessage((Object)ChatColor.YELLOW + "  Hunger: " + (Object)ChatColor.AQUA + target.getFoodLevel() + '/' + 20 + " (" + target.getSaturation() + " saturation)");
        sender.sendMessage((Object)ChatColor.YELLOW + "  Exp/Level: " + (Object)ChatColor.AQUA + target.getExp() + '/' + target.getLevel());
        sender.sendMessage((Object)ChatColor.YELLOW + "  Location: " + (Object)ChatColor.AQUA + world.getName() + ' ' + (Object)ChatColor.GRAY + '[' + WordUtils.capitalizeFully((String)world.getEnvironment().name().replace('_', ' ')) + "] " + (Object)ChatColor.GOLD + '(' + location.getBlockX() + ", " + location.getBlockY() + ", " + location.getBlockZ() + ')');
        sender.sendMessage((Object)ChatColor.YELLOW + "  Vanished: " + (Object)ChatColor.AQUA + baseUser.isVanished() + " (priority=" + StaffPriority.of(target).getPriorityLevel() + ')');
        sender.sendMessage((Object)ChatColor.YELLOW + "  Staff Chat: " + (Object)ChatColor.AQUA + baseUser.isInStaffChat());
        sender.sendMessage((Object)ChatColor.YELLOW + "  Operator: " + (Object)ChatColor.AQUA + target.isOp());
        if (PermissionsEx.getPlugin() != null) {
            sender.sendMessage((Object)ChatColor.YELLOW + "  * Permission: " + (PermissionsEx.getUser((Player)target).has("*") ? new StringBuilder().append((Object)ChatColor.AQUA).append("true").toString() : new StringBuilder().append((Object)ChatColor.AQUA).append("false").toString()));
        }
        sender.sendMessage((Object)ChatColor.YELLOW + "  Staff Mode: " + (Object)ChatColor.AQUA + baseUser.isStaffUtil());
        sender.sendMessage((Object)ChatColor.YELLOW + "  GameMode: " + (Object)ChatColor.AQUA + WordUtils.capitalizeFully((String)target.getGameMode().name().replace('_', ' ')));
        sender.sendMessage((Object)ChatColor.YELLOW + "  Idle Time: " + (Object)ChatColor.AQUA + DurationFormatUtils.formatDurationWords((long)BukkitUtils.getIdleTime(target), (boolean)true, (boolean)true));
        sender.sendMessage((Object)ChatColor.YELLOW + "  IP4 Address: " + (Object)ChatColor.AQUA + (sender.hasPermission(new StringBuilder().append(command.getPermission()).append(".ip").toString()) ? target.getAddress().getHostString() : new StringBuilder().append((Object)ChatColor.STRIKETHROUGH).append("1.1.1.1").toString()));
        if (baseUser.getNotes() != null) {
            if (!baseUser.getNotes().isEmpty()) {
                if (baseUser.getNotes().size() > 1) {
                    new Text((Object)ChatColor.YELLOW + "  Note: " + (Object)ChatColor.AQUA + baseUser.getNotes().get(0) + (Object)ChatColor.GRAY + " [Click for more notes]").setHoverText((Object)ChatColor.AQUA + "Click me to view " + target.getName() + "'s " + baseUser.getNotes().size() + " more notes.").setClick(ClickAction.RUN_COMMAND, "/note check " + target.getName()).send(sender);
                } else {
                    sender.sendMessage((Object)ChatColor.YELLOW + "  Notes: " + (Object)ChatColor.AQUA + baseUser.getNotes().get(0));
                }
            } else {
                sender.sendMessage((Object)ChatColor.YELLOW + "  Notes: " + (Object)ChatColor.RED + "none");
            }
        } else {
            sender.sendMessage((Object)ChatColor.YELLOW + "  Notes: " + (Object)ChatColor.RED + "none");
        }
        int version = ((CraftPlayer)target).getHandle().playerConnection.networkManager.getVersion();
        sender.sendMessage((Object)ChatColor.YELLOW + "  Client Version: " + (Object)ChatColor.AQUA + version + (Object)ChatColor.GRAY + " [" + (String)MoreObjects.firstNonNull((Object)CLIENT_PROTOCOL_IDS.get(version), (Object)"Unknown (check at http://wiki.vg/Protocol_version_numbers)") + "]");
        sender.sendMessage((Object)ChatColor.GRAY + BukkitUtils.STRAIGHT_LINE_DEFAULT);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return args.length == 1 ? null : Collections.emptyList();
    }
}

