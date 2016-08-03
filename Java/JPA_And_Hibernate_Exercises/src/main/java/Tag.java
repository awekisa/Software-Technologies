import javafx.geometry.Pos;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {
    private Integer id;

    private String name;

    private Set<Post> posts = new HashSet<>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Column(nullable = false)
    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToMany()
    @JoinTable(
            name="post_tags",
            joinColumns={@JoinColumn(name="tags_id", referencedColumnName = "id")},
            inverseJoinColumns={@JoinColumn(name="post_id", referencedColumnName = "id")})

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
