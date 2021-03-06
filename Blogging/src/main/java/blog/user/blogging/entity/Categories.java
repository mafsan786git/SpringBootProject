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
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "blogCategory",
                joinColumns = @JoinColumn(name = "categoryId"),
                inverseJoinColumns = @JoinColumn(name = "blogId"))
    private List<Blogs> blogList = new ArrayList<>();

    public List<Blogs> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blogs> blogList) {
        this.blogList = blogList;
    }

    public Categories(String categoryName) {
        this.categoryName = categoryName;
    }
}
