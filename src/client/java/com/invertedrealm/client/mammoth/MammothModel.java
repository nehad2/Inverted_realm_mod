package com.invertedrealm.client.mammoth;

import com.invertedrealm.entity.mammoth.MammothEntity;

import net.minecraft.util.Identifier;

import software.bernie.geckolib.model.GeoModel;

public class MammothModel extends GeoModel<MammothEntity> {

    @Override
    public Identifier getModelResource(MammothEntity object) {
        return new Identifier(
                "inverted_realm",
                "geo/mammoth.geo.json"
        );
    }

    @Override
    public Identifier getTextureResource(MammothEntity object) {
        return new Identifier(
                "inverted_realm",
                "textures/entity/mammoth.png"
        );
    }

    @Override
    public Identifier getAnimationResource(MammothEntity object) {
        return new Identifier(
                "inverted_realm",
                "animations/mammoth.animation.json"
        );
    }
}