package org.vaadin.matti;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.dom.DomEvent;
import com.vaadin.flow.dom.DomEventListener;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import elemental.json.JsonObject;
import javax.sound.midi.SysexMessage;

@Route("")
@Theme(Lumo.class)
public class DemoView extends Div {

    public DemoView() {
        GoogleMap googleMap = new GoogleMap();

        GoogleMapMarker marker = new GoogleMapMarker();
        marker.setLatitude(62);
        marker.setLongitude(24);

        marker.setDraggable(true);
        
        marker.getElement().addEventListener("google-map-marker-dragend", new DomEventListener() {
            @Override
            public void handleEvent(DomEvent event) {
                JsonObject eventData = event.getEventData();
                System.err.println("Event data " + eventData);
            }
        });

        // Can't make this work for some reason
        // The data stored in the marker is kind of one step behisnd 
        marker.addDragEndListener(e -> {
            Notification.show("New position of marker: " + marker.getLatitude() + " " + marker.getLongitude(), 2000, Notification.Position.MIDDLE);
        });

        // Apparently fit-to-markers don't work with Flow for some reason so fix center of map too
        googleMap.setLatitude(62);
        googleMap.setLongitude(24);

        googleMap.addMarker(marker);
        add(googleMap);
        final Button button = new Button("Button");
        button.addClickListener(e -> Notification.show("Marker" + marker.getLatitude() + " " + marker.getLongitude(), 2000, Notification.Position.MIDDLE));
        add(button);

    }
}
