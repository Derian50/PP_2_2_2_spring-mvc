package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDAOImp implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void remove(User user) {
        entityManager.remove(
                entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(int id) {
        Query query = entityManager.createQuery(
                "SELECT u FROM User u where u.id =:id", User.class);
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }
    @Override
    public List<User> getUsers() {
        String jpqlQuery = "SELECT u FROM User u";
        Query query = entityManager.createQuery(jpqlQuery, User.class);

        return query.getResultList();
    }
}
