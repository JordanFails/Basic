package me.jordanfails.samplefeatures.PartnerPackage.Listener;

import me.jordanfails.samplefeatures.PartnerPackage.PartnerPackage;
import me.jordanfails.samplefeatures.Utils.CC;
import me.qiooip.lazarus.Lazarus;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Package implements Listener {
    private PartnerPackage item = PartnerPackage.PARTNER;


    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (!e.getAction().name().contains("RIGHT")) return;


        if (!item.isSimilar(player.getItemInHand())) return;


        if(player.getItemInHand().getAmount() < 1) player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);

        else {
            player.setItemInHand(new ItemStack(Material.AIR,1));
        }

        player.playSound(player.getLocation(), Sound.CHEST_OPEN, 100f, 1F);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "abilities " + player.getName() + " AGGRESSIVEPEARL 3");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "abilities " + player.getName() + " ROCKET 5");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "abilities " + player.getName() + " ANTIREDSTONE 3");
    }

}
