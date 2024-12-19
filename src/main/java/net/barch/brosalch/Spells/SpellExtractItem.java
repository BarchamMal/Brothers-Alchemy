package net.barch.brosalch.Spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import static net.barch.brosalch.BrothersAlchemy.LOGGER;

public class SpellExtractItem extends Item {

    private final Spell SPELL;

    public SpellExtractItem(Settings settings, Spell spell) {
        super(settings);
        this.SPELL = spell;
    }

    public Spell getSpell() {
        return SPELL;
    }

    public void onBreak(ItemStack itemStack, World world, PlayerEntity user) {
        if (itemStack.getDamage() < itemStack.getMaxDamage()) return;

        itemStack.decrement(1);

        world.playSound(user, user.getBlockPos(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS, 1, 1);

        if (!user.getInventory().insertStack(Items.GLASS_BOTTLE.getDefaultStack())) {
            user.dropItem(Items.GLASS_BOTTLE.getDefaultStack(), false);
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        return this.SPELL.useBlock(context, null);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getItemCooldownManager().isCoolingDown(user.getStackInHand(hand)))
            return this.SPELL.useEntity(stack, user, entity, hand);
        return ActionResult.FAIL;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        return this.SPELL.useAir(world, user, hand, null);
    }



    public ActionResult useOnBlock(ItemUsageContext context, ItemStack itemStack) {
        return this.SPELL.useBlock(context, itemStack);
    }

    public ActionResult use(World world, PlayerEntity user, Hand hand, ItemStack itemStack) {
        return this.SPELL.useAir(world, user, hand, itemStack);
    }
}
