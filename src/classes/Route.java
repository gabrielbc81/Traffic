/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Roger
 */
public class Route {

    private String route_id;
    //private String agency_id;
    //private String route_short_name;
    private String route_long_name;
    //private String route_desc;
    //private String route_type;
    //private String route_url;
    //private String route_color;
    //private String route_text_color;

    public Route(String route_id, String route_long_name) {
        this.route_id = route_id;
        this.route_long_name = route_long_name;
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public String getRoute_long_name() {
        return route_long_name;
    }

    public void setRoute_long_name(String route_long_name) {
        this.route_long_name = route_long_name;
    }
}
