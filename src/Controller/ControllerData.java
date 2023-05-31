/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ModelData;
import View.ViewData;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.*;

/**
 *
 * @author PC PRAKTIKUM
 */
public class ControllerData {

    ViewData view;
    ModelData model;
    String judul;

    public ControllerData(ViewData view, ModelData model) {
        this.view = view;
        this.model = model;

        view.getBshow().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String data[][] = model.Tampil();
                    view.getTabel().setModel(new JTable(data, view.Kolom).getModel());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });

        view.getBtambah().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (view.getFjudul().isBlank() || view.getFalur().isBlank() || view.getFpenokohan().isBlank() || view.getFakting().isBlank()) {
                        throw new IllegalAccessException("Lengkapi Data !");
                    }
                    double alur = Integer.parseInt(view.getFalur());
                    double penokohan = Integer.parseInt(view.getFpenokohan());
                    double akting = Integer.parseInt(view.getFakting());
                    double nilai = (alur + penokohan + akting) / 3;

                    model.Tambah(view.getFjudul(), view.getFalur(), view.getFpenokohan(), view.getFakting(), nilai);
                    String data[][] = model.Tampil();
                    view.getTabel().setModel((new JTable(data, view.Kolom)).getModel());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });

        view.getTabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = view.getTabel().getSelectedRow();
                int col = view.getTabel().getSelectedColumn();
                view.setFjudul(view.getTabel().getValueAt(row, 0).toString());
                view.setFalur(view.getTabel().getValueAt(row, 1).toString());
                view.setFpenokohan(view.getTabel().getValueAt(row, 2).toString());
                view.setFakting(view.getTabel().getValueAt(row, 3).toString());
                judul = view.getTabel().getValueAt(row, 0).toString();
            }
        });

        view.getBdelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (judul.isEmpty()) {
                        throw new IllegalArgumentException("Pilih Data terlebih dahulu");
                    }
                    int input = JOptionPane.showConfirmDialog(null,
                            "Hapus data : " + judul + " ", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        model.Hapus(judul);
                        String data[][] = model.Tampil();
                        view.getTabel().setModel((new JTable(data, view.Kolom)).getModel());
                    }
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, error.getMessage());
                }
            }
        });

        view.getBupdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (judul.isEmpty()) {
                        throw new IllegalArgumentException("Pilih Data terlebih dahulu");
                    } else {
                        if (view.getFjudul().isBlank() || view.getFalur().isBlank() || view.getFpenokohan().isBlank() || view.getFakting().isBlank()) {
                            throw new IllegalAccessException("Lengkapi Data !");
                        } else {
                            double alur = Integer.parseInt(view.getFalur());
                            double penokohan = Integer.parseInt(view.getFpenokohan());
                            double akting = Integer.parseInt(view.getFakting());
                            double nilai = (alur + penokohan + akting) / 3;

                            model.Tambah(view.getFjudul(), view.getFalur(), view.getFpenokohan(), view.getFakting(), nilai);
                            String data[][] = model.Tampil();
                            view.getTabel().setModel((new JTable(data, view.Kolom)).getModel());
                        }
                    }
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, error.getMessage());
                }
            }
        });
    }
}
