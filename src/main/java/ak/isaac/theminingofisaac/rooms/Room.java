package ak.isaac.theminingofisaac.rooms;

import ak.isaac.theminingofisaac.enemies.Enemy;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {

    private String roomname;
    private Enemy[] enemies;
    private Material[] materials;
    private int height;
    private int width;
    private int length;
    private float x,y,z;
    private int[][] enemySpawnLocation;
    private Location[][] floorTiles;


    public Room(String roomname, int height,int length, int width, Enemy[] enemies, int[][] enemySpawnLocation, Material[] materials, float x, float z) {
        this.roomname = roomname;
        this.enemies = enemies;
        this.materials = materials;
        this.enemySpawnLocation = enemySpawnLocation;
        this.height = height;
        this.width = width;
        this.length = length;

        this.floorTiles = new Location[this.length][this.width];
    }

    public void setEnemies() {

    }

    public void setMaterials() {

    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }


    public Material[] getMaterials() {
        return materials;
    }

    public Location[][] getFloorTiles() {
        return floorTiles;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return this.length;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setFloorTiles(int a, int b, Location location) {
        for(int i = 0; i < a; i++) {
            for(int j = 0; j < b; j++) {
                floorTiles[i][j] = location;
            }
        }
    }

    public String getAllFloorTiles() {
        String s = "";
        try {
            for (int i = 0; i < this.getFloorTiles().length; i++) {
                for (int j = 0; j < this.getFloorTiles()[i].length; j++) {
                    s += this.getFloorTiles()[i][j];
                }
                s += '\n';
            }
        }
        catch (NullPointerException exception) {
            System.out.println("EXCEPTION");
        }
        return s;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public int[][] getEnemySpawnLocation() {
        return enemySpawnLocation;
    }
}
