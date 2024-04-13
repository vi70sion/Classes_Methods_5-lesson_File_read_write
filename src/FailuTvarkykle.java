import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FailuTvarkykle {

    public static void main(String[] args) throws IOException {

//        Sukurkite klasę FailuTvarkykle su main metodu.
//        Metodo viduje, sukurkite failą (File, nurodant jo lokaciją ant
//        savo kompiuterio desktopo). Paspauskite “run”. Sukūrėte
//        objektą, bet ne patį failą. Norint sukurti patį failą, reikia
//        iškviesti šio failo create new File() metodą.
//        Paleiskite programą dabar. Ar failas susikūrė?
//        Failo kūrimo metodas grąžina boolean reikšmę. Išsaugokite
//        ją atitinkamame kintamajame ir atspausdinkite ekrane ar
//        failas susikūrė.
//        Sukurkite stringą su tekstu, kurį norėtumėtė įrašyti į failą.
//        Sukurkite savo failo nuorodą (Path).
//        Panaudodami statinį metodą write(), įrašykite tekstą į failą.

        String filePath = "C:/Users/User/Desktop/myFile.txt";
        File myFile = new File(filePath);
        try{
            boolean created = myFile.createNewFile();
            if(created){
                System.out.println("Failas sukurtas");
            } else {
                System.out.println("Toks failas jau yra");
            }
        } catch(IOException e){
            System.out.println("Failo sukūrimo metu gauta klaida: " + e.getMessage());
            System.exit(0);
        }
        try{
            FileWriter writeFile = new FileWriter(myFile);
            String myText = "Gyvenimas yra gražus!\n";
            writeFile.write(myText);
            writeFile.write("Dar ne pabaiga"); //dar viena eilute pabandymui
            writeFile.close();
        } catch(IOException exception){
            System.out.println("Įrašant į failą gauta klaida: " + exception.getMessage());
            System.exit(0);
        }

//        Sukurkite naujo failo nuorodą (Path).
//        Faile esantį turinį nukopijuokite į naują (nurodant path’ą).
//        Į atsiradusį naują failą su identišku turiniu įrašykite dar
//        bent vieną eilutę teksto.

        String filepath2 = "C:/Users/User/Desktop/myFile2.txt";
        File myFile2 = new File(filepath2);
        try{
            myFile2.createNewFile();
        } catch (IOException exception){
            System.out.println("Failo sukūrimo metu gauta klaida: " + exception.getMessage());
            System.exit(0);
        }
        try {
            FileWriter writeFile2 = new FileWriter(myFile2);

        } catch (IOException exception){
            System.out.println("Įrašant į failą gauta klaida: " + exception.getMessage());
            System.exit(0);
        }

        try {
            FileReader readFile = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(readFile); //nuskaitysime is pirmo failo myFile
            FileWriter writeFile2 = new FileWriter(myFile2); //irasysime i antra faila myFile2
            String readLine;
            while((readLine = bufferedReader.readLine()) != null) {
                    writeFile2.write(readLine + "\n");
            }
            writeFile2.write("Failo pabaiga.");
            writeFile2.close();
            bufferedReader.close();

        } catch(IOException exception){
            System.out.println("Gauta klaida: " + exception.getMessage());
            System.exit(0);
        }

//        Naudodami statinį metodą “perskaitykite” jūsų surašytas
//        eilutes ir išsaugokite jas kaip stringų sąrašą.
//        Atspausdinkite sąraše esančius stringus ekrane.

        List<String> myList = new ArrayList<String>();
        FileReader readFile2 = new FileReader(myFile2);
        BufferedReader bufferedReader = new BufferedReader(readFile2);
        String readLine;
        while((readLine = bufferedReader.readLine()) != null){
            myList.add(readLine);
        }
        System.out.println(myList);
    }
}
