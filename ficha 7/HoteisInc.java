import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.io.*;

public class HoteisInc
{
   private String nome;
   private Map<String,Hotel> hoteis;
   
   public HoteisInc() {
       this.nome="";
       this.hoteis=new HashMap<>();
    }
    
   public HoteisInc(HoteisInc h) {
       this.nome=h.getNome();
       this.hoteis=h.getHoteis();
    }
    
    public HoteisInc(String n,Map<String,Hotel> h) {
        this.nome=n;
        this.hoteis= new HashMap<String,Hotel>();
        for(Map.Entry <String,Hotel> p:h.entrySet())
            this.hoteis.put(p.getKey(), p.getValue().clone());
        }
        
   public String getNome() {return this.nome;}
   public Map<String,Hotel> getHoteis() {
       return this.hoteis.entrySet()
                          .stream()
                          .collect(Collectors.toMap(e->e.getKey(),e->e.getValue().clone()));
    }
    
    public void setNome(String n) {this.nome=nome;}
    public void setHoteis(Map<String,Hotel> h) {
        this.hoteis = hoteis.entrySet()
                            .stream()
                            .collect(Collectors.toMap(e->e.getKey(),e->e.getValue().clone()));
    }
    
    public boolean existeHotel(String cod) {
        return this.hoteis.containsKey(cod);
    }
    
    public int quantos() {
        return this.hoteis.size();
    }
    
    public int quantos(String loc) {
        return (int) this.hoteis.values().stream().filter(h->(h.getLocalidade()).equals(loc)).count();
    }
    
     public int quantosT(String tipo) {
        int c = 0;
        for(Hotel h : hoteis.values()) {
            String cn = h.getClass().getSimpleName();
            if(cn.equals(tipo)) {
                c++;
            }
        }
        return c;
    }
    
    public Hotel getHotel(String cod) {
        return this.hoteis.get(cod);
    }
    
    public void adiciona(Hotel h) {
        this.hoteis.put(h.getCodigo(),h);
    }
    
    public List<Hotel> getHoteisAsList() {
        List<Hotel> h = new ArrayList<Hotel>();
        this.hoteis.values().forEach(entry->{h.add(entry);});
        return h;
    }
    
    public void adiciona(Set<Hotel> hs){
        for(Hotel h : hs)   
            this.hoteis.put(h.getCodigo(),h);
    }
    
    public void mudaPara(String epoca) {
        for(Hotel h : hoteis.values()) {
            if(h instanceof HotelStandard) {
                HotelStandard h2 = (HotelStandard) h;
                if(epoca.equals("alta")) {
                    h2.setEpocaAlta(true);
                } else {
                    h2.setEpocaAlta(false);
                }
            }            
        }
    }
    
    public long total100() {
        long total = 0;
        for(Hotel h : hoteis.values()) {
            total += h.getNumeroQuartos() * h.getPrecoBaseQuarto();
        }
        return total;
    }
    
    
    
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        HoteisInc hi = (HoteisInc) obj;
        return hi.getNome().equals(nome) && 
               hi.getHoteis().equals(hoteis);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder(nome);
        sb.append("(");
        sb.append(hoteis.toString());
        sb.append(")");
        return sb.toString();
    }
    
    public HoteisInc clone() {
        return new HoteisInc(this);
    }
    
    public List<CartaoPontos> daoPontos() {
        return hoteis.values().stream()
                    .filter(h -> h instanceof CartaoPontos)
                    .map(Hotel::clone)
                    .map(h -> (CartaoPontos) h)
                    .collect(Collectors.toList());
    }
    
    public TreeSet<Hotel> ordenarHoteis() {
        TreeSet<Hotel> t = new TreeSet<Hotel>();
        hoteis.values().forEach(h -> {
            t.add(h.clone());
        });
        return t;
    }
    
    public TreeSet<Hotel> ordenarHoteis(Comparator<Hotel> c) {
        TreeSet<Hotel> t = new TreeSet<Hotel>(c);
        hoteis.values().forEach(h -> {
            t.add(h.clone());
        });
        return t;
    }
    
    
}
