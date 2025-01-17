package com.teamabnormals.boatload.core.api;

import com.google.common.collect.ImmutableList;
import com.teamabnormals.boatload.core.registry.BoatloadItems;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.Set;
import java.util.function.Supplier;

public record BoatloadBoatType(ResourceLocation registryName, Supplier<Item> planks, Supplier<Item> boat, Supplier<Item> chestBoat, Supplier<Item> furnaceBoat, Supplier<Item> largeBoat) {
	private static final Set<BoatloadBoatType> BOAT_TYPES = new ObjectArraySet<>();

	public static final BoatloadBoatType OAK = register(create(new ResourceLocation("oak"), () -> Items.OAK_PLANKS, () -> Items.OAK_BOAT, () -> Items.OAK_CHEST_BOAT, () -> BoatloadItems.OAK_FURNACE_BOAT.get(), () -> BoatloadItems.LARGE_OAK_BOAT.get()));
	public static final BoatloadBoatType BIRCH = register(create(new ResourceLocation("birch"), () -> Items.BIRCH_PLANKS, () -> Items.BIRCH_BOAT, () -> Items.BIRCH_CHEST_BOAT, () -> BoatloadItems.BIRCH_FURNACE_BOAT.get(), () -> BoatloadItems.LARGE_BIRCH_BOAT.get()));
	public static final BoatloadBoatType SPRUCE = register(create(new ResourceLocation("spruce"), () -> Items.SPRUCE_PLANKS, () -> Items.SPRUCE_BOAT, () -> Items.SPRUCE_CHEST_BOAT, () -> BoatloadItems.SPRUCE_FURNACE_BOAT.get(), () -> BoatloadItems.LARGE_SPRUCE_BOAT.get()));
	public static final BoatloadBoatType JUNGLE = register(create(new ResourceLocation("jungle"), () -> Items.JUNGLE_PLANKS, () -> Items.JUNGLE_BOAT, () -> Items.JUNGLE_CHEST_BOAT, () -> BoatloadItems.JUNGLE_FURNACE_BOAT.get(), () -> BoatloadItems.LARGE_JUNGLE_BOAT.get()));
	public static final BoatloadBoatType ACACIA = register(create(new ResourceLocation("acacia"), () -> Items.ACACIA_PLANKS, () -> Items.ACACIA_BOAT, () -> Items.ACACIA_CHEST_BOAT, () -> BoatloadItems.ACACIA_FURNACE_BOAT.get(), () -> BoatloadItems.LARGE_ACACIA_BOAT.get()));
	public static final BoatloadBoatType DARK_OAK = register(create(new ResourceLocation("dark_oak"), () -> Items.DARK_OAK_PLANKS, () -> Items.DARK_OAK_BOAT, () -> Items.DARK_OAK_CHEST_BOAT, () -> BoatloadItems.DARK_OAK_FURNACE_BOAT.get(), () -> BoatloadItems.LARGE_DARK_OAK_BOAT.get()));
	public static final BoatloadBoatType MANGROVE = register(create(new ResourceLocation("mangrove"), () -> Items.MANGROVE_PLANKS, () -> Items.MANGROVE_BOAT, () -> Items.MANGROVE_CHEST_BOAT, () -> BoatloadItems.MANGROVE_FURNACE_BOAT.get(), () -> BoatloadItems.LARGE_MANGROVE_BOAT.get()));

	public static BoatloadBoatType create(ResourceLocation registryName, Supplier<Item> planks, Supplier<Item> boat, Supplier<Item> chestBoat, Supplier<Item> furnaceBoat, Supplier<Item> largeBoat) {
		return new BoatloadBoatType(registryName, planks, boat, chestBoat, furnaceBoat, largeBoat);
	}

	public static synchronized BoatloadBoatType register(BoatloadBoatType type) {
		BOAT_TYPES.add(type);
		return type;
	}

	public static ImmutableList<BoatloadBoatType> values() {
		return ImmutableList.copyOf(BOAT_TYPES);
	}

	public static BoatloadBoatType getTypeFromString(String name) {
		for (BoatloadBoatType type : values()) {
			if (type.registryName().toString().equals(name)) return type;
		}
		return OAK;
	}

	public static BoatloadBoatType getTypeFromBoat(Item boat) {
		for (BoatloadBoatType type : values()) {
			if (type.boat().get() == boat) return type;
		}
		return OAK;
	}
}