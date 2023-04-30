package tn.esprit.msstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msstore.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}