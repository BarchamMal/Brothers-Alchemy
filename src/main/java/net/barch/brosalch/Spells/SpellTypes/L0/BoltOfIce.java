package net.barch.brosalch.Spells.SpellTypes.L0;

import net.barch.brosalch.Entities.BoltOfIceEntity;
import net.barch.brosalch.Spells.Spell;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.barch.brosalch.Spells.ParticleFX.spellEffect;


public class BoltOfIce extends Spell {
    public BoltOfIce(int spellStatus, String spellType) {
        super(spellStatus, spellType);
    }

    @Override
    public ActionResult useAir(World world, PlayerEntity user, Hand hand, @Nullable ItemStack itemStack) {

        BoltOfIceEntity boltOfIceEntity = new BoltOfIceEntity(world, user);
        boltOfIceEntity.setItem(Items.AIR.getDefaultStack());
        boltOfIceEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f,1,0.0f);
        world.spawnEntity(boltOfIceEntity);
        spellEffect(world, user);
        boltOfIceEntity.getWorld().playSound(boltOfIceEntity, boltOfIceEntity.getBlockPos(), SoundEvents.BLOCK_POWDER_SNOW_STEP, SoundCategory.PLAYERS, 1, 1);

        return simpleFinishUsingAir(user, hand, itemStack);
    }

}
