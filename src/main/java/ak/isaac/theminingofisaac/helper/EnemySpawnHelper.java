package ak.isaac.theminingofisaac.helper;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import ak.isaac.theminingofisaac.enemies.EnemyManager;
import ak.isaac.theminingofisaac.enemies.Enemy;
import ak.isaac.theminingofisaac.enemies.enemy.TestEnemy;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

//Ist zuständig dafür Gegner mit den richtigen Eigenschaften zu spawnen

public class EnemySpawnHelper {

    private final EnemyManager enemyManager = TheMiningOfIsaac.enemyManager;

    private FileConfiguration fileConfiguration = TheMiningOfIsaac.configHelper.getCustomConfig();
    private File file = TheMiningOfIsaac.configHelper.getBlockDataYML();

    public void spawnEnemy(Enemy enemy, Location location, Player player) throws IOException {
        enemyManager.setAllowMobSpawning(true);
        Entity entity = player.getWorld().spawnEntity(location, enemy.getEntityType());
        enemyManager.getAliveEnemies().put(enemy, entity);
        enemy.setEnemyID(entity.getEntityId());
        enemy.setLocation(entity.getLocation());
        enemy.setAttackCooldownWait(0);
        entity.setCustomName(enemy.getEnemyName());
        entity.setCustomNameVisible(true);
        LivingEntity livingEntity = (LivingEntity) entity;
        livingEntity.getEquipment().setHelmet(enemy.getHelmet());
        livingEntity.getEquipment().setItemInOffHand(enemy.getSecondHand());
        livingEntity.getEquipment().setItemInMainHand(enemy.getMainHand());
        enemy.setEntity(entity);
    }

    public void spawnEnemy(EntityType entityType, Location location, Player player, String enemyName) throws IOException {
        Enemy enemy = enemyManager.getEnemieByName(enemyName);
        enemyManager.setAllowMobSpawning(true);
        Entity entity = player.getWorld().spawnEntity(location, entityType);
        enemyManager.getAliveEnemies().put(enemy, entity);
        enemy.setEnemyID(entity.getEntityId());
        enemy.setLocation(entity.getLocation());
        enemy.setAttackCooldownWait(0);
        entity.setCustomName(enemy.getEnemyName());
        entity.setCustomNameVisible(true);
        LivingEntity livingEntity = (LivingEntity) entity;
        livingEntity.getEquipment().setHelmet(enemy.getHelmet());
        livingEntity.getEquipment().setItemInOffHand(enemy.getSecondHand());
        livingEntity.getEquipment().setItemInMainHand(enemy.getMainHand());
        enemy.setEntity(entity);
    }
}
