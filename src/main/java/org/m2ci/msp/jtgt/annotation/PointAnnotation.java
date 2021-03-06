package org.m2ci.msp.jtgt.annotation;

import org.m2ci.msp.jtgt.Annotation;

/**
 * Point annotation wrapper class
 *
 * @author <a href="mailto:slemaguer@coli.uni-saarland.de">Sébastien Le Maguer</a>
 */
public class PointAnnotation extends Annotation {
    /**
     * Constructor of a point annotation
     *
     * @param time the time of the annotation
     * @param text the annotation label
     */
    public PointAnnotation(double time, String text) {
        super(time, time, text);
    }

    public double getTime() {
        return getStart();
    }

    public void setStart() {
        throw new UnsupportedOperationException("You shall use setTime for a PointAnnotation");
    }


    public void setEnd() {
        throw new UnsupportedOperationException("You shall use setTime for a PointAnnotation");
    }

    public void setTime(double time) {
        super.setStart(time);
        super.setEnd(time);
    }


    /**
     * Check if a given object is equal to the current annotation
     *
     * @param o the given object
     * @return true if equality, false else
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof PointAnnotation)) {
            return false;
        }

        return super.equals(o);
    }
}


/* Pointannotation.java ends here */
