package me.jordanfails.basic.Vouchers.listeners;

import me.activated.core.plugin.AquaCore;
import me.activated.core.plugin.AquaCoreAPI;
import me.activated.core.values.Permission;
import me.jordanfails.basic.Utils.CC;
import me.jordanfails.basic.Vouchers.Vouchers;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CraftingPerk implements Listener {
    private Vouchers item = Vouchers.CRAFTING;

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        Player player = e.getPlayer();


        if (!e.getAction().name().contains("RIGHT")) return;


        if (!item.isSimilar(player.getItemInHand())) return;

        if(AquaCoreAPI.INSTANCE.getGlobalPlayer(player.getUniqueId()).hasPermission("lazarus.craft")){
            return;
        }



        if(player.getItemInHand().getAmount() < 1) player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);

        else {
            player.setItemInHand(new ItemStack(Material.AIR,1));
        }

        AquaCoreAPI.INSTANCE.getGlobalPlayer(player.getUniqueId()).getPermissions().add("lazarus.craft");
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 100f, 1F);
        player.sendMessage(CC.translate("&a&l[PERKS]&a You have successfully claimed the &a&n/craft&a perk!"));
    }


}
