package gt.com.gyt.api.todo.svc;

import java.io.Serializable;
import javax.ejb.Singleton;

/**
 *
 * @author jcano
 */
@Singleton
public class IdentityGeneratorImpl implements Serializable, IdentityGenerator {

    private Integer identity = 0;

    @Override
    public synchronized Integer generateIdentity(String identityName) {
        return identity++;
    }

}
