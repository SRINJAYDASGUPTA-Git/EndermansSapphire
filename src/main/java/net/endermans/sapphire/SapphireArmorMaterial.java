package net.endermans.sapphire;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class SapphireArmorMaterial implements ArmorMaterial{
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
	private static final int[] PROTECTION_VALUES = new int[] {10, 40, 50, 35};

    @Override
	public int getDurability(EquipmentSlot slot) {
		return BASE_DURABILITY[slot.getEntitySlotId()] * 300;
	}
 
	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return PROTECTION_VALUES[slot.getEntitySlotId()];
	}
 
	@Override
	public int getEnchantability() {
		return 30;
	}
 
	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
	}
 
	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(EndermansSapphire.SAPPHIRE);
	}
 
	@Override
	public String getName() {
		return "sapphire";
	}
 
	@Override
	public float getToughness() {
		return 2.0F;
	}
 
	@Override
	public float getKnockbackResistance() {
		return 0.0F;
	}
} 