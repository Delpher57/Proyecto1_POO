public class Artefactos {
    private String nombreArtefacto;
    private String categoria;
    private int precio;
    private int aumentoStat;
    private String tipo;

    public Artefactos(int id, String nombre){
        nombreArtefacto = nombre;
        setAumentoStat(id);
        buscarNombreCategoria(id);
        setPrecio(id);
    }

    private int setCategoriaID(int id){

        while(id>9){
            id = id/10;
        }
        return id;
    }

    private String buscarNombreCategoria(int id){
        String nombre = "";
        int idCategoria = setCategoriaID(id);

        if (idCategoria == 2 || idCategoria == 4 || idCategoria == 7){
            nombre = "Ataque";
            tipo = "Espada de ";
            
        }
        else if(idCategoria == 1 || idCategoria == 5 || idCategoria == 8){
            nombre = "Defensa";
            tipo = "Escudo de ";
        }
        else if (idCategoria == 3 || idCategoria == 6 || idCategoria == 9){
            nombre = "Velocidad";
            tipo = "Botas de ";
        }

        categoria = nombre;
        return categoria;
    }

    public String getCategoria(){
        return categoria;
    }

    private int setAumentoStat(int id){
        aumentoStat = id%100;
        return aumentoStat;
    }

    public int getAumentoStat(){
        return aumentoStat;
    }

    private int setPrecio(int id){
        id = id / 100;
        precio = id % 100;
        return precio;
    }

    public int getPrecio(){
        return precio;
    }

    public String getNombreArtefacto(){
        return tipo + nombreArtefacto.substring(0, 12);
    }
}












