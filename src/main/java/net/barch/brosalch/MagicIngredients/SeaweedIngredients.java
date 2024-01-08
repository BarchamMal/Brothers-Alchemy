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
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.BAItemGrouper;
import static net.barch.brosalch.BrothersAlchemy.NAMESPACE;
import static net.barch.brosalch.MagicIngredients.SugarIngredients.SUGAR_PULP;
import static net.barch.brosalch.MagicIngredients.SugarIngredients.SUGAR_COOKIE;
import static net.barch.brosalch.MagicIngredients.SugarIngredients.SUGAR_TEA;
import static net.barch.brosalch.MagicIngredients.SugarIngredients.SUGAR_EXTRACT;

public class SeaweedIngredients {


    public static final StatusEffectInstance SEAWEED_TEA_EFFECT = new StatusEffectInstance(StatusEffects.WATER_BREATHING, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance SEAWEED_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.WATER_BREATHING, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent SEAWEED_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().hunger(3).saturationModifier(2).snack().statusEffect(SEAWEED_COOKIE_EFFECT, 1).build();

    public static final Item SEAWEED_PULP = new Item(new FabricItemSettings());
    public static final Item SEAWEED_COOKIE = new Item(new FabricItemSettings().food(SEAWEED_COOKIE_FOOD));
    public static final TeaItem SEAWEED_TEA = new TeaItem(new FabricItemSettings(), SEAWEED_TEA_EFFECT);
    public static final Item SEAWEED_EXTRACT = new Item(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "seaweed_pulp"), SEAWEED_PULP);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "seaweed_cookie"), SEAWEED_COOKIE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "seaweed_tea"), SEAWEED_TEA);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "seaweed_extract"), SEAWEED_EXTRACT);

    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(SEAWEED_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, SUGAR_PULP)});
        BAItemGrouper.GroupItem(SEAWEED_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, SUGAR_COOKIE)});
        BAItemGrouper.GroupItem(SEAWEED_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, SUGAR_TEA)});
        BAItemGrouper.GroupItem(SEAWEED_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, SUGAR_EXTRACT)});

    }

}