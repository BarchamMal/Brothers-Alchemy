package net.barch.brosalch.Entities;

import net.barch.brosalch.Spells.ParticleFX;
import net.barch.brosalch.Spells.Spells;
import net.barch.brosalch.Spells.UnusedItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class BoltOfIceEntity extends ThrownItemEntity {
    public BoltOfIceEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    public BoltOfIceEntity(World world, LivingEntity owner) {
        super(Spells.BOLT_OF_ICE_ENTITY_TYPE, owner, world);
    }

    public BoltOfIceEntity(World world, double x, double y, double z) {
        super(Spells.BOLT_OF_ICE_ENTITY_TYPE, x, y, z, world);
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

        ParticleFX.coldEffect(entityHitResult.getEntity().getWorld(), entityHitResult.getEntity());
        entity.damage(this.getDamageSources().freeze(), 4);
        this.getWorld().playSound(this, this.getBlockPos(), SoundEvents.BLOCK_SNOW_BREAK, SoundCategory.NEUTRAL, 1, 1);

        this.kill();

    }

    @Override
    public void tick() {
        super.tick();
        if ((this.getVelocity().x <= 0.1 && this.getVelocity().y <= 0.1 && this.getVelocity().z <= 0.1) && this.age > 20) {
            ParticleFX.coldEffect(this.getWorld(), this);
            this.kill();
        }
    }

    @Override
    protected float getGravity() {
        return 0;
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);


        ParticleFX.coldEffect(this.getWorld(), this);
        this.kill();
    }


}
