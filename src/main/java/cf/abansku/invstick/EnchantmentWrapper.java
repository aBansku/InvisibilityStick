package cf.abansku.invstick;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class EnchantmentWrapper extends Enchantment {
    private final String name;
    private final int lvl;

    public EnchantmentWrapper(String namespace, String name, int lvl) {
        super(NamespacedKey.minecraft(namespace));
        this.name = name;
        this.lvl = lvl;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxLevel() {
        return lvl;
    }

    @Override
    public int getStartLevel() {
        return 0;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return false;
    }
}
