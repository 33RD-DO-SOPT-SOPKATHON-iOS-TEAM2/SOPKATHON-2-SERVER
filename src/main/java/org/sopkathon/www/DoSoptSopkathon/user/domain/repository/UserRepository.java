package org.sopkathon.www.DoSoptSopkathon.user.domain.repository;

import org.sopkathon.www.DoSoptSopkathon.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
