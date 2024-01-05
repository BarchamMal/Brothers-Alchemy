package net.barch.brosalch.Spells;

import net.barch.brosalch.Glue.ItemGroupItem;
import net.barch.brosalch.Miscellaneous.Miscellaneous;
import net.barch.brosalch.Spells.SpellTypes.Air;
import net.barch.brosalch.Spells.SpellTypes.Fire;
import net.barch.brosalch.Spells.SpellTypes.Light;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.*;

public class Spells {
    
    public static final SprayBottleItem SPRAY_BOTTLE = new SprayBottleItem(new FabricItemSettings(). maxCount(1));
    public static final SpellExtractItem LIGHT_SPELL = new SpellExtractItem(new FabricItemSettings().maxCount(1).maxDamage(16), new Light(Miscellaneous.NEUTRAL,"radiant"));
    public static final SpellExtractItem FIRE_SPELL = new SpellExtractItem(new FabricItemSettings().maxCount(1).maxDamage(16), new Fire(Miscellaneous.NEUTRAL,"fire"));
    public static final SpellExtractItem AIR_SPELL = new SpellExtractItem(new FabricItemSettings().maxCount(1).maxDamage(16), new Air(Miscellaneous.NEUTRAL,"air"));



    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "spray_bottle"), SPRAY_BOTTLE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "light_spell"), LIGHT_SPELL);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "fire_spell"), FIRE_SPELL);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "air_spell"), AIR_SPELL);
    }

    public static void GroupItems() {
        BAItemGrouper.GroupItem(SPRAY_BOTTLE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, Items.GLASS_BOTTLE), new ItemGroupItem(SPELLS_GROUP, Items.AIR)});
        BAItemGrouper.GroupItem(LIGHT_SPELL, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, SPRAY_BOTTLE)});
        BAItemGrouper.GroupItem(FIRE_SPELL, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, LIGHT_SPELL)});
        BAItemGrouper.GroupItem(AIR_SPELL, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, FIRE_SPELL)});
    }


}
