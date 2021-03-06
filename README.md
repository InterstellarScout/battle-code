# battle-code
Basic Java Programming Project, used to help teach Java

Dean Sheldon
Northern Essex Community College
CIS141 Computer Science 1
Project Number 4: Battle Code

This program is a continuation of the previous projects BattleCode. This code implements inheritence into the code to make Equipped Heroes. Small changes and additions were made to the code consisting of
additions of new code like Equiptment which was a given and EquippedHero which was added. All Overrides and modifications to the methods were created and edited accordingly. The modification to the
battlemanager was successful as well; adding another constructor of EquippedHero(). Other than that, all other code was left the way it needed to be. As far as the assignment is concerned, as far as I know
all requirements were met.

This program is created to make two heroes that go up against each other in order to go into combat. The original program uses their stats and dice to make them fight and defend properly. 
Once either a player goes down or the rounds end, the game will automatically end declaring the winner with the most health. This project adds an additional feature of battle and tournaments which automatically creates 
an array of characters that go up against each other until a winner is declared.

Completion Statement:
A challenging aspect of this assignment was how annoying it is to create loops in the proper syntax, and then throwing in arrays on top of that. It can occationally become just a giant error. With some working
out, I believe we were able to work out most of the kinks loop and function wise. The array moves from space to space properly, the winning hero's  stats get reset, automatically moving odd heroes further to keep the 
rounds even, and each loop of the battles is tracked to make it easier to track. Apart from the help i got from you, all other work was done by myself. If all is well the code will continue to run happily!

In addition, the most challenging aspect of this assignment was figuring out where to put modifications in order to make the hero properly modified. For example, where to put the attack modifier. Originally I
thought the attack modifier was going to be added to the initial creation of the hero or EquippedHero. That was not right because those modifications had to be added in the actual Attack and Defend methods.
That opened up the need to have an override method in the EquippedHero class that would be used instead of the one in the Heroes class. All code is original and was created without any reference for once.

Enjoy!