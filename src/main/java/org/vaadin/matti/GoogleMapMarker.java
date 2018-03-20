package org.vaadin.matti;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("google-map-marker")
@HtmlImport("bower_components/google-map/google-map.html")
public class GoogleMapMarker extends Component {

    public GoogleMapMarker() {
    }

    public void setLatitude(String lat) {
        getElement().setProperty("latitude", lat);
    }

    public void setLongitude(String lon) {
        getElement().setProperty("longitude", lon);
    }
}
