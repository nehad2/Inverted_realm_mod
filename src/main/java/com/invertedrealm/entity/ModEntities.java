package com.invertedrealm.entity;

import com.invertedrealm.entity.mammoth.MammothEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<MammothEntity> MAMMOTH =
            Registry.register(
                    Registries.ENTITY_TYPE,
                    new Identifier("inverted_realm", "mammoth"),
                    FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MammothEntity::new)
                            .dimensions(EntityDimensions.fixed(2.5f, 3.5f))
                            .build()
            );


    public static void registerEntities() {
        // This forces the class to load and register the entity
        System.out.println("Registering Mammoth Entity");
    }
}