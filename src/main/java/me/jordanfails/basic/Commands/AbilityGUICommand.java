package me.jordanfails.basic.Commands;

import me.jordanfails.basic.Inventories.Inventories;
import me.jordanfails.basic.Utils.CC;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.jordanfails.basic.Basic.PLAYERONLY;

public class AbilityGUICommand implements CommandExecutor{

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
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            Inventories.abilityGUI(player);
        }else {
            sender.sendMessage(CC.translate(PLAYERONLY));
        }
        return false;
    }
}
