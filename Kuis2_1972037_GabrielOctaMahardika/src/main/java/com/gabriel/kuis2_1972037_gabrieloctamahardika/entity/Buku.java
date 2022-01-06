package com.gabriel.kuis2_1972037_gabrieloctamahardika.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @Author 1972037 Gabriel Octa Mahardika
 **/
@Entity
public class Buku {
    private int id;
    private String judul;
    private String penerbit;
    private String pengarang;
    private String tahunTerbit;
    private String jenisBuku;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "judul", nullable = true, length = 50)
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    @Basic
    @Column(name = "penerbit", nullable = true, length = 50)
    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    @Basic
    @Column(name = "pengarang", nullable = true, length = 50)
    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    @Basic
    @Column(name = "tahunTerbit", nullable = true, length = 4)
    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    @Basic
    @Column(name = "jenisBuku", nullable = true, length = 50)
    public String getJenisBuku() {
        return jenisBuku;
    }

    public void setJenisBuku(String jenisBuku) {
        this.jenisBuku = jenisBuku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buku buku = (Buku) o;
        return id == buku.id && Objects.equals(judul, buku.judul) && Objects.equals(penerbit, buku.penerbit) && Objects.equals(pengarang, buku.pengarang) && Objects.equals(tahunTerbit, buku.tahunTerbit) && Objects.equals(jenisBuku, buku.jenisBuku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, judul, penerbit, pengarang, tahunTerbit, jenisBuku);
    }
}
