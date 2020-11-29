package ak.isaac.theminingofisaac.helper;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class ParticleHelper {

    private MathHelper mathHelper = TheMiningOfIsaac.mathHelper;

    public Particle.DustOptions getRandomDustColor() {
        return new Particle.DustOptions(Color.fromRGB(
                mathHelper.getRandomColorRed(),
                mathHelper.getRandomColorGreen(),
                mathHelper.getRandomColorBlue()), 1);
    }

    public void spawnRandomDust(Entity entity, Location location, Particle.DustOptions dustOptions) {
         entity.getWorld().spawnParticle(Particle.REDSTONE, location.add(mathHelper.getRandomLocationX(-1, 1), mathHelper.getRandomLocationY(0, 2), mathHelper.getRandomLocationZ(-1, 1)), 50, dustOptions);

    }
}
