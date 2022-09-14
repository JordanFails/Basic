package me.jordanfails.basic.Vouchers.listeners;

import me.jordanfails.basic.Utils.CC;
import me.jordanfails.basic.Vouchers.Vouchers;
import me.qiooip.lazarus.abilities.AbilityType;
import me.qiooip.lazarus.timer.TimerManager;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedPermissionData;
import net.luckperms.api.model.user.User;
import net.luckperms.api.util.Tristate;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ClearTimerPerk implements Listener {
    private Vouchers item = Vouchers.TIMER;

    public static boolean hasPermission(User user, String permission) {
        return user.getCachedData().getPermissionData().checkPermission(permission).asBoolean();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        User user1 = LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId());

        LuckPerms luckPerms = LuckPermsProvider.get();


        assert user1 != null;
        CachedPermissionData permissionData = user1.getCachedData().getPermissionData();

        Tristate checkResults = permissionData.checkPermission("lazarus.craft");


        if (!e.getAction().name().contains("RIGHT")) return;


        if (!item.isSimilar(player.getItemInHand())) return;


        if (player.getItemInHand().getAmount() < 1)
            player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);

        else {
            player.setItemInHand(new ItemStack(Material.AIR, 1));
        }

        player.playSound(player.getLocation(), Sound.LEVEL_UP, 100f, 1F);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.ANTI_ABILITY_BALL);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.AGGRESSIVE_PEARL);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.COCAINE);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.ANTI_REDSTONE);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.ANTI_TRAP_STAR);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.COMBO);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.DECOY);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.EXOTIC_BONE);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.FAKE_PEARL);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.FAST_PEARL);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.GUARDIAN_ANGEL);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.INVISIBILITY);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.LOGGER_BAIT);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.LUCKY_INGOT);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.POCKET_BARD);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.POTION_COUNTER);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.PRE_PEARL);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.RAGE);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.RAGE_BRICK);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.ROCKET);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.SCRAMBLER);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.SECOND_CHANCE);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.STARVATION_FLESH);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.SWITCH_STICK);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.SWITCHER);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.TANK_INGOT);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.TIME_WARP);
        TimerManager.getInstance().getAbilitiesTimer().cancel(player, AbilityType.WEB_GUN);
        TimerManager.getInstance().getGlobalAbilitiesTimer().cancel(player.getUniqueId());
        player.sendMessage(CC.translate("&a&l(!)&a Successfully cleared all Abilities Timers!"));


    }

}

