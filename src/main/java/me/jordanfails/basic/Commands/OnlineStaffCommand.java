package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.CC;
import org.bukkit.entity.Player;

public class OnlineStaffCommand {

    @Command(
            name = "staffonline",
            aliases = "onlinestaff",
            inGameOnly = false
    )
    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        if(Basic.staff.size() == 0){
            player.sendMessage(" ");
            player.sendMessage(CC.Aqua + "[Staff] "  + CC.White + "We currently have " + CC.AquaU + Basic.staff.size() + CC.White + " staff online. If you need support, use " + CC.AquaU + "/discord" + CC.White + " and join the discord.");
            player.sendMessage(" ");
        }else if(Basic.staff.size() > 1){
            player.sendMessage(" ");
            player.sendMessage(CC.Aqua + "[Staff] "  + CC.White + "We currently have " + CC.AquaU + Basic.staff.size() + CC.White + " staff online. If you need support, use " + CC.AquaU + "/request" + CC.White + ".");
            player.sendMessage(" ");
        }
    }
}
