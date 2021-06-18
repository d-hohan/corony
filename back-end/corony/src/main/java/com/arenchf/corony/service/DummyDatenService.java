package com.arenchf.corony.service;

import com.arenchf.corony.domain.*;
import com.arenchf.corony.repo.AmtRepo;
import com.arenchf.corony.repo.RegelungRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;


//imports?
//muss eine instanz von jeder klasse erstellt werden?
//Variablen in schleifen
//wo ist der index bei beim erzeugen der Inserts

@Service
public class DummyDatenService {

    private final AmtService amtService;
    private final RegelungService regelungService;
    private final BundeslandService bundeslandService;
    private final OrtService ortService;
    private final LaborService laborService;
    private final HaushaltService haushaltService;
    private final PersonService personService;
    private final TestService testService;
    private final KontaktService kontaktService;
    private final RegelungRepo regelungRepo;
    private final AmtRepo amtRepo;
    private final EntityManager entityManager;


    public DummyDatenService(AmtService amtService, BundeslandService bundeslandService, RegelungService regelungService, OrtService ortService, LaborService laborService, HaushaltService haushaltService, PersonService personService, TestService testService, KontaktService kontaktService, RegelungRepo regelungRepo, AmtRepo amtRepo, EntityManager entityManager) {
        this.amtService = amtService;
        this.bundeslandService = bundeslandService;
        this.regelungService = regelungService;
        this.ortService = ortService;
        this.laborService = laborService;
        this.haushaltService = haushaltService;
        this.personService = personService;
        this.testService = testService;
        this.kontaktService = kontaktService;
        this.regelungRepo = regelungRepo;
        this.amtRepo = amtRepo;
        this.entityManager = entityManager;
    }


    final String[] b_land_namen = {"Baden-Wuerttemberg", "Bayern", "Berlin", "Brandenburg", "Bremen", "Hamburg", "Hessen", "Mecklenburg-Vorpommern", "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz", "Saarland", "Sachsen", "Sachsen-Anhalt", "Schleswig-Holstein", "Thueringen", };
    final Integer[] b_land_einwohner = {11100394, 13124737, 3669491, 2521893, 681202, 1847253, 6288080, 1608138, 7993608, 17947221, 4093903, 986887, 4071971, 2194782, 2903773, 2133378};
    final Integer[] b_land_qkm = {35751, 70550, 892, 29654, 419, 755, 21115, 23213, 47616, 34113, 19854, 2569, 18450, 20452, 15802, 16202};

    final Integer[] ort_zu_b_land = {1, 1, 2, 2, 3, 4, 4, 5, 6, 7, 7, 8, 8, 9, 9, 10, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16};
    final String[] ort_namen = {"Stuttgart", "Karlsruhe", "Muenchen", "Nuernberg", "Berlin", "Potsdam", "Cottbus", "Bremen", "Hamburg", "Wiesbaden", "Frankfurt am Main", "Schwerin", "Rostock", "Hannover", "Braunschweig", "Duesseldorf", "Koeln", "Dortmund", "Mainz", "Ludwigshafen am Rhein", "Saarbruecken", "Neunkirchen", "Dresden", "Leipzig", "Magdeburg", "Halle", "Kiel", "Luebeck", "Erfurt", "Jena"};
    final Integer[] ort_einwohner = {635911, 312060, 1484226, 518370, 3669491, 180334, 99678, 567559, 1847253, 278474, 763380, 95653, 209191, 536925, 249406, 621877, 1087863, 588250, 218578, 172253, 180374, 46767, 556780, 593145, 237565, 238762, 246794, 216530, 213981, 111343};
    final Integer[] ort_qkm = {207, 173, 311, 186, 891, 188, 166, 318, 755, 204, 248, 131, 181, 204, 193, 217, 405, 281, 98, 77, 168, 75, 328, 298, 201, 135, 119, 214, 270, 115};

