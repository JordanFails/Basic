package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.CC;
import me.qiooip.lazarus.Lazarus;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class StaffInfoCommand {
    @Command(
            name = "staffinfo",
            permission = "hcf.command.staffinfo",
            description = "a cool command to check your staff infomation!",
            inGameOnly = true
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        Lazarus laz = Lazarus.getInstance();
        int delay = laz.getChatControlHandler().getDelay();

        player.sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "--------------------------------");
        player.sendMessage(" ");
        player.sendMessage(CC.translate("&6&lUser:&r " + player.getName()));
        if(laz.getVanishManager().isVanished(player)){
            player.sendMessage(CC.translate("&6&l* &eVanish: &aEnabled" ));
        }else if(!laz.getVanishManager().isVanished(player)){
            player.sendMessage(CC.translate("&6&l* &eVanish: &cDisabled" ));
        }
        if(laz.getStaffChatHandler().isStaffChatEnabled(player)){
            player.sendMessage(CC.translate("&6&l* &eStaff Chat: &aEnabled"));
        }else if(!laz.getStaffChatHandler().isStaffChatEnabled(player)){
            player.sendMessage(CC.translate("&6&l* &eStaff Chat: &cDisabled"));
        }

        if(delay >= 600){
            player.sendMessage(CC.translate("&6&l* &eChat Delay: &4Error" ));
        }else{
            player.sendMessage(CC.translate("&6&l* &eChat Delay: " + laz.getChatControlHandler().getDelay() + " seconds"));
        }
        player.sendMessage(" ");
        player.sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "--------------------------------");
    }
}
