package app;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import classes.GTFS;
import classes.Route;
//import classes.Stop_Times;
import java.io.FileNotFoundException;

/**
 *
 * @author roger.vargas
 */
public class Traffic {

    public static void main(String[] args) throws FileNotFoundException {
        GTFS gtfs = new GTFS();

        gtfs.loadAll("files");
        System.out.println("Origem: Av. Loureiro da Silva, 515-525 \nDestino: Rua Dormênio, 428");
        gtfs.getRoute(-30.037286, -51.236374, -30.077328, -51.230351).forEach((route) -> {
            System.out.println(route.getRoute_id() + " - " + route.getRoute_long_name());
        });
        
        System.out.println("\n\nOrigem: Av. Farrapos, 669\nDestino: Rua Guido Alberto Werlang, 65-141");
        gtfs.getRoute(-30.024047, -51.214008, -29.996677, -51.093261).forEach((route) -> {
            System.out.println(route.getRoute_id() + " - " + route.getRoute_long_name());
        });

        System.out.println("\n\nOrigem: Av. João Pessoa, 616-944\nDestino: Av. Bento Gonçalves, 2948");
        gtfs.getRoute(-30.038041, -51.218784, -30.063309, -51.185641).forEach((route) -> {
            System.out.println(route.getRoute_id() + " - " + route.getRoute_long_name());
        });
    }
}
