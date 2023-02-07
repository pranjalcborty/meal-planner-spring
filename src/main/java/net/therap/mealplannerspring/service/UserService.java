package net.therap.mealplannerspring.service;

import net.therap.mealplannerspring.dao.UserDao;
import net.therap.mealplannerspring.domain.User;
import net.therap.mealplannerspring.domain.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean isAllowed(UserLogin userLogin) {
        List<User> users = userDao.getUsers();

        for (User user : users) {
            if (user.getUname().equals(userLogin.getUserName()) && user.getPass().equals(userLogin.getPassword())) {
                return true;
            }
        }

        return false;
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
