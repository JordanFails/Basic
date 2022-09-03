package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Inventories.Inventories;
import me.jordanfails.samplefeatures.SampleFeatures;
import me.jordanfails.samplefeatures.Utils.CC;
import me.jordanfails.samplefeatures.Utils.ConfigurationService;
import org.bukkit.entity.Player;


public class RedeemCommand {

    private SampleFeatures plugin;

    @Command(
            name = "support",
            usage = "Usage: /support (clear)",
            inGameOnly = true
    )


    public void execute(CommandArgs args){
        Player player = args.getPlayer();


        if(args.length() == 0){
            if(!ConfigurationService.getConfig().contains(player.getName())){
                String uuid = String.valueOf(player.getUniqueId());
                ConfigurationService.getConfig().set("redeems." + uuid, Integer.parseInt("1"));
                Inventories.redeemGUI(player);
                return;
            }else if(ConfigurationService.getConfig().contains("nicknames." + player.getUniqueId().toString() + Integer.parseInt("1"))){
                player.sendMessage("You cannot redeem");
                return;
            }
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
