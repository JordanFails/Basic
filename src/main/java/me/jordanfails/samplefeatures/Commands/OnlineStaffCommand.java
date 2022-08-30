package me.jordanfails.samplefeatures.Commands;

import me.jordanfails.samplefeatures.SampleFeatures;
import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OnlineStaffCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(SampleFeatures.staff.size() == 0){
                player.sendMessage(" ");
                player.sendMessage(CC.Aqua + "[Staff] "  + CC.White + "We currently have " + CC.AquaU + SampleFeatures.staff.size() + CC.White + " staff online. If you need support, use " + CC.AquaU + "/discord" + CC.White + " and join the discord.");
                player.sendMessage(" ");
            }else if(SampleFeatures.staff.size() > 1){
                player.sendMessage(" ");
                player.sendMessage(CC.Aqua + "[Staff] "  + CC.White + "We currently have " + CC.AquaU + SampleFeatures.staff.size() + CC.White + " staff online. If you need support, use " + CC.AquaU + "/request" + CC.White + ".");
                player.sendMessage(" ");
            }
        }
        return false;
    }
}
