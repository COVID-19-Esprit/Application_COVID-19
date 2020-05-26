
package Admin;

import application_covid.entities.Membre;
import application_covid.utils.MyConnection;
import application_covid.services.MembreCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MembreTabController implements Initializable {

    @FXML
    private TableView<Membre> tableMembre;
    @FXML
    private TableColumn<Membre, String> col_ID;
    @FXML
    private TableColumn<Membre,String> col_Firstname;
    @FXML
    private TableColumn<Membre,String> col_Lastname;
    @FXML
    private TableColumn<Membre,String> col_Email;
    @FXML
    private TableColumn<Membre,String> col_Age;
    @FXML
    private TableColumn<Membre,String> col_phone;
    Connection cnx;

    ObservableList<Membre> mb = FXCollections.observableArrayList();
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cnx = MyConnection.getInstance().getCnx();
            String requete = "SELECT * FROM Membre";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                mb.add(new Membre(rs.getInt("cin"), rs.getString("nomMembre"), rs.getString("prenomMembre")
                        , rs.getString("adresseMembre"), rs.getInt("ageMembre"), rs.getString("passwordMembre"),rs.getInt("telephoneMembre")));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        col_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_Firstname.setCellValueFactory(new PropertyValueFactory<>("nomMembre"));
        col_Lastname.setCellValueFactory(new PropertyValueFactory<>("prenomMembre"));
        col_Email.setCellValueFactory(new PropertyValueFactory<>("adresseMembre"));
        col_Age.setCellValueFactory(new PropertyValueFactory<>("age"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("telephoneMembre"));
        tableMembre.setItems(mb);
        //tableMembre.getSelectionModel().getSelectionMode(SelectionMode.MULTIPLE);
    } 
            public void supprimerMembre(int cin) {
        try {
            String requete = "DELETE FROM membre WHERE cin=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, cin);
            pst.executeUpdate();
            System.out.println("Member deleted");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
    @FXML
    public void deleteButton(){
  
     Alert.AlertType type = Alert.AlertType.CONFIRMATION;
     Alert alert = new Alert(type,"");
     alert.initModality(Modality.APPLICATION_MODAL);
     alert.getDialogPane().setContentText("Are you sure");
     alert.getDialogPane().setHeaderText("Do you want to delete this membre !");
     
     Optional<ButtonType> result = alert.showAndWait();
     if(result.get() == ButtonType.OK){
     ObservableList<Membre> selectedRows, mbdelete;
     mbdelete = tableMembre.getItems();
     selectedRows = tableMembre.getSelectionModel().getSelectedItems();
     
     for (Membre membre: selectedRows){
     mbdelete.remove(membre);
     supprimerMembre(membre.getId());
     }
     }
    }
    
      public void ChangeScreen(ActionEvent event) throws IOException {
    Parent WorldStaticParent = FXMLLoader.load(getClass().getResource("InscriptionMembre.fxml"));
    Scene WorldStaticScene = new Scene(WorldStaticParent);
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(WorldStaticScene);
    window.show();

   }

}
