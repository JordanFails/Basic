package me.jordanfails.basic.Utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigurationService{

    private static File playerData;
    private static FileConfiguration playerConfig;

    private static File freeRank;

    private static FileConfiguration freeRankConfig;

    public static void setup(){
        playerData = new File(Bukkit.getServer().getPluginManager().getPlugin("Basic").getDataFolder(), "playerdata.yml");
        freeRank = new File(Bukkit.getServer().getPluginManager().getPlugin("Basic").getDataFolder(), "freerank.yml");

        if(!freeRank.exists()) {
            try{
                freeRank.createNewFile();

            }catch (IOException e){
                //IDK bite me
            }
        }

        if(!playerData.exists()){
            try{
                playerData.createNewFile();
            }catch (IOException e){
                //IDK bite me
            }

        }

        playerConfig = YamlConfiguration.loadConfiguration(playerData);
        freeRankConfig = YamlConfiguration.loadConfiguration(freeRank);


    }

    public static FileConfiguration getPlayerConfig() {
        return playerConfig;
    }

    public static FileConfiguration getFreeRankConfig(){
        return freeRankConfig;
    }

    public static void save() {
        try{
            playerConfig.save(playerData);
        }catch (IOException e){
            System.out.println("couldnt save the file.");
        }

        try{
            freeRankConfig.save(freeRank);
        }catch (IOException e){
            System.out.println("couldnt save the file.");
        }
    }

    public static void reload() {
        playerConfig = YamlConfiguration.loadConfiguration(playerData);
        freeRankConfig = YamlConfiguration.loadConfiguration(freeRank);
    }

}
