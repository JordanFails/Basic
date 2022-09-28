package me.jordanfails.basic.Commands;

import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Utils.ConfigurationService;
import org.apache.commons.lang.time.FastDateFormat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

public class ServerTimeCommand implements TabCompleter {

    private static final FastDateFormat FORMAT = FastDateFormat.getInstance("E MMM dd h:mm:ssa z yyyy", TimeZone.getTimeZone("GMT-4"));


    @com.minnymin.command.Command(
            name = "servetime"
    )
    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();

        sender.sendMessage(ChatColor.GREEN + "The server time is " + ChatColor.LIGHT_PURPLE + FORMAT.format(System.currentTimeMillis()) + ChatColor.GREEN + '.');
    }

    /**
     * Requests a list of possible completions for a command argument.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param alias   The alias used
     * @param args    The arguments passed to the command, including final
     *                partial argument to be completed and command label
     * @return A List of possible completions for the final argument, or null
     * to default to the command executor
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.emptyList();
    }
}
