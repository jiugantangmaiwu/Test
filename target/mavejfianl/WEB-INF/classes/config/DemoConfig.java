package config;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import controller.MessageController;
import controller.UserController;
import model.Mess;
import model.User;

/**
 * Created by 景探 on 2017/5/15.
 */
public class Config extends JFinalConfig {


    public Config() {
        super();
    }

    /**
     * 配置常亮
     * @param me
     */
    @Override
    public void configConstant(Constants me) {
        PropKit.use("a_little_config.txt");//加载少量必要配置,随后可用PropKit.get(...)获取值
       me.setDevMode(PropKit.getBoolean("devMOde",false)); //开发模式的常量配置
        me.setViewType(ViewType.JSP);//设置视图类型为JSP否则默认为FreeMarker
    }

    /**
     * 配置路由
     * @param me
     */
    @Override
    public void configRoute(Routes me) {
        me.add("/user", UserController.class,"/user");//第三个参数为该Controller的视图存放路径
        me.add("/message", MessageController.class,"/message");
    }

    @Override
    public void configEngine(Engine engine) {

    }

    /**
     * 配置插件
     * @param me
     */
    @Override
    public void configPlugin(Plugins me) {
        //配置c3p0数据库连接池插件
        C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        me.add(c3p0Plugin);
        //配置ActiveRecord插件
        ActiveRecordPlugin arp=new ActiveRecordPlugin(c3p0Plugin);
        me.add(arp);
        arp.addMapping("mess","MessageID", Mess.class);//映射mess表到Mess模型,由于id不叫id,故第二个参数指定列名
        arp.addMapping("user","userId", User.class);

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
//main方法启动方式
    public static void main(String [] args){
        JFinal.start();
    }
}
