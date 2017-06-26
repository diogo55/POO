import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.Collection;

public class ListaPais
{
  private List<FichaPais> lista;
  
  public ListaPais() {
    this.lista = new ArrayList<FichaPais>();
    }
    
 public ListaPais(ListaPais lp) {
     this.lista=lp.getLista();
    }
   
 public ListaPais(List<FichaPais> l) {
    this.lista = new ArrayList<FichaPais>();
    this.setLista(l);
    }
    
 public List<FichaPais> getLista() {
     return lista;
    }
    
 public void setLista(List<FichaPais> l) {
    this.lista = new ArrayList<FichaPais>(l.size());
    for(FichaPais p : l)
        lista.add(p);
    }
    
  public void adicionar(String nome, String continente,
double populacao){
    FichaPais pais = new FichaPais(nome,continente,populacao);
    this.lista.add(pais);
}
 
    public int numPaises()  {
        return this.lista.size();
    }
    
    public int numPaises(String continente) {
        int t=0;
        Iterator<FichaPais> it = this.lista.iterator();
        while (it.hasNext()) {
            FichaPais p = it.next();
            if(p.getCont().equals(continente)) t++;;
        }
        return t;
    }
    
    public int numPaisesF(String continente) {
        return (int) this.lista.stream().filter(p->p.getCont().equals(continente)).count();
    } 
    
    public FichaPais getFicha(String nome){
        Iterator<FichaPais> it = this.lista.iterator();
        FichaPais pais = new FichaPais();
        while (it.hasNext()) {
            FichaPais p = it.next();
            if(p.getNome().equals(nome)) pais=p;
        }
        return pais;
    }
    
    public FichaPais getFichaF(String nome) {
        lista.stream().filter(f->f.getNome().equals(nome));
        if (lista != null) return lista.get(0);
        else return null;
    }
    
        public List<String> nomesPaises(double valor){
        List<String> nomes = new ArrayList<String>();
        Iterator<FichaPais> it = lista.iterator();
        while(it.hasNext()){
            FichaPais p = it.next();
            if (p.getPop()>valor) nomes.add(p.getNome());
        }
        return nomes;
    }
    
    public List<String> nomesPaisesF(double valor) {
        return this.lista.stream().filter(p->p.getPop()>valor).map(FichaPais::getNome).collect(Collectors.toList());
    }
    
    public List<String> nomesContinentes(double valor) {
    List<String> nomes = new ArrayList<String>();
        Iterator<FichaPais> it = lista.iterator();
        while(it.hasNext()){
            FichaPais p = it.next();
            if (p.getPop()>valor && !nomes.contains(p.getCont())) nomes.add(p.getCont());
        }
        return nomes;
    }
    
    public List<String> nomesContinentesF(double valor){
                return this.lista.stream().filter(p->p.getPop()>valor).map(FichaPais::getCont).distinct().collect(Collectors.toList());
    }
    
    
    public double somatorio(String continente) {
         int t=0;
        Iterator<FichaPais> it = this.lista.iterator();
        while (it.hasNext()) {
            FichaPais p = it.next();
            if(p.getCont().equals(continente)) t+=p.getPop();
        }
        return t;
    }
    
    
    public double somatorioF(String continente){
        return this.lista.stream().filter(p->p.getCont().equals(continente)).mapToDouble(FichaPais::getPop).sum();
    }
    
    public void actualiza(ArrayList<FichaPais> fichas) {
        int i;
        Iterator<FichaPais> it = fichas.iterator();
        while(it.hasNext()) {
            FichaPais pais = it.next();
            if (!this.lista.contains(pais)) lista.add(pais);
            else {
                for(i=0;!lista.get(i).equals(pais);i++);
                lista.get(i).setPop(pais.getPop());
            }
        }
    }
    
    public void actualizaF(ArrayList<FichaPais> fichas) {
        int i;
        for(FichaPais pais : fichas) {
            if (!this.lista.contains(pais)) lista.add(pais);
            else {
                for(i=0;!lista.get(i).equals(pais);i++);
                lista.get(i).setPop(pais.getPop());
            }
        }
    }
    
    public void remove(ArrayList<String> paises) {
        Iterator<FichaPais> it = this.lista.iterator(); 
        while(it.hasNext()) {
        FichaPais pais = it.next();
        if (paises.contains(pais)) it.remove();
    }
    }
    
    public void removeF(ArrayList<String> paises) {
        this.lista.stream().filter(p->!paises.contains(p));
    }
    
    public ListaPais clone(){
        return new ListaPais(this);
    }
    
    public boolean equals(Object o){
        if(o==this)
            return true;
        if((o==null) || o.getClass() != this.getClass())
            return false;
        ListaPais lp = (ListaPais) o;
        return lp.getLista().equals(lista);
    }
    
    public String toString(){
        int i;
        StringBuilder sb = new StringBuilder();
        for(i=0;i<this.lista.size();i++){
            sb.append("Pais: ").append(lista.get(i).toString()).append("\n");
        }
        
        return sb.toString();
    }
}
