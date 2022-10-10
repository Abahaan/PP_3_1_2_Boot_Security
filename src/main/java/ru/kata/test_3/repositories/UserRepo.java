package ru.kata.test_3.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import ru.kata.test_3.models.User;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @EntityGraph(attributePaths = {"roles"})
    User findByUsername(String username);
}
