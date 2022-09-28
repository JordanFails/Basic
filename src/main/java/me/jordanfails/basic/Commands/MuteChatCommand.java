package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.activated.core.managers.server.ChatManagement;
import me.activated.core.plugin.AquaCore;
import me.activated.core.plugin.AquaCoreAPI;
import me.jordanfails.basic.Utils.CC;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.handlers.chat.ChatControlHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class MuteChatCommand {

    @Command(
            name = "mutechat",
            permission = "hcf.mutechat",
            noPerm = "You lack the permissions to execute this command"

    )
    public void execute(CommandArgs args) {
        ChatManagement chatManagement = AquaCore.INSTANCE.getChatManagement();
        CommandSender player = args.getSender();
        if (args.length() == 0) {
            if (chatManagement.isMuted()) {
                chatManagement.setMuted(false);
                Bukkit.getConsoleSender().sendMessage(CC.translate("&a&n" + player.getName() + "&r has unmuted chat."));
                Bukkit.getServer().broadcastMessage(CC.translate("&a&l(!)&a Global chat has been unmuted."));
                player.sendMessage(CC.translate("&a&l(!)&a Chat has been successfully &r&nunmuted&a!"));
            } else {
                chatManagement.setMuted(true);
                Bukkit.getConsoleSender().sendMessage(CC.translate("&a&n" + player.getName() + "&r has muted chat."));
                Bukkit.getServer().broadcastMessage(CC.translate("&a&l(!)&a Global chat has been muted."));
                player.sendMessage(CC.translate("&a&l(!)&a Chat has been successfully &r&nmuted&a!"));
            }
        }
    }
}