package net.barch.brosalch.Miscellaneous;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.barch.barch_lib.Items.ItemGroupItem;
import net.minecraft.component.ComponentType;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.*;

public class Miscellaneous {

    public static final int TICKS = 20;
    public static final int SECONDS = 60;

    public static final int TEA_TIME = 45*TICKS;
    public static final int COOKIE_TIME = 15*TICKS;

    public static final int TEA_STRENGTH = 0;
    public static final int COOKIE_STRENGTH = 1;

    public static final int POSITIVE = 1;
    public static final int NEUTRAL = 0;
    public static final int NEGATIVE = -1;

    public static final int SPELL_LVL_0 = 20*TICKS;
    public static final int SPELL_LVL_1 = 30*TICKS;
    public static final int SPELL_LVL_2 = 1*TICKS*SECONDS;
    public static final int SPELL_LVL_3 = 2*TICKS*SECONDS;

    public static final Item TEACUP = createItem("teacup", Item.class, new Item.Settings());
    public static final Item DIAMOND_PULPIFIER = createItem("diamond_pulpifier", Item.class, new Item.Settings().maxCount(1).recipeRemainder(TEACUP));

    public static ConsumableComponent getCookieFood(StatusEffectInstance effectInstance) {
        return ConsumableComponents.food().consumeEffect(new ApplyEffectsConsumeEffect(effectInstance)).consumeSeconds(.8f).build();
    }

    public static void RegisterAll() {
        GroupItems();
    }

    public static void GroupItems() {
        BAItemGrouper.GroupItem(TEACUP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, Items.GLASS_BOTTLE)});
        BAItemGrouper.GroupItem(DIAMOND_PULPIFIER, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.TOOLS, Items.BRUSH)});

    }


}
