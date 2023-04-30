package tn.esprit.msstore.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@ToString
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idProduct;
    private String descriptionProduct;
    private float priceProduct;
    private Long quantityProduct;
    private String nameProduct;
    private String referenceProduct;
    //private String imageProduct;
    @Lob
    private byte[] imageProduct;
    private float discountProduct;
    private String marqueProduct;
    @Temporal(TemporalType.DATE)
    private Date dateCreationProduct;
    @JsonIgnore
    @ManyToOne
    private CategoryProduct categoryProduct;

    @JsonIgnore
    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    private List<RatingProduct> ratingProductList;

    @JsonIgnore
    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    private List<CartLine> cartLines;

    @JsonIgnoreProperties(value = {"productListUser"})
    @ManyToOne
    private User userProduct;

    @JsonIgnore
    @OneToOne
    private CommentPost comment;

    /*@JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    /*@JoinTable(
            name = "FavorisProduct",
            joinColumns = @JoinColumn(name = "idProduct"),
            inverseJoinColumns = @JoinColumn(name = "idFavori"))*/
    //private List<FavoriProduct> favoriProducts;
    @JsonBackReference
    @ManyToOne
    private Sous_CategoryProduct sousCategorie;

    @JsonIgnore
    @OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL)
    private List<FavoriProduct> favoriProducts;

}
