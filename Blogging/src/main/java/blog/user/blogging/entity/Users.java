package blog.user.blogging.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

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

    public void setCommentList(List<Comments> commentList) {
        this.commentList = commentList;
    }

    public List<Blogs> getBlogList() {
        return this.blogList;
    }

    public void setBlogList(Blogs blog) {
        this.blogList.add(blog);
    }

    public Users(String userName, String userMobile, String userEmail){
        this.userEmail = userEmail;
        this.userName = userName;
        this.userMobile = userMobile;
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
