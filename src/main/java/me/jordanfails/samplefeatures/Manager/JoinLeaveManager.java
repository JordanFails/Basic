package me.jordanfails.samplefeatures.Manager;

import me.jordanfails.samplefeatures.SampleFeatures;
import me.jordanfails.samplefeatures.Utils.CC;
import me.jordanfails.samplefeatures.Utils.Utils;
import com.lunarclient.bukkitapi.LunarClientAPI;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.staffmode.VanishManager;
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
            player.sendMessage(Utils.chat("&b&l(!)&r You have not been verified using &b&nLunar Client!"));
            player.sendMessage(Utils.chat("&rUsing &b&nLunar Client&r can boost your overall experience bringing"));
            player.sendMessage(Utils.chat("&rWaypoints, F focus, and &b&nmany&r more!"));
        }

        if(!SampleFeatures.staff.contains(player.getUniqueId()) && player.getName().equals("SimplyHate")){
            if(Lazarus.getInstance().getVanishManager().isVanished(player) && SampleFeatures.staff.contains(player.getUniqueId())){
                SampleFeatures.staff.remove(player.getUniqueId());
            }else if(!Lazarus.getInstance().getVanishManager().isVanished(player)){
                SampleFeatures.staff.add(player.getUniqueId());
            }
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
            if(laz.getVanishManager().isVanished(player)){

            }
        }

    }
}
