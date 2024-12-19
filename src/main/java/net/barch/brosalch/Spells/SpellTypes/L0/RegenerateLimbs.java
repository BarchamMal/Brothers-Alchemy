package net.barch.brosalch.Spells.SpellTypes.L0;

import net.barch.brosalch.Spells.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.barch.brosalch.Spells.ParticleFX.healEffect;
import static net.barch.brosalch.Spells.ParticleFX.spellEffect;


public class RegenerateLimbs extends Spell {
    public RegenerateLimbs(int spellStatus, String spellType) {
        super(spellStatus, spellType);
    }

    @Override
    public ActionResult useEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getItemCooldownManager().isCoolingDown(stack)) {
            StatusEffectInstance statusEffect = new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0);
            entity.addStatusEffect(statusEffect, user);
            spellEffect(user.getWorld(), user);
            healEffect(user.getWorld(), entity);
            user.getWorld().playSound(user, entity.getBlockPos(), SoundEvents.BLOCK_BEACON_POWER_SELECT, SoundCategory.PLAYERS, 1, 1);

            return simpleDamage(user, hand, stack);
        }
        return ActionResult.FAIL;
    }

    @Override
    public ActionResult useAir(World world, PlayerEntity user, Hand hand, @Nullable ItemStack itemStack) {
        StatusEffectInstance statusEffect = new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0);
        user.addStatusEffect(statusEffect, user);
        spellEffect(user.getWorld(), user);
        healEffect(world, user);
        user.getWorld().playSound(user, user.getBlockPos(), SoundEvents.BLOCK_BEACON_POWER_SELECT, SoundCategory.PLAYERS, 1, 1);

        return simpleFinishUsingAir(user, hand, itemStack);

    }
}
