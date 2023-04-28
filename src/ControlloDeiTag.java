public class ControlloDeiTag {


    public static int verficaTag(String tag) {

        if (tag.equalsIgnoreCase("nome"))
            return 0;

        if (tag.equalsIgnoreCase("cognome"))
            return 1;

        if (tag.equalsIgnoreCase("sesso"))
            return 2;

        if (tag.equalsIgnoreCase("comune_nascita"))
            return 3;

        if (tag.equalsIgnoreCase("data_nascita"))
            return 4;

        return 0;
    }
}
