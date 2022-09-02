package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class HatCommand {

    @Command(
            name = "hat",
            permission = "hcf.command.hat",
            inGameOnly = true
    )
    public void execute(CommandArgs args) {
        Player player = args.getPlayer();
        ItemStack stack = player.getItemInHand();
        if (stack == null || stack.getType() == Material.AIR) {
            player.sendMessage(ChatColor.RED + "You are not holding anything.");
            return;
        }
        if (stack.getType().getMaxDurability() != 0) {
            player.sendMessage(ChatColor.RED + "The item you are holding is not suitable to wear for a hat.");
            return;
        }

        PlayerInventory inventory = player.getInventory();
        ItemStack helmet = inventory.getHelmet();

        if (helmet != null && helmet.getType() != Material.AIR) {
            player.sendMessage(ChatColor.RED + "You are already wearing something as your hat.");
            return;
        }

        int amount = stack.getAmount();
        if (amount > 1) {
            --amount;
            stack.setAmount(amount);
        } else {
            player.setItemInHand(new ItemStack(Material.AIR, 1));
        }
        helmet = stack.clone();
        helmet.setAmount(1);
        player.sendMessage(CC.translate("&a(!)&a Successfully added " + helmet.getType().name() + " as your hat!"));
        inventory.setHelmet(helmet);
    }
}
