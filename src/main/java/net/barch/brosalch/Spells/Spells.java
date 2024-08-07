package net.barch.brosalch.Spells;

import net.barch.brosalch.Entities.BoltOfIceEntity;
import net.barch.barch_lib.Items.ItemGroupItem;
import net.barch.brosalch.Miscellaneous.Miscellaneous;
import net.barch.brosalch.Spells.SpellTypes.L0.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.*;

public class Spells {

    public static final int SPELL_COOLDOWN = 60;
    
    public static final SprayBottleItem SPRAY_BOTTLE = new SprayBottleItem(new Item.Settings(). maxCount(1));
    public static final Item AIR_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item BLESSING_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item EARTH_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item ENERGY_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item FIRE_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item HEALING_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item LIGHT_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item WATER_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item WEIGHT_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item CURSE_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item VOID_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item EXHAUSTION_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item COLD_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item HARMING_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item DARKNESS_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item DROUGHT_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));

    public static final SpellExtractItem REGENERATE_LIMBS = new SpellExtractItem(new Item.Settings().maxCount(1).maxDamage(16), new RegenerateLimbs(Miscellaneous.POSITIVE,"healing"));
    public static final SpellExtractItem FIRE_TRICK = new SpellExtractItem(new Item.Settings().maxCount(1).maxDamage(16), new FireTrick(Miscellaneous.NEUTRAL,"fire"));
    public static final SpellExtractItem FLESH_SHIELD = new SpellExtractItem(new Item.Settings().maxCount(1).maxDamage(16), new FleshShield(Miscellaneous.POSITIVE,"blessing"));
    public static final SpellExtractItem BOLT_OF_ICE = new SpellExtractItem(new Item.Settings().maxCount(1).maxDamage(16), new BoltOfIce(Miscellaneous.NEGATIVE,"cold"));
    public static final SpellExtractItem FREEZE = new SpellExtractItem(new Item.Settings().maxCount(1).maxDamage(16), new Freeze(Miscellaneous.NEGATIVE,"curse"));
    public static final SpellExtractItem BIOMECRAFT = new SpellExtractItem(new Item.Settings().maxCount(1).maxDamage(16), new Biomecraft(Miscellaneous.NEUTRAL,"earth"));
    public static final SpellExtractItem DROP_OUT = new SpellExtractItem(new Item.Settings().maxCount(1).maxDamage(16), new DropOut(Miscellaneous.NEUTRAL,"void"));
    public static final SpellExtractItem GILLS = new SpellExtractItem(new Item.Settings().maxCount(1).maxDamage(16), new Gills(Miscellaneous.POSITIVE,"water"));

    public static final EntityType<BoltOfIceEntity> BOLT_OF_ICE_ENTITY_TYPE = FabricEntityTypeBuilder.<BoltOfIceEntity>create(SpawnGroup.MISC, BoltOfIceEntity::new)
            .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
            .trackRangeBlocks(512).trackedUpdateRate(10)
            .build();

    public static void RegisterAll() {
        RegisterItems();
        RegisterEntities();
        GroupItems();
        ParticleFX.onInitialize();
        UnusedItems.RegisterAll();
    }

    public static void RegisterItems() {
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "spray_bottle"), SPRAY_BOTTLE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "air_extract"), AIR_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "blessing_extract"), BLESSING_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "earth_extract"), EARTH_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "energy_extract"), ENERGY_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "fire_extract"), FIRE_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "healing_extract"), HEALING_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "light_extract"), LIGHT_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "water_extract"), WATER_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "weight_extract"), WEIGHT_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "curse_extract"), CURSE_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "void_extract"), VOID_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "exhaustion_extract"), EXHAUSTION_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "cold_extract"), COLD_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "harming_extract"), HARMING_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "darkness_extract"), DARKNESS_EXTRACT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "drought_extract"), DROUGHT_EXTRACT);

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "regenerate_limbs"), REGENERATE_LIMBS);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "fire_trick"), FIRE_TRICK);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "flesh_shield"), FLESH_SHIELD);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "bolt_of_ice"), BOLT_OF_ICE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "freeze"), FREEZE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "biomecraft"), BIOMECRAFT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "drop_out"), DROP_OUT);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "gills"), GILLS);
    }

    public static void RegisterEntities() {
        Registry.register(Registries.ENTITY_TYPE, Identifier.of(NAMESPACE, "bolt_of_ice"), BOLT_OF_ICE_ENTITY_TYPE);
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
        BAItemGrouper.GroupItem(WEIGHT_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, WATER_EXTRACT)});
        BAItemGrouper.GroupItem(CURSE_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, WEIGHT_EXTRACT)});
        BAItemGrouper.GroupItem(VOID_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, CURSE_EXTRACT)});
        BAItemGrouper.GroupItem(EXHAUSTION_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, VOID_EXTRACT)});
        BAItemGrouper.GroupItem(COLD_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, EXHAUSTION_EXTRACT)});
        BAItemGrouper.GroupItem(HARMING_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, COLD_EXTRACT)});
        BAItemGrouper.GroupItem(DARKNESS_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, HARMING_EXTRACT)});
        BAItemGrouper.GroupItem(DROUGHT_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, DARKNESS_EXTRACT)});
        BAItemGrouper.GroupItem(REGENERATE_LIMBS, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, DROUGHT_EXTRACT)});
        BAItemGrouper.GroupItem(FIRE_TRICK, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, REGENERATE_LIMBS)});
        BAItemGrouper.GroupItem(FLESH_SHIELD, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, FIRE_TRICK)});
        BAItemGrouper.GroupItem(BOLT_OF_ICE, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, FLESH_SHIELD)});
        BAItemGrouper.GroupItem(FREEZE, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, BOLT_OF_ICE)});

    }


}
