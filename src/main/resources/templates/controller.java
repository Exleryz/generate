Hello [(${recipient})]

package [(${packageName})].[(${controllerdir})];

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Exler(yz)
 */

@RestController
public class [(${Template})][(${Controller})] {

    @Autowired
    [(${Template})][(${Service})] [(${template})][(${Service})];

    @PostMapping("/[(${Template})]/")
    public String post() {
        return "";
    }

}
