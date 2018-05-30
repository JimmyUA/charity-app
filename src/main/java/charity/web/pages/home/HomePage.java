package charity.web.pages.home;

import charity.entity.User;
import charity.service.UserService;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("/")
@WicketHomePage
public class HomePage extends WebPage {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @SpringBean
    private UserService userService;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Label label = new Label("label", "Start");
        Form form = new Form("form");
        TextField<String> textField = new TextField<>("userName", Model.of());
        Button button = new Button("submit"){
            @Override
            public void onSubmit() {
                super.onSubmit();
                User user = new User();
                user.setUsername(textField.getModelObject());
                userService.save(user);
            }
        };

        add(label, form);
        form.add(textField, button);
    }
    

}
