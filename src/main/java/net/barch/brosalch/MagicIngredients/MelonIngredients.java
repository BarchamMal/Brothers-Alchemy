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
import static net.barch.brosalch.MagicIngredients.SweetBerryIngredients.SWEET_BERRY_PULP;
import static net.barch.brosalch.MagicIngredients.SweetBerryIngredients.SWEET_BERRY_COOKIE;
import static net.barch.brosalch.MagicIngredients.SweetBerryIngredients.SWEET_BERRY_TEA;
import static net.barch.brosalch.MagicIngredients.SweetBerryIngredients.SWEET_BERRY_EXTRACT;
import static net.barch.brosalch.Miscellaneous.Miscellaneous.getCookieFood;

public class MelonIngredients {


    public static final StatusEffectInstance MELON_TEA_EFFECT = new StatusEffectInstance(StatusEffects.SLOW_FALLING, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance MELON_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.SLOW_FALLING, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent MELON_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).build();

    public static final Item MELON_PULP = createItem("melon_pulp", Item.class, new Item.Settings());
    public static final Item MELON_COOKIE = createItem("melon_cookie", new Item.Settings(), MELON_COOKIE_FOOD, getCookieFood(MELON_COOKIE_EFFECT));
    public static final TeaItem MELON_TEA = createItem("melon_tea", new Item.Settings(), MELON_TEA_EFFECT);
    public static final Item MELON_EXTRACT = createItem("melon_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        GroupItems();
    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(MELON_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, SWEET_BERRY_PULP)});
        BAItemGrouper.GroupItem(MELON_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, SWEET_BERRY_COOKIE)});
        BAItemGrouper.GroupItem(MELON_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, SWEET_BERRY_TEA)});
        BAItemGrouper.GroupItem(MELON_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, SWEET_BERRY_EXTRACT)});

    }

}