package cf.abansku.invstick;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Listeners implements Listener {
    public Listeners(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void playerAttackEvent(EntityDamageByEntityEvent event) {
        if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player damager = (Player) event.getDamager();
            Player player = (Player) event.getEntity();
            if(damager.getInventory().getItemInMainHand().containsEnchantment(CustomEnchant.INVISIBILITY)) {
                PotionEffect effect = new PotionEffect(PotionEffectType.INVISIBILITY, 600, 2);
                player.addPotionEffect(effect);
            }
        }
        if(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            LivingEntity entity = (LivingEntity) event.getEntity();
            if(player.getInventory().getItemInMainHand().containsEnchantment(CustomEnchant.INVISIBILITY)) {
                PotionEffect effect = new PotionEffect(PotionEffectType.INVISIBILITY, 600, 2);
                entity.addPotionEffect(effect);
            }
        }
    }
}
