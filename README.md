# Simple Search Engine

This is a **Java-based search engine** that demonstrates indexing, ranking, and query operations to search through a collection of books. The project focuses on building a functional search system from the ground up while practicing object-oriented design, data structures, and algorithmic thinking.

---

## 🛠️ Features
- **Book Representation:** Implements a `Book` class following a provided `Media` interface. Stores title, author(s), content, and ratings, with proper encapsulation.
- **Inverted Index:** Builds an inverted index mapping tokens (words) to the books that contain them. The index supports case-insensitive searches and efficient lookup.
- **Search Functionality:** Users can query the index to find relevant books. Results are ranked based on a `Comparable` implementation in the `Book` class.
- **Custom Ranking:** Books are ordered using a comparison algorithm that considers ratings and relevance to search queries.
- **Testing:** Includes JUnit tests to verify correct behavior of indexing, search, and book representation.

---

## 📂 Repository Structure
The project is organized as follows:

/simple-search-engine
├── src/ # Java source code
│ ├── Media.java # Interface representing generic media (books, movies, etc.)
│ ├── Book.java # Class representing a Book implementing Media
│ ├── SearchClient.java # Handles indexing and search queries
│ └── Testing.java # JUnit tests for all classes and methods
├── books/ # Sample book text files used for testing
│ ├── Dracula.txt
│ ├── Frankenstein; Or, the Modern Prometheus.txt
│ ├── Gulliver's Travels into Several Remote Nations of the World.txt
│ ├── Romeo and Juliet.txt
│ ├── The Great Gatsby.txt
│ ├── The Picture of Dorian Gray.txt
│ ├── The War of the Worlds.txt
│ ├── Treasure Island.txt
│ └── Winnie-the-Pooh.txt
├── README.md # Project overview and instructions
└── .gitignore # Ignore compiled files and IDE artifacts

---

## 🎯 Learning Objectives
- Implement Java classes representing compound data types
- Use object-oriented principles to model real-world entities
- Build and query an inverted index for efficient search
- Apply Comparable interface for custom ordering
- Write and update unit tests to verify program correctness

---

## ⚡ Skills Demonstrated
- Java programming and object-oriented design
- Data structures: lists, maps, sets
- Inverted indexing and search algorithms
- Test-driven development with JUnit

---

## 🔗 Usage

1. Clone the repository:
   ```bash
   git clone https://github.com/amberli/simple-search-engine.git
2. Open in Visual Studio Code (or your preferred IDE) and ensure the src/ folder is recognized as the source directory.
3. Run the main() method in SearchClient.java. This will execute the search engine using the sample books in the data/ folder. You can modify the queries or add more books to test different scenarios.
4. (Optional) Run Testing.java to verify correctness using JUnit tests.
