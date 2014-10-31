package Moteur;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public interface Buffer {
    public String getContent();
    public String getContentAt(int debut, int fin);
    public void addContent(String txt);
    public void addContentAtPosition(String txt, int position);
    public void deleteContent(int debut, int fin);
    public int getLength();

}
