package me.jordanfails.basic.Commands;

import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.BaseConstants;
import me.jordanfails.basic.Utils.Basic.BasicCommand;
import me.jordanfails.basic.Utils.BukkitUtils;
import me.qiooip.lazarus.commands.manager.BaseCommand;
import net.minecraft.util.org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class WhoisCommand {

    @com.minnymin.command.Command(
            name = "whois",
            description = "Check information about a player.",
            usage = "Usage: /whois {player}"
    )
    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();

        if(args.length() < 1){
            sender.sendMessage(args.getCommand().getUsage());
        }
        final Player target = BukkitUtils.playerWithNameOrUUID(args.getArgs(0));
        if(!BasicCommand.canSee(sender, target)) {
            sender.sendMessage(String.format(BaseConstants.PLAYER_WITH_NAME_OR_UUID_NOT_FOUND, args.getArgs(0)));
        }
        final Location location = target.getLocation();
        final World world = location.getWorld();
        sender.sendMessage(ChatColor.GRAY + BukkitUtils.STRAIGHT_LINE_DEFAULT);
        sender.sendMessage(ChatColor.GRAY + " [" + ChatColor.GRAY + target.getDisplayName() + ChatColor.GRAY + ']');
        sender.sendMessage(ChatColor.GOLD + "  Hunger: " + ChatColor.GRAY + target.getFoodLevel() + '/' + 20 + " (" + target.getSaturation() + " saturation)");
        sender.sendMessage(ChatColor.GOLD + "  Exp/Level: " + ChatColor.GRAY + target.getExp() + '/' + target.getLevel());
        sender.sendMessage(ChatColor.GOLD + "  Location: " + ChatColor.GRAY + world.getName() + ' ' + ChatColor.GRAY + '[' + WordUtils.capitalizeFully(world.getEnvironment().name().replace('_', ' ')) + "] " + ChatColor.GRAY + '(' + location.getBlockX() + ", " + location.getBlockY() + ", " + location.getBlockZ() + ')');
        sender.sendMessage(ChatColor.GOLD + "  Operator: " + ChatColor.GRAY + target.isOp());
        sender.sendMessage(ChatColor.GOLD + "  GameMode: " + ChatColor.GRAY + WordUtils.capitalizeFully(target.getGameMode().name().replace('_', ' ')));
        sender.sendMessage(ChatColor.GOLD + "  Idle Time: " + ChatColor.GRAY + DurationFormatUtils.formatDurationWords(BukkitUtils.getIdleTime(target), true, true));
        sender.sendMessage(ChatColor.GOLD + "  IP4 Address: " + ChatColor.GRAY + (sender.hasPermission(args.getCommand().getPermission() + ".ip") ? target.getAddress().getHostString(): ChatColor.STRIKETHROUGH + "1.1.1.1" ));
        sender.sendMessage(ChatColor.GRAY + BukkitUtils.STRAIGHT_LINE_DEFAULT);
    }
}



