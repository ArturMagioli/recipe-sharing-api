package com.magioli.recipesharing.repositories;

import com.magioli.recipesharing.entities.RecipeSharingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeSharingUserRepository extends JpaRepository<RecipeSharingUser, Long> {

    Optional<RecipeSharingUser> findByEmail(String email);

    void deleteByEmail(String email);
}
