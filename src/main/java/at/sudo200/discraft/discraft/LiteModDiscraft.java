package at.sudo200.discraft.discraft;

import at.sudo200.discraft.discraft.config.Config;
import at.sudo200.discraft.discraft.presence.GamePresenceState;
import at.sudo200.discraft.discraft.presence.PresenceManager;
import at.sudo200.discraft.discraft.util.Presence;
import com.mumfrey.liteloader.Configurable;
import com.mumfrey.liteloader.LiteMod;
import com.mumfrey.liteloader.Tickable;
import com.mumfrey.liteloader.modconfig.ConfigPanel;
import net.arikia.dev.drpc.DiscordRPC;
import net.minecraft.client.Minecraft;

import java.io.File;
import java.util.Objects;

public class LiteModDiscraft implements LiteMod, Tickable, Configurable {
    private final Config config = Config.get();
    private final PresenceManager presenceManager = new PresenceManager(config);

    private int count = 0;
    private boolean forceUpdate = false;


    /**
     * Default constructor. All LiteMods must have a default constructor. In general you should do very little
     * in the mod constructor EXCEPT for initialising any non-game-interfacing components or performing
     * sanity checking prior to initialisation
     */
    public LiteModDiscraft() {
        DiscordRPC.discordInitialize(config.getClientID(), null, true);
        DiscordRPC.discordUpdatePresence(
                new Presence(config.getStartingMsg())
                        .build()
        );
    }

    /**
     * getName() should be used to return the display name of your mod and MUST NOT return null
     *
     * @see com.mumfrey.liteloader.LiteMod#getName()
     */
    @Override
    public String getName() {
        return "Discraft";
    }

    /**
     * getVersion() should return the same version string present in the mod metadata, although this is
     * not a strict requirement.
     *
     * @see com.mumfrey.liteloader.LiteMod#getVersion()
     */
    @Override
    public String getVersion() {
        return "1.0-SNAPSHOT";
    }

    /**
     * init() is called very early in the initialisation cycle, before the game is fully initialised, this
     * means that it is important that your mod does not interact with the game in any way at this point.
     *
     * @see com.mumfrey.liteloader.LiteMod#init(File)
     */
    @Override
    public void init(File configPath) {
    }

    /**
     * Get the class of the configuration panel to use, the returned class must
     * have a default (no-arg) constructor
     *
     * @return configuration panel class
     */
    @Override
    public Class<? extends ConfigPanel> getConfigPanelClass() {
        return at.sudo200.discraft.discraft.config.ConfigPanel.class;
    }

    /**
     * Called every frame
     *
     * @param minecraft    Minecraft instance
     * @param partialTicks Partial tick value
     * @param inGame       True if in-game, false if in the menu
     * @param clock        True if this is a new tick, otherwise false if it's a
     */
    @Override
    public void onTick(Minecraft minecraft, float partialTicks, boolean inGame, boolean clock) {
        if(!clock)// We work tick based, not frame based
            return;

        if(count++ >= 100) {
            count = 0;
            forceUpdate = true;
        }

        presenceManager.updatePresence(minecraft, forceUpdate);
        if(forceUpdate)
            forceUpdate = false;

        if(!inGame || minecraft.isGamePaused()) // When not in game
            presenceManager.setPresenceState(GamePresenceState.MENU);
        else if(Objects.requireNonNull(minecraft.getConnection()).getNetworkManager().isLocalChannel())
            // When alone
            presenceManager.setPresenceState(GamePresenceState.SINGLEPLAYER);
        else // Else probably multiplayer
            presenceManager.setPresenceState(GamePresenceState.MULTIPLAYER);
    }

    /**
     * upgradeSettings is used to notify a mod that its version-specific settings are being migrated
     *
     * @see com.mumfrey.liteloader.LiteMod#upgradeSettings(String, File, File)
     */
    @Override
    public void upgradeSettings(String version, File configPath, File oldConfigPath) {
    }
}
