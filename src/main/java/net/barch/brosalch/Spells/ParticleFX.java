package net.barch.brosalch.Spells;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import static net.barch.brosalch.BrothersAlchemy.NAMESPACE;

public class ParticleFX {

    public static final SimpleParticleType HEAL = FabricParticleTypes.simple();
    public static final SimpleParticleType LIGHT = FabricParticleTypes.simple();
    public static final SimpleParticleType FLESH_SHIELD = FabricParticleTypes.simple();
    public static final SimpleParticleType TEMPORARY_HP = FabricParticleTypes.simple();

    public static void onInitialize() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(NAMESPACE, "heal"), HEAL);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(NAMESPACE, "light"), LIGHT);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(NAMESPACE, "flesh_shield"), FLESH_SHIELD);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(NAMESPACE, "temp_hp"), TEMPORARY_HP);
    }

    public static void healEffect(World world, Entity entity) {
        Random random = world.getRandom();

        double x;
        double y;
        double z;

        double xv;
        double yv;
        double zv;

        int max = 0;
        while (max <= 20) {

            x = entity.getPos().x + randomMultiplier(randomVal(random), random);
            y = entity.getPos().y + (randomMultiplier(randomVal(random), random) / 2);
            z = entity.getPos().z + randomMultiplier(randomVal(random), random);

            xv = randomMultiplier(randomVal(random)/20,random);
            yv = randomVal(random)/5;
            zv = randomMultiplier(randomVal(random)/20,random);

            world.addParticle(HEAL, x, y, z, xv, yv, zv);
            max += 1;
        }
    }

    public static void coldEffect(World world, Entity entity) {
        Random random = world.getRandom();

        double x;
        double y;
        double z;

        double xv;
        double yv;
        double zv;

        int max = 0;
        while (max <= 20) {

            x = entity.getPos().x + randomMultiplier(randomVal(random), random);
            y = entity.getPos().y + (randomMultiplier(randomVal(random), random) / 2);
            z = entity.getPos().z + randomMultiplier(randomVal(random), random);

            xv = randomMultiplier(randomVal(random)/20,random);
            yv = randomVal(random)/5;
            zv = randomMultiplier(randomVal(random)/20,random);

            world.addParticle(ParticleTypes.SNOWFLAKE, x, y, z, xv, yv, zv);
            max += 1;
        }
    }
    public static void waterEffect(World world, Entity entity) {
        Random random = world.getRandom();

        double x;
        double y;
        double z;

        double xv;
        double yv;
        double zv;

        int max = 0;
        while (max <= 20) {

            x = entity.getPos().x + randomMultiplier(randomVal(random), random);
            y = entity.getPos().y + (randomMultiplier(randomVal(random), random) / 2);
            z = entity.getPos().z + randomMultiplier(randomVal(random), random);

            xv = randomMultiplier(randomVal(random)/20,random);
            yv = randomVal(random)/5;
            zv = randomMultiplier(randomVal(random)/20,random);

            world.addParticle(ParticleTypes.SPLASH, x, y, z, xv, yv, zv);
            max += 1;
        }
    }

    public static void fleshShieldEffect(World world, Entity entity) {
        Random random = world.getRandom();

        double x;
        double y;
        double z;

        double xv;
        double yv;
        double zv;

        int max = 0;
        while (max <= 20) {

            x = entity.getPos().x + randomMultiplier(randomVal(random), random);
            y = entity.getPos().y + (randomMultiplier(randomVal(random), random) / 2);
            z = entity.getPos().z + randomMultiplier(randomVal(random), random);

            xv = randomMultiplier(randomVal(random)/20,random);
            yv = randomVal(random)/5;
            zv = randomMultiplier(randomVal(random)/20,random);

            world.addParticle(FLESH_SHIELD, x, y, z, xv, yv, zv);
            max += 1;
        }
    }
    public static void dazeEffect(World world, Entity entity) {
        Random random = world.getRandom();

        double x;
        double y;
        double z;

        double xv;
        double yv;
        double zv;

        int max = 0;
        while (max <= 20) {

            x = entity.getPos().x + randomMultiplier(randomVal(random), random);
            y = entity.getPos().y + 0.5 + (randomMultiplier(randomVal(random), random) / 4);
            z = entity.getPos().z + randomMultiplier(randomVal(random), random);

            xv = randomMultiplier(randomVal(random)/20,random);
            yv = randomVal(random)/5;
            zv = randomMultiplier(randomVal(random)/20,random);

            world.addParticle(ParticleTypes.END_ROD, x, y, z, xv, yv, zv);
            max += 1;
        }
    }

    public static void temporaryHpEffect(World world, Entity entity) {
        Random random = world.getRandom();

        double x;
        double y;
        double z;

        double xv;
        double yv;
        double zv;

        int max = 0;
        while (max <= 20) {

            x = entity.getPos().x + randomMultiplier(randomVal(random), random);
            y = entity.getPos().y + (randomMultiplier(randomVal(random), random) / 2);
            z = entity.getPos().z + randomMultiplier(randomVal(random), random);

            xv = randomMultiplier(randomVal(random)/20,random);
            yv = randomVal(random)/5;
            zv = randomMultiplier(randomVal(random)/20,random);

            world.addParticle(TEMPORARY_HP, x, y, z, xv, yv, zv);
            max += 1;
        }
    }

    public static void lightEffect(World world, Entity entity) {
        Random random = world.getRandom();

        double x;
        double y;
        double z;

        double xv;
        double yv;
        double zv;

        int max = 0;
        while (max <= 20) {

            x = entity.getPos().x + randomMultiplier(randomVal(random), random);
            y = entity.getPos().y + (randomMultiplier(randomVal(random), random) / 2);
            z = entity.getPos().z + randomMultiplier(randomVal(random), random);

            xv = randomMultiplier(randomVal(random)/20,random);
            yv = randomVal(random)/5;
            zv = randomMultiplier(randomVal(random)/20,random);

            world.addParticle(LIGHT, x, y, z, xv, yv, zv);
            max += 1;
        }
    }

    public static void fireEffect(World world, Entity entity) {
        Random random = world.getRandom();

        double x;
        double y;
        double z;

        double xv;
        double yv;
        double zv;

        int max = 0;
        while (max <= 20) {

            x = entity.getPos().x + randomMultiplier(randomVal(random), random);
            y = entity.getPos().y + (randomMultiplier(randomVal(random), random) / 2);
            z = entity.getPos().z + randomMultiplier(randomVal(random), random);

            xv = randomMultiplier(randomVal(random)/20,random);
            yv = randomVal(random)/5;
            zv = randomMultiplier(randomVal(random)/20,random);

            world.addParticle(ParticleTypes.FLAME, x, y, z, xv, yv, zv);
            max += 1;
        }
    }

    public static void spellEffect(World world, Entity entity) {
        Random random = world.getRandom();

        double x;
        double y;
        double z;

        double xv;
        double yv;
        double zv;

        world.addParticle(ParticleTypes.FLASH, entity.getPos().x, entity.getPos().y, entity.getPos().z, 0.0, 0.0, 0.0);

        int max = 0;
        while (max <= 20) {

            x = entity.getPos().x + randomMultiplier(randomVal(random), random)/2;
            y = entity.getPos().y + randomMultiplier(randomVal(random), random);
            z = entity.getPos().z + randomMultiplier(randomVal(random), random)/2;


            world.addParticle(ParticleTypes.WITCH, x, y, z, 0.0, 0.0,0.0);
            max += 1;
        }

        max = 0;
        while (max <= 20) {

            x = entity.getPos().x + randomMultiplier(randomVal(random), random)/2;
            y = entity.getPos().y + randomMultiplier(randomVal(random), random);
            z = entity.getPos().z + randomMultiplier(randomVal(random), random)/2;

            xv = randomMultiplier(randomVal(random)/20, random);
            yv = randomVal(random)/5;
            zv = randomMultiplier(randomVal(random)/20, random);

            world.addParticle(ParticleTypes.SOUL, x, y, z, xv, yv, zv);
            max += 1;
        }

    }

    private static double randomMultiplier(double val, Random random) {
        if (random.nextBetween(0,2) == 1) return val;

        return - val;
    }

    private static double randomVal(Random random) {
        return random.nextDouble();
    }

}
