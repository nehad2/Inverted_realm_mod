package com.invertedrealm;

import terrablender.api.SurfaceRuleManager;
import com.invertedrealm.entity.ModEntityAttributes;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.invertedrealm.entity.ModEntities;

public class InvertedRealm implements ModInitializer {
    public static final String MOD_ID = "inverted_realm";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override

    public void onInitialize() {
        LOGGER.info("Initializing Inverted Realm...");

        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        ModEntityAttributes.registerAttributes();
        ModEntities.registerEntities();

        SurfaceRuleManager.addSurfaceRules(
                SurfaceRuleManager.RuleCategory.OVERWORLD,
                MOD_ID,
                VanillaSurfaceRules.createOverworldSurfaceRule());
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
