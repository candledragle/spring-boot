package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.data.jpa.domain.AppTaskEntity;

@Repository
public interface AppTaskRepository extends JpaRepository<AppTaskEntity,Long> {

}
