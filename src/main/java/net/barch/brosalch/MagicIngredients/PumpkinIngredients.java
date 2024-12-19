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
import static net.barch.brosalch.MagicIngredients.MelonIngredients.MELON_PULP;
import static net.barch.brosalch.MagicIngredients.MelonIngredients.MELON_COOKIE;
import static net.barch.brosalch.MagicIngredients.MelonIngredients.MELON_TEA;
import static net.barch.brosalch.MagicIngredients.MelonIngredients.MELON_EXTRACT;
import static net.barch.brosalch.Miscellaneous.Miscellaneous.getCookieFood;

public class PumpkinIngredients {


    public static final StatusEffectInstance PUMPKIN_TEA_EFFECT = new StatusEffectInstance(StatusEffects.JUMP_BOOST, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance PUMPKIN_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.JUMP_BOOST, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent PUMPKIN_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).build();

    public static final Item PUMPKIN_PULP = createItem("pumpkin_pulp", Item.class, new Item.Settings());
    public static final Item PUMPKIN_COOKIE = createItem("pumpkin_cookie", new Item.Settings(), PUMPKIN_COOKIE_FOOD, getCookieFood(PUMPKIN_COOKIE_EFFECT));
    public static final TeaItem PUMPKIN_TEA = createItem("pumpkin_tea", new Item.Settings(), PUMPKIN_TEA_EFFECT);
    public static final Item PUMPKIN_EXTRACT = createItem("pumpkin_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        GroupItems();
    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(PUMPKIN_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, MELON_PULP)});
        BAItemGrouper.GroupItem(PUMPKIN_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, MELON_COOKIE)});
        BAItemGrouper.GroupItem(PUMPKIN_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, MELON_TEA)});
        BAItemGrouper.GroupItem(PUMPKIN_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, MELON_EXTRACT)});

    }

}