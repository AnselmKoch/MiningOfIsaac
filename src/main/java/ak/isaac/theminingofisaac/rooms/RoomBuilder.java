package ak.isaac.theminingofisaac.rooms;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import ak.isaac.theminingofisaac.helper.ConfigHelper;
import ak.isaac.theminingofisaac.helper.MathHelper;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;

public class RoomBuilder {

    private RoomManager roomManager = TheMiningOfIsaac.roomManager;
    private ConfigHelper configHelper = TheMiningOfIsaac.configHelper;

    public void buildRoom(Player player, Room room) throws IOException, InvalidConfigurationException {
       int width = room.getWidth();
       int height = room.getHeight();
       int length = room.getLength();
       Material[] materials = room.getMaterials();

        buildFloor(player, room, width, height, length, materials);
        buildRoof(player, width, height,length, materials);
        buildWallSubtractX(player, width, height,length, materials);
        buildWallAddZ(player, width, height,length, materials);
        buildWallAddX(player, width, height,length, materials);
        buildWallSubtractZ(player, width, height,length, materials);

    }

    //Baut den Boden
    public void buildFloor(Player player,Room room, int width, int height, int length, Material[] materials) throws IOException, InvalidConfigurationException {
        //Wenn höhe größer als Breite ist:
        for (int i = 0; i < length; i++) {

            //Zufälliger Block auswählen für die X-Achse
            int randomMaterialWidth = TheMiningOfIsaac.mathHelper.getRandomInt(0, materials.length);
            Material randomMaterial1 = materials[randomMaterialWidth];

            Location location = player.getLocation().add(0,-1,0);
            location.add(i,0,0);
            location.getBlock().setType(randomMaterial1);

            roomManager.getPlacedBlocks().add(location.getBlock());


            for(int i2=0; i2 < width; i2++) {

                //Zufälliger Block auswählen für die Y-Achse
                int randomMaterialHeight = TheMiningOfIsaac.mathHelper.getRandomInt(0, materials.length);
                Material randomMaterial2 = materials[randomMaterialHeight];

                if(i2 != 0) {
                    location.add(0, 0, 1);
                    location.getBlock().setType(randomMaterial2);
                    roomManager.getPlacedBlocks().add(location.getBlock());
                }

            }
        }
        roomManager.saveBlockLocations();
    }

    //Baut das Dach
    public void buildRoof(Player player, int width, int height,int length, Material[] materials) throws IOException, InvalidConfigurationException {
        //Wenn höhe größer als Breite ist:
        for (int i = 0; i < length; i++) {

            //Zufälliger Block auswählen für die X-Achse
            int randomMaterialWidth = TheMiningOfIsaac.mathHelper.getRandomInt(0, materials.length);
            Material randomMaterial1 = materials[randomMaterialWidth];

            Location location = player.getLocation().add(0,height,0);
            location.add(i,0,0);
            location.getBlock().setType(randomMaterial1);

            roomManager.getPlacedBlocks().add(location.getBlock());

            for(int i2=0; i2 < width; i2++) {

                //Zufälliger Block auswählen für die Y-Achse
                int randomMaterialHeight = TheMiningOfIsaac.mathHelper.getRandomInt(0, materials.length);
                Material randomMaterial2 = materials[randomMaterialHeight];

                if(i2 != 0) {
                    location.add(0, 0, 1);
                    location.getBlock().setType(randomMaterial2);
                    roomManager.getPlacedBlocks().add(location.getBlock());
                }
            }
        }
        roomManager.saveBlockLocations();
    }

    //Wand X-
    public void buildWallSubtractX(Player player, int width, int height, int length, Material[] materials) throws IOException, InvalidConfigurationException {
        //Wenn höhe größer als Breite ist:
        for (int i = 0; i < length; i++) {

            //Zufälliger Block auswählen für die X-Achse
            int randomMaterialWidth = TheMiningOfIsaac.mathHelper.getRandomInt(0, materials.length);
            Material randomMaterial1 = materials[randomMaterialWidth];

            Location location = player.getLocation().add(width,0,0);
            location.add(0,0,i);
            location.getBlock().setType(randomMaterial1);

            roomManager.getPlacedBlocks().add(location.getBlock());

            for(int i2=0; i2 < height; i2++) {

                //Zufälliger Block auswählen für die Y-Achse
                int randomMaterialHeight = TheMiningOfIsaac.mathHelper.getRandomInt(0, materials.length);
                Material randomMaterial2 = materials[randomMaterialHeight];

                if(i2 != 0) {
                    location.add(0, 1, 0);
                    location.getBlock().setType(randomMaterial2);
                    roomManager.getPlacedBlocks().add(location.getBlock());
                }
            }
        }
        roomManager.saveBlockLocations();
    }

