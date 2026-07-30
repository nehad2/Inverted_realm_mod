package com.invertedrealm.entity;

import com.invertedrealm.entity.mammoth.MammothEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class ModEntityAttributes {

    public static void registerAttributes() {

        FabricDefaultAttributeRegistry.register(
                ModEntities.MAMMOTH,
                MammothEntity.createMammothAttributes()
        );

    }
}