package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.BukkitReflection;
import me.jordanfails.basic.Utils.CC;
import net.minecraft.util.org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.jordanfails.basic.Basic.NOPERMS;

public class SetSlotsCommand {

    @Command(
            name = "setslots",
            permission = "core.command.setslots"
    )

    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();
        int max = 100000;

        if(!sender.hasPermission("core.command.setslots")){
            sender.sendMessage(CC.translate(NOPERMS));
        }

        if(args.length() == 1){
            if(!NumberUtils.isDigits(args.getArgs(0))){
                sender.sendMessage(CC.translate("&cThe value you provided is invalid!"));
            }


            BukkitReflection.setMaxPlayers(Bukkit.getServer(), Integer.parseInt(args.getArgs(0)));
                sender.sendMessage(CC.translate("&7Updated the max slot count to &e%slots%&7.")
                        .replace("%slots%", args.getArgs(0)));

        }
    }
}
