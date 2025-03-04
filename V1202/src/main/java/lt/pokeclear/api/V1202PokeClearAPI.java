package lt.pokeclear.api;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import com.pixelmonmod.pixelmon.api.registries.PixelmonSpecies;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import lt.pokeclear.common.api.PokeClearAPI;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_20_R2.CraftServer;
import org.bukkit.craftbukkit.v1_20_R2.entity.CraftEntity;
import org.bukkit.entity.Entity;

import java.util.UUID;

public final class V1202PokeClearAPI extends PokeClearAPI<Species, Pokemon, PixelmonEntity> {
    public static final V1202PokeClearAPI INSTANCE = new V1202PokeClearAPI();

    private V1202PokeClearAPI(){
    }

    @Override
    public Species[] allSpecies() {
        return PixelmonSpecies.getAll().toArray(new Species[0]);
    }

    @Override
    public boolean isUltraBeast(Species species) {
        return species.isUltraBeast();
    }

    @Override
    public boolean isLegendary(Species species) {
        return species.isLegendary();
    }

    @Override
    public String speciesName(Species species) {
        return species.getName();
    }

    @Override
    public boolean isPokeEntity(Entity entity) {
        return mcEntity(entity) instanceof PixelmonEntity;
    }

    @Override
    public PixelmonEntity getPokeEntity(Entity entity) {
        return (PixelmonEntity) mcEntity(entity);
    }

    @Override
    public void unloadEntity(PixelmonEntity entityPixelmon) {
        entityPixelmon.unloadEntity();
    }

    @Override
    public boolean isShiny(Pokemon pokemon) {
        return pokemon.isShiny();
    }

    @Override
    public Pokemon getPokeData(PixelmonEntity entityPixelmon) {
        return entityPixelmon.getPokemon();
    }

    @Override
    public boolean isBossPokeEntity(PixelmonEntity entityPixelmon) {
        return entityPixelmon.isBossPokemon();
    }

    @Override
    public Species getSpecies(Pokemon pokemon) {
        return pokemon.getSpecies();
    }

    @Override
    public int getSpeciesDexID(Species species) {
        return species.getDex();
    }

    @Override
    public boolean canDespawn(PixelmonEntity entityPixelmon) {
        return entityPixelmon.canDespawn;
    }

    @Override
    public UUID getOwnerUUID(Pokemon pokemon) {
        UUID uuid = pokemon.getOwnerPlayerUUID();
        return uuid == null ? pokemon.getOwnerTrainerUUID() : uuid;
    }

    @Override
    public boolean inBattle(PixelmonEntity entityPixelmon) {
        return entityPixelmon.battleController != null;
    }

    @Override
    public boolean inRanch(Pokemon pokemon) {
        return false;
    }

    public static net.minecraft.world.entity.Entity mcEntity(Entity entity){
        return ((CraftEntity) entity).getHandle();
    }

    public static Entity bukkitEntity(net.minecraft.world.entity.Entity entity){
        return CraftEntity.getEntity(((CraftServer) Bukkit.getServer()),entity);
    }
}
