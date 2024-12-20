package net.barch.brosalch.Entities;

import net.barch.brosalch.Spells.ParticleFX;
import net.barch.brosalch.Spells.Spells;
import net.barch.brosalch.Spells.UnusedItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.jmx.Server;

public class BoltOfIceEntity extends ThrownItemEntity {

    public BoltOfIceEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    public BoltOfIceEntity(World world, LivingEntity owner) {
        super(Spells.BOLT_OF_ICE_ENTITY_TYPE, world);
    }

    public BoltOfIceEntity(LivingEntity owner, World world, ItemStack stack) {
        super(Spells.BOLT_OF_ICE_ENTITY_TYPE, owner, world, stack);
    }

    private ParticleEffect getParticleParameters() {
        return ParticleTypes.SNOWFLAKE;
    }

    @Override
    public ItemStack getStack() {
        return this.getDefaultItem().getDefaultStack();
    }

    public void handleStatus(byte status) {
        if (status == 3) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for(int i = 0; i < 8; ++i) {
                this.getWorld().addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            }
        }

    }

    @Override
    protected Item getDefaultItem() {
        return UnusedItems.RAY_OF_FROST;
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();

        if (!(entity instanceof LivingEntity)) {
            return;
        }
        if (!(getWorld() instanceof ServerWorld)) return;

        ParticleFX.coldEffect(entityHitResult.getEntity().getWorld(), entityHitResult.getEntity());
        entity.damage(((ServerWorld)getWorld()), this.getOwner().getDamageSources().playerAttack((PlayerEntity)this.getOwner()), 4);
        entity.damage((ServerWorld) getWorld(), this.getOwner().getDamageSources().freeze(), 1);
        this.getWorld().playSound(this, this.getBlockPos(), SoundEvents.BLOCK_SNOW_BREAK, SoundCategory.NEUTRAL, 1, 1);

        this.kill((ServerWorld) getWorld());

    }

    @Override
    public void tick() {
        super.tick();
        if (!(getWorld() instanceof ServerWorld)) return;
        if ((this.getVelocity().x <= 0.1 && this.getVelocity().y <= 0.1 && this.getVelocity().z <= 0.1) && this.age > 20) {
            ParticleFX.coldEffect(this.getWorld(), this);
            this.kill((ServerWorld) getWorld());
        }
    }

    @Override
    protected double getGravity() {
        return 0;
    }

    protected void onCollision(HitResult hitResult) {

        if (!(getWorld() instanceof ServerWorld)) return;

        super.onCollision(hitResult);

        ParticleFX.coldEffect(this.getWorld(), this);
        this.kill((ServerWorld) getWorld());
    }


}
