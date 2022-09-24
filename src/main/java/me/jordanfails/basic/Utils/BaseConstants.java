package me.jordanfails.basic.Utils;

import org.bukkit.ChatColor;

public final class BaseConstants {
    public static final String PLAYER_WITH_NAME_OR_UUID_NOT_FOUND;

    static {
        PLAYER_WITH_NAME_OR_UUID_NOT_FOUND = ChatColor.RED + "Player not found.";
    }
}
