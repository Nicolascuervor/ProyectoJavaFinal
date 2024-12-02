/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas.personalizados;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Nicolas
 */
public class TableRender implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jTable1, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
         
        
        JLabel label = new JLabel();
        JCheckBox check = new JCheckBox();
        
        DefaultTableModel modelR = (DefaultTableModel) jTable1.getModel();
        
        
       
        
       DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jTable1, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      
                Component component = super.getTableCellRendererComponent(jTable1, value, isSelected, hasFocus, row, column);
                component.setBackground(new Color(0, 63, 112)); // Color de fondo de la cabecera
                component.setForeground(Color.WHITE); // Color del texto de la cabecera
                return component;
                             
            }
        };
       
       
       
       
        for (int i = 0; i < jTable1.getColumnModel().getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        
            DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component;

       
        if (value instanceof Boolean) {
            // Si es un JCheckBox, usamos el renderizador estándar para Boolean
            JCheckBox checkBox = new JCheckBox();
            checkBox.setSelected((Boolean) value);
            
            component = checkBox;
        } else {
            // Renderizado normal para las demás celdas
            component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Cambiar el color cuando la fila es seleccionada
            if (isSelected) {
                component.setBackground(new Color(181, 178, 178)); // Cambiar a tu color preferido al seleccionar
            } else {
                component.setBackground(Color.WHITE); // Color por defecto de la fila
            }
        }

        return component;
    }
};

// Aplicar el renderizado a todas las columnas de la tabla
for (int i = 0; i < jTable1.getColumnModel().getColumnCount(); i++) {
    jTable1.getColumnModel().getColumn(i).setCellRenderer(tableRenderer);
}
        
        
        
          
        // Verificar si el valor es nulo antes de trabajar con él
        Object cellValue = modelR.getValueAt(row, column);
        
        if (row % 2 == 0) {
            label.setOpaque(true);
            label.setBackground(new Color(238, 238, 238)); // Color de fondo blanco para las filas pares
        } else {
            label.setOpaque(true);
            label.setBackground(new Color(238, 238, 238)); // Color de fondo celeste para filas impares
        }
        
         if (modelR.getRowCount() > 20) {
            // Establecer una altura fija para que el JScrollPane funcione cuando hay más de 10 filas
            jTable1.setPreferredScrollableViewportSize(new Dimension(700, 200));
        } else {
            // Si no hay más de 10 filas, ajustar a la altura mínima (tamaño dinámico)
            jTable1.setPreferredScrollableViewportSize(jTable1.getPreferredSize());
        }


        if (cellValue != null) {
            if (cellValue.getClass().equals(Boolean.class)) {
                // Renderiza el checkbox si la columna es de tipo Boolean
                check.setSelected((Boolean) cellValue);  // No hace falta parsear a Boolean
                return check;
            } else {
                // Para las columnas que no son Boolean, establece el texto
                label.setText(cellValue.toString());
            }
        } else {
            // Manejar el caso donde el valor es nulo
            label.setText("");  // O puedes mostrar algún valor predeterminado si prefieres
        }

        return label;
    }
}
