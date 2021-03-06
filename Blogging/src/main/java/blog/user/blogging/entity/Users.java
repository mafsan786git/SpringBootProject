package blog.user.blogging.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany
    @JoinColumn(name = "userblogId",referencedColumnName = "userId")
    private List<Blogs> blogList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "usercommentId",referencedColumnName = "userId")
    private List<Comments> commentList = new ArrayList<>();

    public List<Comments> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comments> commentList) {
        this.commentList = commentList;
    }

    public List<Blogs> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blogs> blogList) {
        this.blogList = blogList;
    }

    public Users(String userName, String userMobile, String userEmail){
        this.userEmail = userEmail;
        this.userName = userName;
        this.userMobile = userMobile;
    }

}
