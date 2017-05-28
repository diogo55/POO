
public class Produto
{
    private String codigo;
    private String nome;
    private int quant;
    private int qmin;
    private double preComp;
    private double preVenda;
    
    public Produto(String codigo,String nome,int quant,int qmin,double comp,double venda) {
        this.codigo=codigo;
        this.nome=nome;
        this.quant=quant;
        this.qmin=qmin;
        this.preComp=comp;
        this.preVenda=venda;
    }
    
    public Produto() {
        this.codigo="";
        this.nome="";
        this.quant=0;
        this.qmin=0;
        this.preComp=0;
        this.preVenda=0;
    }
    
    public Produto(Produto p){
        this.codigo=p.getCod();
        this.nome=p.getNome();
        this.quant=p.getQuant();
        this.qmin=p.getMin();
        this.preComp=p.getComp();
        this.preVenda=p.getVenda();
    }
    
    public String getCod() {return this.codigo;}
    public String getNome() {return this.nome;}
    public int getQuant() {return this.quant;}
    public int getMin() {return this.qmin;}
    public double getComp() {return this.preComp;}
    public double getVenda() {return this.preVenda;}
    
    public void setCod(String c) {this.codigo=c;}
    public void setNome(String n) {this.nome=n;}
    public void setQuant(int q) {this.quant=q;}
    public void setMin(int q) {this.qmin=q;}
    public void setComp(double p) {this.preComp=p;}
    public void setVenda(double p) {this.preVenda=p;}
    
    public void modificaStock(int valor) {
        this.quant+=valor;
    }
    
    public void alteraCodigo(String codigo) {
        if (codigo.length()>=8) this.codigo=codigo;
    }
    
    public void setPrecoVenda(double preco) {
        if (this.preComp<preco) this.preVenda=preco;
    }
    
    public void defineMargemLucro(double percentagem) {
        this.preVenda=this.preComp+this.preComp*percentagem;
    }
    
    public void efectuaCompra(double valor) {
        this.quant-=valor;
    }
    
    public double lucroTotal() {
        return (this.quant*this.preVenda)-(this.quant*this.preComp);
    }
    
    public double precoTotal(int encomenda) {
        return this.preComp*encomenda;
    }
    
    public boolean abaixoValor(){
        return (this.quant<this.qmin);
    }
}
