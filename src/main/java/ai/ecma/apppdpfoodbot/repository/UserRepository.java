package ai.ecma.apppdpfoodbot.repository;

import ai.ecma.apppdpfoodbot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByChatId(String chatId);

    Optional<User> findByPhone(String phone);

}