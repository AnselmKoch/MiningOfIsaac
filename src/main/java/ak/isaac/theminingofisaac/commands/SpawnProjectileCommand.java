package ak.isaac.theminingofisaac.commands;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import ak.isaac.theminingofisaac.enemies.projectiles.Projectile;
import ak.isaac.theminingofisaac.helper.MathHelper;
import ak.isaac.theminingofisaac.helper.ParticleHelper;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Random;

//Spawnt ein Projectile nach Wahl (in dem Fall abhängig von Partikeln)

public class SpawnProjectileCommand implements CommandExecutor {

    private MathHelper mathHelper = TheMiningOfIsaac.mathHelper;
    private ParticleHelper particleHelper = TheMiningOfIsaac.particleHelper;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {

        if(sender instanceof Player) {

            Player player = (Player)sender;
            if(args.length == 0) {
                for(int i = 0; i < 150; i++) {
                    Location location = player.getLocation();
                    particleHelper.spawnRandomDust(player, location, particleHelper.getRandomDustColor());
                }
            }
        }
        return true;
    }
}
