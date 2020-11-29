package ak.isaac.theminingofisaac.rooms.room;

import ak.isaac.theminingofisaac.enemies.Enemy;
import ak.isaac.theminingofisaac.enemies.enemy.DummyEnemy;
import ak.isaac.theminingofisaac.enemies.enemy.TestEnemy;
import ak.isaac.theminingofisaac.helper.BlockHelper;
import ak.isaac.theminingofisaac.rooms.Room;
import org.bukkit.Material;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class TestRoom extends Room {



    public TestRoom() {
        super("TestRoom", 10, 10,10, new Enemy[]{new TestEnemy(), new DummyEnemy()}, new Material[]{Material.STONE_BRICKS, Material.SMOOTH_STONE, Material.COBBLESTONE}, 3,3);
    }
}
