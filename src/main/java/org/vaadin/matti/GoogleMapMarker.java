package org.vaadin.matti;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.shared.Registration;

@Tag("google-map-marker")
@HtmlImport("bower_components/google-map/google-map-marker.html")
public class GoogleMapMarker extends Component {

    public GoogleMapMarker() {
    }

    public void setLatitude(double lat) {
        getElement().setProperty("latitude", lat);
    }

    public void setLongitude(double lon) {
        getElement().setProperty("longitude", lon);
    }

    @Synchronize("google-map-marker-dragend")
    public double getLatitude() {
        String property = getElement().getProperty("latitude");
        return Double.valueOf(property);
    }

    @Synchronize("google-map-marker-dragend")
    public double getLongitude() {
        String property = getElement().getProperty("longitude");
        return Double.valueOf(property);
    }

    public void setDraggable(boolean draggable) {
        getElement().setProperty("draggable", draggable);
        // This custom property needs to be true to make events actually sent...
        getElement().setProperty("dragEvents", true);
    }

    public Registration addDragEndListener(ComponentEventListener<DragEndEvent> dragEndListener) {
        return super.addListener(DragEndEvent.class, dragEndListener);
    }

}
