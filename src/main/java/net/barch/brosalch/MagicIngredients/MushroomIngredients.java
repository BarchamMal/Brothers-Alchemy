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

import static net.barch.brosalch.BrothersAlchemy.BAItemGrouper;
import static net.barch.brosalch.BrothersAlchemy.NAMESPACE;
import static net.barch.brosalch.MagicIngredients.WheatIngredients.WHEAT_PULP;
import static net.barch.brosalch.MagicIngredients.WheatIngredients.WHEAT_COOKIE;
import static net.barch.brosalch.MagicIngredients.WheatIngredients.WHEAT_TEA;
import static net.barch.brosalch.MagicIngredients.WheatIngredients.WHEAT_EXTRACT;

public class MushroomIngredients {


    public static final StatusEffectInstance MUSHROOM_TEA_EFFECT = new StatusEffectInstance(StatusEffects.SATURATION, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance MUSHROOM_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.SATURATION, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent MUSHROOM_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).snack().statusEffect(MUSHROOM_COOKIE_EFFECT, 1).build();

    public static final Item MUSHROOM_PULP = new Item(new Item.Settings());
    public static final Item MUSHROOM_COOKIE = new Item(new Item.Settings().food(MUSHROOM_COOKIE_FOOD));
    public static final TeaItem MUSHROOM_TEA = new TeaItem(new Item.Settings(), MUSHROOM_TEA_EFFECT);
    public static final Item MUSHROOM_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "mushroom_pulp"), MUSHROOM_PULP);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "mushroom_cookie"), MUSHROOM_COOKIE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "mushroom_tea"), MUSHROOM_TEA);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "mushroom_extract"), MUSHROOM_EXTRACT);

    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(MUSHROOM_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, WHEAT_PULP)});
        BAItemGrouper.GroupItem(MUSHROOM_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, WHEAT_COOKIE)});
        BAItemGrouper.GroupItem(MUSHROOM_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, WHEAT_TEA)});
        BAItemGrouper.GroupItem(MUSHROOM_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, WHEAT_EXTRACT)});

    }

}