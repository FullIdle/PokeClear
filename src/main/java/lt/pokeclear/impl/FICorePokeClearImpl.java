package lt.pokeclear.impl;

import lt.pokeclear.common.api.PokeClearAPI;
import lt.pokeclear.common.laotou.PokeClear;
import me.fullidle.ficore.ficore.FICoreAPI;
import me.fullidle.ficore.ficore.common.api.pokemon.wrapper.IPokemonWrapper;
import me.fullidle.ficore.ficore.common.api.pokemon.wrapper.ISpeciesWrapper;
import me.fullidle.ficore.ficore.common.api.pokemon.wrapper.PokeEntityWrapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class FICorePokeClearImpl extends PokeClear<ISpeciesWrapper<?>, IPokemonWrapper<?>, PokeEntityWrapper<?>> implements Listener {
    @Override
    public void onEnable() {
        super.onEnable();
        this.getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public PokeClearAPI<ISpeciesWrapper<?>, IPokemonWrapper<?>, PokeEntityWrapper<?>> getApi() {
        return FICorePokeClearAPIImpl.INSTANCE;
    }

    @Override
    public void listenerImpl(String waitClearOnSpawn) {
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        if (waitClear == null || !FICoreAPI.getPokeEntityWrapperFactory().isPokeEntity(event.getEntity())) return;
        waitClear.onSpawn(event.getEntity());
    }
}
