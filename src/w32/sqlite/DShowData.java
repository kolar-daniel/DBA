package w32.sqlite;

import javafx.scene.control.TableView;
import w32.Warehouse;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//run: VMOPtions: --module-path "Y:\stemberk\verejne_zaci\javafx-sdk-17.0.1\lib" --add-modules javafx.controls,javafx.fxml
//Run -> Edit Configurations -> Alt+V (add VM Options line), Add --module-path /opt/javafx-sdk-17.0.2/lib --add-modules=javafx.controls
// --module-path "C:\Users\stemb\IdeaProjects\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml
// --module-path "X:\stemberk\verejne_zaci\javafx-sdk-17.0.1\lib" --add-modules javafx.controls,javafx.fxml

public class DShowData extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create a TableView with a list of persons
        TableView<GCovid> table = new TableView<>(HCovidTableUtils.getWarehouseList());

        // Add columns to the TableView
        table.getColumns().addAll(HCovidTableUtils.getIdColumn(),
                HCovidTableUtils.getid2Column(),
                HCovidTableUtils.getDatumColumn(),
        HCovidTableUtils.getVekColumn(),
        HCovidTableUtils.getPohlaviColumn(),
        HCovidTableUtils.getkraj_nuts_kodColumn(),
                HCovidTableUtils.getokres_lau_kodColumn(),
                HCovidTableUtils.getnakaza_v_zahraniciColumn(),
                HCovidTableUtils.getnakaza_zeme_csu_kodColumn(),
        HCovidTableUtils.getreportovano_khsColumn());
        VBox root = new VBox(table);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Simplest TableView");
        stage.show();
    }
}
