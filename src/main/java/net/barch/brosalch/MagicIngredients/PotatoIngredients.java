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
import static net.barch.brosalch.MagicIngredients.MushroomIngredients.MUSHROOM_PULP;
import static net.barch.brosalch.MagicIngredients.MushroomIngredients.MUSHROOM_COOKIE;
import static net.barch.brosalch.MagicIngredients.MushroomIngredients.MUSHROOM_TEA;
import static net.barch.brosalch.MagicIngredients.MushroomIngredients.MUSHROOM_EXTRACT;

public class PotatoIngredients {


    public static final StatusEffectInstance POTATO_TEA_EFFECT = new StatusEffectInstance(StatusEffects.ABSORPTION, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance POTATO_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.ABSORPTION, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent POTATO_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().hunger(3).saturationModifier(2).snack().statusEffect(POTATO_COOKIE_EFFECT, 1).build();

    public static final Item POTATO_PULP = new Item(new FabricItemSettings());
    public static final Item POTATO_COOKIE = new Item(new FabricItemSettings().food(POTATO_COOKIE_FOOD));
    public static final TeaItem POTATO_TEA = new TeaItem(new FabricItemSettings(), POTATO_TEA_EFFECT);
    public static final Item POTATO_EXTRACT = new Item(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "potato_pulp"), POTATO_PULP);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "potato_cookie"), POTATO_COOKIE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "potato_tea"), POTATO_TEA);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "potato_extract"), POTATO_EXTRACT);

    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(POTATO_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, MUSHROOM_PULP)});
        BAItemGrouper.GroupItem(POTATO_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, MUSHROOM_COOKIE)});
        BAItemGrouper.GroupItem(POTATO_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, MUSHROOM_TEA)});
        BAItemGrouper.GroupItem(POTATO_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, MUSHROOM_EXTRACT)});

    }

}