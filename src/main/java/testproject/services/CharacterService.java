package testproject.services;

import testproject.model.Character;

import javax.ws.rs.PathParam;
import java.util.List;

public interface CharacterService {

    Character getRandomChar();
    List<Character> getCharacters_JSON(String keyword);

}
