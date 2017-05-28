
public class Lugar
{
    private String matricula;
    private String nome;
    private int minutos;
    private boolean permanente;
    
    public Lugar() {
        this.matricula="";
        this.nome="";
        this.minutos=0;
        this.permanente=false;
    }
    
    public Lugar(String m, String n, int min, boolean p) {
        this.matricula=m;
        this.nome=n;
        this.minutos=min;
        this.permanente=p;
    }
    
    public Lugar(Lugar l) {
        this.matricula=l.getMat();
        this.nome=l.getNome();
        this.minutos=l.getMin();
        this.permanente=l.getPerm();
    }
    
    public String getMat(){return this.matricula;}
    public String getNome(){return this.nome;}
    public int getMin() {return this.minutos;}
    public boolean getPerm() {return this.permanente;}
    
    public void setMat(String m){this.matricula=m;}
    public void setNome(String n){this.nome=n;}
    public void setMin(int m) {this.minutos=m;}
    public void setPerm(boolean p) {this.permanente=p;}
    
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || o.getClass() != this.getClass()) return false;
        else{
            Lugar l = (Lugar) o;
            return (l.getMat().equals(matricula) &&
                    l.getNome().equals(nome) &&
                    l.getMin()==minutos &&
                    l.getPerm()==permanente);
        }
    }
    
    
    public Lugar clone(){
        return new Lugar(this);
    }
}
