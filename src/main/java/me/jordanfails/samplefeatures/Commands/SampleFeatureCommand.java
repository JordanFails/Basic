package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
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
            ConfigurationService.reload();
            player.sendMessage(CC.translate("&b[SampleFeatures]&r Plugin has been reloaded"));
        }
    }
}
