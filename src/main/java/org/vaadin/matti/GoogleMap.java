package org.vaadin.matti;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("google-map")
@HtmlImport("frontend://bower_components/google-map/google-map.html")
public class GoogleMap extends Component {

    public GoogleMap() {
        getElement().setProperty("fitToMarkers", true);
        getElement().getStyle().set("width", "600px");
        getElement().getStyle().set("height", "300px");
    }

    public void addMarker(GoogleMapMarker marker) {
        getElement().appendChild(marker.getElement());
    }

    public void setLatitude(double lat) {
        getElement().setProperty("latitude", lat);
    }

    public void setLongitude(double lon) {
        getElement().setProperty("longitude", lon);
    }

}
