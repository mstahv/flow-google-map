package org.vaadin.matti;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("")
@Theme(Lumo.class)
public class DemoView extends Div {

    public DemoView() {
        GoogleMap googleMap = new GoogleMap();

        GoogleMapMarker marker = new GoogleMapMarker();
        marker.setLatitude("62");
        marker.setLongitude("24");

        googleMap.addMarker(marker);
        add(googleMap);
    }
}