    final String[] nachnamen = {"Müller", "Schmidt", "Schneider", "Fischer", "Meyer", "Weber", "Wagner", "Becker", "Schulz", "Hoffmann", "Schäfer", "Koch", "Bauer", "Richter", "Klein", "Schröder", "Wolf", "Neumann", "Schwarz", "Zimmermann", "Krüger", "Braun", "Hofmann", "Schmitz", "Hartmann", "Lange", "Schmitt", "Werner", "Krause", "Meier", "Schmid", "Lehmann", "Schulze", "Maier", "Köhler", "Herrmann", "Walter", "Körtig", "Mayer", "Huber", "Kaiser", "Fuchs", "Peters", "Möller", "Scholz", "Lang", "Weiss", "Jung", "Hahn", "Vogel", "Friedrich", "Günther", "Keller", "Schubert", "Berger", "Frank", "Roth", "Beck", "Winkler", "Lorenz", "Baumann", "Albrecht", "Ludwig", "Franke", "Simon", "Böhm", "Schuster", "Schumacher", "Kraus", "Winter", "Otto", "Krämer", "Stein", "Vogt", "Martin", "Jäger", "Gross", "Sommer", "Brandt", "Haas", "Heinrich", "Seidel", "Schreiber", "Schulte", "Graf", "Dietrich", "Ziegler", "Engel", "Kühn", "Kuhn", "Pohl", "Horn", "Thomas", "Busch", "Wolff", "Sauer", "Bergmann", "Pfeiffer", "Voigt", "Ernst"};
    final String[] vornamen = {"Sabine", "Susanne", "Petra", "Monika", "Claudia", "Birgit", "Andrea", "Stefanie", "Karin", "Katrin", "Julia", "Anna", "Nicole", "Anja", "Gabriele", "Angelika", "Martina", "Brigitte", "Heike", "Sandra", "Renate", "Barbara", "Christina", "Katharina", "Christine", "Kerstin", "Ursula", "Maria", "Ute", "Sarah", "Marion", "Silvia", "Melanie", "Ulrike", "Bettina", "Jutta", "Silke", "Tanja", "Christiane", "Elke", "Nadine", "Ingrid", "Daniela", "Angela", "Jennifer", "Anke", "Cornelia", "Nina", "Sonja", "Katja", "Michael", "Thomas", "Andreas", "Peter", "Stefan", "Christian", "Hans", "Klaus", "Jan", "Wolfgang", "Frank", "Matthias", "Jürgen", "Alexander", "Martin", "Bernd", "Markus", "Thorstenn", "Uwe", "Jens", "Jörg", "Ralf", "Sven", "Daniel", "Sebastian", "Rainer", "Manfred", "Oliver", "Holger", "Dirk", "Tobias", "Philipp", "Carsten", "Florian", "Dieter", "Christoph", "Dennis", "Joachim", "Patrick", "Marc", "Carl", "Andre", "Marco", "Tim", "Kai", "Marcel", "Robert", "Werner", "Lars", "Rolf"};
    final String[] stassennamen = {"Hauptstrasse", "Schulstrasse", "Gartenstrasse", "Bahnhofstrasse", "Dorfstrasse", "Bergstrasse", "Birkenweg", "Lindenstrasse", "Kirchstrasse", "Waldstrasse", "Ringstrasse", "Schillerstrasse", "Amselweg", "Goethestrasse", "Wiesenweg", "Buchenweg", "Jahnstrasse", "Wiesenstrasse", "Ahornweg", "Finkenweg", "Eichenweg", "Am Sportplatz", "Feldstrasse", "Mühlenweg", "Rosenstrasse", "Erlenweg", "Friedhofstrasse", "Blumenstrasse", "Lindenweg", "Tannenweg", "Brunnenstrasse", "Kirchweg", "Bachstrasse", "Raiffeisenstrasse", "Mozartstrasse", "Rosenweg", "Lerchenweg", "Drosselweg", "Mühlenstrasse", "Talstrasse", "Gartenweg", "Industriestrasse", "Mittelstrasse", "Beethovenstrasse", "Poststrasse", "Waldweg", "Kirchplatz", "Meisenweg", "Fliederweg", "Kirchgasse", "Am Bahnhof", "Breslauer Strasse", "Lessingstrasse", "Schlossstrasse", "Kiefernweg", "Fasanenweg", "Burgstrasse", "Neue Strasse", "Birkenstrasse", "Uhlandstrasse", "Kastanienweg", "Königsberger Strasse", "Tulpenweg", "Schulweg", "Im Winkel", "Mühlweg", "Marktplatz", "Parkstrasse", "Danziger Strasse", "Grüner Weg", "Kapellenweg", "Schützenstrasse", "Berliner Strasse", "Mittelweg", "Römerstrasse", "Eschenweg", "Heideweg", "Nelkenweg", "Fichtenweg", "Am Anger", "Ulmenweg", "Stettiner Strasse", "Wilhelmstrasse", "Lärchenweg", "Sonnenstrasse", "Schubertstrasse", "Friedrichstrasse", "Eichendorffstrasse", "Am Hang", "Sudetenstrasse", "Marienstrasse", "Friedhofsweg", "Marktstrasse", "Kurze Strasse", "Brückenstrasse", "Eichenstrasse", "Schwalbenweg", "Ginsterweg", "Neuer Weg", "Lange Strasse"};
    final String[] test_arten = {"PCR-Test", "Antigen-Schnelltest", "Antikörpertest", "Gurgeltest", "Lolli-Test"};

