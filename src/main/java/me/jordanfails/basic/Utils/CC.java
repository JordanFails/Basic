package me.jordanfails.basic.Utils;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class CC {
    public static final String Black;
    public static final String BlackB;
    public static final String BlackI;
    public static final String BlackU;
    public static final String DarkBlue;
    public static final String DarkBlueB;
    public static final String DarkBlueI;
    public static final String DarkBlueU;
    public static final String DarkGreen;
    public static final String DarkGreenB;
    public static final String DarkGreenI;
    public static final String DarkGreenU;
    public static final String DarkAqua;
    public static final String DarkAquaB;
    public static final String DarkAquaI;
    public static final String DarkAquaU;
    public static final String DarkRed;
    public static final String DarkRedB;
    public static final String DarkRedI;
    public static final String DarkRedU;
    public static final String DarkPurple;
    public static final String DarkPurpleB;
    public static final String DarkPurpleI;
    public static final String DarkPurpleU;
    public static final String Gold;
    public static final String GoldB;
    public static final String GoldI;
    public static final String GoldU;
    public static final String Gray;
    public static final String GrayB;
    public static final String GrayI;
    public static final String GrayU;
    public static final String DarkGray;
    public static final String DarkGrayB;
    public static final String DarkGrayI;
    public static final String DarkGrayU;
    public static final String Blue;
    public static final String BlueB;
    public static final String BlueI;
    public static final String BlueU;
    public static final String Green;
    public static final String GreenB;
    public static final String GreenI;
    public static final String GreenU;
    public static final String Aqua;
    public static final String AquaB;
    public static final String AquaI;
    public static final String AquaU;
    public static final String Red;
    public static final String RedB;
    public static final String RedI;
    public static final String RedU;
    public static final String LightPurple;
    public static final String LightPurpleB;
    public static final String LightPurpleI;
    public static final String LightPurpleU;
    public static final String Yellow;
    public static final String YellowB;
    public static final String YellowI;
    public static final String YellowU;
    public static final String White;
    public static final String WhiteB;
    public static final String WhiteI;
    public static final String WhiteU;
    public static final String Bold;
    public static final String Strike;
    public static final String Underline;
    public static final String Magic;
    public static final String Italic;
    public static final String Reset;
    public static final String Go;
    public static final String Wait;
    public static final String Stop;

    public static final String SERVER_NAME = "Sample Features";

    public CC() {
    }

    public static String prefix(char color) {
        return translate("&" + color + "&l(!) &" + color);
    }

    public static String translate(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String bungeeTranslate(String string){
        return net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String strip(String string) {
        return ChatColor.stripColor(string);
    }

    static {
        Black = ChatColor.BLACK.toString();
        BlackB = ChatColor.BLACK + ChatColor.BOLD.toString();
        BlackI = ChatColor.BLACK + ChatColor.ITALIC.toString();
        BlackU = ChatColor.BLACK + ChatColor.UNDERLINE.toString();
        DarkBlue = ChatColor.DARK_BLUE.toString();
        DarkBlueB = ChatColor.DARK_BLUE + ChatColor.BOLD.toString();
        DarkBlueI = ChatColor.DARK_BLUE + ChatColor.ITALIC.toString();
        DarkBlueU = ChatColor.DARK_BLUE + ChatColor.UNDERLINE.toString();
        DarkGreen = ChatColor.DARK_GREEN.toString();
        DarkGreenB = ChatColor.DARK_GREEN + ChatColor.BOLD.toString();
        DarkGreenI = ChatColor.DARK_GREEN + ChatColor.ITALIC.toString();
        DarkGreenU = ChatColor.DARK_GREEN + ChatColor.UNDERLINE.toString();
        DarkAqua = ChatColor.DARK_AQUA.toString();
        DarkAquaB = ChatColor.DARK_AQUA + ChatColor.BOLD.toString();
        DarkAquaI = ChatColor.DARK_AQUA + ChatColor.ITALIC.toString();
        DarkAquaU = ChatColor.DARK_AQUA + ChatColor.UNDERLINE.toString();
        DarkRed = ChatColor.DARK_RED.toString();
        DarkRedB = ChatColor.DARK_RED + ChatColor.BOLD.toString();
        DarkRedI = ChatColor.DARK_RED + ChatColor.ITALIC.toString();
        DarkRedU = ChatColor.DARK_RED + ChatColor.UNDERLINE.toString();
        DarkPurple = ChatColor.DARK_PURPLE.toString();
        DarkPurpleB = ChatColor.DARK_PURPLE + ChatColor.BOLD.toString();
        DarkPurpleI = ChatColor.DARK_PURPLE + ChatColor.ITALIC.toString();
        DarkPurpleU = ChatColor.DARK_PURPLE + ChatColor.UNDERLINE.toString();
        Gold = ChatColor.GOLD.toString();
        GoldB = ChatColor.GOLD + ChatColor.BOLD.toString();
        GoldI = ChatColor.GOLD + ChatColor.ITALIC.toString();
        GoldU = ChatColor.GOLD + ChatColor.UNDERLINE.toString();
        Gray = ChatColor.GRAY.toString();
        GrayB = ChatColor.GRAY + ChatColor.BOLD.toString();
        GrayI = ChatColor.GRAY + ChatColor.ITALIC.toString();
        GrayU = ChatColor.GRAY + ChatColor.UNDERLINE.toString();
        DarkGray = ChatColor.DARK_GRAY.toString();
        DarkGrayB = ChatColor.DARK_GRAY + ChatColor.BOLD.toString();
        DarkGrayI = ChatColor.DARK_GRAY + ChatColor.ITALIC.toString();
        DarkGrayU = ChatColor.DARK_GRAY + ChatColor.UNDERLINE.toString();
        Blue = ChatColor.BLUE.toString();
        BlueB = ChatColor.BLUE + ChatColor.BOLD.toString();
        BlueI = ChatColor.BLUE + ChatColor.ITALIC.toString();
        BlueU = ChatColor.BLUE + ChatColor.UNDERLINE.toString();
        Green = ChatColor.GREEN.toString();
        GreenB = ChatColor.GREEN + ChatColor.BOLD.toString();
        GreenI = ChatColor.GREEN + ChatColor.ITALIC.toString();
        GreenU = ChatColor.GREEN + ChatColor.UNDERLINE.toString();
        Aqua = ChatColor.AQUA.toString();
        AquaB = ChatColor.AQUA + ChatColor.BOLD.toString();
        AquaI = ChatColor.AQUA + ChatColor.ITALIC.toString();
        AquaU = ChatColor.AQUA + ChatColor.UNDERLINE.toString();
        Red = ChatColor.RED.toString();
        RedB = ChatColor.RED + ChatColor.BOLD.toString();
        RedI = ChatColor.RED + ChatColor.ITALIC.toString();
        RedU = ChatColor.RED + ChatColor.UNDERLINE.toString();
        LightPurple = ChatColor.LIGHT_PURPLE.toString();
        LightPurpleB = ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString();
        LightPurpleI = ChatColor.LIGHT_PURPLE + ChatColor.ITALIC.toString();
        LightPurpleU = ChatColor.LIGHT_PURPLE + ChatColor.UNDERLINE.toString();
        Yellow = ChatColor.YELLOW.toString();
        YellowB = ChatColor.YELLOW + ChatColor.BOLD.toString();
        YellowI = ChatColor.YELLOW + ChatColor.ITALIC.toString();
        YellowU = ChatColor.YELLOW + ChatColor.UNDERLINE.toString();
        White = ChatColor.WHITE.toString();
        WhiteB = ChatColor.WHITE + ChatColor.BOLD.toString();
        WhiteI = ChatColor.WHITE + ChatColor.ITALIC.toString();
        WhiteU = ChatColor.WHITE + ChatColor.UNDERLINE.toString();
        Bold = ChatColor.BOLD.toString();
        Strike = ChatColor.STRIKETHROUGH.toString();
        Underline = ChatColor.UNDERLINE.toString();
        Magic = ChatColor.MAGIC.toString();
        Italic = ChatColor.ITALIC.toString();
        Reset = ChatColor.RESET.toString();
        Go = GreenB + "(!) " + Green;
        Wait = YellowB + "(!) " + Yellow;
        Stop = RedB + "(!) " + Red;
    }

    public static List<String> list(List<String> s){
        return s.stream().map(CC::translate).collect(Collectors.toList());
    }


}

