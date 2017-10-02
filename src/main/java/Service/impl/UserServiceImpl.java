package Service.impl;

import dao.impl.UserDaoImpl;
import dto.UserDTO;
import Entity.User;
import Helper.Transformer;
import Service.api.UserService;

import java.util.List;

/**
 * Created by aleksandrdolmatov on 23.01.17.
 */
public class UserServiceImpl implements UserService {
    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public UserDTO findById(long id) {
        return null;
    }

    @Override
    public  UserDTO findByLogin(String login) {

        UserDTO userDTO= Transformer.transfomUsertoUserDTO(UserDaoImpl.getInstance().findByLogin(login));

        return userDTO;
    }

    @Override
    public void delete(long id) {
        UserDaoImpl.getInstance().delete(id);

    }

    @Override
    public boolean create(UserDTO userDTO) {
        boolean bool = false;
        User user = Transformer.transformUserDTOtoUser(userDTO);
      if(UserDaoImpl.getInstance().create(user)){
          bool = true;
      }


        return bool;
    }

    @Override
    public boolean update(UserDTO userDTO, long id) {
        if(UserDaoImpl.getInstance().update(Transformer.transformUserDTOtoUser(userDTO), id)){
            return true;
        }
        return false;
    }
}
