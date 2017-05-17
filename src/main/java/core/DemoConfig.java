import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import controller.MessageController;
import controller.UserController;
import model.Mess;
import model.User;

import javax.sound.midi.Sequence;

/**
 * Created by 景探 on 2017/5/17.
 */
public class DemoConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(PropKit.use("a_little_config.txt").getBoolean("devMode", true));
        constants.setViewType(ViewType.JSP);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/user", UserController.class,"/user");
        routes.add("/mess", MessageController.class,"/mess");
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        plugins.add(c3p0Plugin);

        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(c3p0Plugin);
        plugins.add(activeRecordPlugin);
        activeRecordPlugin.setShowSql(true);
        activeRecordPlugin.addMapping("user","userId", User.class);
        activeRecordPlugin.addMapping("mess","MessageID", Mess.class);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
