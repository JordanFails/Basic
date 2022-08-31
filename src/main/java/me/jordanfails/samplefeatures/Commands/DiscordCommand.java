package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.CC;
import me.jordanfails.samplefeatures.Utils.Utils;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand {
    @Command(
            name = "discord",
            inGameOnly = false
    )
    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        player.sendMessage(CC.translate("&eJoin out discord at:&d discord.gg/servername&e."));
    }
}
