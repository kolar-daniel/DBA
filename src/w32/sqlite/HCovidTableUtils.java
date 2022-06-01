package w32.sqlite;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import w32.Warehouse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HCovidTableUtils {
    public static ObservableList<GCovid> getWarehouseList() {
        ObservableList<GCovid> ret = FXCollections.<GCovid>observableArrayList();
        Connection c = AMainDBConn.connect();
        String sql = "SELECT datum, AVG(vek) as vekovy_prumer, (SELECT COUNT(*) FROM Covid as C2 where pohlavi like 'M' AND C2.datum = C1.datum) as pocet_muzu, (SELECT COUNT(*) FROM Covid as C2 where pohlavi like 'Z' AND C2.datum = C1.datum) as pocet_zen, COUNT(*) as celkovy_pocet FROM Covid as C1 GROUP BY datum";
        try (Statement st = c.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            int cnt = 0;
            while(rs.next()) {
                System.out.println(cnt++);
                //System.out.format("id:%d, name: %s, c:%d%n", rs.getInt("id"), rs.getString("name"), rs.getInt("capacity"));
                //System.out.println(new Warehouse(rs.getInt("id"), rs.getString("name"), rs.getInt("capacity")).toString());
                ret.add(new GCovid(rs.getInt("id"), rs.getString("id2"), rs.getString("datum"), rs.getDouble("vek"), rs.getString("pohlavi"), rs.getString("kraj_nuts_kod"), rs.getString("okres_lau_kod"), rs.getBoolean("nakaza_v_zahranici"), rs.getString("nakaza_zeme_csu_kod"), rs.getBoolean("reportovano_khs")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Warehouse p1 = new Warehouse(0, "Sharan", 4000 );
        return ret; //FXCollections.<Warehouse>observableArrayList(p1);
    }

    /* Returns Id TableColumn */
    public static TableColumn<GCovid, Integer> getIdColumn() {
        TableColumn<GCovid, Integer> personIdCol = new TableColumn<>("id");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        return personIdCol;
    }

    /* Returns Name TableColumn */
    public static TableColumn<GCovid, String> getid2Column() {
        TableColumn<GCovid, String> fNameCol = new TableColumn<>("id2");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("id2"));
        return fNameCol;
    }

    public static TableColumn<GCovid, String> getDatumColumn() {
        TableColumn<GCovid, String> fNameCol = new TableColumn<>("datum");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("datum"));
        return fNameCol;
    }

    /* Returns Last Name TableColumn */
    public static TableColumn<GCovid, Double> getVekColumn() {
        TableColumn<GCovid, Double> lastNameCol = new TableColumn<>("vek");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("vek"));
        return lastNameCol;
    }
    public static TableColumn<GCovid, String> getPohlaviColumn() {
        TableColumn<GCovid, String> fNameCol = new TableColumn<>("pohlavi");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("pohlavi"));
        return fNameCol;
    }
    public static TableColumn<GCovid, String> getkraj_nuts_kodColumn() {
        TableColumn<GCovid, String> fNameCol = new TableColumn<>("kraj_nuts_kod");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("kraj_nuts_kod"));
        return fNameCol;
    }
    public static TableColumn<GCovid, String> getokres_lau_kodColumn() {
        TableColumn<GCovid, String> fNameCol = new TableColumn<>("okres_lau_kod");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("okres_lau_kod"));
        return fNameCol;
    }
    public static TableColumn<GCovid, Boolean> getnakaza_v_zahraniciColumn() {
        TableColumn<GCovid, Boolean> fNameCol = new TableColumn<>("nakaza_v_zahranici");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("nakaza_v_zahranici"));
        return fNameCol;
    }
    public static TableColumn<GCovid, String> getnakaza_zeme_csu_kodColumn() {
        TableColumn<GCovid, String> fNameCol = new TableColumn<>("nakaza_zeme_csu_kod");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("nakaza_zeme_csu_kod"));
        return fNameCol;
    }
    public static TableColumn<GCovid, Boolean> getreportovano_khsColumn() {
        TableColumn<GCovid, Boolean> fNameCol = new TableColumn<>("reportovano_khs");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("reportovano_khs"));
        return fNameCol;
    }

}
