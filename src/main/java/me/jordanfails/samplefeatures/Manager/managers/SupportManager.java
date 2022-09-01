package me.jordanfails.samplefeatures.Manager.managers;

import me.jordanfails.samplefeatures.Manager.IManager;
import me.jordanfails.samplefeatures.SampleFeatures;
import org.bukkit.entity.Player;
import us.doctordark.util.Config;

import java.util.UUID;

public class SupportManager implements IManager {
    private static final Config reclaims = new Config(SampleFeatures.get(),"reclaims", SampleFeatures.get().getDataFolder().getAbsolutePath());

    public boolean hasReclaimed(Player p){
        return reclaims.get("reclaimed." + p.getUniqueId().toString()) != null;
    }

    public void setReclaimed(Player p){
        reclaims.set("reclaimed." + p.getUniqueId().toString(), UUID.randomUUID().toString());
        reclaims.save();
    }
}
