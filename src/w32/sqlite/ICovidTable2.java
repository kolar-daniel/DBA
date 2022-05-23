package w32.sqlite;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ICovidTable2 {
    public static ObservableList<GCovid2> getWarehouse2List() {
        ObservableList<GCovid2> ret = FXCollections.<GCovid2>observableArrayList();
        Connection c = AMainDBConn.connect();
        String sql = "SELECT datum, AVG(vek) AS prumernyVek, " +
                "(SELECT COUNT(*) FROM warehouse AS covid WHERE pohlavi LIKE 'M' AND covid.datum = warehouse.datum) AS pocetMuzu," +
                " (SELECT COUNT(*) FROM warehouse AS covid WHERE pohlavi LIKE 'Z' AND covid.datum = warehouse.datum) AS pocetZen," +
                "COUNT(*) AS celkovyPocet FROM warehouse GROUP BY datum;";
        try (Statement st = c.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            int cnt = 0;
            while(rs.next()) {
                System.out.println(cnt++);
                //System.out.format("id:%d, name: %s, c:%d%n", rs.getInt("id"), rs.getString("name"), rs.getInt("capacity"));
                //System.out.println(new Warehouse(rs.getInt("id"), rs.getString("name"), rs.getInt("capacity")).toString());
                ret.add(new GCovid2(rs.getString("datum"), rs.getInt("prumernyVek"), rs.getInt("pocetMuzu"), rs.getInt("pocetZen"), rs.getInt("celkovyPocet")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Warehouse p1 = new Warehouse(0, "Sharan", 4000 );
        return ret; //FXCollections.<Warehouse>observableArrayList(p1);
    }

    /* Returns Id TableColumn */
    public static TableColumn<GCovid2, String> getDatumColumn() {
        TableColumn<GCovid2, String> personIdCol = new TableColumn<>("datum");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("datum"));
        return personIdCol;
    }

    /* Returns Name TableColumn */
    public static TableColumn<GCovid2, Integer> getprumernyVekColumn() {
        TableColumn<GCovid2, Integer> fNameCol = new TableColumn<>("prumernyVek");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("prumernyVek"));
        return fNameCol;
    }

    /* Returns Last Name TableColumn */
    public static TableColumn<GCovid2, Integer> getpocetMuzuColumn() {
        TableColumn<GCovid2, Integer> lastNameCol = new TableColumn<>("pocetMuzu");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("pocetMuzu"));
        return lastNameCol;
    }
    public static TableColumn<GCovid2, Integer> getpocetZenColumn() {
        TableColumn<GCovid2, Integer> fNameCol = new TableColumn<>("pocetZen");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("pocetZen"));
        return fNameCol;
    }
    public static TableColumn<GCovid2, Integer> getcelkovyPocetColumn() {
        TableColumn<GCovid2, Integer> fNameCol = new TableColumn<>("celkovyPocet");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("celkovyPocet"));
        return fNameCol;
    }
}
