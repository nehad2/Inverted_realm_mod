package com.invertedrealm.client.mammoth;

import com.invertedrealm.entity.ModEntities;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ModEntityRenderers {

    public static void register() {

        EntityRendererRegistry.register(
                ModEntities.MAMMOTH,
                MammothRenderer::new
        );

    }
}