package ak.isaac.theminingofisaac.enemies.enemy;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import ak.isaac.theminingofisaac.enemies.Enemy;
import ak.isaac.theminingofisaac.enemies.EnemyManager;
import ak.isaac.theminingofisaac.helper.ItemStackHelper;
import ak.isaac.theminingofisaac.helper.MathHelper;
import ak.isaac.theminingofisaac.helper.ParticleHelper;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.*;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestEnemy extends Enemy{

private ItemStackHelper itemStackHelper = TheMiningOfIsaac.itemStackHelper;
private EnemyManager enemyManager = TheMiningOfIsaac.enemyManager;
private MathHelper mathHelper = TheMiningOfIsaac.mathHelper;
private ParticleHelper particleHelper = TheMiningOfIsaac.particleHelper;


//Konstruktor
public TestEnemy() {
        super("Test",
        5
        ,
        EntityType.ZOMBIE,
        TheMiningOfIsaac.itemStackHelper.goldenHelmet,
        TheMiningOfIsaac.itemStackHelper.air,
        TheMiningOfIsaac.itemStackHelper.air,
        TheMiningOfIsaac.itemStackHelper.air,
        TheMiningOfIsaac.itemStackHelper.diamondSword,
        TheMiningOfIsaac.itemStackHelper.air);
        }


    /*Checkt die Reichweite, wird ausgeführt wenn der Attackcooldown 0 ist.
      Wenn ein Spieler in Reichweite ist wird die Attacke durchgeführt
     */

//Gegner Angriff
public void attack(Entity source, Entity target) {


        //Spawnt 50  Zufällig farbene Partikel an zufälligen Koordinaten
        for(int i = 0; i<150;i++) {
                Location sourceLocation = source.getLocation();
                sourceLocation.add(mathHelper.getRandomLocationX(-1, 1), mathHelper.getRandomLocationY(0, 2), mathHelper.getRandomLocationZ(-1, 1));
                particleHelper.spawnRandomDust(source, sourceLocation, particleHelper.getRandomDustColor());
        }
        //Spawnt eine Explosion an der Location von dem Enemy und removed diesen gleichzeitig
        this.getEntity().getWorld().createExplosion(this.getLocation(), 2);
        this.setAttackCooldownWait(this.getAttackCooldown());
        this.getEntity().remove();
        enemyManager.getAliveEnemies().remove(this); }
}
