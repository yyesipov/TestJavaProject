package testproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import testproject.model.Character;
import testproject.services.CharacterServiceJSON;

import java.util.List;


@RestController
public class CharacterController {

    @Autowired
    private CharacterServiceJSON characterServiceJSON;

    @RequestMapping(value = "/wiki", method = RequestMethod.GET)
    public Character randomChar() {
        return characterServiceJSON.getRandomChar();
    }

    @RequestMapping(value = "/{keyword}", method = RequestMethod.GET)
    public List<Character> charactersList(String keyword) {
        return characterServiceJSON.getCharacters_JSON(keyword);
    }

}
