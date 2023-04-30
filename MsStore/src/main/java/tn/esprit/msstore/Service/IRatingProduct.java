package tn.esprit.msstore.Service;

import tn.esprit.msstore.Entity.RatingProduct;
import tn.esprit.msstore.dtoEntities.RatingProductDto;

public interface IRatingProduct {
    /*Object addProductRating(RatingProductDto ratingProductDto , Long productId,Long userId);*/
    public RatingProduct addRating(RatingProduct ratingProduct, Long productId, Long userId);
    /*public RatingProductDto modifierRating(RatingProductDto ratingProductDto, Long ratingId, Long userId);*/
    Double getProductRating(Long productId);
    public RatingProduct updateRating(RatingProduct ratingProduct, Long ratingId, Long userId);
}
