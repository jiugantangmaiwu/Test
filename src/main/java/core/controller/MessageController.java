package controller;

import com.jfinal.core.Controller;
import model.Mess;
import model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 景探 on 2017/5/15.
 */
public class MessageController extends Controller{
    public void index(){
        //查找指定用户的所有信息
        int userId=getParaToInt("userId");
        List<Mess> list=Mess.dao.getMessByUserId(userId);
        setAttr("messList",list);
        render("mess_list.jsp");
    }
    public void showMessage(){
        int userId=getParaToInt("userId");
        setAttr("userId",userId);
        render("mess_send.jsp");
    }
    public void sendMessage(){
        int userId=getParaToInt("userId");
        String MessageInfo=getPara("MessageInfo");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String SendTime=df.format(new Date());
       // Date SendTime=getParaToDate("SendTime");
        String TypeName=getPara("TypeName");
        Mess.dao.addMessage(MessageInfo,SendTime,TypeName,userId);
        redirect("/mess?userId="+userId);

    }
}
