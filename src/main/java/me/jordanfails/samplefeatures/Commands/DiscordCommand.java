package me.jordanfails.samplefeatures.Commands;

import me.jordanfails.samplefeatures.Utils.CC;
import me.jordanfails.samplefeatures.Utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        player.sendMessage(CC.translate("&d&lDiscord&r  » Join the discord at &d&ndiscord.gg/servername&r!"));
        player.sendMessage(CC.translate("&rJoining the discord to information and changelogs!"));

        return false;
    }
}
