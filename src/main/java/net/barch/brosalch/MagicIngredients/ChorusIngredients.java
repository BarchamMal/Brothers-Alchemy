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
import static net.barch.brosalch.MagicIngredients.SeaweedIngredients.SEAWEED_PULP;
import static net.barch.brosalch.MagicIngredients.SeaweedIngredients.SEAWEED_COOKIE;
import static net.barch.brosalch.MagicIngredients.SeaweedIngredients.SEAWEED_TEA;
import static net.barch.brosalch.MagicIngredients.SeaweedIngredients.SEAWEED_EXTRACT;

public class ChorusIngredients {


    public static final StatusEffectInstance CHORUS_TEA_EFFECT = new StatusEffectInstance(StatusEffects.LEVITATION, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance CHORUS_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.LEVITATION, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent CHORUS_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().hunger(3).saturationModifier(2).snack().statusEffect(CHORUS_COOKIE_EFFECT, 1).build();

    public static final Item CHORUS_PULP = new Item(new FabricItemSettings());
    public static final Item CHORUS_COOKIE = new Item(new FabricItemSettings().food(CHORUS_COOKIE_FOOD));
    public static final TeaItem CHORUS_TEA = new TeaItem(new FabricItemSettings(), CHORUS_TEA_EFFECT);
    public static final Item CHORUS_EXTRACT = new Item(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "chorus_pulp"), CHORUS_PULP);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "chorus_cookie"), CHORUS_COOKIE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "chorus_tea"), CHORUS_TEA);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "chorus_extract"), CHORUS_EXTRACT);

    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(CHORUS_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, SEAWEED_PULP)});
        BAItemGrouper.GroupItem(CHORUS_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, SEAWEED_COOKIE)});
        BAItemGrouper.GroupItem(CHORUS_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, SEAWEED_TEA)});
        BAItemGrouper.GroupItem(CHORUS_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, SEAWEED_EXTRACT)});

    }

}