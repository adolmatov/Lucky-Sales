package Service;

import Service.impl.UserServiceImpl;

/**
 * Created by aleksandrdolmatov on 21.01.17.
 */
public class AuthenticationManager {
    public static boolean Authentication(String login, String password){
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        if(password.equals(userServiceImpl.findByLogin(login).getPassword()))
        return true;
        else return false;
    }
}
