import com.squareup.okhttp.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class JSON_Parser {

    ConexionAPI conect = new ConexionAPI();

    Response response = conect.getResponse();



    private String responseToString() {
        String respuesta = "";
        {
            try {
                respuesta = response.body().string();
            } catch (IOException e) {
                System.out.println("Error: " + e);
                ;
            }
        }

        return respuesta;
    }

    private JSONArray stringToJSONArray() {
        String respuesta = responseToString();
        JSONParser parser = new JSONParser();

        Object objeto = null;
        {
            try {
                objeto = parser.parse(respuesta);
            } catch (ParseException e) {
                System.out.println("Error: "+e);;
            }
        }

        JSONObject objetoJSON = (JSONObject) objeto;

        JSONObject canciones = (JSONObject) objetoJSON.get("response");
        JSONArray arreglo = (JSONArray) canciones.get("songs");

        return arreglo;
    }

    public JSONArray getArreglo(){
        return stringToJSONArray();
    }





}
