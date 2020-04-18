package org.j2ee.model.repository;

import org.j2ee.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person,Long> {

    @Transactional
    @Modifying
    @Query("update Person p set p.name = :n , p.family = :f , p.email = :e WHERE p.id = :i")
    void update(@Param("i") Long id, @Param("n") String name,@Param("f") String family,@Param("e") String email);
}
