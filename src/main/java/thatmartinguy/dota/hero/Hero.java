package thatmartinguy.dota.hero;

public class Hero
{
    private String name;

    protected float strength;
    protected float agility;
    protected float intelligence;

    public Hero(String name, float strength, float agility, float intelligence)
    {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    /**
     * Gets the hero's current attributes
     * @return An array, going in the order [strength, agility, intelligence]
     */
    public float[] getAttributes()
    {
        return new float[] {strength, agility, intelligence};
    }

    public String getName()
    {
        return name;
    }
}
