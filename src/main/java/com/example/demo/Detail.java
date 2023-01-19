package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;

public class Detail
{
    static ObservableList<Detail> lista = FXCollections.observableArrayList();
    static String fileCurrent;
    private static  String VATNr="";

    static String InternalReference="";
    static String InternalEmail="";
    static String ExternalEmail="";
    String LineNumber;
    static String OperationCodeTransportType="";
    String TariffCode;
    String ProductName;
    static String OperationCodeGoodsDeclared="";
    BigDecimal Quantity;
    String QuantityMeasurementCode;
    BigDecimal NetWeight;
    BigDecimal GrossWeight;
    BigDecimal NetValueWithoutVAT;
    String InternalReferenceCode;
    static String PaletCode="";
    static String PartnerCountryCode="";
    static String PartnerCode="";
    static String PartnerName="";
    static String TruckPlateNumber="";
    static String TransporterCountryCode="";
    static String TransporterCode="";
    static String TransporterName="";
    static String StartDateOfTransport="";
    static String CodeForBorderCrossingPoint="";
    static String CodeForCustomsOffice="";
    static String CountryCodeLoading="";
    static  String CountyCodeLoading="";
    static String TownNameLoading="";
    static String StreetNameLoading="";
    static String CountryCodeUnloading="";
    static String CountyUnloading="";
    static String TownNameUnloading="";
    static String StreetNameUnloading="";
    static String CountyCodeHub="";
    static String TownNameHub="";
    static String HubCode="";
    static String DocumentTypeCode="";
    static String DocumentNumber="";
    static String DocumentDate="";
    static String StreetNameHub="";

    BigDecimal NewGrossWeight;

    public BigDecimal getNewGrossWeight() {
        return NewGrossWeight;
    }

    public void setNewGrossWeight(BigDecimal newGrossWeight) {
        NewGrossWeight = newGrossWeight;
    }

    public static String getVATNr() {
        return VATNr;
    }

    public static String getInternalReference() {
        return InternalReference;
    }


    public static void setStreetNameHub(String streetNameHub) {
        StreetNameHub = streetNameHub;
    }

    public static String getStreetNameHub() {
        return StreetNameHub;
    }

    public static void setExternalEmail(String externalEmail) {
        ExternalEmail = externalEmail;
    }

    public void setNetValueWithoutVAT(BigDecimal netValueWithoutVAT) {
        NetValueWithoutVAT = netValueWithoutVAT;
    }

    public void setInternalReferenceCode(String internalReferenceCode) {
        InternalReferenceCode = internalReferenceCode;
    }

    public static void setPaletCode(String paletCode) {
        PaletCode = paletCode;
    }

    public static void setPartnerCountryCode(String partnerCountryCode) {
        PartnerCountryCode = partnerCountryCode;
    }

    public static void setPartnerCode(String partnerCode) {
        PartnerCode = partnerCode;
    }

    public static void setPartnerName(String partnerName) {
        PartnerName = partnerName;
    }

    public static void setTruckPlateNumber(String truckPlateNumber) {
        TruckPlateNumber = truckPlateNumber;
    }

    public static void setTransporterCountryCode(String transporterCountryCode) {
        TransporterCountryCode = transporterCountryCode;
    }

    public static void setTransporterCode(String transporterCode) {
        TransporterCode = transporterCode;
    }

    public static void setTransporterName(String transporterName) {
        TransporterName = transporterName;
    }

    public static void setStartDateOfTransport(String startDateOfTransport) {
        StartDateOfTransport = startDateOfTransport;
    }

    public static void setCodeForBorderCrossingPoint(String codeForBorderCrossingPoint) {
        CodeForBorderCrossingPoint = codeForBorderCrossingPoint;
    }

    public static void setCodeForCustomsOffice(String codeForCustomsOffice) {
        CodeForCustomsOffice = codeForCustomsOffice;
    }

