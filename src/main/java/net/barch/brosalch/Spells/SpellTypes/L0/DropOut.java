package net.barch.brosalch.Spells.SpellTypes.L0;

import net.barch.brosalch.Spells.ParticleFX;
import net.barch.brosalch.Spells.Spell;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.barch.brosalch.Spells.ParticleFX.lightEffect;
import static net.barch.brosalch.Spells.ParticleFX.spellEffect;


public class DropOut extends Spell {
    public DropOut(int spellStatus, String spellType) {
        super(spellStatus, spellType);
    }

    @Override
    public ActionResult useBlock(ItemUsageContext context, @Nullable ItemStack itemStack) {
        World world = context.getWorld();
        PlayerEntity user = context.getPlayer();
        Hand hand = context.getHand();
        spellEffect(user.getWorld(), user);
        ParticleFX.fireEffect(world, user);
        ParticleFX.lightEffect(world, user);
        ParticleFX.dazeEffect(world, user);
        user.getWorld().playSound(user, user.getBlockPos(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1, 1);

        if (getMiningLevel(world.getBlockState(user.getBlockPos().down())) == "wood" && getMiningLevel(world.getBlockState(user.getBlockPos().down().down())) == "wood") {
            world.setBlockState(user.getBlockPos().down(), Blocks.AIR.getDefaultState());
            world.setBlockState(user.getBlockPos().down(2), Blocks.AIR.getDefaultState());
        }

        return simpleDamage(user, hand, itemStack);

    }

}
