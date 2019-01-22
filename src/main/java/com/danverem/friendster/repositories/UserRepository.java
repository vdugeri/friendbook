package com.danverem.friendster.repositories;

import com.danverem.friendster.models.User;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class UserRepository extends AbstractRepository<User> {

    @PersistenceContext(unitName = "friendsPU")
    EntityManager entityManager;

    public UserRepository() {
        super(User.class);
    }

    @Override
    EntityManager getEntityManager() {
        return entityManager;
    }
}
