/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.dao.impl;

import adopsiHewan.config.DBConnection;
import adopsiHewan.model.ManajemenHewan;
import adopsiHewan.dao.Interface.InManajemenHewan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.FileInputStream;
/**
 *
 * @author ASUS
 */
public class ManajemenHewanDAO implements InManajemenHewan{
    
    Connection connection;
    final String insert = "INSERT INTO hewan (nama_hewan, jenis, umur, kelamin, deskripsi, foto, status) VALUES (?, ?, ?, ?, ?, ?, ?);";
    final String update = "UPDATE hewan set nama_hewan=?, jenis=?, umur=?, kelamin=?, deskripsi=?, foto=?, status=? WHERE id_hewan=?;";
    final String delete = "DELETE FROM hewan WHERE id_hewan=?;";
    final String select = "SELECT * FROM hewan;";
    final String carinama = "SELECT * FROM hewan WHERE nama_hewan LIKE ?;";
    
    public ManajemenHewanDAO() {
        connection = DBConnection.getConnection();
    }

    @Override
    public void insert(ManajemenHewan mh) {
        PreparedStatement statement = null;
        try{
            connection.setAutoCommit(true);
            statement = connection.prepareStatement(insert);
            statement.setString(1, mh.getNama_hewan());
            statement.setString(2, mh.getJenis());
            statement.setInt(3, mh.getUmur());
            statement.setString(4, mh.getKelamin());
            statement.setString(5, mh.getDeskripsi());
            statement.setBytes(6, mh.getFoto());
            statement.setString(7, mh.getStatus());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()) {
                mh.setId_hewan(rs.getInt(1));
            }
        } catch(SQLException ex) {
            System.out.println("Input Data Berhasil!");
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                System.out.println("Input Gagal");
            }
        }
    }

    @Override
    public void update(ManajemenHewan mh) {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(true);
            statement = connection.prepareStatement(update);
            statement.setString(1, mh.getNama_hewan());
            statement.setString(2, mh.getJenis());
            statement.setInt(3, mh.getUmur());
            statement.setString(4, mh.getKelamin());
            statement.setString(5, mh.getDeskripsi());
            statement.setBytes(6, mh.getFoto());
            statement.setString(7, mh.getStatus());
            statement.setInt(8, mh.getId_hewan());
            statement.executeUpdate();
        } catch(SQLException ex) {
            System.out.println("Update Berhasil!");
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                System.out.println("Input Gagal");
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(SQLException ex) {
            System.out.println("Delete Berhasil!");
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                System.out.println("Delete Gagal");
            }
        }
    }

    @Override
    public List<ManajemenHewan> getAll() {
        List<ManajemenHewan> mh = null;
        try {
            mh = new ArrayList<ManajemenHewan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()) {
                ManajemenHewan mh2 = new ManajemenHewan();
                mh2.setId_hewan(rs.getInt("id_hewan"));
                mh2.setNama_hewan(rs.getString("nama_hewan"));
                mh2.setJenis(rs.getString("jenis"));
                mh2.setUmur(rs.getInt("umur"));
                mh2.setKelamin(rs.getString("kelamin"));
                mh2.setDeskripsi(rs.getString("deskripsi"));
                mh2.setFoto(rs.getBytes("foto"));
                mh2.setStatus(rs.getString("status"));
                mh.add(mh2);
            }
        } catch(SQLException ex) {
            Logger.getLogger(ManajemenHewan.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mh;
    }

    @Override
    public List<ManajemenHewan> getCariNama(String nama) {
        List<ManajemenHewan> mh = null;
        try {
            mh = new ArrayList<ManajemenHewan>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%"+nama+"%");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                ManajemenHewan mh2 = new ManajemenHewan();
                mh2.setId_hewan(rs.getInt("id_hewan"));
                mh2.setNama_hewan(rs.getString("nama_hewan"));
                mh2.setJenis(rs.getString("jenis"));
                mh2.setUmur(rs.getInt("umur"));
                mh2.setKelamin(rs.getString("kelamin"));
                mh2.setDeskripsi(rs.getString("deskripsi"));
                //mh2.setFoto(rs.getBytes("foto"));
                mh2.setStatus(rs.getString("status"));
                mh.add(mh2);
            }
        } catch(SQLException ex) {
            Logger.getLogger(ManajemenHewanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mh;
    }

}

