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
import static net.barch.brosalch.MagicIngredients.PumpkinIngredients.PUMPKIN_PULP;
import static net.barch.brosalch.MagicIngredients.PumpkinIngredients.PUMPKIN_COOKIE;
import static net.barch.brosalch.MagicIngredients.PumpkinIngredients.PUMPKIN_TEA;
import static net.barch.brosalch.MagicIngredients.PumpkinIngredients.PUMPKIN_EXTRACT;
import static net.barch.brosalch.Miscellaneous.Miscellaneous.getCookieFood;

public class CocoaIngredients {


    public static final StatusEffectInstance COCOA_TEA_EFFECT = new StatusEffectInstance(StatusEffects.STRENGTH, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance COCOA_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.STRENGTH, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent COCOA_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).build();

    public static final Item COCOA_PULP = createItem("cocoa_pulp", Item.class, new Item.Settings());
    public static final Item COCOA_COOKIE = createItem("cocoa_cookie", new Item.Settings(), COCOA_COOKIE_FOOD, getCookieFood(COCOA_COOKIE_EFFECT));
    public static final TeaItem COCOA_TEA = createItem("cocoa_tea", new Item.Settings(), COCOA_TEA_EFFECT);
    public static final Item COCOA_EXTRACT = createItem("cocoa_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        GroupItems();
    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(COCOA_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, PUMPKIN_PULP)});
        BAItemGrouper.GroupItem(COCOA_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, PUMPKIN_COOKIE)});
        BAItemGrouper.GroupItem(COCOA_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, PUMPKIN_TEA)});
        BAItemGrouper.GroupItem(COCOA_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, PUMPKIN_EXTRACT)});

    }

}