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
import static net.barch.brosalch.MagicIngredients.PotatoIngredients.POTATO_PULP;
import static net.barch.brosalch.MagicIngredients.PotatoIngredients.POTATO_COOKIE;
import static net.barch.brosalch.MagicIngredients.PotatoIngredients.POTATO_TEA;
import static net.barch.brosalch.MagicIngredients.PotatoIngredients.POTATO_EXTRACT;
import static net.barch.brosalch.Miscellaneous.Miscellaneous.getCookieFood;

public class BeetIngredients {


    public static final StatusEffectInstance BEET_TEA_EFFECT = new StatusEffectInstance(StatusEffects.REGENERATION, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance BEET_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.REGENERATION, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent BEET_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).build();

    public static final Item BEET_PULP = createItem("beet_pulp", Item.class, new Item.Settings());
    public static final Item BEET_COOKIE = createItem("beet_cookie", new Item.Settings(), BEET_COOKIE_FOOD, getCookieFood(BEET_COOKIE_EFFECT));
    public static final TeaItem BEET_TEA = createItem("beet_tea", new Item.Settings(), BEET_TEA_EFFECT);
    public static final Item BEET_EXTRACT = createItem("beet_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        GroupItems();
    }


    public static void GroupItems() {

        BAItemGrouper.GroupItem(BEET_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, POTATO_PULP)});
        BAItemGrouper.GroupItem(BEET_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, POTATO_COOKIE)});
        BAItemGrouper.GroupItem(BEET_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, POTATO_TEA)});
        BAItemGrouper.GroupItem(BEET_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, POTATO_EXTRACT)});

    }

}