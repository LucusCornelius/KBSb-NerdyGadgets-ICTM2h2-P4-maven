package m2h2.Backoffice.TestCode;

import m2h2.Algoritme.Adressen_GEO_Data_Extractor;
import m2h2.Backoffice.Components.*;

import java.util.ArrayList;

public class DummyData {


    public void setDummyData(){

        Koerier koerier;
        koerier = new Koerier("Henk", 5678);
        koerier = new Koerier("Willem", 2313);
        koerier = new Koerier("Sanne", 5642);
        koerier = new Koerier("Gerben", 7478);
        koerier = new Koerier("Justin", 9878);
        koerier = new Koerier("Billy", 5843);

        /*
        ArrayList<Order> orders = new ArrayList<Order>();
        Order O = new Order("lucas", "Bloemberg", "7924PW", "Veeningen", 28, "", false);
        OrderLine OL = new OrderLine("Tc", 3, "Rice Cooker");
        O.addOrderline(OL);
        orders.add(O);

        O = new Order("lucas", "Hertog Ottostraat", "5552KG", "Valkenswaard", 15, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Lucien Gaudinstraat", "1034WB", "Amsterdam", 46, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Groenlinglaan", "3951WD", "Maarn", 45, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Emmastraat", "7075AN", "Etten", 52, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Wolweverstraat", "8011NW", "Zwolle", 27, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Rijsoordstraat", "3081BX", "Rotterdam", 60, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Kraanbaan", "2951JG", "Alblasserdam", 29, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Indrelaan", "5627VL", "Eindhoven", 75, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Bilderdijkhof", "1422DV", "Uithoorn", 12, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Achter de Hoven", "6225EK", "Maastricht", 70, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Erasmusplein", "3132EL", "Vlaardingen", 47, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Proost de Beaufortstraat", "6231EB", "Meerssen", 28, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Vredeman de Vriesstraat", "5041GS", "Tilburg", 86, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Haakakker", "5466NA", "Veghel", 68, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Santpoortse Dreef", "2071TS", "Santpoort-noord", 136, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Fitissingel", "5754CE", "Deurne", 180, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Veilingstraat", "6827AK", "Arnhem", 17, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Lepelaarstraat", "3181TH", "Rozenburg", 6, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Kerkstraat", "9641AR", "Veendam", 6, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Vossenschanslaan", "3445EC", "Woerden", 54, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Tweelingen", "3225EK", "Hellevoetsluis", 10, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Barbarastraat", "6462CK", "Kerkrade", 16, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Sint Hubertusstraat", "5614CK", "Eindhoven", 54, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Meerheide", "5521DZ", "Eersel", 15, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Bloemberg", "7924PW", "Veeningen", 28, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Vredeman de Vriesstraat", "5041GS", "Tilburg", 86, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Jacob van Wassenaerstraat", "5703CG", "Helmond", 20, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Essendaal", "3181AD", "Rozenburg", 21, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Tugelaweg", "1092VH", "Amsterdam", 44, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Peizerweg", "9495PA", "Winde", 123, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Schouw", "2636DG", "Schipluiden", 25, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Prins Willem-Alexanderlaan", "6301TT", "Valkenburg", 127, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Maar", "6454AM", "Jabeek", 16, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Watermolen", "1035BV", "Amsterdam", 52, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Rhaladijk", "9064DD", "Aldtsjerk", 7, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Dirk Costerstraat", "3069WE", "Rotterdam", 1, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Langbree", "9403GB", "Assen", 4, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Westeresweg", "7875BC", "Exloo", 39, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "De Eendracht", "1188GN", "Amstelveen", 13, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Grote Haag", "3811HH", "Amersfoort", 129, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Zevenblad", "7623CG", "Borne", 18, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Van Dijckstraat", "3117WT", "Schiedam", 21, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Landschot", "2036EW", "Haarlem", 68, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Kloosterstraat", "5051RE", "Goirle", 15, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Dinkel", "2911EE", "Nieuwerkerk Aan Den Ijssel", 48, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Rubensstraat", "9718MG", "Groningen", 93, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Bourgondieweg", "1611WG", "Bovenkarspel", 161, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Rosa Spierplantsoen", "1705KV", "Heerhugowaard", 99, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Kwikstraat", "5446AL", "Wanroij", 5, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Vosbergstraat", "5384ST", "Heesch", 4, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Begoniastraat", "7906JA", "Hoogeveen", 11, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Miep Giesstraat", "3417CW", "Montfoort", 5, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Mantinghstraat", "7908AX", "Hoogeveen", 32, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Lepelaarstraat", "3181TH", "Rozenburg", 6, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Huttensmidhoek", "7546AZ", "Enschede", 58, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Velveweg", "7533XH", "Enschede", 161, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Dorpsplein", "2065AL", "Haarlemmerliede", 5, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Jacob van Wassenaerstraat", "5703CG", "Helmond", 20, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Alendorpstraat", "3511LM", "Utrecht", 29, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "De Halden", "6685CD", "Haalderen", 32, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Heerderweg", "6224LA", "Maastricht", 67, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Bloemberg", "7924PW", "Veeningen", 28, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Pleinweg", "3081JM", "Rotterdam", 175, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Verlengde Oosterdiep Oostzijde", "7884TG", "Barger-compascuum", 87, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Stuken", "9247DW", "Ureterp", 80, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Wolweverstraat", "8011NW", "Zwolle", 27, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Reeenlaan", "7315EX", "Apeldoorn", 42, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Bisschop Callierstraat", "2014XH", "Haarlem", 8, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Smithlaan", "6135JL", "Sittard", 73, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Augustijnenstraat", "7011BX", "Gaanderen", 3, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Dopheide", "5768GC", "Meijel", 17, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Oudeweg", "4571LL", "Axel", 23, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Begoniastraat", "4645CB", "Putte", 26, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Egelantier", "3222VD", "Hellevoetsluis", 111, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Steenwijkerweg", "8471KW", "Wolvega", 15, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Cronjestraat", "1782EE", "Den Helder", 30, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Begoniastraat", "7906JA", "Hoogeveen", 11, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Wolfskuilen", "7364AA", "Lieren", 4, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Draailier", "3766ET", "Soest", 22, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Hertog Ottostraat", "5552KG", "Valkenswaard", 15, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Veldhofstraat", "6471CJ", "Eygelshoven", 2, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Simplonbaan", "3524GC", "Utrecht", 79, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Donkerslootstraat", "3074WD", "Rotterdam", 71, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Begoniastraat", "7906JA", "Hoogeveen", 11, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Bourgondieweg", "1611WG", "Bovenkarspel", 161, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Eemhof", "2987EA", "Ridderkerk", 13, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Steenhof", "7731EW", "Ommen", 21, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Klaproosweide", "3448JH", "Woerden", 14, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Van Moerkerkenstraat", "1064KB", "Amsterdam", 5, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Kerkstraat", "6543KK", "Nijmegen", 50, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Hugo de Grootstraat", "9665LT", "Oude Pekela", 26, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Frederik Hendriklaan", "1814JM", "Alkmaar", 13, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Kerkstraat", "9641AR", "Veendam", 6, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Bloemberg", "7924PW", "Veeningen", 28, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Vivaldipad", "1323AJ", "Almere", 65, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Boven Zevenwouden", "3524CK", "Utrecht", 49, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Iepenlaan", "1406PS", "Bussum", 23, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Korhoensingel", "7681LE", "Vroomshoop", 3, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Hessenweg", "6718TD", "Ede", 70, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Begoniastraat", "4645CB", "Putte", 26, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Essendaal", "3181AD", "Rozenburg", 21, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Frederik Hendriklaan", "1814JM", "Alkmaar", 13, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Clematisstraat", "7591XE", "Denekamp", 110, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Adelaarstraat", "6971WJ", "Brummen", 43, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Schubertstraat", "1077GP", "Amsterdam", 19, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Dudokplein", "3315KH", "Dordrecht", 135, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Zuiderhavenweg", "4004JJ", "Tiel", 52, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Maerelaan", "1962KB", "Heemskerk", 19, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "De Ring", "9313TE", "Leutingewolde", 19, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Dorpsstraat", "9482PB", "Tynaarlo", 69, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "John Fitzgerald Kennedylaan", "9981KC", "Uithuizen", 56, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Jozef Israelslaan", "2282TP", "Rijswijk", 180, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Mantinghstraat", "7908AX", "Hoogeveen", 32, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Zilverschoonlaan", "3452AB", "Vleuten", 8, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Gelkingestraat", "9711JH", "Groningen", 24, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Korte Hartweg", "3762SJ", "Soest", 26, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Watermolen", "1035BV", "Amsterdam", 52, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Hunze", "3961JA", "Wijk Bij Duurstede", 1, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Bourgondieweg", "1611WG", "Bovenkarspel", 161, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Vechtstraat", "7071VC", "Ulft", 42, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Van Hessen Kasselstraat", "5051CE", "Goirle", 13, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Primulastraat", "1441HB", "Purmerend", 6, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Rembrandtstraat", "7141XN", "Groenlo", 20, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Glazenapplein", "5932TX", "Tegelen", 38, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Kuyperlaan", "1161XN", "Zwanenburg", 22, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Verzetslaan", "3705PN", "Zeist", 118, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Vincent van Goghlaan", "1741JR", "Schagen", 23, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Haagdoornstraat", "6841AJ", "Arnhem", 5, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Zeven Bosjes", "7609BL", "Almelo", 7, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Stavenissestraat", "3086RH", "Rotterdam", 44, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Julianastraat", "7031ZZ", "Wehl", 29, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "De Ring", "9313TE", "Leutingewolde", 19, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Meester Gilles van de Bempdenstraat", "1901AZ", "Castricum", 2, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Venrayseweg", "5961AH", "Horst", 54, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Klipper", "3891ZW", "Zeewolde", 14, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Zonnebloemstraat", "2014VV", "Haarlem", 15, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Via Regia", "6217JX", "Maastricht", 132, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Seinestraat", "5912LD", "Venlo", 18, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Verlengde Oosterdiep Oostzijde", "7884TG", "Barger-compascuum", 87, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Harry Hoekstraat", "2291SL", "Wateringen", 69, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Meerheide", "5521DZ", "Eersel", 15, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Wagenmaker", "2761MB", "Zevenhuizen", 51, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "De Mutsaet", "8252KR", "Dronten", 42, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Hoekerkade", "2725AG", "Zoetermeer", 79, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Ericaweg", "1251WL", "Laren", 40, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Vijverveld", "5541GR", "Reusel", 14, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Horst", "8225MX", "Lelystad", 61, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Sint Willibrordusstraat", "6039CA", "Stramproy", 18, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Baken", "9732BE", "Groningen", 105, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Fuchsiastraat", "1214GK", "Hilversum", 40, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "K. ter Laanstraat", "9621BV", "Slochteren", 12, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Rembrandtstraat", "7141XN", "Groenlo", 20, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Primulastraat", "1441HB", "Purmerend", 6, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Baai", "4871BA", "Etten-leur", 14, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Vivaldipad", "1323AJ", "Almere", 65, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Lingewei", "4004LK", "Tiel", 67, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Willibrordlaan", "7581DS", "Losser", 45, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Prinses Marijkestraat", "3314NR", "Dordrecht", 21, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Prins Clausstraat", "4455BG", "Nieuwdorp", 27, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Vicarislaan", "4901TB", "Oosterhout", 5, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Caan van Necklaan", "2281BC", "Rijswijk", 103, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Proost de Beaufortstraat", "6231EB", "Meerssen", 28, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Boeijerstraat", "1483TL", "De Rijp", 118, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Frederik Hendriklaan", "1814JM", "Alkmaar", 13, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Burgemeester Ramakersstraat", "6151GT", "Munstergeleen", 27, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Burgemeester Ramakersstraat", "6151GT", "Munstergeleen", 27, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);
        O = new Order("lucas", "Hoepmakerstraat", "2865XW", "Ammerstol", 33, "", false);
        OL = new OrderLine("e", 5, "Juicer");
        O.addOrderline(OL);
        orders.add(O);








        Adressen_GEO_Data_Extractor AdressenObject1 = new Adressen_GEO_Data_Extractor(orders);

         */


    }
}