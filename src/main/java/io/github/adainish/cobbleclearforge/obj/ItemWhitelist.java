package io.github.adainish.cobbleclearforge.obj;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemWhitelist
{

    public List<String> whitelistedItemIDs = new ArrayList<>();

    public ItemWhitelist()
    {}

    public static Item getItemFromString(String id)
    {
        ResourceLocation location = ResourceLocation.parse(id);
        return BuiltInRegistries.ITEM.get(location);
    }

    public List<Item> convertedWhiteListedItems()
    {
        List<Item> items = new ArrayList<>();
        for (String s : whitelistedItemIDs) {
            //pull item from registry and add to whitelist
            Item item = getItemFromString(s);
            if (item != null)
                items.add(item);
        }
        return items;
    }

    public boolean isWhiteListed(String string)
    {
        for (String s:whitelistedItemIDs) {
            if (string.equalsIgnoreCase(s))
                return true;
        }
        return false;
    }

    public boolean isWhiteListed(ItemEntity itemEntity)
    {
        Item item = itemEntity.getItem().getItem();
        return convertedWhiteListedItems().contains(item);
    }
}
