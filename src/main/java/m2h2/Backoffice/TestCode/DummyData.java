package m2h2.Backoffice.TestCode;

import m2h2.Backoffice.Components.*;
import m2h2.Backoffice.Components.Database.DatabaseConnectie;
import m2h2.Backoffice.Magazijn.*;
import m2h2.Algoritme.Orders_Met_Coordinaten;
import m2h2.Algoritme.RouteBuilder_OSRM;
import m2h2.Algoritme.Adressen_GEO_Data_Extractor;
import m2h2.Backoffice.Components.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class DummyData {


    public DummyData(){
        //koeriers en bussen voor tijdens de demo

        Koerier koerier;
        koerier = new Koerier("Henk", 5678);
        koerier = new Koerier("Willem", 2313);
        koerier = new Koerier("Sanne", 5642);
        koerier = new Koerier("Gerben", 7478);
        koerier = new Koerier("Justin", 9878);
        koerier = new Koerier("Billy", 5843);


        //bus = new Bus("N-99-GSD", 457);


    }
}