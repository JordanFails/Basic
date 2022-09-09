package me.jordanfails.samplefeatures.Vouchers.listeners;

import me.activated.core.plugin.AquaCoreAPI;
import me.jordanfails.samplefeatures.SampleFeatures;
import me.jordanfails.samplefeatures.Utils.CC;
import me.jordanfails.samplefeatures.Utils.Cooldown;
import me.jordanfails.samplefeatures.Vouchers.Vouchers;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedPermissionData;
import net.luckperms.api.model.PermissionHolder;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.util.Tristate;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class FeedPerk implements Listener {
    private Vouchers item = Vouchers.FEED;

    public static boolean hasPermission(User user, String permission){
        return user.getCachedData().getPermissionData().checkPermission(permission).asBoolean();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        User user1 = LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId());

        LuckPerms luckPerms = LuckPermsProvider.get();


        assert user1 != null;
        CachedPermissionData permissionData = user1.getCachedData().getPermissionData();

        Tristate checkResults = permissionData.checkPermission("lazarus.feed");


        if (!e.getAction().name().contains("RIGHT")) return;


        if (!item.isSimilar(player.getItemInHand())) return;

        if(hasPermission(user1, "lazarus.feed")){
            return;
        }



        if(player.getItemInHand().getAmount() < 1) player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);

        else {
            player.setItemInHand(new ItemStack(Material.AIR,1));
        }

        luckPerms.getUserManager().modifyUser(player.getUniqueId(), user -> {
            user1.data().add(Node.builder("lazarus.feed").build());
        });
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 100f, 1F);
        player.sendMessage(CC.translate("&a&l[PERKS]&a You have successfully claimed the &a&n/feed&a perk!"));
    }


}
