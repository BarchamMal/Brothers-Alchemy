package net.barch.brosalch.Glue;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

/**
 * In this class are contained the utils for creating blocks.
 * So far the only one is {@link BlockBuilder#CloneBlock(Block)}
 */
public class BlockBuilder {

    private static FabricBlockSettings Settings;


    /**
     * A warning: this only runs .sounds, .strength, .resistance, .mapColor, and .slipperiness methods
     * @param block The block to clone the stats of.
     * @return the FabricBlockSettings
     */
    public static FabricBlockSettings CloneBlock(Block block) {


        Settings = FabricBlockSettings.create()
                .sounds(block.getSoundGroup(block.getDefaultState()))
                .strength(block.getHardness())
                .resistance(block.getBlastResistance())
                .mapColor(block.getDefaultMapColor())
                .slipperiness(block.getSlipperiness());

        return Settings;

    };

}