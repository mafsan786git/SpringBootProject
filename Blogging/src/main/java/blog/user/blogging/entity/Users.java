package blog.user.blogging.entity;

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
    @JsonManagedReference
    private List<Blogs> blogList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "usercommentId",referencedColumnName = "userId")
    private List<Comments> commentList = new ArrayList<>();

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
