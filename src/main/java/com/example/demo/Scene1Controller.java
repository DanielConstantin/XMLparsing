package com.example.demo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;


public class Scene1Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TitledPane MainWIndow;

    @FXML
    private AnchorPane anch;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private HBox hb1txt;

    @FXML
    private HBox hb2txt;

    @FXML
    private HBox hb3txt;

    @FXML
    private TableView<Detail> tbl1;

    @FXML
    private TextField txtComanda;

    @FXML
    private TextField txtOperationCodeTransportType;

    @FXML
    private TextField txtOperationCodeGoodsDeclared;

    @FXML
    private TextField txtVAT;

    @FXML
    private TextField txtPalletCode;

    @FXML
    private TextField txtPartnerCountryCode;

    @FXML
    private TextField txtPartnerCode;

    @FXML
    private TextField txtPartnerNam;

    @FXML
    private TextField txtTruckPlateNumber;

    @FXML
    private TextField txtTransporterCountryCode;

    @FXML
    private TextField txtTransporterCode;

    @FXML
    private TextField txtTransporterName;

    @FXML
    private TextField txtStartDateOfTransport;

    @FXML
    private TextField txtCodeForBorderCrossingPoint;

    @FXML
    private TextField txtCodeForCustomsOffice;
    @FXML
    private TextField txtCountryCodeLoading;
    @FXML
    private TextField txtTownNameLoading;
    @FXML
    private TextField StreetNameLoading;
    @FXML
    private TextField txtCountryCodeUnloading;
    @FXML
    private TextField txtCountyUnloading;
    @FXML
    private TextField txtTownNameUnloading;
    @FXML
    private TextField txtStreetNameUnloading;
    @FXML
    private TextField txtStreetNameLoading;
    @FXML
    private TextField txtDocumentTypeCode;
    @FXML
    private TextField txtDocumentNumber;
    @FXML
    private TextField txtDocumentDate;

    @FXML
    protected void pressIncarca() {
        reload();
    }
    @FXML
    protected void pressModifica() {
        CSVReader.read("fisa.csv");

    };
    @FXML
    protected void pressSalveaza() {
        try {
            Detail.PrintLista();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        reload();
    };

    @FXML
    private TableColumn<Detail, BigDecimal> colCantitate;

    @FXML
    private TableColumn<Detail, String> colCod;

    @FXML
    private TableColumn<Detail, String> colDenumire;

    @FXML
    private TableColumn<Detail, BigDecimal> colGreutateBruta;

    @FXML
    private TableColumn<Detail, BigDecimal> colGreutateNeta;

    @FXML
    private TableColumn<Detail, BigDecimal> colGrossNou;

    @FXML
    private TableColumn<Detail, String> colLinie;

    @FXML
    private TableColumn<Detail, String> colTarifCode;

    @FXML
    private TableColumn<Detail, String> colUM;

    @FXML
    private Label lbltotalGross;
    @FXML
    private Label lbltn;
    @FXML
    private Label fisierProcesat;

    @FXML
    private Label lbltn1;

    @FXML
    private Label lbltn11;

    @FXML
    private Label lbltotalNet;

    @FXML
    private Label lbltotalNewGross;

    @FXML
    private Label lbltotalVal;
    @FXML
    private MenuItem menuAlegeDestinatie;
    @FXML
    private MenuItem menuAlegeSursa;
    @FXML
    void SelectSursa(ActionEvent e) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(Utils.sourceDir);
        File selectedDirectory = directoryChooser.showDialog(lbltn.getScene().getWindow());

        if(directoryChooser == null){
            //No Directory selected
        }else{
            System.out.println(selectedDirectory);
            System.out.println(Utils.destinationDir);
            if(!selectedDirectory.equals(Utils.destinationDir)) {
                Utils.sourceDir = selectedDirectory;
                reload();
            }else{
                fisierProcesat.setText("Directoarele Sursa si Procesate nu pot fi identice");
            }

        }

    };
    @FXML
    void selectDestinatie(ActionEvent e) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(Utils.destinationDir);
        File selectedDirectory = directoryChooser.showDialog(lbltn.getScene().getWindow());


        if(selectedDirectory == null){
            //No Directory selected
        }else{
            if(!selectedDirectory.equals(Utils.sourceDir)) {
                Utils.destinationDir = selectedDirectory;
            }else{
                fisierProcesat.setText("Directoarele Procesate si Sursa nu pot fi identice");
            }
        }

    };

    @FXML
    private TableColumn<Detail, BigDecimal> colValoare;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        CSVReader.read("fisa.csv");
        Utils.setInitialPath();
        reload();

        StringConverter bdsc = new StringConverter<BigDecimal>() {

            @Override
            public String toString(BigDecimal object) {
                return object.toPlainString();
            }

            @Override
            public BigDecimal fromString(String string) {
                if (string == null || string.isEmpty()) return BigDecimal.ZERO;
                return new BigDecimal(string);
            }
        };
        ObservableList<Detail> ListaDate = Detail.getLista();
        TableView.TableViewSelectionModel<Detail> selectionModel = tbl1.getSelectionModel();
        colCod.setCellValueFactory(new PropertyValueFactory<>("InternalReferenceCode"));
        colCod.setCellFactory(TextFieldTableCell.forTableColumn());
        colDenumire.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        colDenumire.setCellFactory(TextFieldTableCell.forTableColumn());
        colTarifCode.setCellValueFactory(new PropertyValueFactory<>("TariffCode"));
        colTarifCode.setCellFactory(TextFieldTableCell.forTableColumn());
        colCantitate.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        colCantitate.setCellFactory(TextFieldTableCell.forTableColumn(bdsc));
        colUM.setCellValueFactory(new PropertyValueFactory<>("QuantityMeasurementCode"));
        colUM.setCellFactory(TextFieldTableCell.forTableColumn());
        colValoare.setCellValueFactory(new PropertyValueFactory<>("NetValueWithoutVAT"));
        colValoare.setCellFactory(TextFieldTableCell.forTableColumn(bdsc));
        colGreutateBruta.setCellValueFactory(new PropertyValueFactory<>("GrossWeight"));
        colGreutateBruta.setCellFactory(TextFieldTableCell.forTableColumn(bdsc));
        colGreutateNeta.setCellValueFactory(new PropertyValueFactory<>("NetWeight"));
        colGreutateNeta.setCellFactory(TextFieldTableCell.forTableColumn(bdsc));
        colLinie.setCellValueFactory(new PropertyValueFactory<>("LineNumber"));
        colLinie.setCellFactory(TextFieldTableCell.forTableColumn());
        colGrossNou.setCellValueFactory(new PropertyValueFactory<>("NewGrossWeight"));
        colGrossNou.setCellFactory(TextFieldTableCell.forTableColumn(bdsc));

        tbl1.setItems(ListaDate);
        tbl1.setEditable(true);
        txtComanda.setText(Detail.getInternalReference().toString());
        txtComanda.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setInternalReference(newValue);
        });
        txtDocumentNumber.setText(Detail.getDocumentNumber().toString());
        txtDocumentNumber.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setDocumentNumber(newValue);
        });
        txtCodeForBorderCrossingPoint.setText(Detail.getCodeForBorderCrossingPoint().toString());
        txtCodeForBorderCrossingPoint.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setCodeForBorderCrossingPoint(newValue);
        });
        txtCodeForCustomsOffice.setText(Detail.getCodeForCustomsOffice().toString());
        txtCodeForCustomsOffice.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setCodeForCustomsOffice(newValue);
        });
        txtCountyUnloading.setText(Detail.getCountyUnloading().toString());
        txtCountyUnloading.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setCountyUnloading(newValue);
        });
        txtDocumentDate.setText(Detail.getDocumentDate().toString());
        txtDocumentDate.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setDocumentDate(newValue);
        });
        txtCountryCodeLoading.setText(Detail.getCountryCodeLoading().toString());
        txtCountryCodeLoading.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setCountryCodeLoading(newValue);
        });
        txtCountryCodeUnloading.setText(Detail.getCountryCodeUnloading().toString());
        txtCountryCodeUnloading.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setCountryCodeUnloading(newValue);
        });
        txtDocumentTypeCode.setText(Detail.getDocumentTypeCode().toString());
        txtDocumentTypeCode.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setDocumentTypeCode(newValue);
        });
        txtOperationCodeTransportType.setText(Detail.getOperationCodeTransportType().toString());
        txtOperationCodeTransportType.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setOperationCodeTransportType(newValue);
        });
        txtPalletCode.setText(Detail.getPaletCode());
     /*   txtPalletCode.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setPaletCode(newValue);
        });*/
        txtPartnerCode.setText(Detail.getPartnerCode().toString());
        txtPartnerCode.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setPartnerCode(newValue);
        });
        txtPartnerCountryCode.setText(Detail.getPartnerCountryCode().toString());
        txtPartnerCountryCode.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setPartnerCountryCode(newValue);
        });
        txtPartnerNam.setText(Detail.getPartnerName().toString());
        txtPartnerNam.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setPartnerName(newValue);
        });

        txtVAT.setText(Detail.getVATNr().toString());
        txtVAT.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setVATNr(newValue);

        });

        txtStartDateOfTransport.setText(Detail.getStartDateOfTransport().toString());
        txtStartDateOfTransport.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setStartDateOfTransport(newValue);
        });
        txtStreetNameUnloading.setText(Detail.getStreetNameUnloading().toString());
        txtStreetNameUnloading.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setStreetNameUnloading(newValue);
        });
        txtTownNameLoading.setText(Detail.getTownNameLoading().toString());
        txtTownNameLoading.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setTownNameLoading(newValue);
        });
        txtTownNameUnloading.setText(Detail.getTownNameUnloading().toString());
        txtTownNameUnloading.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setTownNameUnloading(newValue);
        });
        txtTransporterCode.setText(Detail.getTransporterCode().toString());
        txtTransporterCode.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setTransporterCode(newValue);
        });
        txtTransporterCountryCode.setText(Detail.getTransporterCountryCode().toString());
        txtTransporterCountryCode.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setTransporterCountryCode(newValue);
        });
        txtTransporterName.setText(Detail.getTransporterName().toString());
        txtTransporterName.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setTransporterName(newValue);
        });
        txtTruckPlateNumber.setText(Detail.getTruckPlateNumber().toString());
        txtTruckPlateNumber.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setTruckPlateNumber(newValue);
        });
        txtStreetNameLoading.setText(Detail.getStreetNameLoading().toString());
        txtStreetNameLoading.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setStreetNameLoading(newValue);
        });
        txtOperationCodeGoodsDeclared.setText(Detail.getOperationCodeGoodsDeclared().toString());
        txtOperationCodeGoodsDeclared.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setOperationCodeGoodsDeclared(newValue);
        });
        ObservableList<Detail> selectedItems =
                selectionModel.getSelectedItems();
        // tbl1.getColumns().addAll(colLinie, colCod, colTarifCode, colDenumire, colCantitate, colUM,colGreutateNeta, colGreutateBruta, colValoare);

        colLinie.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Detail, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Detail, String> t) {
                        ((Detail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setLineNumber(t.getNewValue());
                    }

                }
        );
        colCod.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Detail, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Detail, String> t) {
                        ((Detail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setInternalReferenceCode(t.getNewValue());
                    }

                }
        );
        colDenumire.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Detail, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Detail, String> t) {
                        ((Detail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setProductName(t.getNewValue());
                    }

                }
        );
        colTarifCode.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Detail, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Detail, String> t) {
                        ((Detail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setTariffCode(t.getNewValue());
                    }

                }
        );
        colUM.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Detail, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Detail, String> t) {
                        ((Detail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setQuantityMeasurementCode(t.getNewValue());
                    }

                }
        );

        colValoare.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Detail, BigDecimal>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Detail, BigDecimal> t) {
                        ((Detail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setNetValueWithoutVAT(t.getNewValue());
                    }

                }
        );
        colCantitate.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Detail, BigDecimal>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Detail, BigDecimal> t) {
                        ((Detail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setQuantity(t.getNewValue());
                    }

                }
        );
        colGreutateNeta.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Detail, BigDecimal>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Detail, BigDecimal> t) {
                        ((Detail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setNetWeight(t.getNewValue());
                    }

                }
        );
        colGreutateBruta.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Detail, BigDecimal>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Detail, BigDecimal> t) {
                        ((Detail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setGrossWeight(t.getNewValue());
                    }

                }
        );
       colGrossNou.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Detail, BigDecimal>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Detail, BigDecimal> t) {
                        ((Detail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setNewGrossWeight(t.getNewValue());
                    }

                }
        );
        BigDecimal totalGross = BigDecimal.valueOf(0);
        for (Detail item : tbl1.getItems()) {
            totalGross = totalGross.add(item.getGrossWeight());

            lbltotalGross.setText(totalGross.toPlainString());
        }
        BigDecimal totalNet = BigDecimal.valueOf(0);
        for (Detail item : tbl1.getItems()) {
            totalNet = totalNet.add(item.getNetWeight());
            lbltotalNet.setText(totalNet.toPlainString());
        }
        BigDecimal totalVal = BigDecimal.valueOf(0);
        for (Detail item : tbl1.getItems()) {
            totalVal = totalVal.add(item.getNetValueWithoutVAT());
            lbltotalVal.setText(totalVal.toPlainString());
        }
        BigDecimal totalGrossCorect = BigDecimal.valueOf(0);
        for (Detail item : tbl1.getItems()) {
            totalGrossCorect = totalGrossCorect.add(item.getNewGrossWeight());

            lbltotalNewGross.setText(totalGrossCorect.toPlainString());
        }
    }
