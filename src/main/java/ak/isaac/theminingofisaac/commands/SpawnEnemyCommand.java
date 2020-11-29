package ak.isaac.theminingofisaac.commands;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import ak.isaac.theminingofisaac.enemies.EnemyManager;
import ak.isaac.theminingofisaac.helper.EnemySpawnHelper;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.io.IOException;

//Spawnt bei Aufruf einen Gegner seiner Wahl, dieser muss als 1. Argument nach dem Command genannt werden.
public class SpawnEnemyCommand implements CommandExecutor {

    private final EnemyManager enemyManager = TheMiningOfIsaac.enemyManager;
    private final EnemySpawnHelper enemySpawnHelper = TheMiningOfIsaac.enemySpawnHelper;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player player = ((Player)sender);
            //Wenn Argumente 1 sind, also /spawnenemie x
                if(args.length == 1) {
                    String targetEnemyName = args[0];
                    EntityType targetEntityType = enemyManager.getEnemieByName(targetEnemyName).getEntityType();
                    Location location = player.getLocation();

                    try {
                        enemySpawnHelper.spawnEnemy(targetEntityType, location, player, targetEnemyName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }else{

        }
        return true;
    }
}
