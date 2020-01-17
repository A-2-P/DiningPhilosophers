public class Main {

    public static void main(String[] args) {
        //Monitor erstellen
        Monitor monitor = new Monitor();


        //Gabeln erstellen
        Gabel gabel[] = new Gabel[5];

        for (int i = 0; i < gabel.length; i++) {
            gabel[i] = new Gabel();
        }

        //Philosophen erstellen
        for (int i = 0; i < gabel.length; i++) {

//            if(i!=0) {
//                new Philosoph(gabel[i], gabel[i-1]);
//            }else{
//                new Philosoph(gabel[i], gabel[gabel.length-1]);
//            }
            //Den If Block mit Modulo:
            Gabel linkeGabel = gabel[(i+1)%gabel.length];
            Gabel rechteGabel = gabel[i];
            new Philosoph(i, linkeGabel, rechteGabel, monitor); //i als id
        }
    }
}
