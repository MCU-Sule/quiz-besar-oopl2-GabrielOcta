package com.gabriel.kuis2_1972037_gabrieloctamahardika.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

/**
 * @Author 1972037 Gabriel Octa Mahardika
 **/
@Entity
public class Anggota {
    private int id;
    private String nama;
    private String alamat;
    private String notelpon;
    private Date tglLahir;
    private Date tglMasuk;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nama", nullable = true, length = 50)
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Basic
    @Column(name = "alamat", nullable = true, length = 50)
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Basic
    @Column(name = "notelpon", nullable = true, length = 14)
    public String getNotelpon() {
        return notelpon;
    }

    public void setNotelpon(String notelpon) {
        this.notelpon = notelpon;
    }

    @Basic
    @Column(name = "tglLahir", nullable = true)
    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    @Basic
    @Column(name = "tglMasuk", nullable = true)
    public Date getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anggota anggota = (Anggota) o;
        return id == anggota.id && Objects.equals(nama, anggota.nama) && Objects.equals(alamat, anggota.alamat) && Objects.equals(notelpon, anggota.notelpon) && Objects.equals(tglLahir, anggota.tglLahir) && Objects.equals(tglMasuk, anggota.tglMasuk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nama, alamat, notelpon, tglLahir, tglMasuk);
    }
}
