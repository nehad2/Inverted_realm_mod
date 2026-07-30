package com.invertedrealm.client;

import com.invertedrealm.ModBlocks;
import com.invertedrealm.client.mammoth.ModEntityRenderers;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class InvertedRealmClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOARFROST_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderLayer.getTranslucent(),
                ModBlocks.BLACK_ICE,
                ModBlocks.BLACK_ICE_32,
                ModBlocks.GLACIER_ICE
        );
        ModEntityRenderers.register();
    }
}
