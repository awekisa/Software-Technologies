import java.util.Random;
import java.util.Scanner;

public class ex25_AdvertisementMessage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        String[] phrases = {"Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."};
        String[] events = {"Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"};
        String[] authors = {"Diana",
                "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random rnd = new Random();

        for (int i = 0; i < num; i++) {
            int phraseIndex = rnd.nextInt(phrases.length);
            int eventsIndex = rnd.nextInt(events.length);
            int authorsIndex = rnd.nextInt(authors.length);
            int citiesIndex = rnd.nextInt(cities.length);
            System.out.println(phrases[phraseIndex] + " " + events[eventsIndex] + " " + authors[authorsIndex] + " - " + cities[citiesIndex]);
        }
    }
}
