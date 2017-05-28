
public class Complexo
{
    private double a;
    private double b;
    
    public Complexo(double x, double y) {
        this.a=x;
        this.b=y;
    }
    
    public double getA() {
        return this.a;
    }
    
    public double getB() {
        return this.b;
    }
    
    public void setA(double a) {
        this.a=a;
    }
    
    public void setB(double b) {
        this.b=b;
    }
    
    public Complexo conjugado() {
        double a=this.a;
        double b=this.b;
        return new Complexo(a,-b);
    }
    
    public Complexo soma(Complexo complexo) {
        double a=this.a+complexo.getA();
        double b=this.b+complexo.getB();
        return new Complexo(a,b);
    }
    
    public Complexo produto(Complexo complexo) {
        double a=this.a*complexo.getA()-this.b*complexo.getB();
        double b=this.b*complexo.getA()+this.a*complexo.getB();
        return new Complexo(a,b);
    }
    
    public Complexo reciproco() {
        double a = this.a;
        double b = this.b;
        
        double na = a/(a*a+b*b);
        double nb = b/(a*a+b*b);
        
        return new Complexo (na,-nb);
    }
}

