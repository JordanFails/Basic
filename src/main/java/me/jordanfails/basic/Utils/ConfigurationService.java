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

    private static File pronouns;

    private static FileConfiguration pronounsConfig;


    public static void setup(){
        playerData = new File(Bukkit.getServer().getPluginManager().getPlugin("Basic").getDataFolder(), "playerdata.yml");
        freeRank = new File(Bukkit.getServer().getPluginManager().getPlugin("Basic").getDataFolder(), "freerank.yml");
        pronouns = new File(Bukkit.getServer().getPluginManager().getPlugin("Basic").getDataFolder(), "pronouns.yml");

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

        if(!pronouns.exists()){
            try {
                pronouns.createNewFile();
            }catch (IOException e){
                //IDK bite me
            }
        }

        playerConfig = YamlConfiguration.loadConfiguration(playerData);
        freeRankConfig = YamlConfiguration.loadConfiguration(freeRank);
        pronounsConfig = YamlConfiguration.loadConfiguration(pronouns);


    }

    public static FileConfiguration getPlayerConfig() {
        return playerConfig;
    }

    public static FileConfiguration getFreeRankConfig(){
        return freeRankConfig;
    }

    public static FileConfiguration getPronounsConfig() {
        return pronounsConfig;
    }

    public static void save() {
        try{
            playerConfig.save(playerData);
        }catch (IOException e){
            System.out.println("Couldn't save PlayerData File!");
        }

        try{
            freeRankConfig.save(freeRank);
        }catch (IOException e){
            System.out.println("Couldn't save FreeRank File!");
        }

        try{
            pronounsConfig.save(pronouns);
        }catch (IOException e){
            System.out.println("Couldn't save Pronouns File!");
        }
    }

    public static void reload() {
        playerConfig = YamlConfiguration.loadConfiguration(playerData);
        freeRankConfig = YamlConfiguration.loadConfiguration(freeRank);
        pronounsConfig = YamlConfiguration.loadConfiguration(pronouns);
    }

}