    //Wand Z-
    public void buildWallSubtractZ(Player player, int width, int height,int length, Material[] materials) throws IOException, InvalidConfigurationException {
        //Wenn höhe größer als Breite ist:
        for (int i = 0; i < width; i++) {

            //Zufälliger Block auswählen für die X-Achse
            int randomMaterialWidth = TheMiningOfIsaac.mathHelper.getRandomInt(0, materials.length);
            Material randomMaterial1 = materials[randomMaterialWidth];

            Location location = player.getLocation().add(0,0,width);
            location.add(i,0,0);
            location.getBlock().setType(randomMaterial1);

            roomManager.getPlacedBlocks().add(location.getBlock());

            for(int i2=0; i2 < height; i2++) {

                //Zufälliger Block auswählen für die Y-Achse
                int randomMaterialHeight = TheMiningOfIsaac.mathHelper.getRandomInt(0, materials.length);
                Material randomMaterial2 = materials[randomMaterialHeight];

                if(i2 != 0) {
                    location.add(0, 1, 0);
                    location.getBlock().setType(randomMaterial2);
                    roomManager.getPlacedBlocks().add(location.getBlock());
                }
            }
        }
        roomManager.saveBlockLocations();
    }



    //Wand Z+
    public void buildWallAddZ(Player player, int width, int height, int length, Material[] materials) throws IOException, InvalidConfigurationException {
        //Wenn höhe größer als Breite ist:
        for (int i = 0; i < width; i++) {

            //Zufälliger Block auswählen für die X-Achse
            int randomMaterialWidth = TheMiningOfIsaac.mathHelper.getRandomInt(0, materials.length);
            Material randomMaterial1 = materials[randomMaterialWidth];

            Location location = player.getLocation();
            location.add(0,0,i);
            location.getBlock().setType(randomMaterial1);

            roomManager.getPlacedBlocks().add(location.getBlock());

            for(int i2=0; i2 < height; i2++) {

                //Zufälliger Block auswählen für die Y-Achse
                int randomMaterialHeight = TheMiningOfIsaac.mathHelper.getRandomInt(0, materials.length);
                Material randomMaterial2 = materials[randomMaterialHeight];

                if(i2 != 0) {
                    location.add(0, 1, 0);
                    location.getBlock().setType(randomMaterial2);
                    roomManager.getPlacedBlocks().add(location.getBlock());
                }
            }
        }
        roomManager.saveBlockLocations();
    }

    //Wand x+
    public void buildWallAddX(Player player, int width, int height, int length, Material[] materials) throws IOException, InvalidConfigurationException {
        //Wenn höhe größer als Breite ist:
            for (int i = 0; i < length; i++) {

                //Zufälliger Block auswählen für die X-Achse
                int randomMaterialWidth = TheMiningOfIsaac.mathHelper.getRandomInt(0, materials.length);
                Material randomMaterial1 = materials[randomMaterialWidth];

                Location location = player.getLocation();
                location.add(i,0,0);
                location.getBlock().setType(randomMaterial1);

                roomManager.getPlacedBlocks().add(location.getBlock());

                for(int i2=0; i2 < height; i2++) {

                    //Zufälliger Block auswählen für die Y-Achse
                    int randomMaterialHeight = TheMiningOfIsaac.mathHelper.getRandomInt(0, materials.length);
                    Material randomMaterial2 = materials[randomMaterialHeight];

                    if(i2 != 0) {
                        location.add(0, 1, 0);
                        location.getBlock().setType(randomMaterial2);
                        roomManager.getPlacedBlocks().add(location.getBlock());
                    }
            }

        }
            roomManager.saveBlockLocations();
    }

}