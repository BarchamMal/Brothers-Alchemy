package net.barch.brosalch.Spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.jetbrains.annotations.Nullable;

public class Spell {

    private int SPELL_STATUS;
    private String SPELL_TYPE;

    public Spell(int spellStatus, String spellType) {
        this.SPELL_STATUS = spellStatus;
        this.SPELL_TYPE = spellType;
    }


    public void damageSolo(ItemStack stack) {
        stack.setDamage(stack.getDamage() + 8);
    }

    public void damageSpray(ItemStack stack) {
        stack.setDamage(stack.getDamage() + 1);
    }

    public int getSpellStatus() {
        return SPELL_STATUS;
    }

    public String getSpellType() {
        return SPELL_TYPE;
    }

    public TypedActionResult<ItemStack> useAir(World world, PlayerEntity user, Hand hand, @Nullable ItemStack itemStack) {
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    public ActionResult useEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        return ActionResult.SUCCESS;
    }

    public ActionResult useBlock(ItemUsageContext context, @Nullable ItemStack itemStack) {
        return ActionResult.SUCCESS;
    }

}
