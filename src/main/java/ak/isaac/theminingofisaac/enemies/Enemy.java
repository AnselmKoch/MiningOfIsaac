package ak.isaac.theminingofisaac.enemies;


import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import java.util.UUID;

public abstract class Enemy{

    private String name;
    private int enemyID;
    private int attackCooldownWait;
    private int attackCooldown;
    private boolean canAttack;
    private EntityType entityType;
    private Entity entity;
    private UUID privateUUID;
    private Location location;
    private boolean inRange;


    private ItemStack helmet;
    private ItemStack chestplate;
    private ItemStack leggings;
    private ItemStack boots;
    private ItemStack mainHand;
    private ItemStack secondHand;


    public Enemy(String newName,int newAttackCooldown, EntityType newEntityType, ItemStack newHelmet, ItemStack newChestplate, ItemStack newLeggings, ItemStack newBoots, ItemStack newMainHand, ItemStack newSecondHand) {
        this.name = newName;
        this.attackCooldown =  newAttackCooldown * 20;
        this.entityType = newEntityType;
        this.helmet = newHelmet;
        this.chestplate = newChestplate;
        this.leggings = newLeggings;
        this.boots = newBoots;
        this.mainHand = newMainHand;
        this.secondHand = newSecondHand;
    }


    public void attack(Entity source,Entity target) {

    }

    public void setCanAttack(boolean newCanAttack) {
        this.canAttack = newCanAttack;
    }

    public boolean getCanAttack() {
        return this.canAttack;
    }
    public void setLocation(Location newLocation) {
        this.location = newLocation;
    }

    public void setEnemyID(int newEntityID) {
        this.enemyID = newEntityID;
    }

    public void setEntity(Entity newEntity) {
        this.entity = newEntity;
    }

    public void generatePrivateUUID() {
        this.privateUUID = UUID.randomUUID();
    }

    public int getEnemyID() {
        return this.enemyID;
    }

    public Location getLocation() {
        return this.location;
    }

    public UUID getPrivateUUID() {
        return this.privateUUID;
    }

    public Entity getEntity() {
        return this.entity;
    }

    public EntityType getEntityType() {
        return this.entityType;
    }

    public String getEnemyName() {
        return this.name;
    }

    public ItemStack getHelmet() {
        return this.helmet;
    }

    public ItemStack getMainHand() {
        return this.mainHand;
    }

    public ItemStack getSecondHand() {
        return this.secondHand;
    }

    public boolean getInRange() {
        return inRange;
    }

    public void setInRange(boolean newInRange) {
        inRange = newInRange;
    }

    public int getAttackCooldown() {
        return this.attackCooldown;
    }

    public void setAttackCooldown(int newAttackCooldown) {
        this.attackCooldown = newAttackCooldown;
    }

    public int getAttackCooldownWait() {
        return this.attackCooldownWait;
    }

    public void setAttackCooldownWait(int newAttackCooldownWait) {
        this.attackCooldownWait = newAttackCooldownWait ;
    }
}