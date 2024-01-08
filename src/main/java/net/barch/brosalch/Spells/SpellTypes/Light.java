package net.barch.brosalch.Spells.SpellTypes;

import net.barch.brosalch.Spells.Spell;
import net.barch.brosalch.Spells.SpellExtractItem;
import net.barch.brosalch.Spells.Spells;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.barch.brosalch.Miscellaneous.Miscellaneous.SPELL_LVL_0;


public class Light extends Spell {
    public Light(int spellStatus, String spellType) {
        super(spellStatus, spellType);
    }

    @Override
    public ActionResult useBlock(ItemUsageContext context, @Nullable ItemStack itemStack) {
        World world = context.getWorld();
        PlayerEntity user = context.getPlayer();
        Hand hand = context.getHand();

        // The reason for the whole "fake context" thing is to prevent the player losing they're spray bottle or spell via this method.
        ItemStack use = Items.TORCH.getDefaultStack();
        use.setCount(64);
        ItemUsageContext fakeContext = new ItemUsageContext(world, user, hand, use, new BlockHitResult(context.getHitPos(), context.getSide(), context.getBlockPos(), context.hitsInsideBlock()));
        use.useOnBlock(fakeContext);

        // Spray bottles use _much_ less durability...
        if (user.getStackInHand(hand).getItem() == Spells.SPRAY_BOTTLE) {
            damageSpray(itemStack, user);
            ((SpellExtractItem)itemStack.getItem()).onBreak(itemStack, world, user);

            user.getItemCooldownManager().set(user.getStackInHand(hand).getItem(),  10);
            return ActionResult.success(true);
        }

        //... than raw spells.
        damageSolo(user.getStackInHand(hand), user);
        ((SpellExtractItem)user.getStackInHand(hand).getItem()).onBreak(user.getStackInHand(hand), user.getWorld(), user);

        user.getItemCooldownManager().set(user.getStackInHand(hand).getItem(),  10);
        return ActionResult.success(true);
    }

    @Override
    public ActionResult useEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        StatusEffectInstance statusEffect = new StatusEffectInstance(StatusEffects.NIGHT_VISION, SPELL_LVL_0, 0);
        entity.addStatusEffect(statusEffect);

        if (user.getStackInHand(hand).getItem() == Spells.SPRAY_BOTTLE) {
            damageSpray(stack, user);
            ((SpellExtractItem)stack.getItem()).onBreak(stack, user.getWorld(), user);

            user.getItemCooldownManager().set(user.getStackInHand(hand).getItem(),  10);
            return ActionResult.SUCCESS;
        }

        damageSolo(stack, user);
        ((SpellExtractItem)stack.getItem()).onBreak(stack, user.getWorld(), user);

        user.getItemCooldownManager().set(user.getStackInHand(hand).getItem(),  10);
        return ActionResult.SUCCESS;
    }

    @Override
    public TypedActionResult<ItemStack> useAir(World world, PlayerEntity user, Hand hand, @Nullable ItemStack itemStack) {
        StatusEffectInstance statusEffect = new StatusEffectInstance(StatusEffects.NIGHT_VISION, SPELL_LVL_0, 0);
        user.addStatusEffect(statusEffect);

        if (user.getStackInHand(hand).getItem() == Spells.SPRAY_BOTTLE) {
            damageSpray(itemStack, user);
            ((SpellExtractItem)itemStack.getItem()).onBreak(itemStack, user.getWorld(), user);

            user.getItemCooldownManager().set(user.getStackInHand(hand).getItem(),  10);
            return TypedActionResult.success(user.getStackInHand(hand));
        }

        damageSolo(user.getStackInHand(hand), user);
        ((SpellExtractItem)user.getStackInHand(hand).getItem()).onBreak(user.getStackInHand(hand), user.getWorld(), user);

        user.getItemCooldownManager().set(user.getStackInHand(hand).getItem(),  10);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
