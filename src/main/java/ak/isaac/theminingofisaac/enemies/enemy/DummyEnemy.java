package ak.isaac.theminingofisaac.enemies.enemy;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import ak.isaac.theminingofisaac.enemies.Enemy;
import ak.isaac.theminingofisaac.helper.ItemStackHelper;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DummyEnemy extends Enemy {

    private ItemStackHelper itemStackHelper = TheMiningOfIsaac.itemStackHelper;

    public DummyEnemy() {
        super("Dummy",
                0,
                EntityType.IRON_GOLEM,
                TheMiningOfIsaac.itemStackHelper.air,
                TheMiningOfIsaac.itemStackHelper.air,
                TheMiningOfIsaac.itemStackHelper.air,
                TheMiningOfIsaac.itemStackHelper.air,
                TheMiningOfIsaac.itemStackHelper.air,
                TheMiningOfIsaac.itemStackHelper.air);
    }

    public void attack(Entity source, Entity target) {
        LivingEntity livingEntity = (LivingEntity)source;
        livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 20));
        livingEntity.setHealth(99);
    }
}
