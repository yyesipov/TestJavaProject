package testproject.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testproject.model.Character;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


//@Repository

public class CharacterDaoImpl implements CharacterDao {

  /*  DataSource datasource;

    private JdbcTemplate templCustomer;

    public void setDataSource(DataSource dataSource) {
        this.templCustomer = new JdbcTemplate(dataSource);
    }

    public Character getCharacter() {


        Character character = (Character) templCustomer.queryForObject(
                "SELECT * FROM characters ORDER BY random() LIMIT 1;",
                new RowMapper<Character>() {
                    public Character mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        Character Character = new Character();
                        Character.setId(rs.getInt("id"));
                        Character.setName(rs.getString("name"));
                        Character.setStatus(rs.getString("status"));
                        Character.setSpecies(rs.getString("species"));
                        Character.setGender(rs.getString("gender"));
                        Character.setImage(rs.getString("image"));
                        Character.setUrl(rs.getString("url"));

                        return Character;
                    }
                });

        return character;


    }


    public List<Character> getCharactersByKeyword(String keyword) {
        List<Character> CharacterList = (List<Character>) templCustomer.query(
                "SELECT * FROM characters WHERE name LIKE '%" + keyword + "%';", new RowMapper<Character>() {
                    public Character mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        Character Character = new Character();
                        Character.setId(rs.getInt("id"));
                        Character.setName(rs.getString("name"));
                        Character.setStatus(rs.getString("status"));
                        Character.setSpecies(rs.getString("species"));
                        Character.setGender(rs.getString("gender"));
                        Character.setImage(rs.getString("image"));
                        Character.setUrl(rs.getString("url"));
                        return Character;
                    }
                });

        return CharacterList;
    }
*/


    private static final Logger logger = LoggerFactory.getLogger(CharacterDaoImpl.class);

    SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Character getCharacter() {

        Session session = sessionFactory.getCurrentSession();
        Character character =  (Character) session.createSQLQuery("SELECT * FROM characters ORDER BY random() LIMIT 1");

        logger.info("Character has been loaded successfully. Character details: " + character);
//        session.close();
        return character;
    }

    @Override
    public List<Character> getCharactersByKeyword(String keyword) {

        Session session = sessionFactory.getCurrentSession();
        List<Character> charList = session.createSQLQuery("SELECT * FROM characters WHERE name LIKE '%" + keyword + "%'").list();
        Character c = charList.isEmpty() ? null : charList.get(0);
        logger.info("Characters have been loaded successfully. Character details: " + charList.toString());
//        session.close();
        return charList;
    }
}