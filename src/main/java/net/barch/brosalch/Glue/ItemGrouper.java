package net.barch.brosalch.Glue;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import org.jetbrains.annotations.Nullable;


/**
 * This is not a static class because I've seen many mods with multiple large itemgroups ( i.e. "Steam 'n' Rails: Tracks" or "Steam 'n' Rails: Conductor Caps" ) so someone could make multiple of these instead of having only one supergroup.
 */
public class ItemGrouper {

    private RegistryKey<ItemGroup> super_group;

    /**
     * @param super_group The Group that all items go in.
     * My mods have an itemgroup with all my mod's items and blocks. This is what the super_group is.
     * If you don't have one, no problem, set the supergroup to null.
     */
    public ItemGrouper(@Nullable RegistryKey<ItemGroup> super_group) {
        this.super_group = super_group;
    }

    public RegistryKey<ItemGroup> getSuper_group() {
        return super_group;
    }

    public void setSuper_group(RegistryKey<ItemGroup> super_group) {
        this.super_group = super_group;
    }

    /**
     * * Put 'item' in 1 or more groups and, if enabled, into the supergroup.
     * @param item The item to group.
     * @param groups The groups that it goes into.
     */
    public void GroupItem(Item item, ItemGroupItem[] groups) {

        if (super_group != null) {
            ItemGroupEvents.modifyEntriesEvent(super_group).register(content -> {
                content.add(item);
            });
        }

        for (ItemGroupItem group: groups) {

            ItemGroupEvents.modifyEntriesEvent(group.group).register(content -> {
                content.addAfter(group.getItem(), item);
            });
        }

    }

    /**
     * Put 'item' in 1 or more groups and, if enabled, into the supergroup.
     * @param item The block to group.
     * @param groups The groups that it goes into.
     */
    public void GroupItem(Block item, ItemGroupItem[] groups) {

        if (super_group != null) {
            ItemGroupEvents.modifyEntriesEvent(super_group).register(content -> {
                content.add(item);
            });
        }

        for (ItemGroupItem group: groups) {

            ItemGroupEvents.modifyEntriesEvent(group.group).register(content -> {
                content.addAfter(group.getItem(), item);
            });
        }

    }


}
