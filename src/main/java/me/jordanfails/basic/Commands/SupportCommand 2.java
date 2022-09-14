package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Inventories.Inventories;
import me.jordanfails.basic.Utils.CC;
import org.bukkit.entity.Player;


public class SupportCommand {

    private Basic plugin;

    @Command(
            name = "support",
            usage = "Usage: /support (clear)",
            inGameOnly = true
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
                    args.getSender().sendMessage(CC.translate("&b[Redeem]&r You have cleared all redeems."));
                }
            }
        }

    }


}