    private List<Amt> amtList = new ArrayList<>();
    private List<Bundesland> bundeslandList = new ArrayList<>();
    private List<Regelung> regelungList = new ArrayList<>();
    private List<Ort> ortList = new ArrayList<>();
    private List<Labor> laborList = new ArrayList<>();
    private List<Haushalt> haushaltList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    private List<Kontakt> kontaktList = new ArrayList<>();
    private List<Test> testList = new ArrayList<>();

    public void erzeugen() {

        for(int i = 0; i < 30; i++) {
            //Erzeugen des Amtes
            Amt a1 = amtService.addAmt("Gesundheitsamt "+ ort_namen[i], "keine");
            amtList.add(a1);

            //Erzeugen der Regelung
            Regelung r1 = regelungService.addRegelung(a1.getId(), "Regelungstext", System.currentTimeMillis() - (86400000 * (int)(Math.random()*(100-3+1)+3)), System.currentTimeMillis());
            regelungList.add(r1);

        }

        //Erzeugen der Bundeslaender
        for(int b = 0; b < 16; b++) {
            Bundesland b1 = bundeslandService.addBundesland(b_land_namen[b], regelungList.get(b).getId(), b_land_einwohner[b], b_land_qkm[b]);
            bundeslandList.add(b1);
        }

        int haushalts_index = 0;
        int personen_index = 0;

        for(int i = 0; i < 30; i++) {

            //Erzeugen des Ortes
            Ort o1 = ortService.addOrt(ort_namen[i], regelungList.get(i).getId(), bundeslandList.get(ort_zu_b_land[i] - 1).getId(), ort_einwohner[i], ort_qkm[i]);
            ortList.add(o1);

            //Erzeugen der Labore
            Labor l1 = laborService.addLabor(o1.getId());
            laborList.add(l1);


            //Erzeugen der Haushalte mit ihren jeweiligen Personen


            //haushalt 1 - 4 (jeweils 1 Person)
            for (int hp = 0; hp < 4; hp++) {

                Haushalt h1 = haushaltService.addHaushalt(amtList.get(i).getId(), ortList.get(i).getId(), stassennamen[(int)(Math.random()*(99-0+1)+0)] + " " + (int)(Math.random()*(150-1+1)+1), (long) (Math.random()*(199899856-122011020+1)+122011020));
                haushaltList.add(h1);

                Person p1 = personService.addPerson(h1.getId(), regelungList.get(i).getId(), nachnamen[(int)(Math.random()*(99-0+1)+0)], vornamen[(int)(Math.random()*(99-0+1)+0)], (long)(Math.random()*(1451602800000L-(-1262307600000L)+1)+(-1262307600000L)), null, (long)(Math.random()*(199899856-122011020+1)+122011020));
                personList.add(p1);

                haushalts_index++;
                personen_index++;
            }

            //haushalt 5 (2 Personen)
            Haushalt h2 = haushaltService.addHaushalt(amtList.get(i).getId(), ortList.get(i).getId(), stassennamen[(int)(Math.random()*(99-0+1)+0)] + " " + (int)(Math.random()*(150-1+1)+1), (long) (Math.random()*(199899856-122011020+1)+122011020));
            haushaltList.add(h2);
            for (int h = 0; h < 2; h++) {
                Person p2 = personService.addPerson(h2.getId(), regelungList.get(i).getId(), nachnamen[(int)(Math.random()*(99-0+1)+0)], vornamen[(int)(Math.random()*(99-0+1)+0)], (long)(Math.random()*(1451602800000L-(-1262307600000L)+1)+(-1262307600000L)), null, (long)(Math.random()*(199899856-122011020+1)+122011020));
                personList.add(p2);

                personen_index++;
            }
            haushalts_index++;

            //haushalt 6-7 (jeweils 3 Personen)
            for (int h = 0; h < 2; h++) {
                Haushalt h3 = haushaltService.addHaushalt(amtList.get(i).getId(), ortList.get(i).getId(), stassennamen[(int)(Math.random()*(99-0+1)+0)] + " " + (int)(Math.random()*(150-1+1)+1), (long) (Math.random()*(199899856-122011020+1)+122011020));
                haushaltList.add(h3);
                for (int p = 0; p < 3; p++) {
                    Person p3 = personService.addPerson(h3.getId(), regelungList.get(i).getId(), nachnamen[(int)(Math.random()*(99-0+1)+0)], vornamen[(int)(Math.random()*(99-0+1)+0)], (long)(Math.random()*(1451602800000L-(-1262307600000L)+1)+(-1262307600000L)), null, (long)(Math.random()*(199899856-122011020+1)+122011020));
                    personList.add(p3);

                    personen_index++;
                }
                haushalts_index++;
            }

            //haushalt 8-9 (jeweils 4 Personen)
            for (int h = 0; h < 2; h++) {
                Haushalt h4 = haushaltService.addHaushalt(amtList.get(i).getId(), ortList.get(i).getId(), stassennamen[(int)(Math.random()*(99-0+1)+0)] + " " + (int)(Math.random()*(150-1+1)+1), (long) (Math.random()*(199899856-122011020+1)+122011020));
                haushaltList.add(h4);
                for (int p = 0; p < 4; p++) {
                    Person p4 = personService.addPerson(h4.getId(), regelungList.get(i).getId(), nachnamen[(int)(Math.random()*(99-0+1)+0)], vornamen[(int)(Math.random()*(99-0+1)+0)], (long)(Math.random()*(1451602800000L-(-1262307600000L)+1)+(-1262307600000L)), null, (long)(Math.random()*(199899856-122011020+1)+122011020));
                    personList.add(p4);
                    personen_index++;
                }
                haushalts_index++;
            }

            //haushalt 10 (5 Person)
            Haushalt h5 = haushaltService.addHaushalt(amtList.get(i).getId(), ortList.get(i).getId(), stassennamen[(int)(Math.random()*(99-0+1)+0)] + " " + (int)(Math.random()*(150-1+1)+1), (long) (Math.random()*(199899856-122011020+1)+122011020));
            haushaltList.add(h5);
            for (int h = 0; h < 5; h++) {
                Person p5 = personService.addPerson(h5.getId(), regelungList.get(i).getId(), nachnamen[(int)(Math.random()*(99-0+1)+0)], vornamen[(int)(Math.random()*(99-0+1)+0)], (long)(Math.random()*(1451602800000L-(-1262307600000L)+1)+(-1262307600000L)), null, (long)(Math.random()*(199899856-122011020+1)+122011020));
                personList.add(p5);

                personen_index++;
            }
            haushalts_index++;
        }

        int kontakt_index = 0;
        int test_index = 0;

        for (int i = 0; i < 750; i++){

            for (int k = 0; k < (int)(Math.random()*(40-1+1)+1); k++){

                int randomizer;
                do {
                    randomizer = (int)(Math.random()*(749-0+1)+0);
                }while (randomizer == k);

                Kontakt k1 = kontaktService.addKontakt(personList.get(i).getId(), personList.get(randomizer).getId(), System.currentTimeMillis() - (86400000 * (int)(Math.random()*(150-1+1)+1)));
                kontaktList.add(k1);
                kontakt_index++;
            }

            for (int t = 0; t < (int)(Math.random()*(8-0+1)+0); t++){
                Test t1 = testService.addTest(laborList.get((int)(Math.random()*(29-0+1)+0)).getId(), System.currentTimeMillis() - (86400000 * (int)(Math.random()*(63-1+1)+1)), personList.get(i).getId(), getRandomBoolean(), test_arten[(int)(Math.random()*(4-0+1)+0)]);
                testList.add(t1);
                test_index++;
            }

        }

    }

    private Boolean getRandomBoolean(){
        return Math.random() < 0.5;
    }

}
