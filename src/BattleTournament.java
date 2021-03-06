
public class BattleTournament {

    public static final int INITIAL_SIZE = 4;

    public static void main(String[] args)
    {

        BattleManager manager = new BattleManager();

        //an array of names to be used when creating heroes
        final String[] names =
        {
            "Hiro Protagonist", "Bruce Lee", "Chuck Norris", "Luke Cage",
            "Frank Castle", "Danny Rand", "Jessica Jones", "Mathew Murdock",
            "Wilson Fisk", "Victor Von Doom", "Jean Grey", "Elektra Natchios",
            "Steven Rogers", "James Howlett", "Wade Wilson", "Bruce Banner",
            "Peter Parker", "Tony Stark", "Susan Storm-Richards"
        };

        //an array of items to be used when creating equipped heroes
        final Equiptment[] items =
        {
            new Equiptment("Leather Gloves", 0, 0),
            new Equiptment("Studded Gloves", 2, 1),
            new Equiptment("Broad Sword", 5, -1),
            new Equiptment("Pair of Blades", 3, 1),
            new Equiptment("Wooden Shield", 1, 1),
            new Equiptment("Iron Shield", 2, 2)

        };


        //create an array of equippedheroes
        EquippedHero[] equippedList = new EquippedHero[INITIAL_SIZE];

        for (int i = 0; i < equippedList.length; i++)
        {

            //using mod to cycle through array names and items - 
            //could be randomly selected
            String name = names[i % names.length];
            Equiptment eq = items[i % items.length];
            equippedList[i] = manager.setHero(name, eq);
        }

        Heroes equippedwinner = manager.tournament(equippedList);
        System.out.println("Winner of equipped heroes is " + equippedwinner.getName());

    }

}
