

public class Pixel
{
    private double x,y;
    private int cor;
    
    public Pixel(double x, double y,int cor) {
        this.x=x;
        this.y=y;
        this.cor=cor;
    }
    
    public Pixel() {
        this.x=0;
        this.y=0;
        this.cor=0;
    }
    
    public Pixel (Pixel p){
      x = p.getX();
      y = p.getY();
      cor = p.getCor();
  }
  
    public int getCor() {
      return this.cor;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setX(double x) {
        this.x=x;
    }
    
    public void setY(double y) {
        this.y=y;
    }
    
    public void setCor(int cor) {
        this.cor=cor;
    }
    
    public void desloca(double x, double y) {
        this.x+=x;
        this.y+=y;
    }
    
    public void mudarCor(int cor){this.cor = cor;}
  
  public String nomeCor(){
      String corString;
      int cores = this.cor;
      switch(cores){
          case 0: corString="Preto";
                  break;
          case 1: corString="Azul Marinho";
                  break;
          case 2: corString="Verde escuro";
                  break;
          case 3: corString="Azul petróleo";
                  break;
          case 4: corString="Castanho";
                  break;
          case 5: corString="Púrpura";
                  break;
          case 6: corString="Verde Oliva";
                  break;
          case 7: corString="Cinza Claro";
                  break;
          case 8: corString="Cinza Escuro";
                  break;
          case 9: corString="Azul";
                  break;
          case 10: corString="Verde";
                   break;
          case 11: corString="Azul turquesa";
                   break;
          case 12: corString="Vermelho";
                   break;
          case 13: corString="Fúscia";
                   break;
          case 14: corString="Amarelo";
                   break;
          case 15: corString="Branco";
                   break;
          default: corString="Invalid color";
                   break;
        }
        return corString;
    }
}
