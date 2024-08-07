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
import static net.barch.brosalch.MagicIngredients.BeetIngredients.BEET_PULP;
import static net.barch.brosalch.MagicIngredients.BeetIngredients.BEET_COOKIE;
import static net.barch.brosalch.MagicIngredients.BeetIngredients.BEET_TEA;
import static net.barch.brosalch.MagicIngredients.BeetIngredients.BEET_EXTRACT;

public class SweetBerryIngredients {


    public static final StatusEffectInstance SWEET_BERRY_TEA_EFFECT = new StatusEffectInstance(StatusEffects.HASTE, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance SWEET_BERRY_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.HASTE, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent SWEET_BERRY_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).snack().statusEffect(SWEET_BERRY_COOKIE_EFFECT, 1).build();

    public static final Item SWEET_BERRY_PULP = new Item(new Item.Settings());
    public static final Item SWEET_BERRY_COOKIE = new Item(new Item.Settings().food(SWEET_BERRY_COOKIE_FOOD));
    public static final TeaItem SWEET_BERRY_TEA = new TeaItem(new Item.Settings(), SWEET_BERRY_TEA_EFFECT);
    public static final Item SWEET_BERRY_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sweet_berry_pulp"), SWEET_BERRY_PULP);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sweet_berry_cookie"), SWEET_BERRY_COOKIE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sweet_berry_tea"), SWEET_BERRY_TEA);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sweet_berry_extract"), SWEET_BERRY_EXTRACT);

    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(SWEET_BERRY_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, BEET_PULP)});
        BAItemGrouper.GroupItem(SWEET_BERRY_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, BEET_COOKIE)});
        BAItemGrouper.GroupItem(SWEET_BERRY_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, BEET_TEA)});
        BAItemGrouper.GroupItem(SWEET_BERRY_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, BEET_EXTRACT)});

    }

}