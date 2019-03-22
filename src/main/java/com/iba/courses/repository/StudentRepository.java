package com.iba.courses.repository;
import com.iba.courses.domain.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Cat, Long> {
    @Query("select student from Cat student")
    List<Cat> getAllStudent();

    @Modifying
    @Query(value = "insert into student (login,password,name,university,course) VALUES ('Stepan','12345','Bondar','BSUIR',3)", nativeQuery = true)
    @Transactional
    void addNewStudent();
}
