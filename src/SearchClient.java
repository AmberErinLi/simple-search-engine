import java.io.*;
import java.util.*;

// This class allows users to find and rate books within BOOK_DIRECTORY
// containing certain terms
public class SearchClient {
    public static final String BOOK_DIRECTORY = "./books";
    private static final Random RAND = new Random();

    public static final int MIN_RATING = 1;
    public static final int MAX_RATING = 5;
    public static final int MIN_NUM_RATINGS = 1;
    public static final int MAX_NUM_RATINGS = 100;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        List<Media> media = new ArrayList<>(loadBooks());

        Map<String, Set<Media>> index = createIndex(media);

        System.out.println("Welcome to the CSE 123 Search Engine!");
        String command = "";
        while (!command.equalsIgnoreCase("quit")) {
            System.out.println("What would you like to do? [Search, Rate, Quit]");
            System.out.print("> ");
            command = console.nextLine();

            if (command.equalsIgnoreCase("search")) {
                searchQuery(console, media, index);
            } else if (command.equalsIgnoreCase("rate")) {
                addRating(console, media);
            } else if (!command.equalsIgnoreCase("quit")) {
                System.out.println("Invalid command, please try again.");
            }
        }
        System.out.println("See you next time!");
    }

    // Behavior:
    //   - Creates an inverted index mapping terms to the Set of Media containing those terms.
    //     The terms are considered case-insensitively and are ordered alphabetically in the
    //     inverted index.
    // Returns:
    //   - The inverted index with terms mapped to the Set of Media that contains them.
    // Parameters:
    //   - documents - the Media objects that will be mapped to the terms that they contain
    public static Map<String, Set<Media>> createIndex(List<Media> documents) {
        Map<String, Set<Media>> index = new TreeMap<>();
        for (Media doc : documents) {
            for (String word : doc.getContent()) {
                if (!index.containsKey(word.toLowerCase())) {
                    Set<Media> locations = new HashSet<>();
                    locations.add(doc);
                    index.put(word.toLowerCase(), locations);
                } else {
                    index.get(word.toLowerCase()).add(doc);
                }
            }
        }
        return index;  
    }

    // Returns:
    //   - The Set of Media entries in the provided index that contain the given search query.
    // Parameters:
    //   - Map<String, Set<Media>> index - an inverted index mapping terms to the set of media
    //     containing those terms. Should be non-null.
    //   - String query - the query that the media objects will be searched for
    public static Set<Media> search(Map<String, Set<Media>> index, String query) {
        Set<Media> relevant = new TreeSet<>();
        if (!index.containsKey(query.toLowerCase())) {
            return relevant;
        }
        for (Media media : index.get(query.toLowerCase())) {
            relevant.add(media);
        }
        return relevant;
    }
    
    // Behavior:
    //   - Allows the user to search a specific query using the provided index to find
    //     appropriate Media entries.
    // Parameters:
    //   - Scanner console - takes user input for a search query. Should be non-null.
    //   - List<Media> documents - The Media documents searched for the query and mapped to
    //     terms in the inverted index.
    //   - Map<String, Set<Media>> index - an inverted index mapping terms to the Set of Media
    //     containing those terms. Should be non-null
    public static void searchQuery(Scanner console, List<Media> documents, 
                                   Map<String, Set<Media>> index) {
        System.out.println("Enter query:");
        System.out.print("> ");
        String query = console.nextLine();

        Set<Media> result = search(index, query);
        
        if (result.isEmpty()) {
            System.out.println("\tNo results!");
        } else {
            for (Media m : result) {
                System.out.println("\t" + m.toString());
            }
        }
    }

    // Behavior:
    //   - Allows the user to add a rating to one of the options within a List of Media
    // Parameters:
    //   - Scanner console - takes user input for the rating. Should be non-null.
    //   - List<Media> media - list of all Media options loaded into the search engine.
    //     Should be non-null.
    public static void addRating(Scanner console, List<Media> media) {
        for (int i = 0; i < media.size(); i++) {
            System.out.println("\t" + i + ": " + media.get(i).toString());
        }
        System.out.println("What would you like to rate (enter index)?");
        System.out.print("> ");
        int choice = Integer.parseInt(console.nextLine());
        if (choice < 0 || choice >= media.size()) {
            System.out.println("Invalid choice");
        } else {
            System.out.println("Rating [" + media.get(choice).getTitle() + "]");
            System.out.println("What rating would you give?");
            System.out.print("> ");
            int rating = Integer.parseInt(console.nextLine());
            media.get(choice).addRating(rating);
        }
    }

    // Behavior:
    //   - Loads all books from BOOK_DIRECTORY. Assumes that each book starts with two lines -
    //     "Title: " which is followed by the book's title
    //     "Author: " which is followed by the book's author
    // Exceptions:
    //   - Throws FileNotFoundException if the BOOK_DIRECTORY file does not exist.
    // Returns:
    //   - A list of all Book objects corresponding to the ones located in BOOK_DIRECTORY
    public static List<Media> loadBooks() throws FileNotFoundException {
        List<Media> ret = new ArrayList<>();
        
        File dir = new File(BOOK_DIRECTORY);
        for (File f : dir.listFiles()) {
            Scanner sc = new Scanner(f, "utf-8");
            String title = sc.nextLine().substring("Title: ".length());
            List<String> author = List.of(sc.nextLine().substring("Author: ".length()));

            Media book = new Book(title, author, sc);

            // Adds random ratings to 'book' based on the class constants. 
            // Feel free to comment this out.
            int minRating = RAND.nextInt(MIN_RATING, MAX_RATING + 1);
            addRatings(minRating, Math.min(MAX_RATING, RAND.nextInt(minRating, MAX_RATING + 1)),
                        RAND.nextInt(MIN_NUM_RATINGS, MAX_NUM_RATINGS), book);
            ret.add(book);
        }

        return ret;
    }

    // Adds ratings to the provided media numRatings amount of times. Each rating is a random int
    // between minRating and maxRating (inclusive).
    private static void addRatings(int minRating, int maxRating, int numRatings, Media media) {
        for (int i = 0; i < numRatings; i++) {
            media.addRating(RAND.nextInt(minRating, maxRating + 1));
        }
    }
}
