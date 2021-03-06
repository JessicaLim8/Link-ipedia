package com.linkipedia;

import java.util.ArrayList;
import java.util.Comparator;

public class Node implements Comparable<Node> {
    int id;
    String title;
    ArrayList<String> categories;

    public Node(int id, String title) {
        this.id = id;
        this.title = title;
        this.categories = new ArrayList<String>();
    }

    public int id() {
        return id;
    }

    public String title() {
        return title;
    }

    public ArrayList<String> categories() {
        return categories;
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || this.getClass() != that.getClass()) {
            return false;
        }
        Node n = (Node) that;
        return this.id == n.id() && this.title.equals(n.title());
    }

    @Override
    public String toString() {
        return id + ", " + title;
    }

	@Override
	public int compareTo(Node that) {
		return this.title.compareTo(that.title());
	}

	public static class SubstringComparator implements Comparator<Node> {
		public int compare(Node a, Node b) {
			int alen = a.title().length();
            int blen = b.title().length();

            return alen < blen && a.title().equals(b.title().substring(0, alen)) ? 0 : a.compareTo(b);
		}
	}
}
