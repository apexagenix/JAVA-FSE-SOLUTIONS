public class Fin
{
    public static double forecastValue(double p, double r, int t) 
    {
        if (t == 0)
            return p;
        return forecastValue(p, r, t - 1) * (1 + r);
    }
    public static void main(String[] args) 
    {
        double p = 10000;
        double r = 0.08;
        int t = 5;
        double a = forecastValue(p,r,t);
        System.out.printf("Future Value after "+t+" years: "+a);
    }
}
