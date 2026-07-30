package com.invertedrealm.client.mammoth;

import com.invertedrealm.entity.mammoth.MammothEntity;

import net.minecraft.client.render.entity.EntityRendererFactory;

import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MammothRenderer extends GeoEntityRenderer<MammothEntity> {

    public MammothRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MammothModel());
    }
}