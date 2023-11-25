package org.sopkathon.www.DoSoptSopkathon.user.domain.repository;

import org.sopkathon.www.DoSoptSopkathon.user.domain.entity.User;
import org.sopkathon.www.DoSoptSopkathon.user.exception.UserException;
import org.sopkathon.www.DoSoptSopkathon.user.exception.UserExceptionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findByIdOrElseThrowException(Long id) {
        return findById(id).orElseThrow(() -> new UserException(UserExceptionType.NOT_FOUND_USER));

    }
}
