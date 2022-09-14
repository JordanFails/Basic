package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Utils.CC;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.config.Language;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.event.LuckPermsEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Objects;

public class TimelineCommand {
    @Command(
            name = "timeline",
            inGameOnly = true,
            permission = "hcf.command.timeline"
    )
    public void execute(CommandArgs args) {
        Player player = args.getPlayer();
        String group = Objects.requireNonNull(LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId())).getPrimaryGroup();
        String groupOutput = group.substring(0, 1).toUpperCase() + group.substring(1);
        boolean found = false;

        if (args.length() == 0) {
            player.sendMessage(CC.translate("&eCurrent Rank: " + groupOutput));
        } else if (args.length() == 1) {
            for (Player target : Bukkit.getServer().getOnlinePlayers()) {
                String name = player.getName();
                CraftPlayer handler = (CraftPlayer) player;
                String targetGroup = Objects.requireNonNull(LuckPermsProvider.get().getUserManager().getUser(target.getUniqueId())).getPrimaryGroup();
                String playerRank = LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getPrefix();
                String targetGroupOutput = targetGroup.substring(0, 1).toUpperCase() + targetGroup.substring(1);
                if (name.equalsIgnoreCase(args.getArgs(0))) {
                    player.sendMessage(CC.translate("&eCurrent Rank: " + targetGroupOutput));
                    found = true;
                    break;
                }
            }
            if (!found) {
                player.sendMessage(Language.COMMANDS_PLAYER_NOT_FOUND);
            }

        }

    }
}