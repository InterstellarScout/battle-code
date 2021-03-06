/*
An equipped hero has
A field of type Equipment
Methods to get/set the equipment in hand

A constructor that takes String - like the hero - and a piece of equipment. 

A constructor that takes a String - like the hero. Since the equipment is not specified in the constructor, the default equipment of "Bare Hands" should be assigned to the Hero. When equipment is created with the empty constructor, it creates "Bare Hands"

An equipped hero should override the attack and defend method of the Hero.
The new methods should call their parent method and add the modifier from the equipment.
*/

public class EquippedHero extends Heroes{
    
    Equiptment e = new Equiptment();

    public Equiptment getE() {
        return e;
    }

    public void setE(Equiptment e) {
        this.e = e;
    }

//Constructors
//Apply the equiptment to the hero
    
public EquippedHero(String name)
{
 super(name);
 //Gives the hero no equiptment. Bare hands. 
  //Heroes EQHero= new Heroes(name);
  Equiptment e = new Equiptment();
  
  e.setName("Bare Hands");
  
  e.setAttackModifier(0);
  e.setDefenseModifier(0);

}

public EquippedHero(String hero, Equiptment equiptment) 
{
super(hero);
    
}

@Override
public int Attack()
{
   int d20total;
   
if (stamina >= 6)
{
    
  loseStamina(6);
   
   Die d20;
   d20 = new Die();
   d20.setSides(20);
   d20.roll();
   
   d20total = d20.getValue();
   
   attack = d20total + agility + e.getAttackModifier(); //d20 rolled + player agility + equiptment attack modifier. 
   
   return attack;
}
    
else
    {
        System.out.println(name + " doesn't have enough stamina! " + name + " rests!");
        attack = 0;
        Rest();
        return attack;
        
    } 
}
    
@Override
public int Defend()
{
   
   int d20total;
   
if (stamina >= 4)
{
   loseStamina(4);
       
   Die d20;
   d20 = new Die();
   d20.setSides(20);
   d20.roll();
   
   d20total = d20.getValue();
   
   defence = d20total + agility + e.getDefenseModifier();
   
   return defence;
}
 
else
    {
        System.out.println(name + " doesn't have enough stamina! " + name + " rests!");
        defence = 0; 
        Rest();
        return defence;
    }
}

   private void Rest()
//When a player tries to attack/defend but is out of stamina, roll a 6 sided, an 8 sided die, and a 10 sided die. Add the highest value to health. Add the sum of the other two to stamina.   0
{
    int healthGain;
    int staminaGain;
   
    int die1;
    int die2;
    int die3;
    
   Die d6;
   Die d8;
   Die d10;
   
   d6 = new Die();
   d8 = new Die();
   d10 = new Die();
   
   d6.setSides(6);
   d8.setSides(8);
   d10.setSides(10);
   
   d6.roll();   
   die1 = d6.getValue();
   d8.roll();  
   die2 = d8.getValue();
   d10.roll();  
   die3 = d10.getValue();
   
   int firstMaxDie;
  
   //Calculations of Adding the highest value to health. Add the sum of the other two to stamina.
   firstMaxDie = Math.max(die1, die2);
   healthGain = Math.max(die3, firstMaxDie);
   
   staminaGain = die1 + die2 + die3;
   staminaGain = staminaGain - healthGain;
  
   addHealth(healthGain);
   addStamina(staminaGain);
   //all adjustments are made in the functions above
}

   
   
}
