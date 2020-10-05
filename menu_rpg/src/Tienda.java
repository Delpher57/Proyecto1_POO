import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Tienda {

    private JSON_Parser parser = new JSON_Parser();
    private JSONArray arreglo = parser.getArreglo();
    int numeroArtefactos = arreglo.size();
    Artefactos arregloArtefactos[] = new Artefactos[numeroArtefactos];

    public Tienda(){
        for (int i=0; i<numeroArtefactos;i++){
            JSONObject art = (JSONObject) arreglo.get(i);

            //Para obtener el ID
            String parcial = art.get("lyrics_owner_id").toString();
            int id = Integer.parseInt(parcial);

            arregloArtefactos[i] = new Artefactos(id, art.get("full_title").toString());

        }
    }

}
