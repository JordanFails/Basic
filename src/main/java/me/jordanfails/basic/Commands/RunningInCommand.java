package me.jordanfails.basic.Commands;

import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.CC;
import me.jordanfails.basic.Utils.Cooldown;
import me.qiooip.lazarus.factions.FactionsManager;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import me.qiooip.lazarus.utils.StringUtils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.jordanfails.basic.Basic.INFO;

public class RunningInCommand implements CommandExecutor {
    /**
     * Executes the given command, returning its success
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            String nameCaps = StringUtils.capitalize(player.getName());
            PlayerFaction getFaction = FactionsManager.getInstance().getPlayerFaction(player.getUniqueId());
            String factionName = getFaction.getName();
            String output = factionName.substring(0, 1).toUpperCase() + factionName.substring(1);

            if(getFaction.getName() == null) {
                player.sendMessage(CC.translate("&7You are not in a team!"));
                return true;
            }

            if(Cooldown.isOnCooldown("runningin_command", player)){
                player.sendMessage(CC.translate("&cYou are still on cooldown for &c&l" + Basic.getRemaining(Cooldown.getCooldownForPlayerLong("runningin_command", player), true)));
                player.closeInventory();
                return true;
            }

            if(getFaction.getHome() == null){
                player.sendMessage(CC.translate("&7You have no HQ set!"));
                return true;
            }

            TextComponent message = new TextComponent(CC.translate("&6&lLetting In &8» &e" + nameCaps + "&r is running in! &e" + getFaction.getOnlineMemberCount() + "&r on " + getFaction.getDtrColor() + getFaction.getDtr() + "&r DTR! &a[Hover]"));
            message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to Faction Focus").color(ChatColor.WHITE).append(" " + output).color(ChatColor.LIGHT_PURPLE).append("!").color(ChatColor.WHITE).create()));
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/f who " + player.getName()));

            for(Player onlinePlayers : Bukkit.getOnlinePlayers()){
                onlinePlayers.spigot().sendMessage(message);
            }
        }
        return true;
    }
}
