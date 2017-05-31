package net.therap.mealplannerspring.service;

import net.therap.mealplannerspring.dao.UserDao;
import net.therap.mealplannerspring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean isAllowed(String uname, String pass) {
        return userDao.isAllowed(uname, pass);
    }

    public boolean contains(User userFetch) {
        List<User> users = userDao.getUsers();

        for (User user : users) {
            if (user.getUname().equals(userFetch.getUname())) {
                return true;
            }
        }

        return false;
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }
}
