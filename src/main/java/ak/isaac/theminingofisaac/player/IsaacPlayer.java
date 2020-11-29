package ak.isaac.theminingofisaac.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class IsaacPlayer {

    private Player player;
    private Location location;

    public IsaacPlayer(Player player) {
        this.player = player;
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
