package airlines;

import java.util.*;

public class Airport implements Comparable<Airport> {
	private String name;
	private int x;
	private int y;
	private Set<Airport> connections; // all airports with a direct route to/from this airport

	public Airport(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		connections = new TreeSet<>();
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public List<Airport> getConnections() {
		return new ArrayList<>(connections);
	}

	// Adds that airport to the list of connections. This is a one-way route, so
	// don’t add this airport to that’s list of connections.
	public void connectTo(Airport that) {
		connections.add(that);
	}

	//
	// Does nothing if this airport is not connected to that.
	//
	public void disconnectFrom(Airport that) {
		if (connections.contains(that)) {
			connections.remove(that);
		} else {
			return;
		}
	}

	// Use best practice.
	public boolean equals(Object x) {
		// cast Object x into Airport
		Airport newX = (Airport) x;
		/*
		 * if(this.getName().equals(newX.getName()) && this.getX() == newX.getX() &&
		 * this.getY() == newX.getY() &&
		 * this.getConnections().equals(newX.getConnections())) { return true; }
		 */

		if (this.compareTo(newX) == 0) {
			return true;
		} else {
			return false;
		}
	}

	// Just compare by airport name.
	public int compareTo(Airport that) {
		return this.getName().compareTo(that.getName());
	}

	public boolean isConnectedTo(Airport that) {
		if (connections.contains(that)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "Airport " + name + " @(" + x + "," + y + ")";
	}
}
