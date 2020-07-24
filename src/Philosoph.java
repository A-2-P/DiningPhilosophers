public class Philosoph {
    private Thread thread;
    private Runnable task;

    public Philosoph(int id, Gabel gabelLinks, Gabel gabelRechts, Monitor monitor) {

        this.task = new PhilosophenTask(id, gabelLinks, gabelRechts, monitor);
        this.thread = new Thread(this.task);

        this.thread.start();
    }



}
