import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.typesafe.config.Config;
import mappers.ExampleMapper;
import modules.BatisModule;
import modules.LinkingModule;
import org.junit.After;
import org.junit.Test;
import play.Application;
import play.Environment;
import play.inject.guice.GuiceApplicationBuilder;
import play.test.WithApplication;

import javax.inject.Inject;

/**
 * AbstractTestWithDao . Created at 8/31/2018 2:30 PM by @author Timur Isachenko
 * @isatimur | † be patient and test it! †
 */
public class AbstractTestWithDao extends WithApplication {
    @Inject
    private Config config;

    @Inject
    private ExampleMapper mapper;

    @Override
    protected Application provideApplication() {
        final AbstractModule batis = new BatisModule(), linking = new LinkingModule();

        final GuiceApplicationBuilder builder = new GuiceApplicationBuilder()
                .in(Environment.simple())
                .overrides(batis, linking);

        Guice.createInjector(builder.applicationModule()).injectMembers(this);

        return builder.build();
    }

    @After
    public void doRollback() {
        // MyBatis почему-то не делает rollback по аннотации @Transactional, потому рекомендуется самостоятельно чистить базу после исполнения тестов
        // todo
    }

    @Test
    public void insertObjectTest() {
    }

}

