package funciones;

import javax.swing.JComboBox;

public class Validaciones {

    public static Boolean esNoVacío (String cadena)
    {
        return cadena.length() != 0;
    }

    public static Boolean esSoloLetras (String cadena, Boolean esEspaciosPermitidos)
    {
        for (int i = 0; i < cadena.length(); i++)
        {
            char c = cadena.charAt(i);
            if (! ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'z') || (c == ' ' && esEspaciosPermitidos)))
                return false;
        }

        return true;
    }

    public static Boolean esSoloNúmeros (String cadena)
    {
        for (int i = 0; i < cadena.length(); i++)
        {
            char c = cadena.charAt(i);
            if (! (c >= '0' && c <= '9'))
                return false;
        }

        return true;
    }

    public static Boolean esMismaCadena (String cadena1, String cadena2)
    {
        return cadena1.equals(cadena2);
    }

    public static Boolean esLongitudRequerida (String cadena, int mínimo, int máximo)
    {
        return cadena.length() >= mínimo && cadena.length() <= máximo;
    }

    public static Boolean esElementoSeleccionado (JComboBox comboBox)
    {
        return comboBox.getSelectedIndex() >= 0;
    }
}
