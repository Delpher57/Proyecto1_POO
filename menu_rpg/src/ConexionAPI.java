import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class ConexionAPI {
    private OkHttpClient client = new OkHttpClient();

    //Se utilizó el API de Genius, el cuál es un API de música
    private Request request = new Request.Builder()
            .url("https://genius.p.rapidapi.com/artists/36539/songs")
            .get()
            .addHeader("x-rapidapi-host", "genius.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "947ef510d7mshf0e145a31cad4fap158658jsna9c51ccb03fb")
            .build();

    private Response response;

    private Response generarResponse(){
        try {
            response = client.newCall(request).execute();
            System.out.println("Se logra conectar con el API");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        return response;
    }

    public Response getResponse(){
        //Retorna un response con la respuesta del servidor de la API
        return generarResponse();
    }
}
