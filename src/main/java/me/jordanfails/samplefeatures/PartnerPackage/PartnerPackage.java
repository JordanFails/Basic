package me.jordanfails.samplefeatures.PartnerPackage;

import me.jordanfails.samplefeatures.SampleFeatures;
import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PartnerPackage {
    PARTNER("PARTNER", CC.translate("&d&lPartner Shard"), SampleFeatures.get().getConfig().getStringList("package.lore"), new ItemStack(Material.PRISMARINE_SHARD, 1), Enchantment.DURABILITY, 10);
    private String name, display;
    private List<String> lore;

    private ItemStack stack;

    private Enchantment enchantment;

    private Integer level;

    PartnerPackage(String name, String display, List<String> lore, ItemStack stack, Enchantment enchantment, Integer level) {
        this.name = name;
        this.display = display;
        this.lore = lore;
        this.stack = stack;
        this.enchantment = enchantment;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getDisplay() {
        return CC.translate((display));
    }

    public static List<String> getItemNames() {
        List<String> names = new ArrayList<>();
        Arrays.asList(values()).forEach(item -> names.add(item.getName()));
        return names;
    }

    public static PartnerPackage getItem(String name){
        return Arrays.stream(values()).filter(item -> item.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Enchantment getEnchantment(){
        return enchantment;
    }

    public void setEnchantment(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    public List<String> getLore() {
        return lore;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public Integer getLevel(){
        return level;
    }

    public boolean isSimilar(ItemStack toCompare) {
        return toCompare != null &&
                toCompare.getType().equals(stack.getType()) &&
                toCompare.hasItemMeta() &&
                toCompare.getItemMeta().hasDisplayName() &&
                toCompare.getItemMeta().getDisplayName().equals(CC.translate(getDisplay()));
    }

    public ItemStack getStack() {
        return stack;
    }


}
