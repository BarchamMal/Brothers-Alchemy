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
import static net.barch.brosalch.MagicIngredients.CarrotIngredients.CARROT_PULP;
import static net.barch.brosalch.MagicIngredients.CarrotIngredients.CARROT_COOKIE;
import static net.barch.brosalch.MagicIngredients.CarrotIngredients.CARROT_TEA;
import static net.barch.brosalch.MagicIngredients.CarrotIngredients.CARROT_EXTRACT;

public class
SugarIngredients {


    public static final StatusEffectInstance SUGAR_TEA_EFFECT = new StatusEffectInstance(StatusEffects.SPEED, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance SUGAR_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.SPEED, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent SUGAR_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).snack().statusEffect(SUGAR_COOKIE_EFFECT, 1).build();

    public static final Item SUGAR_PULP = new Item(new Item.Settings());
    public static final Item SUGAR_COOKIE = new Item(new Item.Settings().food(SUGAR_COOKIE_FOOD));
    public static final TeaItem SUGAR_TEA = new TeaItem(new Item.Settings(), SUGAR_TEA_EFFECT);
    public static final Item SUGAR_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sugar_pulp"), SUGAR_PULP);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sugar_cookie"), SUGAR_COOKIE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sugar_tea"), SUGAR_TEA);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "sugar_extract"), SUGAR_EXTRACT);

    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(SUGAR_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, CARROT_PULP)});
        BAItemGrouper.GroupItem(SUGAR_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, CARROT_COOKIE)});
        BAItemGrouper.GroupItem(SUGAR_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, CARROT_TEA)});
        BAItemGrouper.GroupItem(SUGAR_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, CARROT_EXTRACT)});

    }

}