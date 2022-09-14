package me.jordanfails.basic.PartnerPackage;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PartnerPackageCommand {
    @Command(
            name = "package",
            description = "a command to give yourself and others a partner package!!"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        if(player.hasPermission("hcf.command.partnerpackage")){
            if(args.length() < 3){
                player.sendMessage(CC.translate("&cUsage: /package <player> <package> <amount>"));
                return;
            }

            if(PartnerPackage.getItemNames().contains(args.getArgs(0).toUpperCase())){
                player.sendMessage(CC.translate("&cThis package doesn't currently exist!"));
                return;
            }

            Player target = Bukkit.getServer().getPlayer(args.getArgs(0));

            if(target == null){
                player.sendMessage(CC.translate("&cPlayer is not online."));
                return;
            }

            PartnerPackage item = PartnerPackage.getItem(args.getArgs(1));

            try{
                int amount  = Integer.parseInt(args.getArgs(2));
                if(item != null){
                    ItemStack stack = item.getStack();
                    stack.setAmount(amount);
                    ItemMeta meta = stack.getItemMeta();
                    meta.setDisplayName(item.getDisplay());
                    meta.addEnchant(item.getEnchantment(), item.getLevel(), true);
                    meta.setLore(CC.list(item.getLore()));
                    stack.setItemMeta(meta);
                    target.getInventory().addItem(stack);
                    return;
                }
            }catch (NumberFormatException e){

            }

        }



    }
}
