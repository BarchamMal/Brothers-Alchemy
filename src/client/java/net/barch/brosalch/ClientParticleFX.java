package net.barch.brosalch;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.SoulParticle;

import static net.barch.brosalch.Spells.ParticleFX.*;

public class ClientParticleFX {


    public static void onInitialize() {
        ParticleFactoryRegistry.getInstance().register(HEAL, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(LIGHT, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FLESH_SHIELD, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(TEMPORARY_HP, SoulParticle.Factory::new);
    }
}
