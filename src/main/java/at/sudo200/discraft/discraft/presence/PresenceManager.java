package at.sudo200.discraft.discraft.presence;

import at.sudo200.discraft.discraft.config.Config;
import at.sudo200.discraft.discraft.util.Presence;
import net.arikia.dev.drpc.DiscordRPC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;

import java.util.Objects;

/**
 * Controls Discord Rich Presence
 */
public class PresenceManager {
    private final Config config;

    private GamePresenceState
            presenceState = GamePresenceState.STARTING,
            lastPresenceState = presenceState;

    public PresenceManager(Config config) {
        this.config = config;
    }

    /**
     * Sets the current state.
     * @param state the new state
     */
    public void setPresenceState(GamePresenceState state) {
        if(!presenceState.equals(state))
            presenceState = state;
    }

    /**
     * Updates rich presence
     * @param minecraft minecraft instance
     * @param forceUpdate if true, updates even when state hasn't changed
     */
    public void updatePresence(Minecraft minecraft, boolean forceUpdate) {
        if(!(forceUpdate || !presenceState.equals(lastPresenceState)))
            return;

        switch (presenceState) {
            case MENU:
                DiscordRPC.discordUpdatePresence(
                        new Presence(config.getMenuMsg())
                                .build()
                );
                break;

            case SINGLEPLAYER:
                final EntityPlayerMP player = Objects.requireNonNull(minecraft.getIntegratedServer())
                        .getPlayerList()
                        .getPlayers()
                        .stream()
                        .filter(p -> p.getUniqueID().equals(minecraft.getSession().getProfile().getId()))
                        .findFirst()
                        .orElse(null);

                DiscordRPC.discordUpdatePresence(
                        new Presence(config.getSingleplayerMsg())
                                .setDetails(
                                        config.getSingleplayerDetailFormat()
                                                .replaceAll(
                                                        "%WORLDNAME%",
                                                        Objects.requireNonNull(minecraft.getIntegratedServer()).getWorldName()
                                                ).replaceAll(
                                                        "%BIOME%",
                                                        player.world.getBiome(new BlockPos(player.posX, player.posY, player.posZ)).getBiomeName()
                                                ).replaceAll(
                                                        "%DIMENSION%",
                                                        minecraft.getIntegratedServer().getWorld(player.dimension).provider.getDimensionType().getName()
                                                )
                                )
                                .build()
                );
                break;

            case MULTIPLAYER:
                final ServerData serverData = Objects.requireNonNull(minecraft.getCurrentServerData());

                DiscordRPC.discordUpdatePresence(
                        new Presence(config.getMultiplayerMsg())
                                .setDetails(
                                        config.getMultiplayerDetailFormat()
                                                .replaceAll(
                                                        "%SERVERIP%",
                                                        serverData.serverIP
                                                ).replaceAll(
                                                        "%SERVERNAME%",
                                                        serverData.serverName
                                                ).replaceAll(
                                                        "%SERVERMOTD%",
                                                        serverData.serverMOTD
                                                )
                                )
                                .build()
                );
                break;
        }

        lastPresenceState = presenceState;
    }
}
