package g3wt

import hibernate.RdbHelper
import org.springframework.transaction.annotation.Transactional

@Transactional
class DataService {

    static expose = ['gwt:g3wt.client']

    def helloWorld() {

        RdbHelper rdbHelper = new RdbHelper();
        rdbHelper.addUser();
    }

    def signIn(String username, String password){
        RdbHelper rdbHelper = new RdbHelper();
        return rdbHelper.signIn(username, password)
    }


}