
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

public class Paises
{
    private Map<String,FichaDeCapital> lista; //nome pais e sua capital
    
        public Paises() {
        this.lista = new TreeMap<>();
    }
    
    public Paises(Map<String,FichaDeCapital> l) {
        this.lista=l;
    }
    
    public Paises(Paises p) {
        this.lista=p.getLista();
    }
    
    public Map<String,FichaDeCapital> getLista() {
        return this.lista;
    }
    
     public void setLista(Map<String,FichaDeCapital> l) {
        this.lista = new TreeMap<String,FichaDeCapital>();
       for(Map.Entry<String,FichaDeCapital> entry: l.entrySet())
            this.lista.put(entry.getKey(), entry.getValue());
    }
    
    
    public int numPaises() {
        return this.lista.size();
    }
    
    public List<String> populacaoMaisE (double p) {
        List<String> paises = new ArrayList<String>();
        Set set = lista.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()) {
                Map.Entry m = (Map.Entry)it.next();
                FichaDeCapital f = (FichaDeCapital) m.getValue();
                if (f.getPopulacao()>p) paises.add((String) m.getKey());
    } 
    return paises;
    }
    
    public List<String> populacaoMaisI (double p) {
       List<String> paises = new ArrayList<String>();
       for(Map.Entry <String,FichaDeCapital> f : lista.entrySet()) {
           if(f.getValue().getPopulacao() > p) paises.add(f.getKey());
        }
        return paises;
    }
    
    public FichaDeCapital capitalPais(String nome) {
        return lista.get(nome);
}

    public void alteraPop (String n, double p) {
        lista.get(n).setPopulacao(p);
        }
    
    public void inserePais (String n, FichaDeCapital f) {
        lista.put(n,f);
    }
    
    public List<String> capitaisE() {
    List<String> capitais = new ArrayList<String>();
        Set set = lista.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()) {
                Map.Entry m = (Map.Entry)it.next();
                FichaDeCapital f = (FichaDeCapital) m.getValue();
                capitais.add(f.getNome());
    } 
    return capitais;
    }
    
    public List<String> capitaisI() {
         return lista.values().stream().map(FichaDeCapital::getNome).collect(Collectors.toList());
    }
        
    public double capitaisPopE() {
        double t=0;
        Iterator<FichaDeCapital> it = lista.values().iterator();
        while (it.hasNext()){
            FichaDeCapital f = it.next();
            t+=f.getPopulacao();
        }
        return t;
        }
        
     public double capitaisPopI() {
         return lista.values().stream().mapToDouble(FichaDeCapital::getPopulacao).sum();
     }
       
     public void alteraFicha(Map<String,FichaDeCapital> f) {
        for(Map.Entry <String,FichaDeCapital> p: f.entrySet()){
            if (lista.containsKey(p.getKey())) {
                lista.remove(p.getKey());
                lista.put(p.getKey(),p.getValue());
            }
        }
    }
    
    public void removeFicha (List<String> paises) {
        for(String s:paises)
            lista.remove(s);
    }
}
