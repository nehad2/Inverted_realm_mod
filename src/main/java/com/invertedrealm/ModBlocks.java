package com.invertedrealm;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {
    public static final Block SLATE = registerBlock("slate", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(3.5f).requiresTool()));
    public static final Block PERMAFROST = registerBlock("permafrost", new Block(FabricBlockSettings.copyOf(Blocks.DIRT).strength(2.0f).sounds(BlockSoundGroup.GRAVEL)));
    public static final Block PERMAFROST_FACE = registerBlock("permafrost_face", new Block(FabricBlockSettings.copyOf(Blocks.DIRT).strength(2.0f).sounds(BlockSoundGroup.GRAVEL)));
    public static final Block HOARFROST_LEAVES = registerBlock("hoarfrost_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(0.2f).sounds(BlockSoundGroup.GRASS).nonOpaque()));
    public static final Block FROST_LOG = registerBlock("frost_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(2.0f)));
    public static final Block ICY_COBBLESTONE = registerBlock("icy_cobblestone", new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).strength(2.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block COMPACTED_SNOW = registerBlock("compacted_snow", new Block(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK).strength(0.6f).sounds(BlockSoundGroup.SNOW)));
    public static final Block BLACK_ICE = registerBlock("black_ice", new Block(FabricBlockSettings.copyOf(Blocks.PACKED_ICE).strength(0.5f).slipperiness(0.98f).sounds(BlockSoundGroup.GLASS)));
    public static final Block FROST_STONE = registerBlock("frost_stone", new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block GLACIER_ICE = registerBlock("glacier_ice", new Block(FabricBlockSettings.copyOf(Blocks.PACKED_ICE).strength(0.8f).slipperiness(0.99f).sounds(BlockSoundGroup.GLASS)));
    public static final Block BLACK_ICE_32 = registerBlock("black_ice_32x32", new Block(FabricBlockSettings.copyOf(Blocks.PACKED_ICE).strength(0.5f).slipperiness(0.98f).sounds(BlockSoundGroup.GLASS)));
    public static final Block FROZEN_STONE = registerBlock("frozen_stone", new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block PERMAFROST_32 = registerBlock("permafrost_32x32", new Block(FabricBlockSettings.copyOf(Blocks.DIRT).strength(2.0f).sounds(BlockSoundGroup.GRAVEL)));

    private static Block registerBlock(String name, Block block) { registerBlockItem(name, block); return Registry.register(Registries.BLOCK, InvertedRealm.id(name), block); }
    private static Item registerBlockItem(String name, Block block) { return Registry.register(Registries.ITEM, InvertedRealm.id(name), new BlockItem(block, new FabricItemSettings())); }
    public static void registerModBlocks() { InvertedRealm.LOGGER.info("Registering Mod Blocks for " + InvertedRealm.MOD_ID); }
}
