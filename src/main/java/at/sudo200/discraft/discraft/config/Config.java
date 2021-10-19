package at.sudo200.discraft.discraft.config;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * stores and retrieves config
 */
public class Config {
    private static final Config instance;

    private final Gson gson = new Gson();
    private ConfigFile config = new ConfigFile();
    private File configfile;

    private final String startingMsg = "Starting the game";

    static {
        instance = new Config();
    }

    private Config() {
        // Default values
        config.clientID = "900063459310456843";

        config.menuMsg = "In the menu";
        config.singleplayerMsg = "Playing Singleplayer";
        config.multiplayerMsg = "Playing Multiplayer";

        config.singleplayerDetailFormat = "In world \"$WORLDNAME$\"";
        config.multiplayerDetailFormat = "On $SERVERNAME$";
    }

    /**
     * @return instance
     * @see Config
     */
    public static Config get() {
        return instance;
    }

    /**
     * @return config file
     */
    public File getConfigfile() {
        return configfile;
    }

    /**
     * @param configpath path to config dir
     */
    public void setConfigPath(File configpath) {
        this.configfile = new File(configpath.getAbsolutePath() + File.separator + "discraft.json");
    }

    /** Initializes the config file
     * @return true if file was newly created
     * @throws IOException thrown if file operation failed
     */
    public boolean initConfigFile() throws IOException {
        if (configfile.createNewFile()) {
            FileWriter writer = new FileWriter(configfile);
            gson.toJson(config, writer);
            writer.close();
            return true;
        }


        FileReader reader = new FileReader(configfile);

        try {
            config = gson.fromJson(reader, ConfigFile.class);
            reader.close();
        } catch (JsonParseException e) {
            reader.close();
            System.err.println("Config file syntax is invalid!\nOverriding existing one!");
            if(configfile.delete())
                initConfigFile();
            else
                System.err.println("Couldn't delete config file! What is this?");
        }

        return false;
    }

    /** Saves the config into the config file
     * @return true if saved successfully
     */
    public boolean saveConfigToFile() {
        try {
            FileWriter writer = new FileWriter(configfile);
            gson.toJson(config, writer);
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * @return Discord application id
     */
    public String getClientID() {
        return config.clientID;
    }

    /**
     * @param clientID Discord application id
     */
    public void setClientID(String clientID) {
        config.clientID = clientID;
    }

    /**
     * @return Message shown during startup
     */
    public String getStartingMsg() {
        return startingMsg;
    }

    /**
     * @return Message shown while in main menu or game menu
     */
    public String getMenuMsg() {
        return config.menuMsg;
    }

    /**
     * @param menuMsg Message shown while in main menu or game menu
     */
    public void setMenuMsg(String menuMsg) {
        config.menuMsg = menuMsg;
    }

    /**
     * @return Message shown while in singleplayer
     */
    public String getSingleplayerMsg() {
        return config.singleplayerMsg;
    }

    /**
     * @param singleplayerMsg Message shown while in singleplayer
     */
    public void setSingleplayerMsg(String singleplayerMsg) {
        config.singleplayerMsg = singleplayerMsg;
    }

    /**
     * @return Message shown while in multiplayer
     */
    public String getMultiplayerMsg() {
        return config.multiplayerMsg;
    }

    /**
     * @param multiplayerMsg Message shown while in multiplayer
     */
    public void setMultiplayerMsg(String multiplayerMsg) {
        config.multiplayerMsg = multiplayerMsg;
    }


    /**
     * @return Detail string while in singleplayer; format string
     */
    public String getSingleplayerDetailFormat() {
        return config.singleplayerDetailFormat;
    }

    /**
     * @param singleplayerDetailFormat Detail string while in singleplayer; format string
     */
    public void setSingleplayerDetailFormat(String singleplayerDetailFormat) {
        config.singleplayerDetailFormat = singleplayerDetailFormat;
    }

    /**
     * @return Detail string while in multiplayer; format string
     */
    public String getMultiplayerDetailFormat() {
        return config.multiplayerDetailFormat;
    }

    /**
     * @param multiplayerDetailFormat Detail string while in multiplayer; format string
     */
    public void setMultiplayerDetailFormat(String multiplayerDetailFormat) {
        config.multiplayerDetailFormat = multiplayerDetailFormat;
    }
}
