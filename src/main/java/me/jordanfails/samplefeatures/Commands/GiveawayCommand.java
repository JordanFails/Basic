package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.entity.Player;

public class GiveawayCommand {

    @Command(name = "giveaway", inGameOnly = true)

    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        if(args.length() == 0){
            player.sendMessage(" ");
            player.sendMessage(CC.translate("&a&lSample Giveaway"));
            player.sendMessage(CC.translate("&a&l*&r /giveaway join&a -&7 Join an active giveaway"));
            player.sendMessage(" ");
        }else if(args.length() == 1){
            if(args.getArgs(0).equals("join")){
                player.sendMessage(CC.translate("&c&l(!)&c There is currently no giveaways running!"));
            }
        }
    }

}
