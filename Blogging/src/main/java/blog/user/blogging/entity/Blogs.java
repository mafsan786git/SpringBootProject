package blog.user.blogging.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Blogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;
    @Column(nullable = false)
    private String blogTopic;
    @Column(nullable = false)
    private String blogDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",nullable = false)
    private Users users;

    @ManyToMany(mappedBy = "blogList",cascade = CascadeType.ALL)
    private List<Categories> categoriesList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "blogcommentId",referencedColumnName = "blogId")
    private List<Comments> commentList = new ArrayList<>();

    public List<Comments> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comments> commentList) {
        this.commentList = commentList;
    }

    public List<Categories> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<Categories> categoriesList) {
        this.categoriesList = categoriesList;
    }
}
