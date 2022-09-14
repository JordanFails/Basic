package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PunishmentWipeCommand {
    @Command(
            name = "pwipe",
            permission = "hcf.command.punishment.wipe"
    )

    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();
        Player player = args.getPlayer();
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "liteban reset-database");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "liteban reset-database confirm server:global");


    }
}
