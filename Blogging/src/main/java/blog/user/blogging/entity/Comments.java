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
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String commentDescription;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Users users;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Blogs blogs;

    public Long userId(){
        return this.users.getUserId();
    }

    public Long blogId(){
        return this.blogs.getBlogId();
    }
}
