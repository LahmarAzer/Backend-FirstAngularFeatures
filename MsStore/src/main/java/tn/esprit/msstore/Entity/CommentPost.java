package tn.esprit.msstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentPost implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idComment;
    @Temporal(TemporalType.DATE)
    private Date dateCreationComment;
    private String descriptionComment;
    private Long nbLiked;
    private Long nbDisliked;

    @JsonIgnore
    @ManyToOne
    private Post post;

    @JsonIgnore
    @ManyToOne
    private User userComment;

    @JsonIgnore
    @OneToOne(mappedBy = "comment")
    private Product productForum;

    @JsonIgnore
    @OneToMany(mappedBy = "commentPost")
    private List<LikeComment> likeComments ;

    @JsonIgnore
    @OneToMany(mappedBy = "commentPost")
    private List<DislikeComment> dislikeComments ;


}
