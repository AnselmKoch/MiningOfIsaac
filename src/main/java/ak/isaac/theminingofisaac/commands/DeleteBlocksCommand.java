package ak.isaac.theminingofisaac.commands;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import ak.isaac.theminingofisaac.rooms.RoomManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class DeleteBlocksCommand implements CommandExecutor {

    private RoomManager roomManager = TheMiningOfIsaac.roomManager;
    private FileConfiguration fileConfiguration = TheMiningOfIsaac.configHelper.getCustomConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
        if(args.length == 0) {
            for(Block block : roomManager.getPlacedBlocks()) {
                block.setType(Material.AIR);
            }
            fileConfiguration.set("blocks", null);
        }

        return true;
    }
}
