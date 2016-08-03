import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nakov on 28-Jul-16.
 */
public class Examples {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("jpa_and_hibernate_lab");
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);
        try {
            //createNewUser(em, sc);
            //createNewPost(em, sc);
            //createNewUserWith10Posts(em, sc);
            //listAllPosts(em, sc);
            //listPostsByAuthor(em,sc);
            //editExistingUser(em, sc);
            //deleteExistingUser(em, sc);
            executeNativeSQL(em, sc);
        }
        finally {
            em.close();
            emf.close();
        }

    }

    private static void executeNativeSQL(EntityManager em, Scanner sc) {
        LocalDateTime startDate =
                LocalDateTime.parse("2016-05-19T12:00:00");
        LocalDateTime endDate = LocalDateTime.now();
        Query postsQuery = em.createNativeQuery(
                "SELECT id, title, date, body, author_id FROM posts " +
                        "WHERE CONVERT(date, Date) " +
                        "BETWEEN :startDate AND :endDate", Post.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate);
        List<Post> posts = postsQuery.getResultList();
        for (Post post : posts)
            System.out.println(post);

    }

    private static void deleteExistingUser(EntityManager em, Scanner sc) {
        // Load an existing user by ID
        User firstUser = em.find(User.class, sc.nextLong());
// Delete the user along with its posts
        em.getTransaction().begin();
//        for (Post post : firstUser.getPosts())
//            em.remove(post);
        em.remove(firstUser);
        em.getTransaction().commit();
        System.out.println("Deleted existing user #" +
                firstUser.getId());

    }

    private static void editExistingUser(EntityManager em, Scanner sc) {
        // Load an existing user by ID
        User firstUser = em.find(User.class, sc.nextLong());
        sc.nextLine();
// Modify the User
        firstUser.setPasswordHash("" + new Date().getTime());
        firstUser.setFullName(sc.nextLine());
// Persist pending changes
        em.getTransaction().begin();
        em.persist(firstUser);
        em.getTransaction().commit();
        System.out.println(
                "Edited existing user #" + firstUser.getId());

    }

    private static void listPostsByAuthor(EntityManager em, Scanner sc) {
        Query peshoPosts =
                em.createQuery(
                        "FROM Post p JOIN FETCH p.author " +
                                "WHERE p.author.username " +
                                "LIKE CONCAT(:username, '%') ")
                        .setParameter("username", sc.nextLine());
        List<Post> posts = peshoPosts.getResultList();
        for (Post post : posts) {
            System.out.println(post);
        }

    }

    private static void listAllPosts(EntityManager em, Scanner sc) {
        Query allPostsQuerySlow = em.createQuery(
                "SELECT p FROM Post p");
        Query allPostsQuery = em.createQuery(
                "SELECT p FROM Post p JOIN FETCH p.author");
        List<Post> posts =
                allPostsQuery.getResultList();
        for (Post post : posts) {
            System.out.println(post);
        }

    }

    private static void createNewUserWith10Posts(EntityManager em, Scanner sc) {
        em.getTransaction().begin();
        User newUser = new User();
        newUser.setUsername("pesho" + new Date().getTime());
        newUser.setPasswordHash("pass12345"); newUser.setFullName("P.Petrov");
        em.persist(newUser);
        System.out.println("Created new user #" + newUser.getId());
        for (int i = 1; i <= 10; i++) {
            Post newPost = new Post();
            newPost.setTitle("Post Title " + i);
            newPost.setBody("<p>Body" + i + "</p>");
            newPost.setAuthor(newUser);
            em.persist(newPost);
            System.out.println("Created new post #" + newPost.getId());
        }
        em.getTransaction().commit();

    }

    private static void createNewPost(EntityManager em, Scanner sc) {
        Post newPost = new Post();
        newPost.setTitle(sc.nextLine());
        newPost.setBody(sc.nextLine());

        User author = new User();
        author.setUsername(sc.nextLine());
        em.getTransaction().begin();
        em.persist(author);

        newPost.setAuthor(author);

        em.persist(newPost);
        em.getTransaction().commit();
        System.out.println("Created new post #" + newPost.getTitle());
    }

    private static void createNewUser(EntityManager em, Scanner sc) {
        User newUser = new User();
        newUser.setUsername(sc.nextLine());
        em.getTransaction().begin();
        em.persist(newUser);
        em.getTransaction().commit();
        System.out.println("Created new user #" + newUser.getId());
    }
}
