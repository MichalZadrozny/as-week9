package pl.michalzadrozny.asweek9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.michalzadrozny.asweek9.model.User;

@Repository
public interface HibernateRepo extends JpaRepository<User, Long> {
}
