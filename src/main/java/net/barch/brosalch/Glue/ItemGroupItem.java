package net.barch.brosalch.Glue;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;

/**
 * This is passed into the {@link ItemGrouper#GroupItem(Item, ItemGroupItem[])} and {@link ItemGrouper#GroupItem(Block, ItemGroupItem[])} methods.
 */
public class ItemGroupItem {

    public RegistryKey<ItemGroup> group = null;
    public Item item = null;
    public Block block = null;

    /**
     * This is used when you are grouping items.
     * @param group The group to put the item in.
     * @param item The item to put in a group.
     */
    public ItemGroupItem(RegistryKey<ItemGroup> group, Item item) {
        this.group = group;
        this.item = item;
    }

    /**
     * This is used when you are grouping blocks.
     * @param group The group to put the block in.
     * @param block The block to put in a group.
     */
    public ItemGroupItem(RegistryKey<ItemGroup> group, Block block) {
        this.group = group;
        this.block = block;
    }

    public Item getItem() {
        if (this.item != null) {
            return this.item;
        }
        return block.asItem();
    }

}
