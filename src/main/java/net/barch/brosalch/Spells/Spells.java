package net.barch.brosalch.Spells;

import net.barch.brosalch.Glue.ItemGroupItem;
import net.barch.brosalch.Miscellaneous.Miscellaneous;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.*;

public class Spells {
    
    public static final SprayBottleItem SPRAY_BOTTLE = new SprayBottleItem(new FabricItemSettings(). maxCount(1));
    public static final SpellExtractItem LIGHT_SPELL = new SpellExtractItem(new FabricItemSettings().maxCount(1).maxDamage(16), new Light(Miscellaneous.POSITIVE,"radiant"));



    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "spray_bottle"), SPRAY_BOTTLE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "light_spell"), LIGHT_SPELL);
    }

    public static void GroupItems() {
        BAItemGrouper.GroupItem(SPRAY_BOTTLE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, Items.GLASS_BOTTLE), new ItemGroupItem(SPELLS_GROUP, Items.AIR)});
        BAItemGrouper.GroupItem(LIGHT_SPELL, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, SPRAY_BOTTLE)});
    }


}
