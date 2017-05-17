package model;

import com.jfinal.plugin.activerecord.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by 景探 on 2017/5/15.
 */
public class Mess extends Model<Mess>{
    public static final Mess dao=new Mess();
    //查询指定用户的消息
    public List<Mess> getMessByUserId(int userId){

        return Mess.dao.find("select * from mess where pk_user_id = ? ",userId);
    }
//给指定用户发消息
public void addMessage(String messInfo,String SendTime,String TypeName,Integer pk_user_id ){

new Mess().set("MessageInfo",messInfo).set("SendTime",SendTime).set("TypeName",TypeName).set("pk_user_id",pk_user_id).save();
}
}
