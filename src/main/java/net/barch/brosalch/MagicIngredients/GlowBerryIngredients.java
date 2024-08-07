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
import static net.barch.brosalch.MagicIngredients.ChorusIngredients.CHORUS_PULP;
import static net.barch.brosalch.MagicIngredients.ChorusIngredients.CHORUS_COOKIE;
import static net.barch.brosalch.MagicIngredients.ChorusIngredients.CHORUS_TEA;
import static net.barch.brosalch.MagicIngredients.ChorusIngredients.CHORUS_EXTRACT;

public class GlowBerryIngredients {


    public static final StatusEffectInstance GLOW_BERRY_TEA_EFFECT = new StatusEffectInstance(StatusEffects.GLOWING, Miscellaneous.TEA_TIME, Miscellaneous.TEA_STRENGTH);
    public static final StatusEffectInstance GLOW_BERRY_COOKIE_EFFECT = new StatusEffectInstance(StatusEffects.GLOWING, Miscellaneous.COOKIE_TIME, Miscellaneous.COOKIE_STRENGTH);

    public static final FoodComponent GLOW_BERRY_COOKIE_FOOD = new FoodComponent.Builder().alwaysEdible().nutrition(3).saturationModifier(2).snack().statusEffect(GLOW_BERRY_COOKIE_EFFECT, 1).build();

    public static final Item GLOW_BERRY_PULP = new Item(new Item.Settings());
    public static final Item GLOW_BERRY_COOKIE = new Item(new Item.Settings().food(GLOW_BERRY_COOKIE_FOOD));
    public static final TeaItem GLOW_BERRY_TEA = new TeaItem(new Item.Settings(), GLOW_BERRY_TEA_EFFECT);
    public static final Item GLOW_BERRY_EXTRACT = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "glow_berry_pulp"), GLOW_BERRY_PULP);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "glow_berry_cookie"), GLOW_BERRY_COOKIE);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "glow_berry_tea"), GLOW_BERRY_TEA);
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "glow_berry_extract"), GLOW_BERRY_EXTRACT);

    }

    public static void GroupItems() {

        BAItemGrouper.GroupItem(GLOW_BERRY_PULP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, CHORUS_PULP)});
        BAItemGrouper.GroupItem(GLOW_BERRY_COOKIE, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, CHORUS_COOKIE)});
        BAItemGrouper.GroupItem(GLOW_BERRY_TEA, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.FOOD_AND_DRINK, CHORUS_TEA)});
        BAItemGrouper.GroupItem(GLOW_BERRY_EXTRACT, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, CHORUS_EXTRACT)});

    }

}