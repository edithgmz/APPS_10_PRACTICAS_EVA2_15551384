package edith.example.practica_2;
/*
 * Created by Edith on 02-Apr-19.
 */

public class Materia {
    private int img_mat, img_doc, img_are, mat_cre;
    private String nom_mat, nom_doc, nom_are;

    public Materia(int img_mat, int img_doc, int img_are, int mat_cre, String nom_mat, String nom_doc, String nom_are) {
        this.img_mat = img_mat;
        this.img_doc = img_doc;
        this.img_are = img_are;
        this.mat_cre = mat_cre;
        this.nom_mat = nom_mat;
        this.nom_doc = nom_doc;
        this.nom_are = nom_are;
    }

    public int getImg_mat() {
        return img_mat;
    }

    public int getImg_doc() {
        return img_doc;
    }

    public int getImg_are() {
        return img_are;
    }

    public int getMat_cre() {
        return mat_cre;
    }

    public String getNom_mat() {
        return nom_mat;
    }

    public String getNom_doc() {
        return nom_doc;
    }

    public String getNom_are() {
        return nom_are;
    }

    public void setImg_mat(int img_mat) {
        this.img_mat = img_mat;
    }

    public void setImg_doc(int img_doc) {
        this.img_doc = img_doc;
    }

    public void setImg_are(int img_are) {
        this.img_are = img_are;
    }

    public void setMat_cre(int mat_cre) {
        this.mat_cre = mat_cre;
    }

    public void setNom_mat(String nom_mat) {
        this.nom_mat = nom_mat;
    }

    public void setNom_doc(String nom_doc) {
        this.nom_doc = nom_doc;
    }

    public void setNom_are(String nom_are) {
        this.nom_are = nom_are;
    }
}
