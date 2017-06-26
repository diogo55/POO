
/**
 * Write a description of class Pais here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FichaPais
{
   private String nome;
   private String continente;
   private double pop; //em milhoes
   
   public FichaPais() {
    this.nome="";
    this.continente="";
    this.pop=0;
    }
    
   public FichaPais(String n,String c, double p) {
       this.nome=n;
       this.continente=c;
       this.pop=p;
    }
    
   public FichaPais(FichaPais p) {
    this.nome=p.getNome();
    this.continente=p.getCont();
    this.pop=p.getPop();
}

    public String getNome() {return this.nome;}
    public String getCont() {return this.continente;}
    public double getPop() {return this.pop;}
    
    public void setNome(String n) {this.nome=n;}
    public void setCont(String c) {this.continente=c;}
    public void setPop(double p) {this.pop=p;}
    
    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null || this.getClass()!=o.getClass()) return false;
        FichaPais p = (FichaPais) o;
        return this.nome.equals(p.getNome()) &&
               this.continente.equals(p.getCont()) &&
               this.pop == p.getPop();
            }
     
    public FichaPais clone() {
        return new FichaPais(this);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Continente: ").append(continente).append("\n");
        sb.append("População: ").append(pop).append("milhoes \n");
        return sb.toString();
    }
}
