package com.bosonit.EJERCICIOS.BS2_2.infrastructure;



import com.bosonit.EJERCICIOS.BS2_2.domain.Ciudad;

import java.util.ArrayList;

public interface CiudadService {

    // CREA UNA NUEVA CIUDAD A RAIZ DE SU NOMBRE Y SU NUMERO DE HABITANTES Y TE LA DEVUELVE
    Ciudad addCiudad (String nombreCiudad, int numHabitantes);

    public void addCiudadALista (Ciudad ciudad);

    public ArrayList<Ciudad> getListaCiudades ();



    Ciudad getCiudad ();

    //CAMPO NOMBRE DE LA CIUDAD
    String getNombre ();
    void setNombre (String nombre);

    //CAMPO NUMERO DE HABITANTES DE LA CIUDAD
    int getNumHabitantes ();
    void setNumHabitantes (int numHabitantes);



}
