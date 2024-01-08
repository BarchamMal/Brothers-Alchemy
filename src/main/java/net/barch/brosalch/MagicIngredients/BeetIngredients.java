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
import static net.barch.brosalch.MagicIngredients.PotatoIngredients.POTATO_PULP;
import static net.barch.brosalch.MagicIngredients.PotatoIngredients.POTATO_COOKIE;
import static net.barch.brosalch.MagicIngredients.PotatoIngredients.POTATO_TEA;
import static net.barch.brosalch.MagicIngredients.PotatoIngredients.POTATO_EXTRACT;

public class BeetIngredients {


    public static final StatusEffectInstance BEET_TEA_EFFECT = new StatusEffectInstance(StatusEffects.REGENERATION, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance BEET_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.REGENERATION, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent BEET_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().hunger(3).saturationModifier(2).snack().statusEffect(BEET_COOKIE_EFFECT, 1).build();

    public static final Item BEET_PULP = new Item(new FabricItemSettings());
    public static final Item BEET_COOKIE = new Item(new FabricItemSettings().food(BEET_COOKIE_FOOD));
    public static final TeaItem BEET_TEA = new TeaItem(new FabricItemSettings(), BEET_TEA_EFFECT);
    public static final Item BEET_EXTRACT = new Item(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "beet_pulp"), BEET_PULP);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "beet_cookie"), BEET_COOKIE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "beet_tea"), BEET_TEA);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "beet_extract"), BEET_EXTRACT);

    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(BEET_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, POTATO_PULP)});
        BAItemGrouper.GroupItem(BEET_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, POTATO_COOKIE)});
        BAItemGrouper.GroupItem(BEET_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, POTATO_TEA)});
        BAItemGrouper.GroupItem(BEET_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, POTATO_EXTRACT)});

    }

}