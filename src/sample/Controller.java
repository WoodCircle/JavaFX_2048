package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private WebView webView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final WebEngine webEngine = webView.getEngine();
        String url = Main.class.getResource("/html/hello.html").toExternalForm();
        webEngine.load(url);
    }
}
