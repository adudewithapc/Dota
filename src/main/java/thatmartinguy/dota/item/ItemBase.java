package thatmartinguy.dota.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import thatmartinguy.dota.Dota;

import javax.annotation.Nullable;

public class ItemBase extends Item
{
    public ItemBase(String name)
    {
        this(name, Dota.TAB_DOTA);
    }

    public ItemBase(String name, @Nullable CreativeTabs creativeTab)
    {
        this.setName(name);
        this.setCreativeTab(creativeTab);
    }

    private void setName(String name)
    {
        this.setRegistryName(name);
        this.setUnlocalizedName(this.getRegistryName().toString());
    }
}
