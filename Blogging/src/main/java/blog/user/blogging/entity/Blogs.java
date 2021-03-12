package blog.user.blogging.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "commentList"})
public class Blogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;
    @Column(nullable = false)
    private String blogTopic;

    @Column(nullable = false)
    private String blogDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    @ManyToMany(mappedBy = "blogList",cascade = CascadeType.ALL)
    private List<Categories> categoriesList = new ArrayList<>();

    @OneToMany(mappedBy = "blogs",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Comments> commentList = new ArrayList<>();


    @JsonIgnore
    public Users getUsers() {
        return this.users;
    }
    public Long getUserId(){
        return this.users.getUserId();
    }
    public void setUsers(Users users) {
        this.users = users;
    }


    public List<Comments> getCommentList() {
        return commentList;
    }

    public void setCommentList(Comments commentList) {
        this.commentList.add(commentList);
    }
    public Blogs(String blogTopic, String blogDescription) {
        this.blogTopic = blogTopic;
        this.blogDescription = blogDescription;
    }

    public List<Categories> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(Categories categoriesList) {
        this.categoriesList.add(categoriesList);
    }
}
