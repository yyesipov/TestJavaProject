package testproject.dao;



import testproject.model.Character;

import java.util.List;

public interface CharacterDao {

    Character getCharacter();
    List<Character> getCharactersByKeyword(String keyword);
}
