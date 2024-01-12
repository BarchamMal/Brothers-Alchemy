package net.barch.brosalch.Spells.SpellTypes.L0;

import net.barch.brosalch.Miscellaneous.Tags;
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

import static net.barch.brosalch.Spells.ParticleFX.*;


public class Biomecraft extends Spell {
    public Biomecraft(int spellStatus, String spellType) {
        super(spellStatus, spellType);
    }

    @Override
    public ActionResult useBlock(ItemUsageContext context, @Nullable ItemStack itemStack) {
        World world = context.getWorld();
        PlayerEntity user = context.getPlayer();
        Hand hand = context.getHand();
        spellEffect(user.getWorld(), user);
        user.getWorld().playSound(user, user.getBlockPos(), SoundEvents.BLOCK_AMETHYST_CLUSTER_BREAK, SoundCategory.PLAYERS, 1, .5f);
        user.getWorld().playSound(user, user.getBlockPos(), SoundEvents.BLOCK_AMETHYST_CLUSTER_BREAK, SoundCategory.PLAYERS, 1, 1);
        user.getWorld().playSound(user, user.getBlockPos(), SoundEvents.BLOCK_AMETHYST_CLUSTER_BREAK, SoundCategory.PLAYERS, 1, 1.5f);

        if (world.getBiome(user.getBlockPos()).isIn(Tags.COLD)) {
            simpleUseOnBlock(world, user, hand, context, Items.SNOW);
            coldEffect(world,user);
        }

        else if (world.getBiome(user.getBlockPos()).isIn(Tags.HOT)) {
            simpleUseOnBlock(world, user, hand, context, Items.FLINT_AND_STEEL);
            fireEffect(world,user);
        }

        else {
            simpleUseOnBlock(world, user, hand, context, Items.MOSS_CARPET);
            lightEffect(world, user);
        }

        return simpleDamage(user, hand, itemStack);

    }

}
