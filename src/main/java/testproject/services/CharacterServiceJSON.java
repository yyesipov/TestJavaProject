package testproject.services;

import org.springframework.transaction.annotation.Transactional;
import testproject.dao.CharacterDao;
import testproject.dao.CharacterDaoImpl;
import testproject.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Service
public class CharacterServiceJSON implements CharacterService{

/*
    @GET
    @Path("/test")
    @Produces("application/json")
    public String getTest(){
        return "result: OK";
    }*/

    @Autowired
    private CharacterDaoImpl characterDao;



    @Transactional(readOnly = true)
    @Override
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Character getRandomChar() {
        return characterDao.getCharacter();
    }

    @Transactional(readOnly = true)
    @Override
    @GET
    @Path("/{keyword}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Character> getCharacters_JSON(@PathParam("keyword") String keyword) {
        List<Character> listOfCaracters = characterDao.getCharactersByKeyword(keyword);
        return listOfCaracters;
    }

    public void setCharacterDao(CharacterDaoImpl characterDao) {
        this.characterDao = characterDao;
    }

    public CharacterDaoImpl getCharacterDao() {
        return characterDao;
    }
}
