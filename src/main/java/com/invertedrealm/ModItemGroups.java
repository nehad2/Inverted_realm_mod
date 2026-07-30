package com.invertedrealm;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class ModItemGroups {
    public static final ItemGroup INVERTED_REALM_GROUP = Registry.register(Registries.ITEM_GROUP, InvertedRealm.id("inverted_realm_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.inverted_realm")).icon(() -> new ItemStack(ModItems.CATALYST))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CATALYST); entries.add(ModBlocks.SLATE); entries.add(ModBlocks.PERMAFROST); entries.add(ModBlocks.PERMAFROST_FACE);
                        entries.add(ModBlocks.PERMAFROST_32); entries.add(ModBlocks.HOARFROST_LEAVES); entries.add(ModBlocks.FROST_LOG);
                        entries.add(ModBlocks.ICY_COBBLESTONE); entries.add(ModBlocks.COMPACTED_SNOW); entries.add(ModBlocks.BLACK_ICE);
                        entries.add(ModBlocks.BLACK_ICE_32); entries.add(ModBlocks.FROST_STONE); entries.add(ModBlocks.FROZEN_STONE); entries.add(ModBlocks.GLACIER_ICE);
                    }).build());
    public static void registerItemGroups() { InvertedRealm.LOGGER.info("Registering Item Groups for " + InvertedRealm.MOD_ID); }
}
