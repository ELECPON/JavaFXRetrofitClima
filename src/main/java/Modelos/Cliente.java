package Modelos;

import Servicio.ClimaAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.ArrayList;

// Recurso JSON API OPENWEATHERMAP
//https://api.openweathermap.org/data/2.5/weather?q=Armenia&APPID=411b3bfcae517b8f8d5d1f7b366b6d29

public class Cliente {


   private static double Temp[] = new double[5];
   private static double Coo[] = new double[2];
   private static double Vien[] = new double[2];
   private static String Pronost[] = new String[2];
   private static String mensaje;


   public Cliente() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ClimaAPI.BASE_URL) // direccion del recurso a consumir (Una RESTful API libre)
                .addConverterFactory(GsonConverterFactory.create()) // Usar JSON para convertir datos de la api a Java plano
                .build();

        //cliente HTTP clima

        ClimaAPI servicio = retrofit.create(ClimaAPI.class);
        Call<extraerClima> call = servicio.resultadosClima();


        call.enqueue(new Callback<extraerClima>() {
            @Override
            public void onResponse(Call<extraerClima> call, Response<extraerClima> response) {


               if (response.isSuccessful()) { // verificar conexion con la API

                    extraerClima clima = response.body();
                    Main temperaturas = clima.getMain();
                    Coord coordenadas = clima.getCoord();
                    Clouds nuves = clima.getClouds();
                    ArrayList<Weather> pronostico = clima.getWeather();
                    Weather pron = pronostico.get(0); // la lista solo tiene una posicion
                    Wind viento = clima.getWind();
                    Sys pais = clima.getSys();

                    mensaje = "Ciudad: "+clima.getName()+ ", Pais: "+ pais.getCountry();

                    // Almacenar en arreglos la info de la Api para despues
                    // enviarla a la GUI

                    Temp[0] = temperaturas.getTemp();
                    Temp[1] = temperaturas.getHumidity();
                    Temp[2] = temperaturas.getPressure();
                    Temp[3] = temperaturas.getTemp_max();
                    Temp[4] = temperaturas.getTemp_min();

                    Coo[0] = coordenadas.getLat();
                    Coo[1] = coordenadas.getLon();

                    Vien[0] = viento.getSpeed();
                    Vien[1] = viento.getDeg();

                    Pronost[0] = pron.getMain();
                    Pronost[1] = pron.getDescription();


               } else {
                    mensaje = "Problemas con la API";
               }

            }

            @Override
            public void onFailure(Call<extraerClima> call, Throwable t) {
                mensaje = "Error de conexion";
            }


        });


    }
            // Getters y Setters para visualizar en la GUI

            public void setTemperatura(double[] Temp){
                this.Temp = Temp;
            }

            public double[] getTemperaturas(){
                return Temp;
            }

            public  void setCoordenadas(double[] Coo){
                this.Coo = Coo;
            }

            public double[] getCoordenadas(){
                return Coo;
            }

            public double[] getViento() {
                return Vien;
            }

            public void setViento(double[] Vien) {
                this.Vien = Vien;
            }

            public String[] getPronostico() {
                return Pronost;
            }

            public void setPronostico(String[] Pronost) {
                this.Pronost = Pronost;
            }

            public String getMensaje() {
                return mensaje;
            }

            public void setMensaje(String mensaje) {
                this.mensaje = mensaje;
            }
}//cierra clase