    public static void setCountryCodeLoading(String countryCodeLoading) {
        CountryCodeLoading = countryCodeLoading;
    }

    public static void setCountyCodeLoading(String countyCodeLoading) {
        CountyCodeLoading = countyCodeLoading;
    }

    public static void setTownNameLoading(String townNameLoading) {
        TownNameLoading = townNameLoading;
    }

    public static void setStreetNameLoading(String streetNameLoading) {
        StreetNameLoading = streetNameLoading;
    }

    public static void setCountryCodeUnloading(String countryCodeUnloading) {
        CountryCodeUnloading = countryCodeUnloading;
    }

    public static void setCountyUnloading(String countyUnloading) {
        CountyUnloading = countyUnloading;
    }

    public static void setTownNameUnloading(String townNameUnloading) {
        TownNameUnloading = townNameUnloading;
    }

    public static void setStreetNameUnloading(String streetNameUnloading) {
        StreetNameUnloading = streetNameUnloading;
    }

    public static void setCountyCodeHub(String countyCodeHub) {
        CountyCodeHub = countyCodeHub;
    }

    public static void setTownNameHub(String townNameHub) {
        TownNameHub = townNameHub;
    }

    public static void setHubCode(String hubCode) {
        HubCode = hubCode;
    }

    public static void setDocumentTypeCode(String documentTypeCode) {
        DocumentTypeCode = documentTypeCode;
    }

    public static void setDocumentNumber(String documentNumber) {
        DocumentNumber = documentNumber;
    }

    public static void setDocumentDate(String documentDate) {
        DocumentDate = documentDate;
    }

    public static String getExternalEmail() {
        return ExternalEmail;
    }

    public BigDecimal getNetValueWithoutVAT() {
        return NetValueWithoutVAT;
    }

    public String getInternalReferenceCode() {
        return InternalReferenceCode;
    }

    public static String getPaletCode() {
        return PaletCode;
    }

    public static String getPartnerCountryCode() {
        return PartnerCountryCode;
    }

    public static String getPartnerCode() {
        return PartnerCode;
    }

    public static String getPartnerName() {
        return PartnerName;
    }

    public static String getTruckPlateNumber() {
        return TruckPlateNumber;
    }

    public static String getTransporterCountryCode() {
        return TransporterCountryCode;
    }

    public static String getTransporterCode() {
        return TransporterCode;
    }

    public static String getTransporterName() {
        return TransporterName;
    }

    public static String getStartDateOfTransport() {
        return StartDateOfTransport;
    }

    public static String getCodeForBorderCrossingPoint() {
        return CodeForBorderCrossingPoint;
    }

    public static String getCodeForCustomsOffice() {
        return CodeForCustomsOffice;
    }

    public static String getCountryCodeLoading() {
        return CountryCodeLoading;
    }

    public static String getCountyCodeLoading() {
        return CountyCodeLoading;
    }

    public static String getTownNameLoading() {
        return TownNameLoading;
    }

    public static String getStreetNameLoading() {
        return StreetNameLoading;
    }

    public static String getCountryCodeUnloading() {
        return CountryCodeUnloading;
    }

    public static String getCountyUnloading() {
        return CountyUnloading;
    }

    public static String getTownNameUnloading() {
        return TownNameUnloading;
    }

    public static String getStreetNameUnloading() {
        return StreetNameUnloading;
    }

    public static String getCountyCodeHub() {
        return CountyCodeHub;
    }

    public static String getTownNameHub() {
        return TownNameHub;
    }

    public static String getHubCode() {
        return HubCode;
    }

    public static String getDocumentTypeCode() {
        return DocumentTypeCode;
    }

    public static String getDocumentNumber() {
        return DocumentNumber;
    }

    public static String getDocumentDate() {
        return DocumentDate;
    }

    public static String getInternalEmail() {
        return InternalEmail;
    }

    public String getLineNumber() {
        return LineNumber;
    }

