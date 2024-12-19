package net.barch.brosalch.MagicIngredients;

import net.barch.barch_lib.Items.ItemGroupItem;
import net.barch.brosalch.Miscellaneous.Miscellaneous;
import net.barch.brosalch.TeaItem;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.*;
import static net.barch.brosalch.BrothersAlchemy.createItem;
import static net.barch.brosalch.MagicIngredients.SeaweedIngredients.SEAWEED_PULP;
import static net.barch.brosalch.MagicIngredients.SeaweedIngredients.SEAWEED_COOKIE;
import static net.barch.brosalch.MagicIngredients.SeaweedIngredients.SEAWEED_TEA;
import static net.barch.brosalch.MagicIngredients.SeaweedIngredients.SEAWEED_EXTRACT;
import static net.barch.brosalch.Miscellaneous.Miscellaneous.getCookieFood;

public class ChorusIngredients {


    public static final StatusEffectInstance CHORUS_TEA_EFFECT = new StatusEffectInstance(StatusEffects.LEVITATION, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance CHORUS_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.LEVITATION, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent CHORUS_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).build();

    public static final Item CHORUS_PULP = createItem("chorus_pulp", Item.class, new Item.Settings());
    public static final Item CHORUS_COOKIE = createItem("chorus_cookie", new Item.Settings(), CHORUS_COOKIE_FOOD, getCookieFood(CHORUS_COOKIE_EFFECT));
    public static final TeaItem CHORUS_TEA = createItem("chorus_tea", new Item.Settings(), CHORUS_TEA_EFFECT);
    public static final Item CHORUS_EXTRACT = createItem("chorus_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        GroupItems();
    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(CHORUS_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, SEAWEED_PULP)});
        BAItemGrouper.GroupItem(CHORUS_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, SEAWEED_COOKIE)});
        BAItemGrouper.GroupItem(CHORUS_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, SEAWEED_TEA)});
        BAItemGrouper.GroupItem(CHORUS_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, SEAWEED_EXTRACT)});

    }

}