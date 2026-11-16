package com.magioli.recipesharing.repositories;

import com.magioli.recipesharing.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findRecipeByUsernameLikeAndTitleLike(@Param("username") String username,
                                                      @Param("title") String title);

    List<Recipe> findRecipeByUsernameLike(@Param("username") String username);

    List<Recipe> findRecipeByTitleContainingIgnoreCase(String title);
}
