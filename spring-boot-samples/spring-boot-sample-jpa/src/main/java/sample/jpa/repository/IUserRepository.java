package sample.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.jpa.domain.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

}
