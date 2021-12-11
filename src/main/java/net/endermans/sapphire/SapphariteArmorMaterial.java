package net.endermans.sapphire;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class SapphariteArmorMaterial implements ArmorMaterial{
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
	private static final int[] PROTECTION_VALUES = new int[] {20, 80, 100, 70};

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
		return 40;
	}
 
	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
	
	}
 
	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(Items.NETHERITE_INGOT);
	}
 
	@Override
	public String getName() {
		return "sappharite";
	}
 
	@Override
	public float getToughness() {
		return 4.0F;
	}
 
	@Override
	public float getKnockbackResistance() {
		return 0.0F;
	}
} 