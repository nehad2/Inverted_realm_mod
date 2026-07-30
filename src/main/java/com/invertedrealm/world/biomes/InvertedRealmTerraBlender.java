package com.invertedrealm.world.biomes;

import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;
import com.invertedrealm.InvertedRealm;

public class InvertedRealmTerraBlender implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() { Regions.register(new InvertedRealmRegion(InvertedRealm.id("inverted_region"), 2)); }
}
