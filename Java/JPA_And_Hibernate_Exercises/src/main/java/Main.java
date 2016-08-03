import javafx.geometry.Pos;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_And_Hibernate_Exercises");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        try {
            //listAllPosts(em, cb);
            //listAllUsers(em, cb);
            //orderData(em, cb);
            //orderByTwoColumns(em, cb);
            //selectAuthors(em, cb);
            //joinAuthorsWithTitles(em, cb);
            //selectAuthorOfSpecificPost(em, cb);
            //createData(em);
            //updateData(em);
            //deleteData(em);


        } finally {
            {
                em.close();
                emf.close();
            }
        }
    }

    private static void deleteData(EntityManager entityManager) {
        Post post = entityManager.find(Post.class, 34);

        entityManager.getTransaction().begin();

        post.getComments().clear();
        post.getTags().clear();
        entityManager.remove(post);

        entityManager.getTransaction().commit();
    }

    private static void updateData(EntityManager entityManager) {
        Post post = entityManager.find(Post.class, 34);
        post.setContent("Random Content should be replaced.");

        entityManager.getTransaction().begin();
        entityManager.persist(post);
        entityManager.getTransaction().commit();
    }

    private static void createData(EntityManager entityManager) {
   User user = entityManager.find(User.class, 2);
        LocalDateTime date = LocalDateTime.MAX.now();
        Post post = new Post();

        post.setAuthor(user);
        post.setTitle("Random Title");
        post.setContent("Random Content");
        post.setDate(date);

        entityManager.getTransaction().begin();
        entityManager.persist(post);
        entityManager.getTransaction().commit();
    }

    private static void selectAuthorOfSpecificPost(EntityManager entityManager, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);

        query.where(
                criteriaBuilder.equal(userRoot.join("posts").get("id"), 4)).select(userRoot);
        List<User> users = entityManager.createQuery(query).getResultList();

        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Name: " + user.getFullname());
        }

    }

    private static void joinAuthorsWithTitles(EntityManager entityManager, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<Post> query = criteriaBuilder.createQuery(Post.class);
        Root<Post> postRoot = query.from(Post.class);

        query.select(postRoot);

        List<Post> posts = entityManager.createQuery(query).getResultList();

        for (Post post : posts) {
            System.out.println("Author: " + post.getAuthor().getUsername());
            System.out.println("Title: " + post.getTitle());
        }
    }

    private static void selectAuthors(EntityManager entityManager, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);

        query.where(criteriaBuilder.gt(criteriaBuilder.size(userRoot.get("posts")), 0)).select(userRoot);

        List<User> users = entityManager.createQuery(query).getResultList();

        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Nam: " + user.getUsername());
            System.out.println("Count: " + user.getPosts().size());
        }
    }

    private static void orderByTwoColumns(EntityManager entityManager, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);

        query.select(userRoot);
        query.orderBy(criteriaBuilder.desc(userRoot.get("username")));

        List<User> users = entityManager.createQuery(query).getResultList();

        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Name: " + user.getFullname());
        }
    }

    private static void orderData(EntityManager entityManager, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);

        query.select(userRoot);
        query.orderBy(criteriaBuilder.asc(userRoot.get("username")));

        List<User> users = entityManager.createQuery(query).getResultList();

        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Name: " + user.getFullname());
        }
    }

    private static void listAllUsers(EntityManager entityManager, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> postRoot = query.from(User.class);

        query.select(postRoot);

        List<User> users = entityManager.createQuery(query).getResultList();
        for (User user : users) {
            System.out.println("ID: " + user.getId());
            System.out.println("Name: " + user.getFullname());
            System.out.println("Username: " + user.getUsername());
        }
    }

    public static void listAllPosts(EntityManager entityManager, CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<Post> query = criteriaBuilder.createQuery(Post.class);
        Root<Post> postRoot = query.from(Post.class);

        query.select(postRoot);

        List<Post> posts = entityManager.createQuery(query).getResultList();
        for (Post post : posts) {
            System.out.println("Title: " + post.getTitle());
            System.out.println("Author ID: " + post.getAuthor().getId());
        }
    }

}
