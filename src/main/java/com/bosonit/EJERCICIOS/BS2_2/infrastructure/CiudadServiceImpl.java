package com.bosonit.EJERCICIOS.BS2_2.infrastructure;


import com.bosonit.EJERCICIOS.BS2_2.domain.Ciudad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CiudadServiceImpl implements CiudadService{


    Ciudad ciudad;

    ArrayList<Ciudad> listaCiudades = new ArrayList<>();

    /*@Override
    public ArrayList<Ciudad> getListaCiudades (){
        ArrayList<Ciudad> listaCiudades = new ArrayList<>();
        listaCiudades = this.listaCiudades;
        return listaCiudades;

    }*/
    @Override
    public ArrayList<Ciudad> getListaCiudades (){
        return listaCiudades;
    }

    public void addCiudadALista (Ciudad ciudad){
        listaCiudades.add (ciudad);
    }

    @Override
    public Ciudad addCiudad(String nombreCiudad, int numHabitantes) {
        Ciudad city = new Ciudad (nombreCiudad, numHabitantes);
        city.setNombre(nombreCiudad);
        city.setNumeroHabitantes(numHabitantes);
        //listaCiudades.add (city);
        ciudad = city;
        return ciudad;
    }

    @Override
    public Ciudad getCiudad() {
        return ciudad;
    }

    @Override
    public String getNombre() {
        return ciudad.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        ciudad.setNombre(nombre);
    }

    @Override
    public int getNumHabitantes() {
        return ciudad.getNumeroHabitantes();
    }

    @Override
    public void setNumHabitantes(int numHabitantes) {
        ciudad.setNumeroHabitantes(numHabitantes);
    }
}
