package com.jordanfails.samplefeatures.Utils;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static String chat(String s){
        return ChatColor.translateAlternateColorCodes('&',s);
    }

    public static List<String> list(List<String> s){
        return s.stream().map(Utils::chat).collect(Collectors.toList());
    }

}