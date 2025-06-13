/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.util;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import java.io.FileInputStream;
import java.sql.Connection;

import adopsiHewan.config.DBConnection;
        
public class PhotoHandler {
    
    byte[] fotoBytes;
    FileInputStream fis = null;
    
    public PhotoHandler() {
        Connection con = DBConnection.getConnection();
    }
    
    public byte[] getFotoBytes() {
        return fotoBytes;
    }
    
    public byte[] fotoKeByte() {

        // Membuka JFileChooser untuk memilih file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih Foto"); // Mengubah teks dialog menjadi "Pilih Foto"
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Gambar JPEG", "jpg", "jpeg"));

        int returnValue = fileChooser.showOpenDialog(null);  // Menampilkan dialog
        if (returnValue == JFileChooser.APPROVE_OPTION) {  // Jika file dipilih
            File selectedFile = fileChooser.getSelectedFile();  // Ambil file yang dipilih
            String fileName = selectedFile.getName();
            System.out.print(fileName);
            String filePath = selectedFile.getAbsolutePath();  // Ambil path lengkap dari file yang dipilih
            System.out.println("File yang dipilih: " + filePath);  // Tampilkan path file yang dipilih

            try {
                // Konversi file menjadi byte array
                fotoBytes = convertImageToByteArray(filePath); // Simpan byte array gambar ke fotoBytes
                // Lakukan operasi dengan fotoBytes (misalnya simpan ke model, database, dll.)
                System.out.println("Foto berhasil diubah menjadi byte array!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return fotoBytes;
    }
   
    public static byte[] convertImageToByteArray(String imagePath) throws IOException {
        File file = new File(imagePath);
        return Files.readAllBytes(file.toPath());  // Baca file dan ubah ke byte array
    }
    
    public FileInputStream fotoKeByte2() {
        // Membuka JFileChooser untuk memilih file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih Foto"); // Mengubah teks dialog menjadi "Pilih Foto"
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Gambar JPEG", "jpg", "jpeg"));

        int returnValue = fileChooser.showOpenDialog(null);  // Menampilkan dialog
        if (returnValue == JFileChooser.APPROVE_OPTION) {  // Jika file dipilih
            File selectedFile = fileChooser.getSelectedFile();  // Ambil file yang dipilih
            String fileName = selectedFile.getName();
            System.out.print(fileName);
            String filePath = selectedFile.getAbsolutePath();  // Ambil path lengkap dari file yang dipilih
            System.out.println("File yang dipilih: " + filePath);  // Tampilkan path file yang dipilih

            try {
                fis = new FileInputStream(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return fis;
    }
    
    public ImageIcon byteKeIcon(byte[] imageData, int width, int height) {
        try {
            // Ubah byte[] menjadi BufferedImage
            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
            BufferedImage bufferedImage = ImageIO.read(bis);
        
            // Resize gambar sesuai ukuran yang diinginkan
            Image scaledImage = bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
            // Buat ImageIcon dari Image yang sudah di-resize
            ImageIcon imageIcon = new ImageIcon(scaledImage);
        
            return imageIcon;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
        public byte[] iconKeByte(ImageIcon icon) throws IOException{
        // Mengambil gambar dari ImageIcon
        Image image = icon.getImage();
        
        // Mengonversi Image menjadi BufferedImage
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        bufferedImage.getGraphics().drawImage(image, 0, 0, null);
        
        // Menggunakan ByteArrayOutputStream untuk mengonversi BufferedImage menjadi byte[]
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);  // Menyimpan gambar sebagai format JPG
        byte[] imageInByte = byteArrayOutputStream.toByteArray();
        
        return imageInByte;  // Mengembalikan byte array
    }
    
}
