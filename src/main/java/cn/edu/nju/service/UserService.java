package cn.edu.nju.service;
import cn.edu.nju.core.Result;
import cn.edu.nju.core.Service;
import cn.edu.nju.model.User;
import cn.edu.nju.model.VO.UserVO;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by CodeGenerator on 2023/02/28.
 */
public interface UserService extends Service<User> {

    void register(UserVO userVO, HttpServletRequest request);

    Result signIn(UserVO userVO);

    Result signOut();

    User findUserByName(String name);
}
