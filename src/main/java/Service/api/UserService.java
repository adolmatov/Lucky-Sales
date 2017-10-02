package Service.api;

import dto.UserDTO;

import java.util.List;

/**
 * Created by aleksandrdolmatov on 23.01.17.
 */
public interface UserService {
    List<UserDTO> findAll();

    UserDTO findById(long id);

    UserDTO findByLogin(String login);

    void delete(long id);

    boolean create(UserDTO userDTO);

    boolean update(UserDTO userDTO, long id);

}
