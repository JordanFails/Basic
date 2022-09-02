package me.jordanfails.samplefeatures.Manager;

import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ChatManager implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChatControl(PlayerCommandPreprocessEvent event){
        String chat = event.getMessage();
        Player player = event.getPlayer();

        if (chat.startsWith("/confirm") && !player.getName().equals("SimplyHate")){
            event.setCancelled(true);
            player.sendMessage(CC.translate("&c&l(!)&c The command &c&n/confirm&c is currently disabled!"));
        }

        if(chat.contains("/pl") && !player.hasPermission("hcf.bypass")){
            event.setCancelled(true);
            player.sendMessage(CC.translate("&c&l(!)&c The command &c&n/pl&c is currently disabled!"));
        }

        if(chat.contains("/reload") && !player.hasPermission("hcf.reboot")){
            event.setCancelled(true);
            player.sendMessage(CC.translate("&c&l(!)&c The command &c&n/reload&c is currently disabled!"));
        }

        if(chat.contains("/bukkit:")){
            event.setCancelled(true);
            player.sendMessage(CC.translate("&c&l(!)&c Please refrain from using colons in commands like &c&n" + chat));
        }

        if(chat.contains("/icanhasbukkit")){
            event.setCancelled(true);
            player.sendMessage(CC.translate("&a&l(!)&a This server runs on a custom spigot!"));
        }

        if(chat.contains("/stream")){
        }
    }
}
