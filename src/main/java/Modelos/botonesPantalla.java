package Modelos;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class botonesPantalla {

    @FXML //Conecta con el documento MainFX.fxml
    private TextArea pantalla; // Elemento visualizador
    @FXML
    private TextField mens;

    public  botonesPantalla(){

    }


    public void clickTemperatura(ActionEvent Event){
        mens.clear();
        pantalla.clear();
        Cliente h = new Cliente();
        mens.setText(h.getMensaje());
        double temp[] = h.getTemperaturas();
        pantalla.setText("Temperatura: " +String.valueOf(Math.round(temp[0]-273.15))+" C"
        +"\nHumedad: " +String.valueOf(temp[1]+" %")
        +"\nPresion: " +String.valueOf(temp[2])
        +"\nTemp maxima: " +String.valueOf(temp[3]-273.15)+" C"
        +"\nTemp minima: " +String.valueOf(temp[4]-273.15)+" C"
        );

    }

    public void clickViento(ActionEvent Event){
        pantalla.clear();
        mens.clear();
        Cliente h = new Cliente();
        mens.setText(h.getMensaje());
        double[] vie = h.getViento();
        pantalla.setText("Velocidad: " +String.valueOf(vie[0])
                +"\nGrados: " +String.valueOf(vie[1]));

    }

    public void clickCoordenadas(ActionEvent Event){
        pantalla.clear();
        mens.clear();
        Cliente h = new Cliente();
        mens.setText(h.getMensaje());
        double coo[] = h.getCoordenadas();
        pantalla.setText("Latitud: " +String.valueOf(coo[0])
                +"\nLongitud: " +String.valueOf(coo[1])
        );

    }

    public void clickPronostico(ActionEvent Event){
        pantalla.clear();
        mens.clear();
        Cliente h = new Cliente();
        mens.setText(h.getMensaje());
        String pro[] = h.getPronostico();
        pantalla.setText("Pronostico:"
                +"\n"+pro[0]
                +"\n"+pro[1]
        );

    }



}
