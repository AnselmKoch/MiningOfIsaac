package ak.isaac.theminingofisaac.listener;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import ak.isaac.theminingofisaac.enemies.Enemy;
import ak.isaac.theminingofisaac.enemies.EnemyManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

//Lässt kein Entityspawn außer der von Gegnern zu

public class EntitySpawnListener implements Listener {

    private final EnemyManager enemyManager = TheMiningOfIsaac.enemyManager;

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntitySpawn(EntitySpawnEvent spawnEvent) {
        Entity entity = spawnEvent.getEntity();

        if((entity instanceof Player) && (entity instanceof Item)){
            spawnEvent.setCancelled(false);
        }else {
            if(enemyManager.getAllowMobSpawning() == true) {
                spawnEvent.setCancelled(false);
                enemyManager.setAllowMobSpawning(false);
            }else{
                spawnEvent.setCancelled(true);
            }
         }
        
    }
}
