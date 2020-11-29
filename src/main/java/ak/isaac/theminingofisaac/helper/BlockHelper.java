package ak.isaac.theminingofisaac.helper;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import org.bukkit.block.Block;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BlockHelper {

    private FileConfiguration fileConfiguration = TheMiningOfIsaac.configHelper.getCustomConfig();
    private File file = TheMiningOfIsaac.configHelper.getBlockDataYML();
    private List<Location> placeBlockLocations = TheMiningOfIsaac.roomManager.getPlacedBlockLocations();
    private ArrayList<Block> placedBlocks = TheMiningOfIsaac.roomManager.getPlacedBlocks();

    public void loadBlocksFromConfig(){
        try {
            if (!(fileConfiguration.getList("blocks").equals(null))) {

                placeBlockLocations = (List<Location>) fileConfiguration.getList("blocks");

                for (int i = 0; i < placeBlockLocations.size(); i++) {
                    placedBlocks.add(placeBlockLocations.get(i).getBlock());
                }
            }
        }catch (NullPointerException nullPointerException) {
            System.out.println("Keine Blöcke gefunden!");
        }
    }
}
