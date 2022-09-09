package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class StartRebootCommand {
    @Command(
            name = "startreboot",
            permission = "hcf.command.startreboot"
    )

    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();

        if(!sender.getName().equalsIgnoreCase("CONSOLE")){
           sender.sendMessage(CC.translate("&c&l(!)&c This is a console only command."));
           return;
        }else{
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "reboot start 1h");
        }
    }
}
