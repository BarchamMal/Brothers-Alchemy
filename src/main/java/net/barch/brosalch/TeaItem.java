package net.barch.brosalch;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import static net.barch.brosalch.Miscellaneous.TEACUP;

public class TeaItem extends Item {
    private static final int MAX_USE_TIME = 32;
    private StatusEffectInstance STATUS_EFFECT_INSTANCE;

    public TeaItem(Settings settings, StatusEffectInstance statusEffect) {
        super(settings);
        this.STATUS_EFFECT_INSTANCE = statusEffect;
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.addStatusEffect(this.STATUS_EFFECT_INSTANCE);

        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (user instanceof PlayerEntity && ((PlayerEntity)user).getAbilities().creativeMode) {
            return stack;
        }

        if (stack.getCount() < 1) {
            return TEACUP.getDefaultStack();
        }

        if (user instanceof PlayerEntity player && !player.getInventory().insertStack(TEACUP.getDefaultStack())) {
            player.dropItem(TEACUP.getDefaultStack(), false);
        }

        return stack;
    }

    public int getMaxUseTime(ItemStack stack) {
        return MAX_USE_TIME;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}
