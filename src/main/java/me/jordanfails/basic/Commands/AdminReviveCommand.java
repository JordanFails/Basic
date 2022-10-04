package me.jordanfails.basic.Commands;

import LorexMC.us.utils.BukkitUtils;
import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.activated.core.api.player.Note;
import me.activated.core.commands.api.AquaCommand;
import me.activated.core.commands.impl.punishments.StaffHistoryCommand;
import me.activated.core.plugin.AquaCore;
import me.activated.core.proxy.bungee.AquaBungee;
import me.jordanfails.basic.Utils.DateTimeFormats;
import me.qiooip.lazarus.Lazarus;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.jordanfails.basic.Basic.*;


public class AdminReviveCommand implements CommandExecutor {

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

        String permission = "hcf.command.revive.admin";

        Player player = Bukkit.getPlayer(args[0]);



        if(args.length < 2){
            sender.sendMessage(TOOLITTLEARGS);
        }

        if(args.length > 1){
            sender.sendMessage(TOOMANYARGS);
            return true;
        }

        if(player == null){
            sender.sendMessage(NOPLAYER);
            return true;
        }


        if(!Lazarus.getInstance().getDeathbanManager().isDeathBanned(player.getUniqueId())){
            sender.sendMessage(ERROR + "This player isn't deathbanned!");
            return true;
        }

        if(!sender.hasPermission(permission)){
            sender.sendMessage(NOPERMS);
            return true;
        }

        Lazarus.getInstance().getDeathbanManager().revivePlayer(player.getUniqueId());
        sender.sendMessage(SUCCESS + "You have successfully revived " + args[0]);
        AquaCore.INSTANCE.getPlayerManagement().getPlayerData(player.getUniqueId()).getNotes().add(new Note("Successfully revived by " + sender.getName(), sender.getName(), System.currentTimeMillis()));


        return true;
    }
}