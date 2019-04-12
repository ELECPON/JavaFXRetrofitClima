package Servicio;
import Modelos.extraerClima;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ClimaAPI {
    String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    @GET("weather?q=Armenia&appid=411b3bfcae517b8f8d5d1f7b366b6d29")
    Call<extraerClima> resultadosClima();
}

