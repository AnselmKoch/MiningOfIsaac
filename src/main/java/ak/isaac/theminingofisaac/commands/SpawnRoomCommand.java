package ak.isaac.theminingofisaac.commands;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import ak.isaac.theminingofisaac.rooms.Room;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import java.io.IOException;

public class SpawnRoomCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
        if(args.length == 2) {
            if(sender instanceof Player) {
                int height = Integer.valueOf(args[0]);
                int width = Integer.valueOf(args[1]);
                Player player = (Player)sender;
                Material[] materials = {Material.STONE, Material.STONE_BRICKS, Material.COBBLESTONE, Material.SMOOTH_STONE};
            }

        }else if(args.length == 1) {
            if(TheMiningOfIsaac.roomManager.getRoomFromName(args[0]) != null) {
                Room room = TheMiningOfIsaac.roomManager.getRoomFromName(args[0]);
                try {
                    TheMiningOfIsaac.roomBuilder.buildRoom((Player)sender, room);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InvalidConfigurationException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
