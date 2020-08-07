package com.example.achatstore.bo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * classe representant un article
 */
//parcelable  ->serialisation -> pr transformer son objet en string, ...
@Entity
public class Article implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private boolean isAchete;
    private float prix;
    private String description;
    private int note;
    private String lien;

    public Article(int id, String nom, boolean isAchete, float prix, String description, int note, String lien) {
        this.id = id;
        this.nom = nom;
        this.isAchete = isAchete;
        this.prix = prix;
        this.description = description;
        this.note = note;
        this.lien = lien;
    }

    protected Article(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        isAchete = in.readByte() != 0;
        prix = in.readFloat();
        description = in.readString();
        note = in.readInt();
        lien = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isAchete() {
        return isAchete;
    }

    public void setAchete(boolean achete) {
        isAchete = achete;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", isAchete=" + isAchete +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", note=" + note +
                ", lien='" + lien + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nom);
        parcel.writeByte((byte) (isAchete ? 1 : 0));
        parcel.writeFloat(prix);
        parcel.writeString(description);
        parcel.writeInt(note);
        parcel.writeString(lien);
    }
}//fin class
