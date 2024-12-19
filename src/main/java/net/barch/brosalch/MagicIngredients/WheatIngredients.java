package net.barch.brosalch.MagicIngredients;

import net.barch.barch_lib.Items.ItemGroupItem;
import net.barch.brosalch.Miscellaneous.Miscellaneous;
import net.barch.brosalch.TeaItem;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.*;
import static net.barch.brosalch.BrothersAlchemy.createItem;
import static net.barch.brosalch.MagicIngredients.AppleIngredients.APPLE_PULP;
import static net.barch.brosalch.MagicIngredients.AppleIngredients.APPLE_COOKIE;
import static net.barch.brosalch.MagicIngredients.AppleIngredients.APPLE_TEA;
import static net.barch.brosalch.MagicIngredients.AppleIngredients.APPLE_EXTRACT;
import static net.barch.brosalch.Miscellaneous.Miscellaneous.getCookieFood;

public class WheatIngredients {


    public static final StatusEffectInstance WHEAT_TEA_EFFECT = new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance WHEAT_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent WHEAT_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).build();

    public static final Item WHEAT_PULP = createItem("wheat_pulp", Item.class, new Item.Settings());
    public static final Item WHEAT_COOKIE = createItem("wheat_cookie", new Item.Settings(), WHEAT_COOKIE_FOOD, getCookieFood(WHEAT_COOKIE_EFFECT));
    public static final TeaItem WHEAT_TEA = createItem("wheat_tea", new Item.Settings(), WHEAT_TEA_EFFECT);
    public static final Item WHEAT_EXTRACT = createItem("wheat_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        GroupItems();
    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(WHEAT_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, APPLE_PULP)});
        BAItemGrouper.GroupItem(WHEAT_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, APPLE_COOKIE)});
        BAItemGrouper.GroupItem(WHEAT_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, APPLE_TEA)});
        BAItemGrouper.GroupItem(WHEAT_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, APPLE_EXTRACT)});

    }

}