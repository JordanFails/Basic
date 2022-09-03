package me.jordanfails.samplefeatures.Manager;

import me.jordanfails.samplefeatures.SampleFeatures;
import me.jordanfails.samplefeatures.Utils.CC;
import me.jordanfails.samplefeatures.Utils.Utils;
import com.lunarclient.bukkitapi.LunarClientAPI;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.staffmode.VanishManager;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveManager implements Listener {


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if(LunarClientAPI.getInstance().isRunningLunarClient(player.getUniqueId())){
            LunarClientAPI.getInstance().registerPlayer(player);
            player.sendMessage(CC.Green + "You have been auto-logged as a premium user");
            return;
        }else if(!LunarClientAPI.getInstance().isRunningLunarClient(player.getUniqueId())){
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(CC.AquaB + "LUNAR CLIENT");
            player.sendMessage(CC.translate("&7Hello &b" + player.getName() + "&7, we have noticed that you not using the &7&nofficial"));
            player.sendMessage(CC.translate("&7&nLunar Client&7 to play on SampleFeatures. Download and install it"));
            player.sendMessage(CC.translate("&7today, and connect to SampleFeatures with Lunar Client from now on to experience"));
            player.sendMessage(" ");
            player.sendMessage(CC.translate("&b&l*&7 Faction Focus on Nametags"));
            player.sendMessage(CC.translate("&b&l*&7 Forced Spawn and Faction Home Waypoints"));
            player.sendMessage(" ");
            player.sendMessage(CC.translate("&b&lREAD MORE: &r&nhttps://lunar.gg/client"));
            player.sendMessage(" ");
        }

        if(!SampleFeatures.staff.contains(player.getUniqueId())) {
            SampleFeatures.staff.add(player.getUniqueId());
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        Lazarus laz = Lazarus.getInstance();
        VanishManager vanishManager = Lazarus.getInstance().getVanishManager();

        if(player.hasPermission("hcf.staffonline") || player.isOp() && SampleFeatures.staff.contains(player.getUniqueId())){
            SampleFeatures.staff.remove(player.getUniqueId());
            if(laz.getStaffModeManager().isInStaffMode(player)){
                laz.getStaffModeManager().disable();
            }
            if(vanishManager.isVanished(player)){
                vanishManager.getAllVanished().remove(player.getUniqueId());
            }else{
                return;
            }
        }

    }
}
