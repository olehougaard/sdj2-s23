package dk.via.accounts;

import dk.via.accounts.view.ViewHandler;
import dk.via.accounts.viewmodel.ViewModelFactory;
import dk.via.accounts.model.UserModel;
import dk.via.accounts.model.UserModelManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

public class Start extends Application {
    @Override
    public void start(Stage primaryStage) {
        UserModel model = UserModelManager.getInstance();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(primaryStage);
    }

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while(networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> interfaceAddresses = networkInterface.getInetAddresses();
                interfaceAddresses.asIterator().forEachRemaining(System.out::println);
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        launch();
    }
}
