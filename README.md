# A1 Task One

Book lending program

## Description

In this task, we've implemented a `Book` class that simulates a book lending system. The `Book` class represents the characteristics of a book in a lending library, including its title, author, and status (borrowed or not). Users can interact with books by borrowing and returning them.

## Getting Started

### Dependencies

* All the dependencies are provided by the `scioer shell`



### Executing program

* Change directory into TaskOne
```
cd TaskOne
```
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
java -cp build/classes/java/main book.Runner
```
* Expected Output:
```
TEST CASE 1: Test Book methods
Book Name: Speak Now: Taylor Swift
Book Borrowed: Speak Now
Give back Book: true
Book Borrowed: Speak Now

TEST CASE 2: Borrow already borrowed book
Book Name: Utopia: Travis Scott
Book Borrowed: 

TEST CASE 3: Give back already available book
Book Name: Coast: Hailee Steinfeld
Give back Book: false

TEST CASE 4: Borrow book with no title or author
Book Name: null: null
Book Borrowed: null

TEST CASE 5: Show title and author seperately
Book Name: Speak Now
Book Author: Taylor Swift
```

## Limitations

* No user input because the instructions say to hard code book characteristics in the runner class

## Author Information

**Name:** Mohammad Sameer  
**Email:** msamee01@uoguelph.ca  
**Student ID:** 1226033    



## Development History

Keep a log of what things you accomplish when.  You can use git's tagging feature to tag the versions or you can reference commits.

* 0.1
    * Initial Release

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)



