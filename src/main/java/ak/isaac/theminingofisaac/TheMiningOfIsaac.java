package ak.isaac.theminingofisaac;

import ak.isaac.theminingofisaac.commands.DeleteBlocksCommand;
import ak.isaac.theminingofisaac.commands.SpawnEnemyCommand;
import ak.isaac.theminingofisaac.commands.SpawnProjectileCommand;
import ak.isaac.theminingofisaac.commands.SpawnRoomCommand;
import ak.isaac.theminingofisaac.enemies.Enemy;
import ak.isaac.theminingofisaac.enemies.EnemyManager;
import ak.isaac.theminingofisaac.enemies.projectiles.Projectile;
import ak.isaac.theminingofisaac.helper.*;
import ak.isaac.theminingofisaac.listener.EntitySpawnListener;
import ak.isaac.theminingofisaac.listener.PlayerJoinListener;
import ak.isaac.theminingofisaac.player.IsaacPlayer;
import ak.isaac.theminingofisaac.rooms.RoomBuilder;
import ak.isaac.theminingofisaac.rooms.RoomManager;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Map;

/* The Binding of Isaac in Minecraft!

    Version: 0.01
    @author: Anselm Koch, akoch3@stud.hs-heilbronn.de

 */

public final class TheMiningOfIsaac extends JavaPlugin {

    //Setting up Helpers to use later
    public static JavaPlugin instance;
    public static EnemyManager enemyManager;
    public static ItemStackHelper itemStackHelper;
    public static EnemySpawnHelper enemySpawnHelper;
    public static EntityHelper entityHelper;
    public static IsaacPlayer isaacPlayer;
    public static Projectile projectile;
    public static MathHelper mathHelper;
    public static ParticleHelper particleHelper;
    public static RoomManager roomManager;
    public static RoomBuilder roomBuilder;
    public static ConfigHelper configHelper;
    public static BlockHelper blockHelper;

    @Override
    public void onEnable() {
        instance = this;
        configHelper = new ConfigHelper();
        enemyManager = new EnemyManager();
        itemStackHelper = new ItemStackHelper();
        enemySpawnHelper = new EnemySpawnHelper();
        entityHelper = new EntityHelper();
        projectile = new Projectile();
        mathHelper = new MathHelper();
        particleHelper = new ParticleHelper();
        roomManager = new RoomManager();
        roomBuilder = new RoomBuilder();
        blockHelper = new BlockHelper();
        enemyManager.registerEnemies();
        roomManager.registerRooms();


        this.getCommand("spawnprojectile").setExecutor(new SpawnProjectileCommand());
        this.getCommand("spawnenemie").setExecutor(new SpawnEnemyCommand());
        this.getCommand("spawnroom").setExecutor(new SpawnRoomCommand());
        this.getCommand("deleteblocks").setExecutor(new DeleteBlocksCommand());
        this.getServer().getPluginManager().registerEvents(new EntitySpawnListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);



        configHelper.createCustomConfig();
        blockHelper.loadBlocksFromConfig();

        entityHelper.checkEntities();

    }

    @Override
    public void onDisable() {
        try {
            for (Map.Entry<Enemy, Entity> entry : enemyManager.getAliveEnemies().entrySet()) {
                entry.getValue().remove();
            }
            configHelper.getCustomConfig().save(configHelper.getBlockDataYML());

        } catch (IOException e) {
            e.printStackTrace();
        }
        instance = null;
    }


    public JavaPlugin getInstance() {
        return this;
    }
}
