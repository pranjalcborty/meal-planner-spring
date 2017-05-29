package net.therap.mealplannerspring.service;

import net.therap.mealplannerspring.dao.UserDao;
import net.therap.mealplannerspring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean isAllowed(String uname, String pass) {
        return userDao.isAllowed(uname, pass);
    }

    public boolean contains(String uName) {
        return userDao.contains(uName);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }
}
