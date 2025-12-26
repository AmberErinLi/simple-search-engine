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
/simple-search-engine
├── src/ # Java source code
│ ├── Book.java
│ ├── SearchClient.java
│ └── Testing.java
├── README.md
└── (other resources, e.g., book content files)

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

