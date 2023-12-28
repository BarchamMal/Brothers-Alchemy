package net.barch.brosalch.MagicIngredients;

import net.barch.brosalch.Glue.ItemGroupItem;
import net.barch.brosalch.Miscellaneous.Miscellaneous;
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
import static net.barch.brosalch.MagicIngredients.PumpkinIngredients.PUMPKIN_PULP;
import static net.barch.brosalch.MagicIngredients.PumpkinIngredients.PUMPKIN_COOKIE;
import static net.barch.brosalch.MagicIngredients.PumpkinIngredients.PUMPKIN_TEA;
import static net.barch.brosalch.MagicIngredients.PumpkinIngredients.PUMPKIN_EXTRACT;

public class CocoaIngredients {


    public static final StatusEffectInstance COCOA_TEA_EFFECT = new StatusEffectInstance(StatusEffects.STRENGTH, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance COCOA_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.STRENGTH, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent COCOA_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().hunger(3).saturationModifier(2).snack().statusEffect(COCOA_COOKIE_EFFECT, 1).build();

    public static final Item COCOA_PULP = new Item(new FabricItemSettings());
    public static final Item COCOA_COOKIE = new Item(new FabricItemSettings().food(COCOA_COOKIE_FOOD));
    public static final TeaItem COCOA_TEA = new TeaItem(new FabricItemSettings(), COCOA_TEA_EFFECT);
    public static final Item COCOA_EXTRACT = new Item(new FabricItemSettings());


    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "cocoa_pulp"), COCOA_PULP);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "cocoa_cookie"), COCOA_COOKIE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "cocoa_tea"), COCOA_TEA);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "cocoa_extract"), COCOA_EXTRACT);

    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(COCOA_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, PUMPKIN_PULP)});
        BAItemGrouper.GroupItem(COCOA_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, PUMPKIN_COOKIE)});
        BAItemGrouper.GroupItem(COCOA_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, PUMPKIN_TEA)});
        BAItemGrouper.GroupItem(COCOA_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, PUMPKIN_EXTRACT)});

    }

}