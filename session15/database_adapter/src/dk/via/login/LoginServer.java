package dk.via.login;

import dk.via.login.dao.SqlUserDao;
import dk.via.login.dao.UserDao;
import dk.via.login.adapter.DatabaseAdapter;
import dk.via.login.server.LoginImplementation;
import dk.via.login.server.UserStorage;
import dk.via.login.shared.Login;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class LoginServer {
    public static void main(String[] args) throws Exception {
        UserDao dao = SqlUserDao.getInstance();
        UserStorage storage = new DatabaseAdapter(dao);
        LoginImplementation login = new LoginImplementation(storage);
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        registry.bind("login", login);
        System.out.println("Server running");
    }
}
