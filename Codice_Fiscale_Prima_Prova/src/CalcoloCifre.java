/* Classe dove sono presenti i metodi per generare i caratteri dei codici fiscali passando
 * le il nome, il codnome, l'anno di nascita, il mese di nascita, il giorno di nascita, il comune di nascita
 * oppure il sesso
 */
public class CalcoloCifre {

    /* Metodo per generare i tre caratteri del codice fiscale dato il nome o il cognome
     * I caratteri vengono generati usando la seguente procedura:
     *     -si verifica che il carattere del nome NON sia una vocale
     *     -viene inserita la consonante nella variabile stringBuilder1
     *     -in caso la variabile stringBuilder1 non sia composta da almeno tre caratteri vengono inserite le vocali del nome
     *     -in caso la variabile stringBuilder1 non sia composta da almeno tre caratteri viene completata con i/il carattere X
     */
    public static StringBuilder cifreNome(String nome) {

        int k=0;
        char cifreNome[] = new char[0];
        String nomeCodiceFiscale = null;
        StringBuilder stringBuilder1 = new StringBuilder();

        for (int i=0; i<nome.length(); i++) {
            if (nome.charAt(i) != 'A' &&
                nome.charAt(i) != 'E' &&
                nome.charAt(i) != 'I' &&
                nome.charAt(i) != 'O' &&
                nome.charAt(i) != 'U' &&
                k < 3)
            {
                stringBuilder1.append(nomeCodiceFiscale).append(nome.charAt(i));
                k++;
            }
        }

        for (int i=0; i<nome.length(); i++) {
            if (nome.charAt(i) == 'A' ||
                nome.charAt(i) == 'E' ||
                nome.charAt(i) == 'I' ||
                nome.charAt(i) == 'O' ||
                nome.charAt(i) == 'U' &&
                k < 3)
            {
                stringBuilder1.append(nomeCodiceFiscale).append(nome.charAt(i));
                k++;
            }
        }

        for (int i = 0; i < 3 && k<3; i++) {
            stringBuilder1.append(nomeCodiceFiscale).append('X');
            k++;
        }

        return stringBuilder1;
    }

    /* Metodo per generare i due caratteri del codice fiscale dato l'anno di nascita
     * Vengono inseriti il carattere n°2 e il carattere n°3 all'interno della variabile stringBuilder1
     * Questi due caratteri sono le ultime due cifre dell'anno di nascita
     */
    public static StringBuilder cifreAnnoDiNascita(String anno) {

        StringBuilder stringBuilder1 = new StringBuilder();

        stringBuilder1.append((String) null).append(anno.charAt(2));
        stringBuilder1.append((String) null).append(anno.charAt(3));

        return stringBuilder1;
    }

    /* Metodo per generare il carattere del codice fiscale dato il mese di nascita
     * Viene eseguito uno switch case e, a seconda del numero del mese, la variabile stringBuilder1
     * viene eguagliata ad un carattere tra: A,B,C,D,E,H,L,M,P,R,S,T.
     */
    public static StringBuilder cifreMeseDiNascita(String mese) {

        StringBuilder stringBuilder1 = new StringBuilder();

        switch (mese.charAt(5)) {
            case 0: switch (mese.charAt(6)) {
                case 1: stringBuilder1.append((String) null).append("A");
                    break;
                case 2: stringBuilder1.append((String) null).append("B");
                    break;
                case 3: stringBuilder1.append((String) null).append("C");
                    break;
                case 4: stringBuilder1.append((String) null).append("D");
                    break;
                case 5: stringBuilder1.append((String) null).append("E");
                    break;
                case 6: stringBuilder1.append((String) null).append("H");
                    break;
                case 7: stringBuilder1.append((String) null).append("L");
                    break;
                case 8: stringBuilder1.append((String) null).append("M");
                    break;
                case 9: stringBuilder1.append((String) null).append("P");
                    break;
            }
                break;

            case 1: switch (mese.charAt(6)) {
                case 0: stringBuilder1.append((String) null).append("R");
                    break;
                case 1: stringBuilder1.append((String) null).append("S");
                    break;
                case 2: stringBuilder1.append((String) null).append("T");
                    break;
            }
                break;
        }

        return stringBuilder1;
    }
}
