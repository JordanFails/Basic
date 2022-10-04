package me.jordanfails.basic.Strikes.args;

import LorexMC.us.utils.other.command.CommandArgument;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.CC;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class StrikeCheckArgument extends CommandArgument {

    private final Basic plugin;

    public StrikeCheckArgument(Basic plugin) {
        super("check", "Check your current strikes");
        this.plugin = plugin;
    }

    @Override
    public String getUsage(String label) {
        return '/' + label + ' ' + getName() + "";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        TextComponent message = new TextComponent(CC.translate("&6&lStrikes &8»&e To get more information, create a ticket in &ediscord! &a[Hover]"));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/aquacore:helpop I want more information about my strike(s)"));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to show more information about your strike(s)!").color(ChatColor.WHITE).create()));
        if(sender instanceof Player){
            Player player = (Player) sender;
            player.sendMessage(CC.translate("&6&lStrikes &8»&e Currently, you have &f1&e strike(s)!"));
            player.spigot().sendMessage(message);
        }
        return true;

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return args.length == 0 ? null : Collections.emptyList();
    }
}
