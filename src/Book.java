import java.util.*;

// This class represents Book objects. Books store information such as their title, authors,
// and contents, and they can be rated.
public class Book implements Media, Comparable<Book> {
    private String title;
    private List<String> authors;
    private List<Integer> ratings;
    private List<String> words;

    // Behavior:
    //   - Creates a book with a title, authors, and a scanner
    // Parameters: 
    //   - String title - the title of the Book
    //   - List<String> authors - a list of authors of the Book
    //   - Scanner content - the scanner that contains the contents of the Book to scan through
    public Book(String title, List<String> authors, Scanner content) {
        this.title = title;
        this.authors = authors;
        this.ratings = new ArrayList<>();
        this.words = new ArrayList<>();
        while (content.hasNext()) {
            words.add(content.next());
        }
    }

    // Returns:
    //   - The title of the Book
    public String getTitle() {
        return title;
    }

    // Returns:
    //   - A list of authors of the Book
    public List<String> getArtists() {
        return authors;
    }

    // Behavior:
    //   - Adds a given score to the list of ratings of the Book
    // Parameters:
    //   - int score - the score to be added to the Book's list of ratings. This should be 
    //     non-negative
    public void addRating(int score) {
        ratings.add(score);
    }

    // Returns:
    //   - The number of ratings the Book has
    public int getNumRatings() {
        return ratings.size();
    }

    // Behavior:
    //   - Calculates and returns the average rating for the Book
    // Returns:
    //   - The Book's average rating or 0 if the Book has no ratings
    public double getAverageRating() {
        int numRatings = this.getNumRatings();
        if (numRatings == 0) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        return sum / numRatings;
    }

    // Returns:
    //   - The list of words the Book contains
    public List<String> getContent() {
        return words;
    }

    // Returns:
    //   - A written description of the Book, including its title, authors, and its average
    //     rating and number of ratings if it has any
    public String toString() {
        if (this.getNumRatings() == 0) {
            return this.title + " by " + this.authors;
        }
        double average = Math.round(this.getAverageRating() * 100) / 100.0;
        return this.title + " by " + this.authors + ": " + average + " (" + 
            this.getNumRatings() + " ratings)";
    }

    // Behavior: 
    //   - Compares the average rating of this Book to that of another Book and returns a
    //     number that represents which rating is higher
    // Returns:
    //   - 1 if this Book has a lower average rating than the other Book
    //     0 if this Book has the same average rating as the other Book 
    //     -1 if this Book has a higher average rating than the other Book
    public int compareTo(Book other) {
        double thisRating = this.getAverageRating();
        double otherRating = other.getAverageRating();
        if (thisRating < otherRating) {
            return 1;
        } else if (thisRating == otherRating) {
            return 0;
        } else {
            return -1;
        }
    }
}
