package charity;

import com.giffing.wicket.spring.boot.starter.app.WicketBootStandardWebApplication;
import org.apache.wicket.Application;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.file.Path;
import org.springframework.stereotype.Component;


@Component
public class WicketWebApplication extends WicketBootStandardWebApplication {

    @Override
    protected void init() {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));

        getResourceSettings().getResourceFinders().add(new Path("/home/jimmy/charity/"));
    }
}
