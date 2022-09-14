package me.jordanfails.basic.Vouchers;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VouchersCommand {
    private Basic plugin = Basic.get();
    @Command(
            name = "voucher",
            description = "a command to give yourself and others vouchers!"
    )

    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();

        if(sender.hasPermission("hcf.command.vouchers")){
            if(args.length() < 3){
                sender.sendMessage(CC.translate("&cUsage: /vouchers <player> <voucher> <amount>"));
                return;
            }

            if(Vouchers.getItemNames().contains(args.getArgs(0).toUpperCase())){
                sender.sendMessage(CC.translate("&cThis voucher doesn't currently exist!"));
                return;
            }

            Player target = Bukkit.getServer().getPlayer(args.getArgs(0));

            if(target == null){
                sender.sendMessage(CC.translate("&cPlayer is not online."));
                return;
            }

            Vouchers item = Vouchers.getItem(args.getArgs(1));

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
