# fighters.Monster-Battle

A fun way to learn about Class Inheritance and Polymorphism in JAVA

## Part 1: Discuss Class Inheritance/Polymorphism with slides

[Link to Google Slides](https://docs.google.com/presentation/d/1GTl5BPuGU_LwpV4cR-CtP9ZPPLvdJUsaY50vs0dOiuA/edit?usp=sharing)

## Part 2: The Battlefield

### Phase 1: Creating your Warrior

- Build the base class for every creature: fighters.Being
- Build two sub-types: fighters.Human, fighters.Monster
- Build two battle types for Humans: fighters.Knight, fighters.Mage
- Build two battle types for Monsters: fighters.Troll, fighters.Elf
- Build two interfaces for any being class: fighters.Fighter, fighters.MagicUser

### Phase 2: Test your Warrior Classes

- Your objects need to pass all 8 test in the "test()" method provided to you.
- Experiment with different warrior types and stat point distributions to create the best warrior you can.
- Send your object code to the teacher. (this will just be the one line of code to create your object)

### Phase 3: Put your Warriors in Battle and Defeat your Classmates

- Teacher will plugin the code for each student and watch the mayhem in the tournament class

## To Do List

- [x] add all objects into an ArrayList
- [x] take first two items in AL and set them as Player1 and Player2
- finish the battle loop
    - [x] Players take turns with random actions
    - [x] player action methods generate values to modify stats with
    - [x] fix block/dodge
    - [x] player stats are updated
    - [x] fix battle action info for lastEvent.setText() in JavaFX window
    - [x] loop ends when P1 or P2 HP <= 0
    - [ ] after first battle, program moves to next two players
- [x] add functionality for all fighter battle methods 
- [x] refine attacks/defenses for each class
- [ ] include custom descriptive messages for battle start/end (communicate args)
- [ ] include an image for the objects, must be a 200x200 png/jpg
- [ ] include a strict mode that also checks for negative stat values (purposfully allowed by defaul to see if students can find the "cheat")

### Phase 4: Create Your Own Monsters and Customize your Actions
