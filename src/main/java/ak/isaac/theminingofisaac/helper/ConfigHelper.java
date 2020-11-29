package ak.isaac.theminingofisaac.helper;

import ak.isaac.theminingofisaac.TheMiningOfIsaac;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigHelper {

    private File blockDataYML = new File(TheMiningOfIsaac.instance.getDataFolder()+"/blockData.yml");
    private FileConfiguration customConfig = YamlConfiguration.loadConfiguration(blockDataYML);

    public void createCustomConfig() {
        blockDataYML = new File(TheMiningOfIsaac.instance.getDataFolder(), "blockData.yml");
        if (!blockDataYML.exists()) {
            blockDataYML.getParentFile().mkdirs();
            TheMiningOfIsaac.instance.saveResource("blockData.yml", false);
        }
        try {
            customConfig.load(blockDataYML);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public File getBlockDataYML() {
        return blockDataYML;
    }

    public FileConfiguration getCustomConfig() {
        return customConfig;
    }

}
