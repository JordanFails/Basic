package com.jordanfails.samplefeatures.Commands;

import com.jordanfails.samplefeatures.Utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        player.sendMessage(Utils.chat("&d&n" + player.getDisplayName() + "&d,&e The discord server is &d&nhttps://discord.gg/(server name)"));
        player.sendMessage(" ");
        player.sendMessage(Utils.chat("&rJoining the discord can keep you informed about &d&lspecial&r rewards!"));
        return false;
    }
}
