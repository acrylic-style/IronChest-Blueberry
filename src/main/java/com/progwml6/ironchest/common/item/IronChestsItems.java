package com.progwml6.ironchest.common.item;

import com.google.common.collect.ImmutableMap;
import com.progwml6.ironchest.IronChests;
import net.blueberrymc.registry.BlueberryRegistries;
import net.blueberrymc.registry.DeferredRegister;
import net.blueberrymc.registry.RegistryObject;
import net.minecraft.world.item.Item;

import java.util.Arrays;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class IronChestsItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BlueberryRegistries.ITEM, IronChests.MODID);

  public static final ImmutableMap<IronChestsUpgradeType, RegistryObject<ChestUpgradeItem>> UPGRADES = ImmutableMap.copyOf(Arrays.stream(IronChestsUpgradeType.values())
          .collect(Collectors.toMap(Function.identity(), type -> register(type.name().toLowerCase(Locale.ROOT) + "_chest_upgrade",
                  () -> new ChestUpgradeItem(type, new Item.Properties().tab(IronChests.IRONCHESTS_ITEM_GROUP).stacksTo(1))))));

  private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> sup) {
    return ITEMS.register(name, sup);
  }
}
