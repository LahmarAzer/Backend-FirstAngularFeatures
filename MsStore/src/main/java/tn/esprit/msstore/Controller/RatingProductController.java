package tn.esprit.msstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.msstore.Entity.RatingProduct;
import tn.esprit.msstore.Service.IRatingProduct;
import tn.esprit.msstore.dtoEntities.RatingProductDto;

//@AllArgsConstructor
@RestController
@RequestMapping("/store/raitingProduct")
public class RatingProductController {
    @Autowired
    IRatingProduct iratingProduct ;

   /* @PostMapping("/addRatingProduct/{productId}/{userId}")
     public RatingProductDto addProductRating(@RequestBody RatingProductDto ratingProductDto,
                                              @PathVariable Long productId , @PathVariable Long userId) {
        return (RatingProductDto) ratingProduct.addProductRating(ratingProductDto, productId , userId);

    }*/
   @PostMapping("/addRatingProduct/{productId}/{userId}")
   public RatingProduct addProductRating(@RequestBody RatingProduct ratingProduct,
                                            @PathVariable Long productId , @PathVariable Long userId) {
       return iratingProduct.addRating(ratingProduct, productId, userId);

   }

    /*@PutMapping("/updaterating/{ratingId}/{userId}")
    public RatingProductDto updaterating(@RequestBody RatingProductDto ratingProductDto,
                                             @PathVariable Long ratingId , @PathVariable Long userId) {
        return (RatingProductDto) ratingProduct.addProductRating(ratingProductDto, ratingId , userId);

    }*/
    @PutMapping("/updaterating/{ratingId}/{userId}")
    public RatingProduct updaterating(@RequestBody RatingProduct ratingProduct,
                                         @PathVariable Long ratingId , @PathVariable Long userId) {
        return  iratingProduct.updateRating(ratingProduct, ratingId, userId);

    }

   @GetMapping("/products/{productId}/rating")
    public ResponseEntity<Double> getProductRating(@PathVariable Long productId) {
        Double rating = iratingProduct.getProductRating(productId);
        return ResponseEntity.ok(rating);
    }

}
