package ak.isaac.theminingofisaac.rooms;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import ak.isaac.theminingofisaac.enemies.enemy.DummyEnemy;
import ak.isaac.theminingofisaac.enemies.enemy.TestEnemy;
import ak.isaac.theminingofisaac.rooms.room.TestRoom;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class RoomManager {


    private static ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Block> placedBlocks = new ArrayList<>();
    private List<Location> placedBlockLocations = new ArrayList<>();

    private FileConfiguration fileConfiguration = TheMiningOfIsaac.configHelper.getCustomConfig();
    private File file  = TheMiningOfIsaac.configHelper.getBlockDataYML();

    public void saveBlockLocations() throws IOException {
        for(Block block: placedBlocks) {
            placedBlockLocations.add(block.getLocation());
        }
        fileConfiguration.set("blocks", placedBlockLocations);
        fileConfiguration.save(file);
    }



    public List<Location> getPlacedBlockLocations() {
        return placedBlockLocations;
    }

    public ArrayList<Block> getPlacedBlocks() {
            return placedBlocks;
    }


    public Room getRoomFromName(String name) {
        for(Room room : rooms) {
            if(room.getRoomname().equalsIgnoreCase(name)) {
                return room;
            }
        }
        return null;
    }

    public void registerRooms() {
        rooms.add(new TestRoom());
    }
}
