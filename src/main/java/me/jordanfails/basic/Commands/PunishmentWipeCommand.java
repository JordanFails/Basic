package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.activated.core.api.player.PlayerData;
import me.activated.core.plugin.AquaCore;
import me.activated.core.plugin.AquaCoreAPI;
import me.qiooip.lazarus.config.Language;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PunishmentWipeCommand {
    @Command(
            name = "pwipe",
            permission = "hcf.command.punishment.wipe"
    )

    public void execute(CommandArgs args){

        Player player = args.getPlayer();
        UUID uuid = player.getUniqueId();



    }
}
