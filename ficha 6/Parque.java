import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

public class Parque
{
    private String nome;
    private Map<String,Lugar> lugares;
    
    public Parque() {
        this.nome="";
        this.lugares = new TreeMap<>();
    }
    
    public Parque(String nome,Map<String,Lugar> l) {
        this.nome=nome;
        this.lugares=new TreeMap<>();
        for(Map.Entry <String,Lugar> p:l.entrySet())
            this.lugares.put(p.getKey(), p.getValue().clone());
    }
    
    public Parque(Parque p) {
        this.nome=p.getNome();
        this.lugares=p.getLugares();
    }
    
    public String getNome() {return this.nome;}
    public Map<String,Lugar> getLugares() {
        Map<String,Lugar> p = new TreeMap<>();
        this.lugares.entrySet().forEach(l->{p.put(l.getKey(),l.getValue().clone());});
        return p;
     }
     
    public void setNome(String n) {this.nome=n;}
    public void setLugares(Map<String,Lugar> l) {
        l.entrySet().forEach(p->{this.lugares.put(p.getKey(),p.getValue().clone());});
    }
    
    public List<String> lugOcup () {
        List<String> oc = new ArrayList<String>();
        this.lugares.entrySet().forEach(l->{oc.add(l.getKey());});
        return oc;
    }
    
    public void novolugar(Lugar l){
    this.lugares.put(l.getMat(),l);
    }
    
    public void remove(String matricula){
        this.lugares.remove(matricula);
    }
    
    public void alteraTempo(String m,int min) {
        this.lugares.get(m).setMin(min);
    }
    
     public int minTotE () {
         Iterator<Lugar> it = this.lugares.values().iterator();
         int tot=0;
         while(it.hasNext()){
             Lugar l = it.next();
             tot+=l.getMin();
            }
         return tot;
     }
    
    
    public int minTotI () {
        int tot=0;
        for (Lugar l : this.lugares.values()) {
            tot += l.getMin();
        }
        return tot;
    }
    
    public boolean existLugar(String matricula) {
        return this.lugares.containsKey(matricula);
    }
    
    public List<String> maisTempoE (int x) {
        Iterator<Lugar> it = this.lugares.values().iterator();
        List<String> m = new ArrayList<String>();
        while (it.hasNext()) {
            Lugar l=it.next();
            if (l.getMin()>x && l.getPerm()) m.add(l.getMat());
    
        }
        return m;
    }
    
    public List<String> matriculaTempo(int x){
      return this.lugares.values().stream()
      .filter(l->l.getMin()>x && l.getPerm())
      .map(Lugar :: getMat)
      .collect(Collectors.toList());
  }
}
