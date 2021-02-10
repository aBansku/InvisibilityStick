package cf.mcskygames.invstick;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        CustomEnchant.register();
        new Listeners(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("invstick")) {
            if(!(sender instanceof Player))
                return true;
            Player player = (Player) sender;
            ItemStack item = new ItemStack(Material.STICK);
            item.addUnsafeEnchantment(CustomEnchant.INVISIBILITY, 1);
            player.getInventory().addItem(item);

            return true;
        }
        return true;
    }
}
