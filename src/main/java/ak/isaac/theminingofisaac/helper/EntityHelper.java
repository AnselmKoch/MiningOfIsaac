package ak.isaac.theminingofisaac.helper;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import ak.isaac.theminingofisaac.enemies.Enemy;
import ak.isaac.theminingofisaac.enemies.EnemyManager;
import ak.isaac.theminingofisaac.player.IsaacPlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;

//Führt jeden Tick die Void "checkEntities" aus um Informationen von Gegner abzufragen

public class EntityHelper {


    EnemyManager enemyManager = TheMiningOfIsaac.enemyManager;
    IsaacPlayer isaacPlayer = TheMiningOfIsaac.isaacPlayer;
    private FileConfiguration fileConfiguration = TheMiningOfIsaac.configHelper.getCustomConfig();

    public void checkEntities() {
        new BukkitRunnable() {
            @Override
            public void run() {
                //Für jeden Gegner und Entity in der Hashmap
                for (Map.Entry<Enemy, Entity> entry : enemyManager.getAliveEnemies().entrySet()) {
                    //Wenn Angriff von Gegner bereit ist
                    if (entry.getKey().getAttackCooldownWait() == 0) {
                        //Reichweite wird überprüft und im Falle von einem Gegner in Reichweite wird angegriffen
                        enemyManager.checkRange();
                    } else {
                        //Cooldown vom Angriff wird verringert
                        int i = entry.getKey().getAttackCooldownWait();
                        entry.getKey().setAttackCooldownWait(i - 1);
                    }
                    //Die Location von jedem Gegner wird aktualisiert
                    entry.getKey().setLocation(entry.getValue().getLocation());
                }
                if (isaacPlayer != null) {
                    isaacPlayer.getPlayer().getLocation();
                }

            }
        }.runTaskTimer(TheMiningOfIsaac.instance, 1L, 1L);
    }

    public void loadEntities() {
        for(Entity entity : isaacPlayer.getPlayer().getWorld().getEntities()) {
            if(!(entity instanceof Player)) {
                Enemy enemy = enemyManager.getEnemieByName(fileConfiguration.getString("enemies." + entity.getUniqueId()));
                enemyManager.getAliveEnemies().put(enemy, entity);
            }
        }
    }
}

