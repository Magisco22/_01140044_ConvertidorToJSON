package com.edu.mx.practica.uno.convertidor;


import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.XML;
import org.json.*;
public class Convertidor {

    public String convertidorClaseToJson(String clase) {
        return "";
    }
    public static int PRETTY_PRINT_INDENT_FACTOR = 4;

    public JSONObject convertirXmToJson(String xml) {
        JSONObject resultado = new JSONObject();
        try {
            resultado = XML.toJSONObject(xml);
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
        return resultado;
    }
    public String Objecttojson(Object m) {
        Gson gson = new Gson();
        String resultado = gson.toJson(m);
        return resultado;
    }


}

//}
