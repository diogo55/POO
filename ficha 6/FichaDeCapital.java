
public class FichaDeCapital
{

    private String nome;
    private double populacao;
    private int nveiculos;
    private double msalario;
    private double mcustovida;
    
    public FichaDeCapital() {
    this.nome="";
    this.populacao=0;
    this.nveiculos=0;
    this.msalario=0;
    this.mcustovida=0;
    }
    
    public FichaDeCapital(FichaDeCapital f) {
    this.nome=f.getNome();
    this.populacao=f.getPopulacao();
    this.nveiculos=f.getNVeiculos();
    this.msalario=f.getMSalario();
    this.mcustovida=f.getMCustovida();
    }
    
    public FichaDeCapital(String n,double p,int nv,double ms, double mv) {
    this.nome=n;
    this.populacao=p;
    this.nveiculos=nv;
    this.msalario=ms;
    this.mcustovida=mv; 
    }
    
    public String getNome() {return this.nome;}
    public double getPopulacao() {return this.populacao;}
    public int getNVeiculos() {return this.nveiculos;}
    public double getMSalario() {return this.msalario;}
    public double getMCustovida() {return this.mcustovida;}
    
    public void setNome(String n) {this.nome=n;}
    public void setPopulacao(double p) {this.populacao=p;}
    public void setNVeiculos(int nv) {this.nveiculos=nv;}
    public void setMSalario(double m) {this.msalario=m;}
    public void setMCustovida(double m) {this.mcustovida=m;}
    
    public FichaDeCapital clone() {
    return new FichaDeCapital(this);
}
    
    public boolean equals(Object o) {
    if (this==o) return true;
    if (o==null || this.getClass() != o.getClass()) return false;
    FichaDeCapital f = (FichaDeCapital) o;
    return f.getNome().equals(nome) &&
           f.getPopulacao() == populacao &&
           f.getNVeiculos() == nveiculos &&
           f.getMSalario() == msalario &&
           f.getMCustovida() == mcustovida;
    }
}
