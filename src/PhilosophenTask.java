import java.util.Random;

public class PhilosophenTask implements Runnable {

    private int id;
    private static Random random = new Random();
    private Gabel gabelLinks, gabelRechts;
    private Zustand zustand;
    private Monitor monitor;

    public PhilosophenTask(int id, Gabel gabelLinks, Gabel gabelRechts, Monitor monitor) {
        this.id = id;
        this.gabelLinks = gabelLinks;
        this.gabelRechts = gabelRechts;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        //this.id = Thread.currentThread().getId();

        while(true) {
            denken();
            zufaelligeZeitWarten();

            rechteGabelNehmen();
            zeitWarten(5000);
            linkeGabelNehmen();
            essen();
            zufaelligeZeitWarten();
            rechteGabelAblegen();
            linkeGabelAblegen();
        }
    }



    private void denken() {
        //System.out.println("Nr.: " + this.id + " denkt heftig!");
        setZustand(Zustand.DENKEN);

    }

    private void setZustand(Zustand zustand) {
        this.zustand = zustand;
        monitor.update(this.id, this.zustand);
    }

    private void rechteGabelNehmen() {
        //System.out.println(this.id + " Ich warten auf die rechte Gabel.");
        setZustand(Zustand.RECHTE_GABEL);
        this.gabelRechts.lock();    //Sperrt und wartet --> .lock()
        //System.out.println(this.id + " Ich habe die rechte Gabel.");
    }
    private void linkeGabelNehmen() {
       // System.out.println(this.id + " Ich warten auf die linke Gabel.");
        setZustand(Zustand.LINKE_GABEL);
        this.gabelLinks.lock();
        //System.out.println(this.id + " Ich habe die linke Gabel.");
    }
    private void essen() {
        //System.out.println("Nr.: "+this.id + " isst heftig!");
        setZustand(Zustand.ESSEN);

    }
    private void linkeGabelAblegen() {
        this.gabelLinks.unlock();
    }

    private void rechteGabelAblegen() {
        this.gabelRechts.unlock();
    }

    private void zufaelligeZeitWarten() {
        int zufallszeitInMS = random.nextInt(900)+100;
       zeitWarten(zufallszeitInMS);
    }
    private void zeitWarten(int zeitInMS) {
        try {
            Thread.sleep(zeitInMS);  //Static method -> Thread (T)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
