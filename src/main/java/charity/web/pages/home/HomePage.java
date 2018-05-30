package charity.web.pages.home;

import charity.entity.User;
import charity.service.UserService;
import charity.web.pages.statistic.StatisticsPage;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.wicketstuff.annotation.mount.MountPath;

@CrossOrigin(origins = "/")
@MountPath("/")
@WicketHomePage
public class HomePage extends WebPage {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private TextField<String> textField;

    @SpringBean
    private UserService userService;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Label label = new Label("label", "Start");
        Form form = new Form("form");
        textField = new TextField<>("userName", Model.of());
        Button button = getButton();
        Link<Void> link = new Link<Void>("statisticsLink"){
            @Override
            public void onClick() {
                setResponsePage(StatisticsPage.class);

            }

        };

        link.add(new Label("linkLabel", new ResourceModel("statistics_link")));

        add(label, form);
        form.add(textField, button, link);
    }

    private Button getButton() {
        return new Button("submit"){
            @Override
            public void onSubmit() {
                super.onSubmit();
                User user = new User();
                user.setUsername(textField.getModelObject());
                userService.save(user);
                textField.clearInput();
            }
        };
    }


}
