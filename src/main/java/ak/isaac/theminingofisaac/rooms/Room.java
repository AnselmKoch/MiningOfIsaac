package ak.isaac.theminingofisaac.rooms;

import ak.isaac.theminingofisaac.enemies.Enemy;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.ArrayList;

public class Room {

    private String roomname;
    private Enemy[] enemies;
    private Material[] materials;
    private int height;
    private int width;
    private int length;
    private float x,y,z;
    private int[][] floorTiles;


    public Room(String roomname, int height,int length, int width, Enemy[] enemies, Material[] materials, float x, float z) {
        this.roomname = roomname;
        this.enemies = enemies;
        this.materials = materials;
        this.height = height;
        this.width = width;
        this.length = length;

        this.floorTiles = new int[this.length][this.width];
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

    public Enemy[] getEnemies() {
        return enemies;
    }

    public Material[] getMaterials() {
        return materials;
    }

    public int[][] getFloorTiles() {
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

    public void setFloorTiles(int a, int b, int value) {
        for(int i = 0; i < a; i++) {
            for(int j = 0; j < b; j++) {
                floorTiles[i][j] = value;
            }
        }
    }

}
