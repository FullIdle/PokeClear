package lt.pokeclear.impl;

import lombok.val;
import lt.pokeclear.common.api.PokeClearAPI;
import me.fullidle.ficore.ficore.FICoreAPI;
import me.fullidle.ficore.ficore.common.api.pokemon.wrapper.IPokemonWrapper;
import me.fullidle.ficore.ficore.common.api.pokemon.wrapper.ISpeciesWrapper;
import me.fullidle.ficore.ficore.common.api.pokemon.wrapper.PokeEntityWrapper;
import org.bukkit.entity.Entity;

import java.util.UUID;

public class FICorePokeClearAPIImpl extends PokeClearAPI<ISpeciesWrapper<?>, IPokemonWrapper<?>, PokeEntityWrapper<?>> {
    public static FICorePokeClearAPIImpl INSTANCE = new FICorePokeClearAPIImpl();

    @Override
    public ISpeciesWrapper<?>[] allSpecies() {
        return FICoreAPI.getSpeciesWrapperFactory().getAll().toArray(new ISpeciesWrapper[0]);
    }

    @Override
    public boolean isUltraBeast(ISpeciesWrapper<?> iSpeciesWrapper) {
        return iSpeciesWrapper.isUltra();
    }

    @Override
    public boolean isLegendary(ISpeciesWrapper<?> iSpeciesWrapper) {
        return iSpeciesWrapper.isLegend();
    }

    @Override
    public boolean isMythical(ISpeciesWrapper<?> iSpeciesWrapper) {
        return iSpeciesWrapper.isMythical();
    }

    @Override
    public String speciesName(ISpeciesWrapper<?> iSpeciesWrapper) {
        return iSpeciesWrapper.getName();
    }

    @Override
    public boolean isPokeEntity(Entity entity) {
        return FICoreAPI.getPokeEntityWrapperFactory().isPokeEntity(entity);
    }

    @Override
    public PokeEntityWrapper<?> getPokeEntity(Entity entity) {
        return FICoreAPI.getPokeEntityWrapperFactory().asPokeEntity(entity);
    }

    @Override
    public void unloadEntity(PokeEntityWrapper<?> pokeEntityWrapper) {
        pokeEntityWrapper.asBukkitEntity().remove();
    }

    @Override
    public boolean isShiny(IPokemonWrapper<?> pokemonWrapper) {
        return pokemonWrapper.isShiny();
    }

    @Override
    public IPokemonWrapper<?> getPokeData(PokeEntityWrapper<?> pokeEntityWrapper) {
        return pokeEntityWrapper.getPokemon();
    }

    @Override
    public boolean isBossPokeEntity(PokeEntityWrapper<?> pokeEntityWrapper) {
        return pokeEntityWrapper.isBoss();
    }

    @Override
    public ISpeciesWrapper<?> getSpecies(IPokemonWrapper<?> pokemonWrapper) {
        return pokemonWrapper.getSpecies();
    }

    @Override
    public int getSpeciesDexID(ISpeciesWrapper<?> iSpeciesWrapper) {
        return iSpeciesWrapper.getDex();
    }

    @Override
    public boolean canDespawn(PokeEntityWrapper<?> pokeEntityWrapper) {
        return pokeEntityWrapper.canDespawn();
    }

    @Override
    public UUID getOwnerUUID(IPokemonWrapper<?> pokemonWrapper) {
        return pokemonWrapper.getOwnerUUID();
    }

    @Override
    public boolean inBattle(PokeEntityWrapper<?> pokeEntityWrapper) {
        return pokeEntityWrapper.inBattle();
    }

    @Override
    public boolean inRanch(IPokemonWrapper<?> pokemonWrapper) {
        return pokemonWrapper.inRanch();
    }
}
