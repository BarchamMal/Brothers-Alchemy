package net.barch.brosalch.Spells.SpellTypes.L0;

import net.barch.brosalch.Spells.Spell;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import static net.barch.brosalch.Miscellaneous.Miscellaneous.SPELL_LVL_0;
import static net.barch.brosalch.Spells.ParticleFX.coldEffect;
import static net.barch.brosalch.Spells.ParticleFX.spellEffect;


public class Freeze extends Spell {
    public Freeze(int spellStatus, String spellType) {
        super(spellStatus, spellType);
    }

    @Override
    public ActionResult useEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getItemCooldownManager().isCoolingDown(stack)) {
            StatusEffectInstance statusEffect = new StatusEffectInstance(StatusEffects.WEAKNESS, SPELL_LVL_0, 10);
            StatusEffectInstance statusEffect1 = new StatusEffectInstance(StatusEffects.SLOWNESS, SPELL_LVL_0, 10);
            entity.addStatusEffect(statusEffect, user);
            entity.addStatusEffect(statusEffect1, user);
            spellEffect(user.getWorld(), user);
            coldEffect(user.getWorld(), entity);

            return simpleDamage(user, hand, stack);
        }
        return ActionResult.FAIL;

    }

}
