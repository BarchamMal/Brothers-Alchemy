package net.barch.brosalch.Spells.SpellTypes.L0;

import net.barch.brosalch.Spells.Spell;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.barch.brosalch.Spells.ParticleFX.fireEffect;
import static net.barch.brosalch.Spells.ParticleFX.spellEffect;


public class FireTrick extends Spell {
    public FireTrick(int spellStatus, String spellType) {
        super(spellStatus, spellType);
    }

    @Override
    public ActionResult useBlock(ItemUsageContext context, @Nullable ItemStack itemStack) {
        World world = context.getWorld();
        PlayerEntity user = context.getPlayer();
        Hand hand = context.getHand();
        spellEffect(user.getWorld(), user);
        fireEffect(world, user);
        user.getWorld().playSound(user, user.getBlockPos(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.PLAYERS, 1, 1);

        simpleUseOnBlock(world, user, hand, context, Items.FLINT_AND_STEEL);

        return simpleDamage(user, hand, itemStack);

    }

}
