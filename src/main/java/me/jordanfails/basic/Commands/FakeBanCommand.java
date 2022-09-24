package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import mkremins.fanciful.FancyMessage;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.*;

public class FakeBanCommand {
    @Command(name  = "punish")

    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        /* Your Code */
        ComponentBuilder message = new ComponentBuilder("this might ban someone");
        /* This is fix */
        // Result of #create is what you send to the player.
        BaseComponent[] msg = message.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ban " + player.getName())).create();

        player.spigot().sendMessage(msg);

    }
}
