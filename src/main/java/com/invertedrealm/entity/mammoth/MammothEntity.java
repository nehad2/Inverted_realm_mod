package com.invertedrealm.entity.mammoth;

import com.invertedrealm.entity.ModEntities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class MammothEntity extends AnimalEntity implements GeoEntity {

    private static final RawAnimation IDLE_ANIMATION =
            RawAnimation.begin().thenLoop("animation");

    private static final RawAnimation WALK_ANIMATION =
            RawAnimation.begin().thenLoop("Walking");

    private static final RawAnimation DEATH_ANIMATION =
            RawAnimation.begin().thenPlayAndHold("Dying_pose");

    private final AnimatableInstanceCache cache =
            GeckoLibUtil.createInstanceCache(this);

    public MammothEntity(EntityType<? extends MammothEntity> type, World world) {
        super(type, world);
    }

    public static DefaultAttributeContainer.Builder createMammothAttributes() {
        return AnimalEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.8);
    }

    @Override
    protected void initGoals() {
        goalSelector.add(0, new SwimGoal(this));
        goalSelector.add(1, new EscapeDangerGoal(this, 1.4));
        goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        goalSelector.add(3, new TemptGoal(
                this,
                1.2,
                Ingredient.ofItems(Items.WHEAT),
                false
        ));
        goalSelector.add(4, new FollowParentGoal(this, 1.1));
        goalSelector.add(5, new WanderAroundFarGoal(this, 0.8));
        goalSelector.add(6, new LookAtEntityGoal(
                this,
                PlayerEntity.class,
                8.0f
        ));
        goalSelector.add(7, new LookAroundGoal(this));
    }

    private PlayState animationPredicate(
            AnimationState<MammothEntity> state) {

        if (isDead() || deathTime > 0) {
            return state.setAndContinue(DEATH_ANIMATION);
        }

        if (state.isMoving()) {
            return state.setAndContinue(WALK_ANIMATION);
        }

        return state.setAndContinue(IDLE_ANIMATION);
    }

    @Override
    public void registerControllers(
            AnimatableManager.ControllerRegistrar controllers) {

        controllers.add(new AnimationController<>(
                this,
                "main_controller",
                5,
                this::animationPredicate
        ));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Nullable
    @Override
    public MammothEntity createChild(
            ServerWorld world,
            PassiveEntity mate) {

        return ModEntities.MAMMOTH.create(world);
    }
}