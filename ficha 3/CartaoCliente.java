

public class CartaoCliente
{
    private int pontos;
    private int valor;
    private String codigo;
    private String nome;
    private int valorBonus;
    
    
    public CartaoCliente(int pontos, int valor, String codigo,
String nome, int valorBonus){
    this.pontos=pontos;
    this.valor=valor;
    this.codigo=codigo;
    this.nome=nome;
    this.valorBonus=valorBonus;
}

    public CartaoCliente(){
            this.pontos=0;
            this.valor=0;
            this.codigo="";
            this.nome="";
            this.valorBonus=0;
        }
        
        public CartaoCliente(CartaoCliente c){
        this.pontos = c.getPts();
        this.valor = c.getVal();
        this.codigo = c.getCode();
        this.nome = c.getNome();
        this.valorBonus = c.getValBon();
    }
    
    public int getPts(){return this.pontos;}
    public int getVal(){return this.valor;}
    public String getCode(){return this.codigo;}
    public String getNome(){return this.nome;}
    public int getValBon(){return this.valorBonus;}
    
    public void setPts(int pts){this.pontos=pts;}
    public void setVal(int val){this.valor=val;}
    public void setCode(String code){this.codigo=code;}
    public void setNome(String nome){this.nome=nome;}
    public void setValBon(int valBon){this.valorBonus=valBon;}
    
    public void descontar(int menu) {
    if(menu==1) this.pontos-=10;
    else this.pontos-=20;
    }
    
    public void descarregarPontos(CartaoCliente cartao){
        this.pontos=cartao.getPts();
    }
    
    public void efectuarCompra(double valor) {
        this.valor+=valor;
        int i=0;
        if (this.pontos<this.valorBonus) i=1;
        if (valor<5) this.pontos+=1;
        else this.pontos+=2;
        if (this.pontos>=this.valorBonus && i==1) this.pontos+=10;
    }
}
