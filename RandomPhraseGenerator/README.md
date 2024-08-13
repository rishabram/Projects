# Random Phrase Generator

This project was developed in conjunction with the knowledge from my Java Data Structures course and was brainstormed and created as a joint collaborative project with Josh Greenbaum. The goal was to create a program that generates random phrases based on a given grammar file. The project emphasizes the use of efficient data structures and algorithms to solve the problem while adhering to object-oriented programming principles.

## Overview
In many video games, characters need to say phrases during gameplay. These phrases must follow a specific format (e.g., a noun followed by a verb followed by an object) but must also be randomized to avoid repetition. The task was to construct a program that generates these random phrases based on an input grammar file.
The input grammar file defines the structure of the phrases using non-terminals (enclosed in `<angle brackets>`) and terminals (without angle brackets). Each non-terminal is defined by a set of possible expansions, allowing for the generation of various phrases.
The Random Phrase Generator is a Java program that reads a context-free grammar from a file and generates random phrases according to the rules specified in the grammar. The program is designed to be efficient and to follow best practices in object-oriented programming.

### Core Features:
- **Random Phrase Generation:** Generates a specified number of random phrases based on the grammar rules.
- **Command-Line Interface:** The program can be executed from the command line, accepting a grammar file and the number of phrases to generate as arguments.
- **Object-Oriented Design:** The project is structured with clear separation of concerns, making it easy to extend and maintain.

## Data Structures Used
This project leverages several key data structures to efficiently manage and generate random phrases:

1. **HashMap (Map<String, String[]>)**: 
   - Used to store the non-terminals and their corresponding expansions. The non-terminal names are the keys, and the values are arrays of possible expansions.
   - **Why HashMap?** The `HashMap` provides average O(1) time complexity for lookups, making it an ideal choice for retrieving the expansions of non-terminals quickly.

2. **ArrayList (ArrayList<String> and ArrayList<Phrase>)**: 
   - Utilized to store lists of phrases associated with each non-terminal and also during the parsing process.
   - **Why ArrayList?** The `ArrayList` is chosen for its dynamic resizing capability and ease of appending elements, which is useful during the parsing and storage of phrases.

3. **Random(Built-In Java Class)**:
   - Used to randomly select one of the possible expansions for a given non-terminal during phrase generation.
   - **Why Random?** The `Random` class provides a straightforward method to generate random integers, ensuring that the phrase generation is both varied and unpredictable.

## Project Structure

### Core Classes:
- **`Grammar6.java`**:
  - Manages the parsing of the grammar file and the generation of random phrases.
  - Methods:
    - `Grammar6(File file)`: Constructor that initializes the grammar from the specified file.
    - `print(int num)`: Prints a specified number of random phrases.
    - `Build(File file)`: Builds the grammar from a file, parsing non-terminals and their expansions.
    - `generatePhrase(String nonterminal)`: Recursively generates a phrase starting from a given non-terminal.

- **`RandomPhraseGenerator.java`**:
  - The driver class that initiates the program. It reads command-line arguments to determine the grammar file and the number of phrases to generate.
  - Methods:
    - `main(String[] args)`: Main method to execute the program.

- **`Phrase.java`**:
  - Represents a phrase that can be printed to the console. It handles the expansion of non-terminals within the phrase.
  - Methods:
    - `Phrase(String phrase, Grammar parent)`: Constructor to initialize the phrase with a string and the parent grammar.
    - `print()`: Prints the phrase, expanding non-terminals as necessary.

- **`NonTerminal.java`**:
  - Represents a non-terminal in the grammar. It contains a list of possible phrases and can print a randomly selected phrase.
  - Methods:
    - `NonTerminal()`: Constructor to initialize the non-terminal.
    - `print()`: Prints a random phrase from the list of phrases.
    - `add(Phrase phrase)`: Adds a phrase to the list of possible expansions.

### Grammar Files:
- The project includes a sample grammar file that can demonstrate the capabilities of the random phrase generator:
  - `sampleTestGrammar`

## How to Run

To run the program and generate random phrases, follow these steps:

1. **Compile the Java files**: 
   javac comprehensive/Grammar6.java comprehensive/RandomPhraseGenerator.java comprehensive/Phrase.java comprehensive/NonTerminal.java

   Run the program:
java comprehensive.RandomPhraseGenerator <path_to_grammar_file> <number_of_phrases>

Example:
java comprehensive.RandomPhraseGenerator super_simple.g 5
This command will generate five random phrases based on the super_simple.g grammar file.

Efficiency Considerations
The project’s performance was optimized by carefully choosing data structures that support fast lookup, storage, and retrieval operations:

HashMap for Fast Lookups: Using a HashMap for storing non-terminals ensures quick retrieval of expansions, minimizing the time required to generate phrases.
StringBuilder for Efficient String Manipulation: The StringBuilder is used to construct the final phrases, avoiding the overhead associated with concatenating strings in a loop.
Minimized File I/O: The grammar file is read once at the start, and all necessary data is stored in memory, reducing the need for repeated I/O operations.
Documentation
All classes and methods are well-documented using Javadoc, ensuring that the code is easy to understand and maintain. The comments provide insights into the purpose and functionality of each component, making the codebase accessible to other developers.

Conclusion
This project provided valuable experience in problem-solving, collaborative programming. software design, and the application of data structures in a real-world scenario. It was a comprehensive exercise in both individual coding skills and collaboration through pair programming.
