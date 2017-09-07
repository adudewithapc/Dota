package thatmartinguy.dota.ability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import thatmartinguy.dota.capability.Capabilities;
import thatmartinguy.dota.capability.IHeroCapability;
import thatmartinguy.dota.util.LogHelper;

import javax.annotation.Nullable;

import static thatmartinguy.dota.ability.Ability.CastResult.*;

public class Ability
{
    protected String name;
    /** Whether or not the ability will activate once a key is pressed.**/
    protected boolean activatable = true;
    /** Whether or not the ability has a passive component.
     * This is different from it being activatable (take Slark's shadow dance for example).
     **/
    protected boolean hasPassive;
    protected int manaCost;
    /** Max cooldown in ticks **/
    protected int maxCooldown;

    /** Cooldown remaining = world time when used - current time **/
    private long cooldown;

    public Ability(String name)
    {
        this(name, 0, 0);
    }

    public Ability(String name, int maxCooldown, int manaCost)
    {
        this.name = name;
        this.maxCooldown = maxCooldown * 20;
        this.manaCost = manaCost;
    }

    /**
     * Called when the ability's hotkey is pressed. Checks whether the ability could be successfully casted or not, and displays an error if it didn't
     * @param player The player casting the ability
     * @param traceResult The RayTraceResult object
     */
    public final void cast(EntityPlayer player, @Nullable RayTraceResult traceResult)
    {
        if(getCastResult(player, traceResult) != SUCCESS)
        {
            //TODO: Display error
        }
        else
        {
            execute(player, traceResult);

            startCooldown(player.world);
        }
    }

    /**
     * Called when the ability's hotkey when the ability can be successfully cast
     * @param player The player casting the ability
     * @param traceResult The RayTraceResult object
     */
    protected void execute(EntityPlayer player, @Nullable RayTraceResult traceResult)
    {

    }

    /**
     * Get the result of trying to use this ability. The ability will only execute if the result is {@link CastResult#SUCCESS}
     * @param player The player casting the ability
     * @param traceResult The RayTraceResult object
     * @return The cast result type
     */
    public CastResult getCastResult(EntityPlayer player, @Nullable RayTraceResult traceResult)
    {
        IHeroCapability heroCapability = player.getCapability(Capabilities.HERO_CAPABILITY, null);
        if(isAbilityCooling(player.world))
            return ON_COOLDOWN;
        if(heroCapability.getMana() > heroCapability.getMaxMana())
            return NO_MANA;
        else
            return SUCCESS;
    }

    /**
     * If the ability has a passive component this method will trigger it
     * @param player The player who's ability has been triggered
     */
    public void triggerPassive(EntityPlayer player)
    {

    }

    /**
     * Checks if the passive component can trigger
     * @param player The player with the ability
     * @return If the ability can trigger
     */
    protected boolean canPassiveTrigger(EntityPlayer player)
    {
        return hasPassive;
    }

    /**
     * Starts the cooldown if possible
     * @param world The world object to get the time from
     */
    private void startCooldown(World world)
    {
        if(!isAbilityCooling(world))
        {
            this.cooldown = world.getWorldTime();
        }
    }

    public void setActivatable(boolean activatable)
    {
        this.activatable = activatable;
    }

    public boolean isActivatable()
    {
        return activatable;
    }

    /**
     * Check whether the ability is on cooldown or not
     * @param world The world object to get the current time from
     * @return Whether or not the ability is on cooldown
     */
    public boolean isAbilityCooling(World world)
    {
        return world.getWorldTime() < cooldown + maxCooldown;
    }

    protected enum CastResult
    {
        SUCCESS(""),
        NO_MANA("You don't have enough mana to cast that"),
        ON_COOLDOWN("That is not ready");

        private String message;

        CastResult(String message)
        {
            this.message = message;
        }

        public String getMessage()
        {
            return message;
        }

        @Override
        public String toString()
        {
            return message;
        }
    }
}
