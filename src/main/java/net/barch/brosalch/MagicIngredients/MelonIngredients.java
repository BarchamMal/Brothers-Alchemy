package net.barch.brosalch.MagicIngredients;

import net.barch.brosalch.Glue.ItemGroupItem;
import net.barch.brosalch.Miscellaneous;
import net.barch.brosalch.TeaItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.BAItemGrouper;
import static net.barch.brosalch.BrothersAlchemy.NAMESPACE;
import static net.barch.brosalch.MagicIngredients.SweetBerryIngredients.SWEET_BERRY_PULP;
import static net.barch.brosalch.MagicIngredients.SweetBerryIngredients.SWEET_BERRY_COOKIE;
import static net.barch.brosalch.MagicIngredients.SweetBerryIngredients.SWEET_BERRY_TEA;
import static net.barch.brosalch.MagicIngredients.SweetBerryIngredients.SWEET_BERRY_EXTRACT;

public class MelonIngredients {


    public static final StatusEffectInstance MELON_TEA_EFFECT = new StatusEffectInstance(StatusEffects.SLOW_FALLING, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance MELON_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.SLOW_FALLING, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent MELON_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().hunger(3).saturationModifier(2).snack().statusEffect(MELON_COOKIE_EFFECT, 1).build();

    public static final Item MELON_PULP = new Item(new FabricItemSettings());
    public static final Item MELON_COOKIE = new Item(new FabricItemSettings().food(MELON_COOKIE_FOOD));
    public static final TeaItem MELON_TEA = new TeaItem(new FabricItemSettings(), MELON_TEA_EFFECT);
    public static final Item MELON_EXTRACT = new Item(new FabricItemSettings());


    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "melon_pulp"), MELON_PULP);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "melon_cookie"), MELON_COOKIE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "melon_tea"), MELON_TEA);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "melon_extract"), MELON_EXTRACT);

    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(MELON_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, SWEET_BERRY_PULP)});
        BAItemGrouper.GroupItem(MELON_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, SWEET_BERRY_COOKIE)});
        BAItemGrouper.GroupItem(MELON_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, SWEET_BERRY_TEA)});
        BAItemGrouper.GroupItem(MELON_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, SWEET_BERRY_EXTRACT)});

    }

}