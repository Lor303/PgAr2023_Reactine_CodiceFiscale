import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        StringBuilder nome, cognome, anno, mese, giorno, cifreAnnoEMese = null;
        int k=0; //per contare se si tratta di nome, cognome, sesso, comune o data di nascita
        int t=0; //si usa nel calcolo del codice fiscale in caso sia maschio o femmina la persona considerata
        ArrayList <StringBuilder> codiceFiscale = new ArrayList<StringBuilder>();


        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        try {

            String filename = "src/InputPersone.xml";
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));

            while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione

                // switch sul tipo di evento
                switch (xmlr.getEventType()) {

                    // inizio del documento: stampa che inizia il documento
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Start Read Doc " + filename);
                        break;

                    // inizio di un elemento: stampa il nome del tag e i suoi attributi
                    case XMLStreamConstants.START_ELEMENT:

                        k = ControlloDeiTag.verficaTag(xmlr.getLocalName());
                        System.out.println("Tag " + xmlr.getLocalName());
                        for (int i = 0; i < xmlr.getAttributeCount(); i++)
                            System.out.printf(" => attributo %s->%s \n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i));
                        break;

                    // fine di un elemento: stampa il nome del tag chiuso
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("END-Tag " + xmlr.getLocalName());
                        break;

                    // commento: ne stampa il contenuto
                    case XMLStreamConstants.COMMENT:
                        System.out.println("// commento " + xmlr.getText());
                        break;

                    // content all’interno di un elemento: stampa il testo
                    case XMLStreamConstants.CHARACTERS:

                        // controlla se il testo non contiene solo spazi
                        if (xmlr.getText().trim().length() > 0)

                            //A seconda del valore di k, che varia nel case XMLStreamConstants.START_ELEMENT,
                            //ci è possibile sapere se il testo attuale sia il nome, il cognome, il sesso, il comune
                            //o lanno di nascita
                            switch (k) {
                                case 0: nome = CalcoloCifre.cifreNome(xmlr.getText()); //case 0 -> nome persona nel file xml
                                    break;
                                case 1: cognome = CalcoloCifre.cifreNome(xmlr.getText()); //case 1 -> cognome persona nel file xml
                                    break;
                                case 2: //case 2 -> sesso persona nel file xml
                                    break;
                                case 3: //case 3 -> comune di nascita persona nel file xml
                                    break;
                                case 4: //case 4 -> data di nascita persona nel file xml
                                        anno = CalcoloCifre.cifreAnnoDiNascita(xmlr.getText()); //case 4 -> data di nascita persona nel file xml
                                        mese = CalcoloCifre.cifreMeseDiNascita(xmlr.getText());
                                        cifreAnnoEMese.append(anno).append(mese);
                                    break;
                            }
                            System.out.println("-> " + xmlr.getText()); //stampa il testo tra i tag
                        break;
                }

                xmlr.next();
            }

        }

        catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

    }
}
