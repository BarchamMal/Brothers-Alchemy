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
import static net.barch.brosalch.MagicIngredients.MelonIngredients.MELON_PULP;
import static net.barch.brosalch.MagicIngredients.MelonIngredients.MELON_COOKIE;
import static net.barch.brosalch.MagicIngredients.MelonIngredients.MELON_TEA;
import static net.barch.brosalch.MagicIngredients.MelonIngredients.MELON_EXTRACT;

public class PumpkinIngredients {


    public static final StatusEffectInstance PUMPKIN_TEA_EFFECT = new StatusEffectInstance(StatusEffects.JUMP_BOOST, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance PUMPKIN_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.JUMP_BOOST, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent PUMPKIN_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().hunger(3).saturationModifier(2).snack().statusEffect(PUMPKIN_COOKIE_EFFECT, 1).build();

    public static final Item PUMPKIN_PULP = new Item(new FabricItemSettings());
    public static final Item PUMPKIN_COOKIE = new Item(new FabricItemSettings().food(PUMPKIN_COOKIE_FOOD));
    public static final TeaItem PUMPKIN_TEA = new TeaItem(new FabricItemSettings(), PUMPKIN_TEA_EFFECT);
    public static final Item PUMPKIN_EXTRACT = new Item(new FabricItemSettings());


    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "pumpkin_pulp"), PUMPKIN_PULP);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "pumpkin_cookie"), PUMPKIN_COOKIE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "pumpkin_tea"), PUMPKIN_TEA);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "pumpkin_extract"), PUMPKIN_EXTRACT);

    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(PUMPKIN_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, MELON_PULP)});
        BAItemGrouper.GroupItem(PUMPKIN_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, MELON_COOKIE)});
        BAItemGrouper.GroupItem(PUMPKIN_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, MELON_TEA)});
        BAItemGrouper.GroupItem(PUMPKIN_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, MELON_EXTRACT)});

    }

}