package testproject.dao;



import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testproject.model.Character;
import javax.persistence.EntityManager;


import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



@Repository

public class CharacterDaoImpl implements CharacterDao {

    private static final Logger logger = LoggerFactory.getLogger(CharacterDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Character getCharacter() {
    @SuppressWarnings("unchecked")

        TypedQuery<Character> query =
            (TypedQuery<Character>) sessionFactory.getCurrentSession().createQuery("SELECT c FROM characters c ORDER BY random() LIMIT 1");
        Character result = query.getSingleResult();
        logger.info("Characters have been loaded successfully. Character details: " + result);

        return result;


    }

    @Override
    public List<Character> getCharactersByKeyword(String keyword) {
        @SuppressWarnings("unchecked")

        TypedQuery<Character> query =
                (TypedQuery<Character>) sessionFactory.getCurrentSession().createQuery("SELECT c.name FROM characters c WHERE c.name LIKE '%" + keyword + "%'");
        List<Character> results = query.getResultList();
        logger.info("Characters have been loaded successfully. Character details: " + results);

        return results;




    }


}