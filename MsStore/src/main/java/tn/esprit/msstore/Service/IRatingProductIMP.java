package tn.esprit.msstore.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.msstore.Entity.Product;
import tn.esprit.msstore.Entity.RatingProduct;
import tn.esprit.msstore.Entity.User;
import tn.esprit.msstore.Repository.ProductRepository;
import tn.esprit.msstore.Repository.RatingRepository;
import tn.esprit.msstore.Repository.UserRepository;
import tn.esprit.msstore.dtoEntities.RatingProductDto;
import tn.esprit.msstore.mappers.RatingProductMapper;

@Slf4j
@Service
@AllArgsConstructor
public class IRatingProductIMP implements IRatingProduct{

    RatingRepository ratingRepository ;

    ProductRepository productRepository ;

    UserRepository userRepository ;

    /*@Override
    public RatingProductDto addProductRating(RatingProductDto ratingProductDto,Long productId,Long userId) {
        Product product = productRepository.findById(productId).orElse(null);
        User user =userRepository.findById(userId).orElse(null);
        if (product != null && ratingProductDto.getNbrEtoilesProduct()<=5 && user!=null) {
            RatingProduct ratingProduct = RatingProductMapper.mapRatingDtoToEntity(ratingProductDto);
            ratingProduct.setProduct(product);
            ratingProduct.setUserRating(user);
            ratingRepository.save(ratingProduct);
            return ratingProductDto;
        }
        return null;
    }*/


    /*@Override
    public RatingProduct addRating(RatingProduct ratingProduct, Long productId, Long userId) {
            Product product = productRepository.findById(productId).orElse(null);
            User user = userRepository.findById(userId).orElse(null);
            if (product != null && ratingProduct.getNbrEtoilesProduct() <= 5 && user != null) {
                ratingProduct.setProduct(product);
                ratingProduct.setUserRating(user);
                ratingRepository.save(ratingProduct);
                return ratingProduct;
            }
            return null;
        }*/
    @Override
    public RatingProduct addRating(RatingProduct ratingProduct, Long productId, Long userId) {
        Product product = productRepository.findById(productId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        if (product != null && ratingProduct.getNbrEtoilesProduct() <= 5 && user != null) {
            RatingProduct existingRatingProduct = ratingRepository.findByProductAndUserRating(product, user);
            if (existingRatingProduct != null) {
                return updateRating(ratingProduct, existingRatingProduct.getIdRaitingProduct(), userId);
            } else {
                ratingProduct.setProduct(product);
                ratingProduct.setUserRating(user);
                ratingRepository.save(ratingProduct);
                return ratingProduct;
            }
        }
        return null;
    }


   /* @Override
    public RatingProductDto modifierRating(RatingProductDto ratingProductDto, Long ratingId, Long userId) {
        RatingProduct ratingProduct = ratingRepository.findById(ratingId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        if (ratingProduct != null && ratingProduct.getUserRating().getIdUser().equals(userId) && user != null) {
            ratingProduct.setNbrEtoilesProduct(ratingProductDto.getNbrEtoilesProduct());
            ratingRepository.save(ratingProduct);
            return ratingProductDto;
        }
        return null;
    }*/

    @Override
    public RatingProduct updateRating(RatingProduct ratingProduct, Long ratingId, Long userId) {
        RatingProduct existingRatingProduct = ratingRepository.findById(ratingId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        if (existingRatingProduct != null && existingRatingProduct.getUserRating().getIdUser().equals(userId) && user != null) {
            existingRatingProduct.setNbrEtoilesProduct(ratingProduct.getNbrEtoilesProduct());
            existingRatingProduct.setReviewProduct(ratingProduct.getReviewProduct());
            ratingRepository.save(existingRatingProduct);
            return existingRatingProduct;
        }
        return null;
    }




    @Override
    public Double getProductRating(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if(product != null ) {
            return ratingRepository.findAverageRating(productId);
        }
        return  null ;
    }
}
