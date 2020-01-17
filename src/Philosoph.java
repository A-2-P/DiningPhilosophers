public class Philosoph {
    //private Gabel gabelLinks, gabelRechts;  //Referenzen / zeiger auf Gabeln
    private Thread thread;
    private Runnable task;

    public Philosoph(int id, Gabel gabelLinks, Gabel gabelRechts, Monitor monitor) {
        //this.gabelLinks = gabelLinks; nicht nötig, da man nur weitergibt
        //this.gabelRechts = gabelRechts;
        this.task = new PhilosophenTask(id, gabelLinks, gabelRechts, monitor);
        this.thread = new Thread(this.task);

        this.thread.start();
    }



}
