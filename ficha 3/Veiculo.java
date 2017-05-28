
public class Veiculo
{
   private String matricula;
   private double kmstotal;
   private double kmsparcial;
   private int cap;
   private int cont;
   private double consMedio;
   
   public Veiculo(String matricula, double kmsTotal, double
kmsParcial, double consumoMedio, int capacidade, int conteudo) {
    this.matricula=matricula;
    this.kmstotal=kmsTotal;
    this.kmsparcial=kmsParcial;
    this.consMedio=consumoMedio;
    this.cap=capacidade;
    this.cont=conteudo;
}

    public Veiculo (){
        this.matricula = "";
        this.kmstotal = 0.0;
        this.kmsparcial = 0.0;
        this.consMedio = 0.0;
        this.cap = 0;
        this.cont = 0;
    }
    
    public Veiculo (Veiculo v){
        this.matricula = v.getMat();
        this.kmstotal = v.getKMT();
        this.kmsparcial = v.getKMP();
        this.consMedio = v.getCM();
        this.cap = v.getCap();
        this.cont = v.getCont();
    }
    
    public String getMat(){ return this.matricula;}
    public double getKMT(){ return this.kmstotal;}
    public double getKMP(){ return this.kmsparcial;}
    public double getCM(){return this.consMedio;}
    public int getCap(){ return this.cap;}
    public int getCont(){ return this.cont;}
    
    public void setMat(String matricula){this.matricula=matricula;}
    public void setKMT(double kmsTotal){this.kmstotal=kmsTotal;}
    public void setKMP(double kmsParcial){this.kmsparcial=kmsParcial;}
    public void setCM(double consumoMedio){this.consMedio=consumoMedio;}
    public void setCap(int capacidade){this.cap=capacidade;}
    public void setCont(int conteudo){this.cont=conteudo;}
    
    public void abastecer(int litros) {
        if ((this.cont+litros)<this.cap) this.cont+=litros;
        else this.cont=this.cap;
    }
    
    public void resetKms() {
        this.kmsparcial=0;
        this.consMedio=0;
    }
    
    public double autonomia() {
        return ((this.cont*100)/this.consMedio);
    }
    
    public void registarViagem(int kms, double consumo) {
        this.kmstotal+=kms;
        this.kmsparcial+=kms;
        this.cont-=consumo;
        this.consMedio = consumo*100/kms;
    }
    
    public boolean naReserva() {
        if (this.cont<10) return true;
        else return false;
    }
    
    public double totalCombustivel(double custoLitro) {
        return this.kmsparcial * this.consMedio * custoLitro;
    }
    
    public double custoMedioKm(double custoLitro){
        return (this.consMedio *100) / custoLitro;
    }
}
