package thatmartinguy.dota.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import thatmartinguy.dota.capability.Capabilities;
import thatmartinguy.dota.capability.IHeroCapability;
import thatmartinguy.dota.hero.EnumHero;

public class ItemHeroChecker extends ItemBase
{
    public ItemHeroChecker(String name)
    {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        if(playerIn.hasCapability(Capabilities.HERO_CAPABILITY, null))
        {
            IHeroCapability heroCapability = playerIn.getCapability(Capabilities.HERO_CAPABILITY, null);

            if(heroCapability.getHero().getName().equals(EnumHero.NONE.getName()))
            {
                heroCapability.setHero(EnumHero.OMNIKNIGHT);
                playerIn.sendMessage(new TextComponentString("Set the hero as \"Omniknight\""));
            }
            else
            {
                playerIn.sendMessage(new TextComponentString("You are currently playing as " + heroCapability.getHero().getName()));
            }
        }
        else
        {
            playerIn.sendMessage(new TextComponentString("The player does not have the hero capability"));
        }

        return new ActionResult<>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
    }
}
