package edith.example.practica_1;
/*
 * Created by Edith on 27-Mar-19.
 */

public class Restaurante {
    private int img_rest;
    private String nom_rest, desc_rest, dir_rest, tel_rest;

    public Restaurante(int img_rest, String nom_rest, String desc_rest, String dir_rest, String tel_rest) {
        this.img_rest = img_rest;
        this.nom_rest = nom_rest;
        this.desc_rest = desc_rest;
        this.dir_rest = dir_rest;
        this.tel_rest = tel_rest;
    }

    public int getImg_rest() {
        return img_rest;
    }

    public String getNom_rest() {
        return nom_rest;
    }

    public String getDesc_rest() {
        return desc_rest;
    }

    public String getDir_rest() {
        return dir_rest;
    }

    public String getTel_rest() {
        return tel_rest;
    }

    public void setImg_rest(int img_rest) {
        this.img_rest = img_rest;
    }

    public void setNom_rest(String nom_rest) {
        this.nom_rest = nom_rest;
    }

    public void setDesc_rest(String desc_rest) {
        this.desc_rest = desc_rest;
    }

    public void setDir_rest(String dir_rest) {
        this.dir_rest = dir_rest;
    }

    public void setTel_rest(String tel_rest) {
        this.tel_rest = tel_rest;
    }
}
