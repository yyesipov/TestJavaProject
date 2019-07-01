package testproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import testproject.model.Character;

public interface CharacterJpaDao extends JpaRepository<Character, Long> {
}