private void reload(){
        if(Detail.CheckFileExist()){
            fisierProcesat.setText(Detail.fileCurrent);
        }else{
            fisierProcesat.setText("NU SUNT FISIERE DE PROCESAT");
            fisierProcesat.setTextFill(Color.RED);
        }

    try {
        if(Detail.CheckFileExist()) {
            Detail.incarca();
        }
    } catch (ParserConfigurationException e) {
        throw new RuntimeException(e);
    } catch (SAXException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (TransformerException e) {
        throw new RuntimeException(e);
    }

    txtComanda.setText(Detail.getInternalReference().toString());
    txtComanda.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setInternalReference(newValue);
    });
    txtDocumentNumber.setText(Detail.getDocumentNumber().toString());
    txtDocumentNumber.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setDocumentNumber(newValue);
    });
    txtCodeForBorderCrossingPoint.setText(Detail.getCodeForBorderCrossingPoint().toString());
    txtCodeForBorderCrossingPoint.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setCodeForBorderCrossingPoint(newValue);
    });
    txtCodeForCustomsOffice.setText(Detail.getCodeForCustomsOffice().toString());
    txtCodeForCustomsOffice.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setCodeForCustomsOffice(newValue);
    });
    txtCountyUnloading.setText(Detail.getCountyUnloading().toString());
    txtCountyUnloading.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setCountyUnloading(newValue);
    });
    txtDocumentDate.setText(Detail.getDocumentDate().toString());
    txtDocumentDate.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setDocumentDate(newValue);
    });
    txtCountryCodeLoading.setText(Detail.getCountryCodeLoading().toString());
    txtCountryCodeLoading.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setCountryCodeLoading(newValue);
    });
    txtCountryCodeUnloading.setText(Detail.getCountryCodeUnloading().toString());
    txtCountryCodeUnloading.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setCountryCodeUnloading(newValue);
    });
    txtDocumentTypeCode.setText(Detail.getDocumentTypeCode().toString());
    txtDocumentTypeCode.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setDocumentTypeCode(newValue);
    });
    txtOperationCodeTransportType.setText(Detail.getOperationCodeTransportType().toString());
    txtOperationCodeTransportType.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setOperationCodeTransportType(newValue);
    });
    txtPalletCode.setText(Detail.getPaletCode());
     /*   txtPalletCode.textProperty().addListener((observable, oldValue, newValue) -> {
            Detail.setPaletCode(newValue);
        });*/
    txtPartnerCode.setText(Detail.getPartnerCode().toString());
    txtPartnerCode.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setPartnerCode(newValue);
    });
    txtPartnerCountryCode.setText(Detail.getPartnerCountryCode().toString());
    txtPartnerCountryCode.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setPartnerCountryCode(newValue);
    });
    txtPartnerNam.setText(Detail.getPartnerName().toString());
    txtPartnerNam.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setPartnerName(newValue);
    });

    txtVAT.setText(Detail.getVATNr().toString());
    txtVAT.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setVATNr(newValue);

    });

    txtStartDateOfTransport.setText(Detail.getStartDateOfTransport().toString());
    txtStartDateOfTransport.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setStartDateOfTransport(newValue);
    });
    txtStreetNameUnloading.setText(Detail.getStreetNameUnloading().toString());
    txtStreetNameUnloading.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setStreetNameUnloading(newValue);
    });
    txtTownNameLoading.setText(Detail.getTownNameLoading().toString());
    txtTownNameLoading.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setTownNameLoading(newValue);
    });
    txtTownNameUnloading.setText(Detail.getTownNameUnloading().toString());
    txtTownNameUnloading.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setTownNameUnloading(newValue);
    });
    txtTransporterCode.setText(Detail.getTransporterCode().toString());
    txtTransporterCode.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setTransporterCode(newValue);
    });
    txtTransporterCountryCode.setText(Detail.getTransporterCountryCode().toString());
    txtTransporterCountryCode.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setTransporterCountryCode(newValue);
    });
    txtTransporterName.setText(Detail.getTransporterName().toString());
    txtTransporterName.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setTransporterName(newValue);
    });
    txtTruckPlateNumber.setText(Detail.getTruckPlateNumber().toString());
    txtTruckPlateNumber.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setTruckPlateNumber(newValue);
    });
    txtStreetNameLoading.setText(Detail.getStreetNameLoading().toString());
    txtStreetNameLoading.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setStreetNameLoading(newValue);
    });
    txtOperationCodeGoodsDeclared.setText(Detail.getOperationCodeGoodsDeclared().toString());
    txtOperationCodeGoodsDeclared.textProperty().addListener((observable, oldValue, newValue) -> {
        Detail.setOperationCodeGoodsDeclared(newValue);
    });
};

}
