package net.endermans.sapphire.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class CubeEntity extends PathAwareEntity {

    public CubeEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
}