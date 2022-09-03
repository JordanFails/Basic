package me.jordanfails.samplefeatures.Utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigurationService{

    private static File file;
    private static FileConfiguration customFile;

    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("SampleFeatures").getDataFolder(), "playerdata.yml");

        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                //idk bite me
            }

        }

        customFile = YamlConfiguration.loadConfiguration(file);


    }

    public static FileConfiguration getConfig() {
        return customFile;
    }

    public static void save() {
        try{
            customFile.save(file);
        }catch (IOException e){
            System.out.println("couldnt save the file.");
        }
    }

    public static void reload() {
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}
