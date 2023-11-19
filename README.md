# A2

Mancala Game

## Description

This program is a text-based implementation of the classic board game Mancala. Mancala is a two-player strategy game that involves moving stones around a board, aiming to capture the most stones in your store. In this version of Mancala, players take turns distributing stones from their pits across the board, following specific rules outlined in the official game rules. The game ends when a player accumulates the most stones in their store.

## Getting Started

### Dependencies

* All the dependencies are provided by the `scioer shell`



### Executing program


* Run gradle build
```
gradle build
```
* run gradle echo
```
gradle echo
```
* Enter the the command of the last line gradle echo outputs
```
java -cp build/classes/java/main ui.TextUI
```
* Expected Output:
```
Mancala Game
Mancala Game
Current Player: Player 1
Winner: None
         12   11   10    9    8   7
   |---|----|----|----|----|----|----|----|
       |  4 |  4 |  4 |  4 |  4 |  4 |
P2   0 |-----------------------------|  0    P1
       |  4 |  4 |  4 |  4 |  4 |  4 |
   |---|----|----|----|----|----|----|----|
         1    2    3    4    5    6

Player 1's turn.
Enter the pit number to move from (1-6 for Player 1, 7-12 for Player 2): 
```

## Limitations

* The player's stones get distributed in the opposite store

## Author Information

**Name:** Mohammad Sameer  
**Email:** msamee01@uoguelph.ca  
**Student ID:** 1226033    



## Development History


My version of the mancala game accounts for edge cases and implements more complex features like distributing the stones correctly. The AI version struggles to implement these complex rules and handle errors. 

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)



