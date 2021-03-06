public class Equiptment
{
    private String name;
    private int attackModifier;
    private int defenseModifier;

    public Equiptment()
    {
        this.name = "Bare Hands";
        this.attackModifier = 0;
        this.defenseModifier = 0;
    }
    
    public Equiptment(String name, int attackModifier, int blockModifier)
    {
        this.name = name;
        this.attackModifier = attackModifier;
        this.defenseModifier = blockModifier;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAttackModifier()
    {
        return attackModifier;
    }

    public void setAttackModifier(int strengthkModifier)
    {
        this.attackModifier = strengthkModifier;
    }

    public int getDefenseModifier()
    {
        return defenseModifier;
    }

    public void setDefenseModifier(int modifier)
    {
        this.defenseModifier = modifier;
    }

    @Override
    public String toString()
    {
        return  name + " attack+ " + attackModifier + ", block+ " + defenseModifier;
    }
    
    
}