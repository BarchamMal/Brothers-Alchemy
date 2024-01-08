package net.barch.brosalch.Spells;

import net.barch.brosalch.Glue.ItemGroupItem;
import net.barch.brosalch.Miscellaneous.Miscellaneous;
import net.barch.brosalch.Spells.SpellTypes.Air;
import net.barch.brosalch.Spells.SpellTypes.Blessing;
import net.barch.brosalch.Spells.SpellTypes.Fire;
import net.barch.brosalch.Spells.SpellTypes.Light;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.*;

public class Spells {
    
    public static final SprayBottleItem SPRAY_BOTTLE = new SprayBottleItem(new FabricItemSettings(). maxCount(1));
    public static final Item AIR_EXTRACT = new Item(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item BLESSING_EXTRACT = new Item(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item EARTH_EXTRACT = new Item(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item ENERGY_EXTRACT = new Item(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item FIRE_EXTRACT = new Item(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item HEALING_EXTRACT = new Item(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item LIGHT_EXTRACT = new Item(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item WATER_EXTRACT = new Item(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE));



    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "spray_bottle"), SPRAY_BOTTLE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "air_extract"), AIR_EXTRACT);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "blessing_extract"), BLESSING_EXTRACT);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "earth_extract"), EARTH_EXTRACT);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "energy_extract"), ENERGY_EXTRACT);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "fire_extract"), FIRE_EXTRACT);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "healing_extract"), HEALING_EXTRACT);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "light_extract"), LIGHT_EXTRACT);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "water_extract"), WATER_EXTRACT);
    }

    public static void GroupItems() {
        BAItemGrouper.GroupItem(SPRAY_BOTTLE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, Items.GLASS_BOTTLE), new ItemGroupItem(SPELLS_GROUP, Items.AIR)});
        BAItemGrouper.GroupItem(AIR_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, SPRAY_BOTTLE)});
        BAItemGrouper.GroupItem(BLESSING_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, AIR_EXTRACT)});
        BAItemGrouper.GroupItem(EARTH_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, BLESSING_EXTRACT)});
        BAItemGrouper.GroupItem(ENERGY_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, EARTH_EXTRACT)});
        BAItemGrouper.GroupItem(FIRE_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, ENERGY_EXTRACT)});
        BAItemGrouper.GroupItem(HEALING_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, FIRE_EXTRACT)});
        BAItemGrouper.GroupItem(LIGHT_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, HEALING_EXTRACT)});
        BAItemGrouper.GroupItem(WATER_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, LIGHT_EXTRACT)});
    }


}
