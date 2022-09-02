package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class DiscordCommand {
    @Command(
            name = "discord",
            inGameOnly = true
    )
    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        player.sendMessage(CC.translate("&eYou can join our  discord at: &dhttps://discord.gg/servername&e."));
        player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100F, 1F);
    }
}
