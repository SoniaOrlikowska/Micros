package micros;

public class ProblemVeryfier {
    boolean isequal;
    String odpowiedzWlasciwa;
    String podanaOdpowiedz;

    public ProblemVeryfier() {

      //ProblemGenerator pro = new ProblemGenerator();
      MicrosFront micro = new MicrosFront();

       // odpowiedzWlasciwa = pro.getTrescOdpowiedzi();
        podanaOdpowiedz =  micro.getRozwiazanie().getText();

        System.out.println("OdpowiedzWlasciwa: " + odpowiedzWlasciwa + " podanaOdpowiedz: " + podanaOdpowiedz);

        if(podanaOdpowiedz.equals(odpowiedzWlasciwa)) {
            isequal = true;
            System.out.println("Sa rowne");
        }
        else isequal = false;

    }
    
    
}
