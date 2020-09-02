public class Correlation {
    double[] x, y;
    double meanX, meanY;

    public Correlation(double[] x, double[] y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculate mean of a double array
     * @param z the array to be calculated
     * @return the mean
     */
    public double mean(double[] z)
    {
        double sum = 0;
        for (int i = 0; i < z.length; i++)
            sum += z[i];

        return sum / z.length;
    }

    public double standardDeviation(double[] z, double meanZ)
    {
        double sum = 0;
        for (int i = 0; i < z.length; i++)
            sum += (z[i] - meanZ) * (z[i] - meanZ);

        return Math.sqrt(sum);
    }

    public double getPearsonCorrelationCoefficient()
    {
        meanX = mean(x);
        meanY = mean(y);

        double cov = getCovariance();
        double stddevX = standardDeviation(x, meanX);
        double stddevY = standardDeviation(y, meanY);
        return cov / (stddevX * stddevY);
    }

    private double getCovariance()
    {
        double covariance = 0;
        for (int i = 0; i < x.length; i++)
            covariance += (x[i] - meanX) * (y[i] - meanY);

        return covariance;
    }

    public static void main(String[] argv)
    {
        Correlation correlation = new Correlation(
                new double[] {50,34,41,42,28,20,36,29,38,52,40,66},
                // new double[] {25.8,25.8,23.8,20.2,16.6,14.0,13.4,14.9,17.2,19.6,21.8,24.1},
                new double[] {74,53,62,58,42,41,47,43,57,74,74,101}
        );
        double r = correlation.getPearsonCorrelationCoefficient();

        System.out.println("r = " + r);
    }
}
