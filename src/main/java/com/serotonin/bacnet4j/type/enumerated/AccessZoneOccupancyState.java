/*
 * ============================================================================
 * GNU General Public License
 * ============================================================================
 *
 * Copyright (C) 2015 Infinite Automation Software. All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * When signing a commercial license with Infinite Automation Software,
 * the following extension to GPL is made. A special exception to the GPL is
 * included to allow you to distribute a combined work that includes BAcnet4J
 * without being obliged to provide the source code for any proprietary components.
 *
 * See www.infiniteautomation.com for commercial license options.
 *
 * @author Matthew Lohbihler
 */
package com.serotonin.bacnet4j.type.enumerated;

import com.serotonin.bacnet4j.exception.BACnetErrorException;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

import com.serotonin.bacnet4j.type.primitive.Enumerated;
import com.serotonin.bacnet4j.util.sero.ByteQueue;
import java.util.Collections;

public class AccessZoneOccupancyState extends Enumerated {
    public static final AccessZoneOccupancyState normal = new AccessZoneOccupancyState(0);
    public static final AccessZoneOccupancyState belowLowerLimit = new AccessZoneOccupancyState(1);
    public static final AccessZoneOccupancyState atLowerLimit = new AccessZoneOccupancyState(2);
    public static final AccessZoneOccupancyState atUpperLimit = new AccessZoneOccupancyState(3);
    public static final AccessZoneOccupancyState aboveUpperLimit = new AccessZoneOccupancyState(4);
    public static final AccessZoneOccupancyState disabled = new AccessZoneOccupancyState(5);
    public static final AccessZoneOccupancyState notSupported = new AccessZoneOccupancyState(6);

    private static final Map<Integer, Enumerated> idMap = new HashMap<>();
    private static final Map<String, Enumerated> nameMap = new HashMap<>();
    private static final Map<Integer, String> prettyMap = new HashMap<>();

    static {
        Enumerated.init(MethodHandles.lookup().lookupClass(), idMap, nameMap, prettyMap);
    }

    public static AccessZoneOccupancyState forId(final int id) {
        AccessZoneOccupancyState e = (AccessZoneOccupancyState) idMap.get(id);
        if (e == null)
            e = new AccessZoneOccupancyState(id);
        return e;
    }

    public static String nameForId(final int id) {
        return prettyMap.get(id);
    }

    public static AccessZoneOccupancyState forName(final String name) {
        return (AccessZoneOccupancyState) Enumerated.forName(nameMap, name);
    }

    public static int size() {
        return idMap.size();
    }

    private AccessZoneOccupancyState(final int value) {
        super(value);
    }

    public AccessZoneOccupancyState(final ByteQueue queue) throws BACnetErrorException {
        super(queue);
    }

    /**
     * Returns a unmodifiable map.
     *
     * @return unmodifiable map
     */
    public static Map<Integer, String> getPrettyMap() {
        return Collections.unmodifiableMap(prettyMap);
    }
    
     /**
     * Returns a unmodifiable nameMap.
     *
     * @return unmodifiable map
     */
    public static Map<String, Enumerated> getNameMap() {
        return Collections.unmodifiableMap(nameMap);
    }
    
    @Override
    public String toString() {
        return super.toString(prettyMap);
    }
}
