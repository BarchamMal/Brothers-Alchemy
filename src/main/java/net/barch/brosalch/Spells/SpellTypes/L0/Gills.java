package net.barch.brosalch.Spells.SpellTypes.L0;

import net.barch.brosalch.Spells.Spell;
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

import static net.barch.brosalch.Miscellaneous.Miscellaneous.SPELL_LVL_0;
import static net.barch.brosalch.Spells.ParticleFX.*;


public class Gills extends Spell {
    public Gills(int spellStatus, String spellType) {
        super(spellStatus, spellType);
    }

    @Override
    public ActionResult useEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getItemCooldownManager().isCoolingDown(stack)) {
            StatusEffectInstance statusEffect = new StatusEffectInstance(StatusEffects.WATER_BREATHING, SPELL_LVL_0, 0);
            entity.addStatusEffect(statusEffect, user);
            spellEffect(user.getWorld(), user);
            waterEffect(user.getWorld(), entity);
            user.getWorld().playSound(user, entity.getBlockPos(), SoundEvents.AMBIENT_UNDERWATER_ENTER, SoundCategory.PLAYERS, 1, 1);
            ItemStack itemStack = user.getStackInHand(hand);

            return simpleDamage(user, hand, itemStack);
        }
        return ActionResult.FAIL;

    }

    @Override
    public ActionResult useAir(World world, PlayerEntity user, Hand hand, @Nullable ItemStack itemStack) {
        StatusEffectInstance statusEffect = new StatusEffectInstance(StatusEffects.WATER_BREATHING, SPELL_LVL_0, 0);
        user.addStatusEffect(statusEffect, user);
        spellEffect(user.getWorld(), user);
        waterEffect(world, user);
        user.getWorld().playSound(user, user.getBlockPos(), SoundEvents.AMBIENT_UNDERWATER_ENTER, SoundCategory.PLAYERS, 1, 1);

        return simpleFinishUsingAir(user, hand, itemStack);
    }

}
