package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Long> {
}
