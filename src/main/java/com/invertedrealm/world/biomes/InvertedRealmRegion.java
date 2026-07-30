package com.invertedrealm.world.biomes;

import terrablender.api.Region;
import terrablender.api.RegionType;
import com.invertedrealm.InvertedRealm;
import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import java.util.function.Consumer;

public class InvertedRealmRegion extends Region {
    public static final RegistryKey<Biome> ALPINE_PEAKS = RegistryKey.of(RegistryKeys.BIOME, InvertedRealm.id("alpine_peaks"));
    public InvertedRealmRegion(Identifier name, int weight) { super(name, RegionType.OVERWORLD, weight); }
    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        this.addBiomeSimilar(mapper, BiomeKeys.SNOWY_PLAINS, ALPINE_PEAKS);
    }
}
