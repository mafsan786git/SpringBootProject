package blog.user.blogging.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "commentList","blogList"})
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    @Column(unique = true,nullable = false)
    private String userMobile;

    @Column(unique = true,nullable = false)
    private String userEmail;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Blogs> blogList = new ArrayList<>();

    @OneToMany(mappedBy = "users",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Comments> commentList = new ArrayList<>();



    //all getter and setter
    public List<Comments> getCommentList() {
        return commentList;
    }

    public void setCommentList(Comments commentList) {
        this.commentList.add(commentList);
    }

    public List<Blogs> getBlogList() {
        return this.blogList;
    }

    public void setBlogList(Blogs blog) {
        this.blogList.add(blog);
    }


    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
