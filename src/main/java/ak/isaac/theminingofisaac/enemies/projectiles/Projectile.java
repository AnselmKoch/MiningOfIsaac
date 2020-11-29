package ak.isaac.theminingofisaac.enemies.projectiles;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import ak.isaac.theminingofisaac.helper.MathHelper;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;

public class Projectile {

    public void shootProjectile(Particle particle, Entity entity, Entity target) {
        entity.getWorld().spawnParticle(particle, entity.getLocation(), 19);
    }
}
