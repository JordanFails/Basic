package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.SampleFeatures;
import me.jordanfails.samplefeatures.Utils.CC;
import me.jordanfails.samplefeatures.Utils.ConfigurationService;
import org.bukkit.entity.Player;

public class SampleFeatureCommand {
    @Command(
            name = "samplefeatures",
            permission = "hcf.command.features"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        if(args.length() == 0){
            player.sendMessage(CC.translate(" "));
            player.sendMessage(CC.translate("&a&lSample Features Plugin"));
            player.sendMessage(CC.translate("&a&l*&r Version: " + SampleFeatures.get().getDescription().getVersion()));
            player.sendMessage(CC.translate("&a&l*&r Author: " + SampleFeatures.get().getDescription().getAuthors()));
        }

        if(args.length() > 1 && args.getArgs(0).equals("reload")){
            ConfigurationService.reload();
            SampleFeatures.get().reloadConfig();
            player.sendMessage(CC.translate("&b[SampleFeatures]&r Plugin configuration has been reloaded"));
        }
    }
}
