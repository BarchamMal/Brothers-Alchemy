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
import static net.barch.brosalch.MagicIngredients.GlowBerryIngredients.GLOW_BERRY_PULP;
import static net.barch.brosalch.MagicIngredients.GlowBerryIngredients.GLOW_BERRY_COOKIE;
import static net.barch.brosalch.MagicIngredients.GlowBerryIngredients.GLOW_BERRY_TEA;
import static net.barch.brosalch.MagicIngredients.GlowBerryIngredients.GLOW_BERRY_EXTRACT;

public class AppleIngredients {


    public static final StatusEffectInstance APPLE_TEA_EFFECT = new StatusEffectInstance(StatusEffects.LUCK, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance APPLE_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.LUCK, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent APPLE_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).snack().statusEffect(APPLE_COOKIE_EFFECT, 1).build();

    public static final Item APPLE_PULP = new Item(new Item.Settings());
    public static final Item APPLE_COOKIE = new Item(new Item.Settings().food(APPLE_COOKIE_FOOD));
    public static final TeaItem APPLE_TEA = new TeaItem(new Item.Settings(), APPLE_TEA_EFFECT);
    public static final Item APPLE_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "apple_pulp"), APPLE_PULP);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "apple_cookie"), APPLE_COOKIE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "apple_tea"), APPLE_TEA);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "apple_extract"), APPLE_EXTRACT);

    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(APPLE_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, GLOW_BERRY_PULP)});
        BAItemGrouper.GroupItem(APPLE_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, GLOW_BERRY_COOKIE)});
        BAItemGrouper.GroupItem(APPLE_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, GLOW_BERRY_TEA)});
        BAItemGrouper.GroupItem(APPLE_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, GLOW_BERRY_EXTRACT)});

    }

}