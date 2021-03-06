package io.gumga.application;

import io.gumga.core.GumgaThreadScope;
import io.gumga.domain.domains.GumgaBoolean;
import io.gumga.testmodel.Lamp;

import io.gumga.testmodel.LampService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class GumgaDomainsTest {

    @Autowired
    private LampService lampService;

    public GumgaDomainsTest() {
        GumgaThreadScope.organizationCode.set("1.");
        GumgaThreadScope.login.set("gumga@gumga.com.br");
    }

    @Test
    public void gumgaBooleanVersion() {
        Lamp l=new Lamp("lampada 1", new GumgaBoolean(true));
        l=lampService.save(l);
        assertEquals(0, l.getVersion().intValue());
        l=lampService.view(l.getId());
        l.setIson(new GumgaBoolean(true));
        l=lampService.save(l);
        assertEquals(0, l.getVersion().intValue());
    }
    

}
