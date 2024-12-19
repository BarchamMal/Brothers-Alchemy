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
import static net.barch.brosalch.MagicIngredients.SugarIngredients.SUGAR_PULP;
import static net.barch.brosalch.MagicIngredients.SugarIngredients.SUGAR_COOKIE;
import static net.barch.brosalch.MagicIngredients.SugarIngredients.SUGAR_TEA;
import static net.barch.brosalch.MagicIngredients.SugarIngredients.SUGAR_EXTRACT;
import static net.barch.brosalch.Miscellaneous.Miscellaneous.getCookieFood;

public class SeaweedIngredients {


    public static final StatusEffectInstance SEAWEED_TEA_EFFECT = new StatusEffectInstance(StatusEffects.WATER_BREATHING, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance SEAWEED_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.WATER_BREATHING, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent SEAWEED_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).build();

    public static final Item SEAWEED_PULP = createItem("seaweed_pulp", Item.class, new Item.Settings());
    public static final Item SEAWEED_COOKIE = createItem("seaweed_cookie", new Item.Settings(), SEAWEED_COOKIE_FOOD, getCookieFood(SEAWEED_COOKIE_EFFECT));
    public static final TeaItem SEAWEED_TEA = createItem("seaweed_tea", new Item.Settings(), SEAWEED_TEA_EFFECT);
    public static final Item SEAWEED_EXTRACT = createItem("seaweed_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        GroupItems();
    }


    public static void GroupItems() {

        BAItemGrouper.GroupItem(SEAWEED_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, SUGAR_PULP)});
        BAItemGrouper.GroupItem(SEAWEED_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, SUGAR_COOKIE)});
        BAItemGrouper.GroupItem(SEAWEED_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, SUGAR_TEA)});
        BAItemGrouper.GroupItem(SEAWEED_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, SUGAR_EXTRACT)});

    }

}