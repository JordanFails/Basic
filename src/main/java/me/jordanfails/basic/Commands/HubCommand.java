package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Basic;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import static me.jordanfails.basic.Basic.PREFIX;

public class HubCommand {
    private final Basic plugin;

    public HubCommand(final Basic plugin) {
        this.plugin = plugin;
    }

    @Command(
            name = ""
    )


    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        CommandSender sender = args.getSender();
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command is only executable by players.");
            return;
        }
        Player p = (Player) sender;
        p.sendMessage(PREFIX + ChatColor.GRAY + "We are sending you to The Hub.");
        teleport(p, "hub");
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Basic.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (p.isOnline()) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&cWe couldn't connect you to any of the Hubs, please try again later."));
                }
            }
        }, 20 * 5);
        return;
    }

    public static void teleport(Player pl, String input) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(input);
        } catch (IOException localIOException) {
        }
        pl.sendPluginMessage(Basic.getInstance(), "BungeeCord", b.toByteArray());
    }
}
