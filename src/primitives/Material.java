package primitives;

/**
 * @author Mikhal Levi & Eliana Grajower
 */
public class Material {
    public Double3 kD = Double3.ZERO;
    public Double3 kS = Double3.ZERO;
    public int nShininess = 0;
    public Double3 kT=Double3.ZERO;//transparency
    public Double3 kR=Double3.ZERO;
    /**
     * setter for kd using double
     * @param kd
     * @return material
     */
    public Material setKD(double kd) {
        this.kD = new Double3(kd);
        return this;
    }

    /**
     * setter for kd using Double3
     * @param kd
     * @return material
     */
    public Material setKD(Double3 kd) {
        this.kD = kd;
        return this;
    }

    /**
     * setter for ks using double
     * @param ks
     * @return material
     */
    public Material setkS(double ks) {
        this.kS = new Double3(ks);
        return this;
    }

    /**
     * setter for ks using Double3
     * @param ks
     * @return material
     */
    public Material setkS(Double3 ks) {
        this.kS = ks;
        return this;
    }

    /**
     * setter for shininess
     * @param shininess
     * @return material
     */
    public Material setnShininess(int shininess) {
        this.nShininess = shininess;
        return this;
    }

    public Double3 getkS() {
        return kS;
    }

    public int getnShininess() {
        return nShininess;
    }
}
