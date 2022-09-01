package me.jordanfails.samplefeatures.Manager;

import lombok.Getter;
import me.jordanfails.samplefeatures.Manager.managers.SupportManager;
import me.jordanfails.samplefeatures.Manager.managers.UserManager;
import me.jordanfails.samplefeatures.SampleFeatures;

import java.util.Arrays;
import java.util.List;

@Getter
public class ManagerHandler {

    private final List<IManager> managers;
    private final SupportManager supportManager;

    private final UserManager userManager;

    private final SampleFeatures plugin = SampleFeatures.get();

    public ManagerHandler() {
        this.managers = Arrays.asList(new SupportManager(),
                new UserManager(plugin));
        this.managers.forEach(IManager::load);

        this.supportManager = findHandler(SupportManager.class);
        this.userManager = findHandler(UserManager.class);
    }

    public <T> T findHandler(Class<T> clazz) {
        return (T) this.managers.stream().filter(iManager -> iManager.getClass().equals(clazz)).findFirst().orElse(null);
    }
}
