package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class StoreCommand {

    @Command(
            name = "store",
            aliases = {"donate", "buy"},
            inGameOnly = true
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        player.sendMessage(CC.translate("&eYou can purchase ranks at: &dstore.samplefeatures.net&e."));
        player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100F, 1F);
    }
}
