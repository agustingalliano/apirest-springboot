package com.example.connectionwithdatabase.core.repository;

import com.example.connectionwithdatabase.core.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    List<User> findByNameContainingOrSurnameContaining(String name, String surname);
    //boolean existsByEmail(String email);


    //Queries con JPQL: 2 formas de hacer lo mismo
    //@Query(value="SELECT u FROM User u WHERE u.name LIKE %?1%")
    //List<User> search (String filter);


    //@Query(value = "SELECT u FROM User u WHERE u.name LIKE %:filter% OR u.surname LIKE %:filter%")
    //List<User> search(@Param("filter") String filter, Sort name);

    //Paginacion con JPQL
    //@Query(value = "SELECT u FROM User u WHERE u.name LIKE %:filter% OR u.surname LIKE %:filter% ORDER BY u.surname")
    //Page<User> findAllUsersWithPagination(Pageable pageable);



    //Consulta nativa
    @Query(
            value = "SELECT * FROM users WHERE users.name LIKE %:filter% OR users.surname LIKE %:filter%",
            nativeQuery = true
    )
    List<User> searchNative (@Param("filter") String filter);

    /*
     * https://www.baeldung.com/spring-data-jpa-query
     * https://www.baeldung.com/spring-data-derived-queries
     * https://www.baeldung.com/spring-jpa-like-queries
     * */

    @Query("select u from User u where u.email = :email")
    public Optional<User> findByEmail(@Param("email") String email);
}
//Se coloca nuestra clase entidad y el tipo de dato de nuestra clave principal