    public static String getOperationCodeTransportType() {
        return OperationCodeTransportType;
    }

    public String getTariffCode() {
        return TariffCode;
    }

    public String getProductName() {
        return ProductName;
    }

    public static String getOperationCodeGoodsDeclared() {
        return OperationCodeGoodsDeclared;
    }

    public BigDecimal getQuantity() {
        return Quantity;
    }

    public String getQuantityMeasurementCode() {
        return QuantityMeasurementCode;
    }

    public BigDecimal getNetWeight() {
        return NetWeight;
    }

    public BigDecimal getGrossWeight() {
        return GrossWeight;
    }

    public static void setVATNr(String vATNr) { VATNr = vATNr;}

    public static void setInternalReference(String internalReference) {
        InternalReference = internalReference;
    }

    public static void setInternalEmail(String internalEmail) {
        InternalEmail = internalEmail;
    }

    public void setLineNumber(String lineNumber) {
        LineNumber = lineNumber;
    }

    public static void setOperationCodeTransportType(String operationCodeTransportType) {
        OperationCodeTransportType = operationCodeTransportType;
    }

    public void setTariffCode(String tariffCode) {
        TariffCode = tariffCode;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public static void setOperationCodeGoodsDeclared(String operationCodeGoodsDeclared) {
        OperationCodeGoodsDeclared = operationCodeGoodsDeclared;
    }

    public void setQuantity(BigDecimal quantity) {
        Quantity = quantity;
    }

    public void setQuantityMeasurementCode(String quantityMeasurementCode) {
        QuantityMeasurementCode = quantityMeasurementCode;
    }

    public void setNetWeight(BigDecimal netWeight) {
        NetWeight = netWeight;
    }

   public void setGrossWeight(BigDecimal grossWeight) {
        GrossWeight = grossWeight;
    }

    public static ObservableList<Detail> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        return "<Detail " +
                "VATNr=\"" + VATNr + '\"' +
                " InternalReference=\"" + InternalReference + '\"' +
                " InternalEmail=\"" + InternalEmail + '\"' +
                " ExternalEmail=\"" + ExternalEmail + '\"' +
                " LineNumber=\"" + LineNumber + '\"' +
                " OperationCodeTransportType=\"" + OperationCodeTransportType + '\"' +
                " TariffCode=\"" + TariffCode + '\"' +
                " ProductName=\"" + ProductName + '\"' +
                " OperationCodeGoodsDeclared=\"" + OperationCodeGoodsDeclared + '\"' +
                " Quantity=\"" + Quantity.toPlainString() + '\"' +
                " QuantityMeasurementCode=\"" + QuantityMeasurementCode + '\"' +
                " NetWeight=\"" + NetWeight.toPlainString() + '\"' +
                " GrossWeight=\"" + NewGrossWeight.setScale(15).toPlainString() +'\"' +
                " NetValueWithoutVAT=\"" + NetValueWithoutVAT.toPlainString() +'\"' +
                " InternalReferenceCode=\"" + InternalReferenceCode.toString() +'\"' +
                " PalletCode=\"" + '\"' +
                " PartnerCountryCode=\"" + PartnerCountryCode.toString() +'\"' +
                " PartnerCode=\"" + PartnerCode.toString() +'\"' +
                " PartnerName=\"" + PartnerName.toString() +'\"' +
                " TruckPlateNumber=\"" + TruckPlateNumber.toString() +'\"' +
                " TransporterCountryCode=\"" + TransporterCountryCode.toString() +'\"' +
                " TransporterCode=\"" + TransporterCode.toString() +'\"' +
                " TransporterName=\"" + TransporterName.toString() +'\"' +
                " StartDateOfTransport=\"" + StartDateOfTransport.toString() +'\"' +
                " CodeForBorderCrossingPoint=\"" + CodeForBorderCrossingPoint +'\"' +
                " CodeForCustomsOffice=\"" + CodeForCustomsOffice.toString() +'\"' +
                " CountryCodeLoading=\"" + CountryCodeLoading.toString() +'\"' +
                " CountyCodeLoading=\"" + CountyCodeLoading.toString() +'\"' +
                " TownNameLoading=\"" + TownNameLoading.toString() +'\"' +
                " StreetNameLoading=\"" + StreetNameLoading.toString() +'\"' +
                " CountryCodeUnloading=\"" + CountryCodeUnloading.toString() +'\"' +
                " CountyUnloading=\"" + CountyUnloading.toString() +'\"' +
                " TownNameUnloading=\"" + TownNameUnloading.toString() +'\"' +
                " StreetNameUnloading=\"" + StreetNameUnloading +'\"' +
                " CountyCodeHub=\"" + CountyCodeHub.toString() +'\"' +
                " TownNameHub=\"" + TownNameHub.toString() +'\"' +
                " StreetNameHub=\"" + StreetNameHub.toString() +'\"' +
                " HubCode=\"" + HubCode.toString() +'\"' +
                " DocumentTypeCode=\"" + DocumentTypeCode.toString() +'\"' +
                " DocumentNumber=\"" + DocumentNumber.toString() +'\"' +
                " DocumentDate=\"" + DocumentDate.toString() +'\"' +
                "/>";
    }
 /*   public static LinkedList<General> genereazaTabel(LinkedList<Detail> det){
        LinkedList<General> gen = new LinkedList<>();
        for(int i=0; i<det.size(); i++){

        }

        return gen;
    }
     }*/
    public static void incarca() throws ParserConfigurationException,
            SAXException, IOException, ParserConfigurationException,
            TransformerException {
        lista.clear();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder loader = factory.newDocumentBuilder();

        Document document = loader.parse(Utils.sourceDir.getAbsolutePath()+"\\"+fileCurrent);

        DocumentTraversal trav = (DocumentTraversal) document;

        NodeIterator it = trav.createNodeIterator(document.getDocumentElement(),
                NodeFilter.SHOW_ELEMENT, null, true);

        int c = 1;
        int contor=0;
        for (Node node = it.nextNode(); node != null;
             node = it.nextNode()) {

            String name = node.getNodeName();
            if (name.equals("Detail")) {
                contor++;
                Detail d = new Detail();

                    d.setVATNr(ReturnString(node.getAttributes().getNamedItem("VATNr").toString()));
                    d.setInternalReference(ReturnString(node.getAttributes().getNamedItem("InternalReference").toString()));
                    d.setInternalEmail(ReturnString(node.getAttributes().getNamedItem("InternalEmail").toString()));
                    d.setExternalEmail(ReturnString(node.getAttributes().getNamedItem("ExternalEmail").toString()));
                    d.setOperationCodeTransportType(ReturnString(node.getAttributes().getNamedItem("OperationCodeTransportType").toString()));
                    d.setOperationCodeGoodsDeclared(ReturnString(node.getAttributes().getNamedItem("OperationCodeGoodsDeclared").toString()));
                    d.setPartnerCountryCode(ReturnString(node.getAttributes().getNamedItem("PartnerCountryCode").toString()));
                    d.setPartnerCode(ReturnString(node.getAttributes().getNamedItem("PartnerCode").toString()));
                    d.setPartnerName(ReturnString(node.getAttributes().getNamedItem("PartnerName").toString()));
                    d.setTruckPlateNumber(ReturnString(node.getAttributes().getNamedItem("TruckPlateNumber").toString()));
                    d.setTransporterCountryCode(ReturnString(node.getAttributes().getNamedItem("TransporterCountryCode").toString()));
                    d.setTransporterCode(ReturnString(node.getAttributes().getNamedItem("TransporterCode").toString()));
                    d.setTransporterName(ReturnString(node.getAttributes().getNamedItem("TransporterName").toString()));
                    d.setStartDateOfTransport(ReturnString(node.getAttributes().getNamedItem("StartDateOfTransport").toString()));
                    d.setCodeForBorderCrossingPoint(ReturnString(node.getAttributes().getNamedItem("CodeForBorderCrossingPoint").toString()));
                    d.setCodeForCustomsOffice(ReturnString(node.getAttributes().getNamedItem("CodeForCustomsOffice").toString()));
                    d.setCountryCodeLoading(ReturnString(node.getAttributes().getNamedItem("CountryCodeLoading").toString()));
                    d.setCountyCodeLoading(ReturnString(node.getAttributes().getNamedItem("CountyCodeLoading").toString()));
                    d.setTownNameLoading(ReturnString(node.getAttributes().getNamedItem("TownNameLoading").toString()));
                    d.setStreetNameLoading(ReturnString(node.getAttributes().getNamedItem("StreetNameLoading").toString()));
                    d.setCountryCodeUnloading(ReturnString(node.getAttributes().getNamedItem("CountryCodeUnloading").toString()));
                    d.setCountyUnloading(ReturnString(node.getAttributes().getNamedItem("CountyUnloading").toString()));
                    d.setTownNameUnloading(ReturnString(node.getAttributes().getNamedItem("TownNameUnloading").toString()));
                    d.setStreetNameUnloading(ReturnString(node.getAttributes().getNamedItem("StreetNameUnloading").toString()));
                    d.setCountyCodeHub(ReturnString(node.getAttributes().getNamedItem("CountyCodeHub").toString()));
                    d.setTownNameHub(ReturnString(node.getAttributes().getNamedItem("TownNameHub").toString()));
                    d.setStreetNameHub(ReturnString(node.getAttributes().getNamedItem("StreetNameHub").toString()));
                    d.setHubCode(ReturnString(node.getAttributes().getNamedItem("HubCode").toString()));
                    d.setDocumentTypeCode(ReturnString(node.getAttributes().getNamedItem("DocumentTypeCode").toString()));
                    d.setDocumentNumber(ReturnString(node.getAttributes().getNamedItem("DocumentNumber").toString()));
                    d.setDocumentDate(ReturnString(node.getAttributes().getNamedItem("StartDateOfTransport").toString()));



                d.setLineNumber(ReturnString(node.getAttributes().getNamedItem("LineNumber").toString()));
                d.setTariffCode(ReturnString(node.getAttributes().getNamedItem("TariffCode").toString()));
                d.setProductName(ReturnString(node.getAttributes().getNamedItem("ProductName").toString()));
                d.setQuantity(new BigDecimal(ReturnString(node.getAttributes().getNamedItem("Quantity").toString())));
                d.setQuantityMeasurementCode(ReturnString(node.getAttributes().getNamedItem("QuantityMeasurementCode").toString()));
                d.setNetWeight(new BigDecimal(ReturnString(node.getAttributes().getNamedItem("NetWeight").toString())));
                d.setNetValueWithoutVAT(new BigDecimal(ReturnString(node.getAttributes().getNamedItem("NetValueWithoutVAT").toString())));
                d.setInternalReferenceCode(ReturnString(node.getAttributes().getNamedItem("InternalReferenceCode").toString()));
                d.setGrossWeight(new BigDecimal(ReturnString(node.getAttributes().getNamedItem("GrossWeight").toString())));
                if(Produse.mapProduse.containsKey(d.getInternalReferenceCode())) {
                    String x = ((Produse) (Produse.mapProduse.get(d.getInternalReferenceCode().toString()))).getGrosPcs().toString();

                    BigDecimal bd = new BigDecimal(x);
                    d.setNewGrossWeight((d.Quantity.multiply(bd)).setScale(15));
                }
                lista.add(d);

                d=null;
            }
            c++;
        }
    }
    private static  String ReturnString(String s){
        String su = s.substring(s.indexOf('"')+1, s.lastIndexOf('"'));

        return su;
    }
    final static String xmlString1 ="<Report Name=\"eTransport - Aprovizionare\">" +
                                   "<table1>" +
                                   "<InternalReference_Collection>" +
                                   "<InternalReference>" +
                                   "<Detail_Collection>" ;
    final static String xmlString2 =
            "</Detail_Collection>" +
            "</InternalReference>" +
            "</InternalReference_Collection>" +
            "</table1>" +
            "</Report>";
    public static void PrintLista() throws FileNotFoundException {

        SAXBuilder sax = new SAXBuilder();
        String midle ="";
        for(int i=0;i<Detail.lista.size(); i++){
            midle= midle+Detail.lista.get(i).toString();
        }
        org.jdom2.Document doc2;
        // https://rules.sonarsource.com/java/RSPEC-2755
        // prevent xxe
     //   sax.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
     //   sax.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");


      ;
        try {

            doc2 = sax.build(new StringReader(xmlString1 + midle + xmlString2));
        } catch (JDOMException | IOException e) {
            throw new RuntimeException(e);
        }
        XMLOutputter xmlOutputter = new XMLOutputter(Format.getCompactFormat().setOmitDeclaration(false));;


        // output to any OutputStream
        try(FileOutputStream fileOutputStream =
                    new FileOutputStream(Utils.destinationDir +"/"+Detail.getInternalReference()+".xml")){
            xmlOutputter.output(doc2, fileOutputStream);
            File fl = new File(Utils.sourceDir.getAbsolutePath()+"\\"+fileCurrent);
           if(fl.exists()) {
               fl.delete();
           }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void Print2() {

        String midle = "";
        for (int i = 0; i < Detail.lista.size(); i++) {
            midle = midle + Detail.lista.get(i).toString();
        }
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        Document doc;
        try {

            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder builder = dbf.newDocumentBuilder();

            doc = builder.parse(new InputSource(new StringReader(xmlString1 + midle + xmlString2)));

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }


        // Make a transformer factory to create the Transformer
        TransformerFactory tFactory = TransformerFactory.newInstance();

        // Make the Transformer
        Transformer transformer = null;
        try {
            transformer = tFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        }

        // Mark the document as a DOM (XML) source
        DOMSource source = new DOMSource(doc);

        // Say where we want the XML to go
        StreamResult result = new StreamResult(Utils.destinationDir +"/"+Detail.getInternalReference()+".xml");

        // Write the XML to file
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }


        // output to any OutputStream


    }
    BigDecimal SumaNet(){
        BigDecimal suma =new BigDecimal(0);
        for(int i=0;i<lista.size();i++){
            suma.add(lista.get(i).getNetWeight());
        }
        return suma;
    }
    BigDecimal SumaGross(){
        BigDecimal suma =new BigDecimal(0);
        for(int i=0;i<lista.size();i++){
            suma.add(lista.get(i).getGrossWeight());
        }
        return suma;
    }
    BigDecimal SumaValoare(){
        BigDecimal suma =new BigDecimal(0);
        for(int i=0;i<lista.size();i++){
            suma.add(lista.get(i).getNetValueWithoutVAT());
        }
        return suma;
    }

    private static File setFile( String dirName)
    {

        File f;
        File dir = new File(dirName);
        if ( dir.isDirectory() )
        {

            String[] list = dir.list(new FilenameFilter()
            {
                @Override
                public boolean accept(File f, String s )
                {
                    return s.endsWith(".xml");
                }

            });

            if ( list.length > 0 )
            {
               // return list[0];
                return new File(list[0]);
            }
        }
        return null;
       // return "";

    }

    static boolean CheckFileExist(){
        File f = setFile(Utils.sourceDir.getAbsolutePath()+"\\");

        if(f != null) {
            fileCurrent = f.getPath();
            System.out.println(fileCurrent);
            return true;
        }else return false;
    }
}
