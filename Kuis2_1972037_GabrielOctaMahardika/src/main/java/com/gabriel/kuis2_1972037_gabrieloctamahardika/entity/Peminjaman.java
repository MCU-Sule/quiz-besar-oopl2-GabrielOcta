package com.gabriel.kuis2_1972037_gabrieloctamahardika.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Author 1972037 Gabriel Octa Mahardika
 **/
@Entity
public class Peminjaman {
    private int id;
    private Date tanggalPinjam;
    private Date tanggalPengembalian;
    private Buku bukuByBukuId;
    private Anggota anggotaByAnggotaId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tanggalPinjam", nullable = true)
    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    @Basic
    @Column(name = "tanggalPengembalian", nullable = true)
    public Date getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public void setTanggalPengembalian(Date tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peminjaman that = (Peminjaman) o;
        return id == that.id && Objects.equals(tanggalPinjam, that.tanggalPinjam) && Objects.equals(tanggalPengembalian, that.tanggalPengembalian);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tanggalPinjam, tanggalPengembalian);
    }

    @ManyToOne
    @JoinColumn(name = "Buku_id", referencedColumnName = "id", nullable = false)
    public Buku getBukuByBukuId() {
        return bukuByBukuId;
    }

    public void setBukuByBukuId(Buku bukuByBukuId) {
        this.bukuByBukuId = bukuByBukuId;
    }

    @ManyToOne
    @JoinColumn(name = "Anggota_id", referencedColumnName = "id", nullable = false)
    public Anggota getAnggotaByAnggotaId() {
        return anggotaByAnggotaId;
    }

    public void setAnggotaByAnggotaId(Anggota anggotaByAnggotaId) {
        this.anggotaByAnggotaId = anggotaByAnggotaId;
    }
}
