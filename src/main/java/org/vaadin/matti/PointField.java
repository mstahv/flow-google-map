/*
 * Copyright 2018 Matti Tahvonen.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.matti;

import com.vaadin.flow.component.HasValue;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

/**
 *
 * @author mstahv
 */
public class PointField extends GoogleMap implements HasValue<PointField, Point> {
    
    private GoogleMapMarker marker = new GoogleMapMarker();

    public PointField() {
        marker.setDraggable(true);
        addMarker(marker);
        marker.addDragEndListener(e-> {
            // workaround for bugs/limitations in Flow/google-map element
            setLatitude(marker.getLatitude());
            setLongitude(marker.getLongitude());
        });
    }

    @Override
    public void setValue(Point v) {
        if(v != null) {
            marker.setVisible(true);
            marker.setLatitude(v.getY());
            marker.setLongitude(v.getX());
            setLatitude(v.getY());
            setLongitude(v.getX());
        } else {
            marker.setVisible(false);
        }
    }

    GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 4326);

    @Override
    public Point getValue() {
        return factory.createPoint(new Coordinate(marker.getLongitude(), marker.getLatitude()));
    }

    @Override
    public String getClientValuePropertyName() {
        // how end users can find this? What if value change should happen on multiple events?
        // And actually, how to make the value change event happen on a property change event in the marker?
        return "longitude";
    }    
    
}
