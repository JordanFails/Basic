package me.jordanfails.basic.Commands;

import com.minnymin.command.CommandArgs;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullCommand implements Listener {

    @com.minnymin.command.Command(
            name = "skull",
            permission = "hcf.command.skull"
    )

    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();
        if(args.getCommand().equals("skull") && args.length() == 1){
            if(sender instanceof Player){
                final Player p = (Player) sender;
                p.getInventory().addItem(new ItemStack[] { this.playerSkullForName(args.getArgs(0)) });
                sender.sendMessage(ChatColor.GRAY + "Added " + ChatColor.GOLD + args.getArgs(0) + ChatColor.GRAY + "'s skull to your inventory");

            }
        }
        sender.sendMessage(ChatColor.RED + "You must run this command as a player.");
    }


    private ItemStack playerSkullForName(final String name) {
        final ItemStack is = new ItemStack(Material.SKULL_ITEM, 1);
        is.setDurability((short)3);
        final ItemMeta meta = is.getItemMeta();
        ((SkullMeta) meta).setOwner(name);
        is.setItemMeta(meta);
        return is;
    }
}
