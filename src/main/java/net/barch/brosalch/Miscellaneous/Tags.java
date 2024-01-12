package net.barch.brosalch.Miscellaneous;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import static net.barch.brosalch.BrothersAlchemy.NAMESPACE;

public class Tags {


    public static final TagKey<Item> CRAFTING_TOOLS = ofItem(NAMESPACE,"crafting_tools");

    public static final TagKey<Biome> COLD = ofBiome("c", "climate_cold");
    public static final TagKey<Biome> HOT = ofBiome("c", "climate_hot");
    public static final TagKey<Biome> TEMPERATE = ofBiome("c", "climate_temperate");


    private static TagKey<Biome> ofBiome(String namespace, String path) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier(namespace, path));
    }
    private static TagKey<Block> ofBlock(String namespace, String path) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(namespace, path));
    }
    private static TagKey<Item> ofItem(String namespace, String path) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(namespace, path));
    }

}