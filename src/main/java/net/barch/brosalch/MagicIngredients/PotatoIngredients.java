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
import static net.barch.brosalch.MagicIngredients.MushroomIngredients.MUSHROOM_PULP;
import static net.barch.brosalch.MagicIngredients.MushroomIngredients.MUSHROOM_COOKIE;
import static net.barch.brosalch.MagicIngredients.MushroomIngredients.MUSHROOM_TEA;
import static net.barch.brosalch.MagicIngredients.MushroomIngredients.MUSHROOM_EXTRACT;
import static net.barch.brosalch.Miscellaneous.Miscellaneous.getCookieFood;

public class PotatoIngredients {


    public static final StatusEffectInstance POTATO_TEA_EFFECT = new StatusEffectInstance(StatusEffects.ABSORPTION, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance POTATO_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.ABSORPTION, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent POTATO_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).build();

    public static final Item POTATO_PULP = createItem("potato_pulp", Item.class, new Item.Settings());
    public static final Item POTATO_COOKIE = createItem("potato_cookie", new Item.Settings(), POTATO_COOKIE_FOOD, getCookieFood(POTATO_COOKIE_EFFECT));
    public static final TeaItem POTATO_TEA = createItem("potato_tea", new Item.Settings(), POTATO_TEA_EFFECT);
    public static final Item POTATO_EXTRACT = createItem("potato_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        GroupItems();
    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(POTATO_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, MUSHROOM_PULP)});
        BAItemGrouper.GroupItem(POTATO_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, MUSHROOM_COOKIE)});
        BAItemGrouper.GroupItem(POTATO_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, MUSHROOM_TEA)});
        BAItemGrouper.GroupItem(POTATO_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, MUSHROOM_EXTRACT)});

    }

}