package model;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import controller.MessageController;
import controller.UserController;

import java.util.List;

/**
 * Created by 景探 on 2017/5/15.
 */
public class User extends Model<User> {
    public static final User dao=new User();
    //取得所有用户
    public List<User> getAllUsers(){
        return User.dao.find("select * from user");
        //return User.dao.find("select * from user");
    }

}
