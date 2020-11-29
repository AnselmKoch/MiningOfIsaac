package ak.isaac.theminingofisaac.enemies;

import ak.isaac.theminingofisaac.enemies.enemy.DummyEnemy;
import ak.isaac.theminingofisaac.enemies.enemy.TestEnemy;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;



public class EnemyManager {

    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private HashMap<Enemy, Entity> aliveEnemies = new HashMap<>();

    private boolean allowMobSpawning = false;

    public void registerEnemies() {
        enemies.add(new TestEnemy());
        enemies.add(new DummyEnemy());
    }

    public void checkRange() {
        for(Entity entity : aliveEnemies.values()) {
            for (Entity entityWorld : entity.getWorld().getNearbyEntities(entity.getLocation(), 10, 10, 10)) {
                if (entityWorld instanceof Player) {
                    if (!entity.isDead()) {
                        getEnemyFromEntity(entity).attack(entity, entityWorld);
                    }
                }
            }
        }
    }

    public Enemy getEnemyFromEntity(Entity entity) {
        for(Enemy enemy : aliveEnemies.keySet()) {
            if(enemy.getEntity() == entity) {
                return enemy;
            }else{
                return null;
            }
        }
        return null;
     }

    public Enemy getAliveEnemyFromName(String name) {
        for(Enemy enemy : aliveEnemies.keySet()) {
            if(name == enemy.getEnemyName()) {
                return enemy;
            }
        }
        return null;
    }

    public Enemy getEnemyByID(int enemyID) {
        for(Enemy enemy : enemies){
           return enemyID == enemy.getEnemyID() ? enemy : null;
        }
        return null;
    }


    public Enemy getEnemieByName(String name) {
        for(Enemy enemy : enemies) {
            if(name.equalsIgnoreCase(enemy.getEnemyName())) {
                return enemy;
            }
        }
        return null;
    }



    public void setAllowMobSpawning(boolean mobSpawning) {
        allowMobSpawning = mobSpawning;
    }

    public boolean getAllowMobSpawning() {
        return allowMobSpawning;
    }

    public HashMap<Enemy, Entity> getAliveEnemies() {
        return aliveEnemies;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

}
