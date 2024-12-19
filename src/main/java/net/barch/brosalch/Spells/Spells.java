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
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.*;

public class Spells {

    public static final int SPELL_COOLDOWN = 60;
    
    public static final SprayBottleItem SPRAY_BOTTLE = (SprayBottleItem) createItem("spray_bottle", SprayBottleItem.class, new Item.Settings().maxCount(1));
    public static final Item AIR_EXTRACT = createItem("air_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item BLESSING_EXTRACT = createItem("blessing_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item EARTH_EXTRACT = createItem("earth_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item ENERGY_EXTRACT = createItem("energy_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item FIRE_EXTRACT = createItem("fire_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item HEALING_EXTRACT = createItem("healing_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item LIGHT_EXTRACT = createItem("light_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item WATER_EXTRACT = createItem("water_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item WEIGHT_EXTRACT = createItem("weight_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item CURSE_EXTRACT = createItem("curse_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item VOID_EXTRACT = createItem("void_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item EXHAUSTION_EXTRACT = createItem("exhaustion_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item COLD_EXTRACT = createItem("cold_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item HARMING_EXTRACT = createItem("harming_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item DARKNESS_EXTRACT = createItem("darkness_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item DROUGHT_EXTRACT = createItem("drought_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));

    public static final SpellExtractItem REGENERATE_LIMBS = createItem("regenerate_limbs", new Item.Settings().maxCount(1).maxDamage(16), new RegenerateLimbs(Miscellaneous.POSITIVE,"healing"));
    public static final SpellExtractItem FIRE_TRICK = createItem("fire_trick", new Item.Settings().maxCount(1).maxDamage(16), new FireTrick(Miscellaneous.NEUTRAL,"fire"));
    public static final SpellExtractItem FLESH_SHIELD = createItem("flesh_shield", new Item.Settings().maxCount(1).maxDamage(16), new FleshShield(Miscellaneous.POSITIVE,"blessing"));
    public static final SpellExtractItem BOLT_OF_ICE = createItem("bolt_of_ice", new Item.Settings().maxCount(1).maxDamage(16), new BoltOfIce(Miscellaneous.NEGATIVE,"cold"));
    public static final SpellExtractItem FREEZE = createItem("freeze", new Item.Settings().maxCount(1).maxDamage(16), new Freeze(Miscellaneous.NEGATIVE,"curse"));
    public static final SpellExtractItem BIOMECRAFT = createItem("biomecraft", new Item.Settings().maxCount(1).maxDamage(16), new Biomecraft(Miscellaneous.NEUTRAL,"earth"));
    public static final SpellExtractItem DROP_OUT = createItem("drop_out", new Item.Settings().maxCount(1).maxDamage(16), new DropOut(Miscellaneous.NEUTRAL,"void"));
    public static final SpellExtractItem GILLS = createItem("gills", new Item.Settings().maxCount(1).maxDamage(16), new Gills(Miscellaneous.POSITIVE,"water"));

    public static final EntityType<BoltOfIceEntity> BOLT_OF_ICE_ENTITY_TYPE = EntityType.Builder.<BoltOfIceEntity>create(SpawnGroup.MISC)
            .dimensions(0.25f, 0.25f)
            .maxTrackingRange(512)
            .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(NAMESPACE, "bolt_of_ice_entity")));

    public static void RegisterAll() {
        RegisterEntities();
        GroupItems();
        ParticleFX.onInitialize();
        UnusedItems.RegisterAll();
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
        BAItemGrouper.GroupItem(BIOMECRAFT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, FREEZE)});
        BAItemGrouper.GroupItem(DROP_OUT, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, BIOMECRAFT)});
        BAItemGrouper.GroupItem(GILLS, new ItemGroupItem[]{new ItemGroupItem(SPELLS_GROUP, DROP_OUT)});

    }


}
