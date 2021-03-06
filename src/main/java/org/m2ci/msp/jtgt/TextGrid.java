package org.m2ci.msp.jtgt;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The textgrid container class
 *
 * @author <a href="mailto:slemaguer@coli.uni-saarland.de">Sébastien Le Maguer</a>
 */
public class TextGrid {
    /** The list of tiers composing the textgrid */
    private ArrayList<Tier> tiers;

    /** Start of the textgrid */
    private double start;

    /** End of the textgrid */
    private double end;

    /** The filename associated with the textgrid */
    @Deprecated
    private String filename;

    /*********************************************************************************************
     ** Constructors
     *********************************************************************************************/
    /**
     * Default constructor
     *
     */
    public TextGrid() {
        setTiers(new ArrayList<Tier>());
        setFilename(null);
    }

    /**
     * Constructor with a given filename
     *
     * @param filename the filename
     */
    public TextGrid(String filename) {
        setFilename(filename);
        setStart(-1);
        setEnd(-1);
        setTiers(new ArrayList<Tier>());
    }


    /**
     * Constructor with full informations without the tiers
     *
     * @param filename the filename
     * @param start the start time of the textgrid
     * @param end the end time of the textgrid
     * @deprecated use {@link #TextGrid(double, double)}
     */
    @Deprecated
    public TextGrid(String filename, double start, double end) {
        setFilename(filename);
        setStart(start);
        setEnd(end);
        setTiers(new ArrayList<Tier>());
    }

    /**
     * Constructor with full information without the tiers
     *
     * @param start the start time of the textgrid
     * @param end the end time of the textgrid
     */
    public TextGrid(double start, double end) {
        setStart(start);
        setEnd(end);
        setTiers(new ArrayList<Tier>());
    }

    /**
     * Constructor with full informations with the tiers
     *
     * @param filename the filename
     * @param start the start time of the textgrid
     * @param end the end time of the textgrid
     * @param tiers the tiers which are going to compose the textgrid
     * @deprecated use {@link #TextGrid(double, double, ArrayList)}
     */
    @Deprecated
    public TextGrid(String filename, double start, double end, ArrayList<Tier> tiers) {
        setFilename(filename);
        setStart(start);
        setEnd(end);
        setTiers(tiers);
    }

    /**
     * Constructor with full information with the tiers
     *
     * @param start the start time of the textgrid
     * @param end the end time of the textgrid
     * @param tiers the tiers which are going to comprise the textgrid
     */
    public TextGrid(double start, double end, ArrayList<Tier> tiers) {
        setStart(start);
        setEnd(end);
        setTiers(tiers);
    }

    /*********************************************************************************************
     ** Accessors
     *********************************************************************************************/
    /**
     * Getting the tiers
     *
     * @return the list of tiers
     */
    public ArrayList<Tier> getTiers() {
        return tiers;
    }

    /**
     * Getting the filename
     *
     * @return the filename
     * @deprecated TextGrids should not have a filename
     */
    @Deprecated
    public String getFilename() {
        return filename;
    }

    /**
     * Get the start time of the textgrid
     *
     * @return the start time of the textgrid
     */
    public double getStart() {
        return start;
    }

    /**
     * Get the end time of the textgrid
     *
     * @return the end time of the textgrid
     */
    public double getEnd() {
        return end;
    }

    /**
     * Associate the tiers to the textgrid
     *
     * @param tiers the tiers which will compose the textgrid
     */
    public void setTiers(ArrayList<Tier> tiers) {
        this.tiers = tiers;
    }

    /**
     * Define the filename
     *
     * @param filename the filename associated to the textgrid
     * @deprecated TextGrids should not have a filename
     */
    @Deprecated
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Set the start time of the textgrid
     *
     * @param start the start time of the textgrid
     */
    public void setStart(double start) {
        this.start = start;
    }

    /**
     * Set the end time of the textgrid
     *
     * @param end the end time of the textgrid
     */
    public void setEnd(double end) {
        this.end = end;
    }

    /*********************************************************************************************
     ** Insertion
     *********************************************************************************************/

    /**
     * Adding a tier at a specific position
     *
     * @param tier the tier to add
     * @param position the position to add the tier in
     */
    public void addTier(Tier tier, int position) {
        if (position < 0) {
            getTiers().add(tier);
        } else {
            getTiers().add(position, tier);
        }

    }

    /**
     * Adding the tier at the end of the tier list
     *
     * @param tier the tier to add
     */
    public void addTier(Tier tier) {
        getTiers().add(tier);
    }

    /**
     * Adding
     *
     * @param tiers the tier list
     */
    public void addTiers(ArrayList<Tier> tiers) {
        for (Tier tier : tiers) {
            addTier(tier);
        }
    }

    /*********************************************************************************************
     ** Deletion
     *********************************************************************************************/
    /**
     * Delete the tier knowing its name
     *
     * @param name the name of the tier
     */
    public void deleteTier(String name) {
        int pos = -1;
        int i = 0;
        while ((i < getTiers().size()) && (pos < 0)) {
            if (getTiers().get(i).getName().equals(name)) {
                pos = i;
            }

            i++;
        }

        if (pos >= 0) {
            deleteTier(pos);
        }
    }

    /**
     * Delete the tier given its position
     *
     * @param position the given position
     */
    public void deleteTier(int position) {
        getTiers().remove(position);
    }


    /**
     * Check if a given object is equal to the current textgrid
     *
     * @param o the given object
     * @return true if equality, false else
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof TextGrid)) {
            return false;
        }

        return ((getStart() == ((TextGrid) o).getStart()) &&
                (getEnd() == ((TextGrid) o).getEnd()) &&
                (((getFilename() == null) && (((TextGrid) o).getFilename() == null)) || getFilename().equals(((TextGrid) o).getFilename())) &&
                (getTiers().equals(((TextGrid) o).getTiers())));
    }

    public String toString() {
        String jsonStr = new ReflectionToStringBuilder(this, ToStringStyle.JSON_STYLE).toString();
        return new JSONObject(jsonStr).toString(4);
    }
}


/* TextGrid.java ends here */
