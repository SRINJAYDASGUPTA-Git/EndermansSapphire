package net.endermans.sapphire;

import net.endermans.sapphire.Entity.CubeEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EndermansSapphire implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("enderman");
	private static final String modid = "enderman";
	public static final Item SAPPHIRE = new Item(new Item.Settings().group(ItemGroup.MISC));
	public static final Block SAPPHIRE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.0F).sounds(BlockSoundGroup.METAL));
	public static final Block SAPPHIRE_ORE = new SapphireOreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5F).sounds(BlockSoundGroup.STONE));
	public static final Block DEEPSLATE_SAPPHIRE_ORE = new DeepslateSapphireOre(FabricBlockSettings.of(Material.STONE).strength(1.5F).sounds(BlockSoundGroup.DEEPSLATE));

	private static ConfiguredFeature<?, ?> OVERWORLD_SAPPHIRE_ORE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					EndermansSapphire.SAPPHIRE_ORE.getDefaultState(),
					5));
	public static PlacedFeature OVERWORLD_SAPPHIRE_ORE_PLACED_FEATURE = OVERWORLD_SAPPHIRE_ORE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(15),
			SquarePlacementModifier.of(),
			HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))
	);
	private static ConfiguredFeature<?, ?> OVERWORLD_DSAPPHIRE_ORE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
					EndermansSapphire.DEEPSLATE_SAPPHIRE_ORE.getDefaultState(),
					5));
	public static PlacedFeature OVERWORLD_DSAPPHIRE_ORE_PLACED_FEATURE = OVERWORLD_DSAPPHIRE_ORE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(15),
			SquarePlacementModifier.of(),
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(-10))
	);
	private static Enchantment POISON = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(modid, "poison"),
			new PoisonEnchantment()
	);

	//Entity
	public static final EntityType<CubeEntity> CUBE = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(modid, "cube"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CubeEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
	);
	public static final Item CUBE_SPAWN_EGG = new SpawnEggItem(EndermansSapphire.CUBE, 12895428, 11382189, new Item.Settings().group(ItemGroup.MISC));
	public static final ToolItem SAPPHIRE_SWORD = new SwordItem(new SapphireToolMaterial(), 8, -2.6f, new Item.Settings().group(ItemGroup.COMBAT));
	public static final ToolItem SAPPHIRE_SHOVEL = new ShovelItem(new SapphireToolMaterial(), 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHIRE_PICKAXE = new CustomPickaxeItem(new SapphireToolMaterial(), 1, -2.8f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHIRE_AXE = new CustomAxeItem(new SapphireToolMaterial(), 7, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHIRE_HOE = new CustomHoeItem(new SapphireToolMaterial(), 7, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHARITE_SWORD = new SwordItem(new SapphariteToolMaterial(), 8, -2.6f, new Item.Settings().group(ItemGroup.COMBAT));
	public static final ToolItem SAPPHARITE_SHOVEL = new ShovelItem(new SapphariteToolMaterial(), 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHARITE_PICKAXE = new CustomPickaxeItem(new SapphariteToolMaterial(), 1, -2.8f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHARITE_AXE = new CustomAxeItem(new SapphariteToolMaterial(), 7, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHARITE_HOE = new CustomHoeItem(new SapphariteToolMaterial(), 7, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ArmorMaterial SAPPHIRE_MATERIAL = new SapphireArmorMaterial();
	public static final ArmorMaterial SAPPHARITE_MATERIAL = new SapphariteArmorMaterial();
	public static final Item SAPPHIRE_HELMET = new ArmorItem(SAPPHIRE_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item SAPPHIRE_CHESTPLATE = new ArmorItem(SAPPHIRE_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item SAPPHIRE_LEGGINGS = new ArmorItem(SAPPHIRE_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item SAPPHIRE_BOOTS = new ArmorItem(SAPPHARITE_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item SAPPHARITE_HELMET = new ArmorItem(SAPPHARITE_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item SAPPHARITE_CHESTPLATE = new ArmorItem(SAPPHARITE_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item SAPPHARITE_LEGGINGS = new ArmorItem(SAPPHARITE_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item SAPPHARITE_BOOTS = new ArmorItem(SAPPHARITE_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));


	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(CUBE, CubeEntity.createMobAttributes());
		Registry.register(Registry.ITEM, new Identifier(modid, "cube_spawn_egg"), CUBE_SPAWN_EGG);
		Registry.register(Registry.ITEM, new Identifier(modid, "sapphire"), SAPPHIRE);
		Registry.register(Registry.ITEM, new Identifier(modid, "sapphire_sword"), SAPPHIRE_SWORD);
		Registry.register(Registry.ITEM, new Identifier(modid, "sapphire_shovel"), SAPPHIRE_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(modid, "sapphire_pickaxe"), SAPPHIRE_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier(modid, "sapphire_axe"), SAPPHIRE_AXE);
		Registry.register(Registry.ITEM, new Identifier(modid, "sapphire_hoe"), SAPPHIRE_HOE);
		Registry.register(Registry.ITEM, new Identifier(modid, "sappharite_sword"), SAPPHARITE_SWORD);
		Registry.register(Registry.ITEM, new Identifier(modid, "sappharite_shovel"), SAPPHARITE_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(modid, "sappharite_pickaxe"), SAPPHARITE_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier(modid, "sappharite_axe"), SAPPHARITE_AXE);
		Registry.register(Registry.ITEM, new Identifier(modid, "sappharite_hoe"), SAPPHARITE_HOE);
		Registry.register(Registry.BLOCK, new Identifier(modid, "sapphire_block"), SAPPHIRE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(modid, "sapphire_block"), new BlockItem(SAPPHIRE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier(modid,"sapphire_ore"), SAPPHIRE_ORE);
		Registry.register(Registry.ITEM, new Identifier(modid, "sapphire_ore"), new BlockItem(SAPPHIRE_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier(modid,"deepslatesapphire_ore"), DEEPSLATE_SAPPHIRE_ORE);
		Registry.register(Registry.ITEM, new Identifier(modid, "deepslatesapphire_ore"), new BlockItem(DEEPSLATE_SAPPHIRE_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier(modid, "sapphire_helmet"), SAPPHIRE_HELMET);
		Registry.register(Registry.ITEM, new Identifier(modid, "sapphire_chestplate"), SAPPHIRE_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(modid, "sapphire_leggings"), SAPPHIRE_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(modid, "sapphire_boots"), SAPPHIRE_BOOTS);
		Registry.register(Registry.ITEM, new Identifier(modid, "sappharite_helmet"), SAPPHARITE_HELMET);
		Registry.register(Registry.ITEM, new Identifier(modid, "sappharite_chestplate"), SAPPHARITE_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(modid, "sappharite_leggings"), SAPPHARITE_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(modid, "sappharite_boots"), SAPPHARITE_BOOTS);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier(modid, "overworld_sapphire_ore"), OVERWORLD_SAPPHIRE_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(modid, "overworld_sapphire_ore"),OVERWORLD_SAPPHIRE_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(modid, "overworld_sapphire_ore")));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier(modid, "overworld_dsapphire_ore"), OVERWORLD_DSAPPHIRE_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(modid, "overworld_dsapphire_ore"),OVERWORLD_DSAPPHIRE_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(modid, "overworld_dsapphire_ore")));

		LOGGER.info("Hello Fabric world!");
	}
}
