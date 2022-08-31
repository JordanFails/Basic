package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Inventories.Inventories;
import me.jordanfails.samplefeatures.SampleFeatures;
import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.io.File;

public class RedeemCommand {

    @Command(
            name = "support",
            usage = "Usage: /support (clear)"
    )



    public void execute(CommandArgs args){
        Player player = args.getPlayer();


        if(args.length() == 0){
            Inventories.redeemGUI(player);
        }

        if(args.length() == 1){
            if(args.getArgs(0).equals("clear")){
                if(!args.getSender().getName().equals("CONSOLE")){
                    args.getSender().sendMessage(CC.translate("&c&l(!)&c This command is for console only."));
                }else if(args.getSender().getName().equals("CONSOLE")){
                    SampleFeatures.redeem.clear();
                    args.getSender().sendMessage(CC.translate("&b[Redeem]&r You have cleared all redeems."));
                }
            }
        }

    }


}
