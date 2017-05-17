package controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import model.User;

import java.util.List;

/**
 * Created by 景探 on 2017/5/15.
 */
public class UserController extends Controller {
   // @ActionKey("/login")
    public void index(){
        List<User> list=User.dao.getAllUsers();
        setAttr("userList",list);
        render("user_list.jsp");
    }
}
