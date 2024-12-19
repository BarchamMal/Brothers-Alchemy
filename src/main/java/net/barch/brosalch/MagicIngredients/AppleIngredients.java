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

import static net.barch.brosalch.BrothersAlchemy.*;
import static net.barch.brosalch.BrothersAlchemy.createItem;
import static net.barch.brosalch.MagicIngredients.GlowBerryIngredients.GLOW_BERRY_PULP;
import static net.barch.brosalch.MagicIngredients.GlowBerryIngredients.GLOW_BERRY_COOKIE;
import static net.barch.brosalch.MagicIngredients.GlowBerryIngredients.GLOW_BERRY_TEA;
import static net.barch.brosalch.MagicIngredients.GlowBerryIngredients.GLOW_BERRY_EXTRACT;
import static net.barch.brosalch.Miscellaneous.Miscellaneous.getCookieFood;

public class AppleIngredients {


    public static final StatusEffectInstance APPLE_TEA_EFFECT = new StatusEffectInstance(StatusEffects.LUCK, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance APPLE_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.LUCK, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent APPLE_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).build();

    public static final Item APPLE_PULP = createItem("apple_pulp", Item.class, new Item.Settings());
    public static final Item APPLE_COOKIE = createItem("apple_cookie", new Item.Settings(), APPLE_COOKIE_FOOD, getCookieFood(APPLE_COOKIE_EFFECT));
    public static final TeaItem APPLE_TEA = createItem("apple_tea", new Item.Settings(), APPLE_TEA_EFFECT);
    public static final Item APPLE_EXTRACT = createItem("apple_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        GroupItems();
    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(APPLE_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, GLOW_BERRY_PULP)});
        BAItemGrouper.GroupItem(APPLE_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, GLOW_BERRY_COOKIE)});
        BAItemGrouper.GroupItem(APPLE_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, GLOW_BERRY_TEA)});
        BAItemGrouper.GroupItem(APPLE_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, GLOW_BERRY_EXTRACT)});

    }

}