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
import static net.barch.brosalch.MagicIngredients.CarrotIngredients.CARROT_PULP;
import static net.barch.brosalch.MagicIngredients.CarrotIngredients.CARROT_COOKIE;
import static net.barch.brosalch.MagicIngredients.CarrotIngredients.CARROT_TEA;
import static net.barch.brosalch.MagicIngredients.CarrotIngredients.CARROT_EXTRACT;
import static net.barch.brosalch.Miscellaneous.Miscellaneous.getCookieFood;

public class
SugarIngredients {


    public static final StatusEffectInstance SUGAR_TEA_EFFECT = new StatusEffectInstance(StatusEffects.SPEED, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance SUGAR_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.SPEED, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent SUGAR_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).build();

    public static final Item SUGAR_PULP = createItem("sugar_pulp", Item.class, new Item.Settings());
    public static final Item SUGAR_COOKIE = createItem("sugar_cookie", new Item.Settings(), SUGAR_COOKIE_FOOD, getCookieFood(SUGAR_COOKIE_EFFECT));
    public static final TeaItem SUGAR_TEA = createItem("sugar_tea", new Item.Settings(), SUGAR_TEA_EFFECT);
    public static final Item SUGAR_EXTRACT = createItem("sugar_extract", Item.class, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        GroupItems();
    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(SUGAR_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, CARROT_PULP)});
        BAItemGrouper.GroupItem(SUGAR_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, CARROT_COOKIE)});
        BAItemGrouper.GroupItem(SUGAR_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, CARROT_TEA)});
        BAItemGrouper.GroupItem(SUGAR_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, CARROT_EXTRACT)});

    }

}