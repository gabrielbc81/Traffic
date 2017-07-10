/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import util.ReadFile;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roger
 */
public class GTFS {

    private final List<Route> routes = new ArrayList<Route>();
    private final List<Stop> stops = new ArrayList<Stop>();
    private final List<Stop_Time> stop_times = new ArrayList<Stop_Time>();
    private final List<Trip> trips = new ArrayList<Trip>();

    public void loadAll(String filePath) throws FileNotFoundException {
        this.loadRoutes(filePath);
        this.loadStop_Times(filePath);
        this.loadStops(filePath);
        this.loadTrips(filePath);
    }

    public void loadRoutes(String filePath)
            throws FileNotFoundException {
        String route_id;
        String route_long_name;
        System.out.println("Carregando Routes");
        long ini = System.currentTimeMillis();
        ReadFile read = new ReadFile(filePath + "/routes.txt", ",");
        read.hasNext(); // passando pela primeira linha que é o cabeçalho
        while (read.hasNext()) {
            route_id = read.next();
            read.skipNext(2);
            route_long_name = read.next();
            read.skipNext(5);
            routes.add(new Route(
                    route_id,
                    route_long_name
            ));
        }
        long end = System.currentTimeMillis();
        System.out.println("Tempo = " + ((end - ini) / 1000.0) + "\n");
    }

    public void loadTrips(String filePath)
            throws FileNotFoundException {
        String route_id;
        String trip_id;
        System.out.println("Carregando Trip.");
        long ini = System.currentTimeMillis();

        ReadFile read = new ReadFile(filePath + "/trips.txt", ",");
        read.hasNext(); // passando pela primeira linha que é o cabeçalho
        while (read.hasNext()) {
            route_id = read.next();
            read.skipNext(1);
            trip_id = read.next();
            read.skipNext(7);
            trips.add(new Trip(
                    route_id,
                    trip_id
            ));
        }
        long end = System.currentTimeMillis();
        System.out.println("Tempo = " + ((end - ini) / 1000.0) + "\n");
    }

    public void loadStops(String filePath)
            throws FileNotFoundException {
        String stop_id;
        double stop_lat;
        double stop_lon;

        System.out.println("Carregando Stops.");
        long ini = System.currentTimeMillis();
        ReadFile read = new ReadFile(filePath + "/stops.txt", ",");
        read.hasNext(); // passando pela primeira linha que é o cabeçalho
        while (read.hasNext()) {
            stop_id = read.next();
            read.skipNext(3);
            stop_lat = read.nextDouble();
            stop_lon = read.nextDouble();
            stops.add(new Stop(
                    stop_id,
                    stop_lat,
                    stop_lon
            ));
        }
        long end = System.currentTimeMillis();
        System.out.println("Tempo = " + ((end - ini) / 1000.0) + "\n");
    }

    public void loadStop_Times(String filePath)
            throws FileNotFoundException {
        System.out.println("Carregando Stop_Times.");
        long ini = System.currentTimeMillis();
        String trip_id;
        String stop_id;
        String stop_sequence;
        ReadFile read = new ReadFile(filePath + "/stop_times.txt", ",");
        read.hasNext(); // passando pela primeira linha que é o cabeçalho
        while (read.hasNext()) {
            trip_id = read.next();
            read.skipNext(2);
            stop_id = read.next();
            stop_sequence = read.next();

            stop_times.add(new Stop_Time(
                    trip_id,
                    stop_id,
                    stop_sequence
            ));
        }
        long end = System.currentTimeMillis();
        System.out.println("Tempo = " + ((end - ini) / 1000.0) + "\n");
    }

    public List<Route> getRoutesByStop(String stop_id) {
        List<Route> lstReturn = new ArrayList<Route>();
        stop_times.stream().filter((stop_time) -> (stop_time.getStop_id().equals(stop_id))).forEachOrdered((stop_time) -> {
            trips.stream().filter((trip) -> (trip.getTrip_id().equals(stop_time.getTrip_id()))).forEachOrdered((trip) -> {
                routes.stream().filter((route) -> (route.getRoute_id().equals(trip.getRoute_id()))).forEachOrdered((route) -> {
                    if (!lstReturn.stream().anyMatch((_route) -> (_route.getRoute_id().equals(route.getRoute_id())))) {
                        lstReturn.add(route);
                    }
                });
            });
        });

        return lstReturn;
    }

    public List<Route> getRoutesByCoordinate(double lat, double lon) {
        List<Route> lstReturn = new ArrayList<Route>();

        stops.stream().filter((stop) -> (stop.getStop_lat() == lat & stop.getStop_lon() == lon)).forEachOrdered((stop) -> {
            stop_times.stream().filter((stop_time) -> (stop_time.getStop_id().equals(stop.getStop_id()))).forEachOrdered((stop_time) -> {
                trips.stream().filter((trip) -> (trip.getTrip_id().equals(stop_time.getTrip_id()))).forEachOrdered((trip) -> {
                    routes.stream().filter((route) -> (route.getRoute_id().equals(trip.getRoute_id()))).forEachOrdered((route) -> {
                        if (!lstReturn.stream().anyMatch((_route) -> (_route.getRoute_id().equals(route.getRoute_id())))) {
                            lstReturn.add(route);
                        }
                    });
                });
            });
        });

        return lstReturn;
    }
    
    public List<Route> getRoute(double latOrigem, double lonOrigem, double latDestino, double lonDestino){
        List<Route> result = new ArrayList<Route>();
        
        List<Route> routeOrigem = getRoutesByCoordinate(latOrigem, lonOrigem);
        List<Route> routeDestino = getRoutesByCoordinate(latDestino, lonDestino);
        
        for (Route routeO : routeOrigem){
            for (Route routeD : routeDestino){
                if (routeO.equals(routeD)){
                    result.add(routeO);
                }
            }
        }
        
        return result;
    }
}
