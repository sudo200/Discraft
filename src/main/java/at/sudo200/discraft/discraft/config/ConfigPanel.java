package at.sudo200.discraft.discraft.config;

import com.mumfrey.liteloader.modconfig.AbstractConfigPanel;
import com.mumfrey.liteloader.modconfig.ConfigPanelHost;

import java.util.HashMap;
import java.util.Map;


public class ConfigPanel extends AbstractConfigPanel {
    private final Config config = Config.get();
    private final Map<Integer, ConfigTextField> fields = new HashMap<>();

    private interface FieldIDs {
        int clientID = 1;
        int menuMsg = 3;
        int singleplayerMsg = 5;
        int multiplayerMsg = 7;
        int singleplayerDetailFormat = 9;
        int multiplayerDetailFormat = 11;
    }

    /**
     * Stub for implementors, this is similar to  and
     * consumers should add all of their controls here
     *
     * @param host
     */
    @Override
    protected void addOptions(ConfigPanelHost host) {
        final int width = host.getWidth() - 10;

        addLabel(0, 1, 5, width, 10, 0xFFFFFF, "Client ID", "You can create you own at https://discord.com/developers/applications");
        fields.put(FieldIDs.clientID, this.addTextField(FieldIDs.clientID,0,  20, width, 20).setText(config.getClientID()).setRegex("^\\d+$", true));
        //--------------------------------------------------------------------------------------------
        addLabel(2, 1, 55, width, 10, 0xFFFFFF, "Menu message", "Shown while in main- or game menu");
        fields.put(FieldIDs.menuMsg, this.addTextField(FieldIDs.menuMsg, 0, 70, width, 20).setText(config.getMenuMsg()));
        //--------------------------------------------------------------------------------------------
        addLabel(4, 1, 105, width, 10, 0xFFFFFF, "Singleplayer message", "Shown while playing singleplayer");
        fields.put(FieldIDs.singleplayerMsg, this.addTextField(FieldIDs.singleplayerMsg, 0, 120, width, 20).setText(config.getSingleplayerMsg()));
        //--------------------------------------------------------------------------------------------
        addLabel(6, 1, 155, width, 10, 0xFFFFFF, "Multiplayer message", "Shown while playing multiplayer");
        fields.put(FieldIDs.multiplayerMsg, this.addTextField(FieldIDs.multiplayerMsg, 1, 170, width, 20).setText(config.getMultiplayerMsg()));
        //--------------------------------------------------------------------------------------------
        addLabel(8, 1, 205, width, 10, 0xFFFFFF, "Singleplayer format string", "Supports $WORLDNAME$, $DIMENSION$ and $BIOME$");
        fields.put(FieldIDs.singleplayerDetailFormat, this.addTextField(FieldIDs.singleplayerDetailFormat, 1, 220, width, 20).setText(config.getSingleplayerDetailFormat()));
        //--------------------------------------------------------------------------------------------
        addLabel(10, 1, 255, width, 10, 0xFFFFFF, "Multiplayer format string", "Supports $SERVERIP$, $SERVERNAME$ and $SERVERMOTD$");
        fields.put(FieldIDs.multiplayerDetailFormat, this.addTextField(FieldIDs.multiplayerDetailFormat, 1, 270, width, 20).setText(config.getMultiplayerDetailFormat()));
        //--------------------------------------------------------------------------------------------
    }

    /**
     * Panels should return the text to display at the top of the config panel
     * window.
     */
    @Override
    public String getPanelTitle() {
        return "Configure Discraft";
    }

    /**
     * Called when the panel is closed, panel should save settings
     */
    @Override
    public void onPanelHidden() {
        config.setClientID(fields.get(FieldIDs.clientID).getText());
        config.setMenuMsg(fields.get(FieldIDs.menuMsg).getText());
        config.setSingleplayerMsg(fields.get(FieldIDs.singleplayerMsg).getText());
        config.setMultiplayerMsg(fields.get(FieldIDs.multiplayerMsg).getText());
        config.setSingleplayerDetailFormat(fields.get(FieldIDs.singleplayerDetailFormat).getText());
        config.setMultiplayerDetailFormat(fields.get(FieldIDs.multiplayerDetailFormat).getText());
        config.saveConfigToFile();
    }
}
