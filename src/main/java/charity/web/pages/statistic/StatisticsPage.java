package charity.web.pages.statistic;

import charity.service.UserService;
import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.AjaxDownloadBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.time.Duration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.wicketstuff.annotation.mount.MountPath;

@CrossOrigin(origins = "/statistics")
@MountPath("/statistics")
public class StatisticsPage extends WebPage{

    @SpringBean
    private UserService userService;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Label totalLabel = new Label("totalLabel", new ResourceModel("amount"));
        Label participantsAmount = new Label("participantsAmount", Model.of(userService.getAllParticipantsAmount()));
        Label onlineLabel = new Label("onlineLabel", new ResourceModel("online"));
        Label participantsAmountLabel = new Label("participantsAmountLabel", new ResourceModel("participants"));

        AbstractAjaxTimerBehavior timer = new AbstractAjaxTimerBehavior(Duration.seconds(20)) {
            @Override
            protected void onTimer(AjaxRequestTarget target) {
                    target.add(StatisticsPage.this);
                    restart(target);
                }
        };

        add(participantsAmount, totalLabel, onlineLabel, participantsAmountLabel);
        add(timer);
    }
}
