package com.quizzai.quizzai_api.users;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, Long> {

        @Query("SELECT u FROM UserEntity u WHERE (:id is NULL OR u.userId = :id)" +
                        " AND (:name IS NULL OR u.name = :name)" +
                        " AND (:email IS NULL OR u.email = :email)" +
                        " AND (:country IS NULL OR u.country = :country)")
        Page<UserEntity> findByFilter(@Param("id") Long id,
                        @Param("name") String name,
                        @Param("email") String email,
                        @Param("country") String country,
                        Pageable pageable);

        Optional<UserEntity> findByEmail(String email);
}