package net.barch.brosalch.MagicIngredients;

import net.barch.brosalch.Glue.ItemGroupItem;
import net.barch.brosalch.Miscellaneous.Miscellaneous;
import net.barch.brosalch.TeaItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.BAItemGrouper;
import static net.barch.brosalch.BrothersAlchemy.NAMESPACE;

public class CarrotIngredients {


    public static final StatusEffectInstance CARROT_TEA_EFFECT = new StatusEffectInstance(StatusEffects.NIGHT_VISION, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance CARROT_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.NIGHT_VISION, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent CARROT_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().hunger(3).saturationModifier(2).snack().statusEffect(CARROT_COOKIE_EFFECT, 1).build();

    public static final Item CARROT_PULP = new Item(new FabricItemSettings());
    public static final Item CARROT_COOKIE = new Item(new FabricItemSettings().food(CARROT_COOKIE_FOOD));
    public static final TeaItem CARROT_TEA = new TeaItem(new FabricItemSettings(), CARROT_TEA_EFFECT);
    public static final Item CARROT_EXTRACT = new Item(new FabricItemSettings());


    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "carrot_pulp"), CARROT_PULP);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "carrot_cookie"), CARROT_COOKIE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "carrot_tea"), CARROT_TEA);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "carrot_extract"), CARROT_EXTRACT);

    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(CARROT_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, Items.PINK_DYE)});
        BAItemGrouper.GroupItem(CARROT_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, Items.COOKIE)});
        BAItemGrouper.GroupItem(CARROT_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, Items.HONEY_BOTTLE)});
        BAItemGrouper.GroupItem(CARROT_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, Items.PHANTOM_MEMBRANE)});

    }

}
