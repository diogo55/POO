
/**
 * Classe que representa um Stand de automóveis
 * 
 * @author anr
 * @version 2014.03.16  
 * @version 2017.03.03
 */

public class Stand {
  //variáveis de instância
  private String nomeStand;
  private Veiculo[] carros;
  private int nveiculos;   //número veículos no stand
  
  //capacidade do stand (em número de veículos)
  private int capacidade;
  
  //capacidade inicial do Stand: valor por omissão
  public static final int capacidade_inicial = 10;
  
  //construtores
  public Stand() {
    this.nomeStand = new String();
    this.carros = new Veiculo[capacidade_inicial];
    this.capacidade = capacidade_inicial;
    this.nveiculos = 0;
  }
  
  public Stand(String nome, int capacidade) {
    this.nomeStand = nome;
    this.carros = new Veiculo[capacidade];
    this.capacidade = capacidade;
    this.nveiculos = 0;
  }
  
  public Stand(Stand umStand) {
    this.nomeStand  = umStand.getNomeStand();
    this.carros     = umStand.getCarros();
    this.capacidade = umStand.getCapacidade();
    this.nveiculos  = umStand.getNVeiculos();
  }
  
  //métodos de instância
  
  public String getNomeStand() {
      return this.nomeStand;
    }
    
  public int getNVeiculos() {
      return this.nveiculos;
    }
    
    public int getCapacidade() {
        return this.capacidade;
    }
  
    public Veiculo[] getCarros() {
        int i;
        Veiculo[] v = new Veiculo[this.nveiculos];
        for (i=0;i<nveiculos;i++)
            v[i]=this.carros[i].clone();
        return v;
    }
    
  public void setNomeStand(String nomeStand){ this.nomeStand = nomeStand;}
  public void setCarros(Veiculo[] carros){this.carros = carros;}
  public void setCapacidade(int capacidade){this.capacidade = capacidade;}
  public void setNVeiculos(int nveiculos){this.nveiculos = nveiculos;}
  //outros métodos
  
  /**
   * Método que insere um veículo no stand
   * 
   */
   public void insereVeiculo(Veiculo v) {
       if (this.nveiculos<this.capacidade) this.carros[this.nveiculos]=v.clone();
       this.nveiculos++;
    }
   
   
   /**
    * Método que verifica se um determinado veículo está no
    * stand.
    */
    public boolean existeVeiculo(Veiculo v) {
        int i;
        boolean r=false;
        for(i=0;i<this.nveiculos && r==false;i++)
            if (this.carros[i].equals(v)) r=true;
        return r;
    }
    
    
    /**
     * Método que verifica se um veículo, cuja matrícula é conhecida, 
     * está no stand.
     */
    public boolean existeVeiculoPorMatricula(String matricula) {
        int i;
        boolean r=false;
        for(i=0;i<this.nveiculos && r==false;i++)
            if (this.carros[i].getMat().equals(matricula)) r=true;
        return r;
    }
    
    
    /** 
     * Método que devolve o veículo com mais kms.
     * 
     */
    public Veiculo veiculoComMaisKms() {
        int pos=0,i;
        double max=0;
        for(i=0;i<this.nveiculos;i++)
            if (this.carros[i].getKMT()>max) {max=this.carros[i].getKMT();pos=i;}
        return this.carros[pos];
    }
    
    /**
     * Método que devolve o veículo mais gastador (em termos de
     * combustível).
     */
    public Veiculo veiculoMaisGastador() {
        int pos=0,i;
        double max=0;
        for(i=0;i<this.nveiculos;i++)
            if (this.carros[i].getCM()>max) {max=this.carros[i].getCM();pos=i;}
        return this.carros[pos];
    }
  
    
    /**
     * Método que determina o número de kms de todos os veículos
     * da garagem.
     * 
     */
    public double totalKmsTodosVeiculos() {
        int tot=0,i;
        for(i=0;i<this.nveiculos;i++)
            tot+=this.carros[i].getKMT();
        return tot;
    }
    
    
    /**
     * equals
     * 
     */
    public boolean equals(Object o) {
        if(this==o)return true;
        if(o==null || this.getClass() != o.getClass()) return false;
        else{
            Stand s = (Stand) o;
            return s.getNomeStand().equals(nomeStand) &&
                   s.getCarros().equals(carros) &&
                   s.getCapacidade()==capacidade &&
                   s.getNVeiculos()==nveiculos;
         }
    }
    
    /**
     * toString
     */

    public String toString() {
         int i;
        StringBuilder s = new StringBuilder();
        s.append("NomeStand: ").append(nomeStand);
        s.append("Número de veiculos: ").append(nveiculos);
        s.append("Capacidade: ").append(capacidade);
        
        for(i=0;i<nveiculos;i++){
            s.append("Carro: ").append(carros[i]);
        }
        
        return s.toString();
    }
    
    /**
     * clone
     */
    public Stand clone() {
        return new Stand(this);
    }
    
}
