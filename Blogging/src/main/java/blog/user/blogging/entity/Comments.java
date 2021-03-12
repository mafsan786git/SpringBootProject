package blog.user.blogging.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "users","blogs"})
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String commentDescription;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Users users;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Blogs blogs;

    public Long getUserId(){
        return this.users.getUserId();
    }

    public Long getBlogId(){
        return this.blogs.getBlogId();
    }
}
