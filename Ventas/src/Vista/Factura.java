
package Vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.sql.Connection;
import Modelo.Conexion;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import Modelo.DetalleVenta;
import controlador.VentaPDF;
import java.text.SimpleDateFormat;
import java.util.Date;
import Modelo.CabeceraVenta;
import Modelo.DetalleVenta;
import controlador.Ctrl_RegistrarVenta;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.PreparedStatement;
import javax.swing.Icon;
import javax.swing.ImageIcon;



public class Factura extends javax.swing.JFrame {
// modelo de datos
    private DefaultTableModel modeloDatosProductos;
    // LISTA PARA EL DETALLE DE VENTA DE PRODUCTOS
    ArrayList<DetalleVenta> listaProductos = new ArrayList<>();
    private DetalleVenta producto;
    private int idCliente=0;
    private int idProducto=0;
    private String nombre="";
    private int cantidadProducto=0;
    private double precioUnitario =0.0;
    private int porcentajeigv=0;
    private int cantidad =0;
    private double subtotal =0.0;
    private double descuento =0.0;
    private double igv =0.0;
    private double totalPagar =0.0;
    // variables para calculos globales
    private double subtotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double igvGeneral = 0.0;
    private double totalPagarGeneral = 0.0;
    // fin de varibles de calculos globales
    private int auxIdDetalle=1;
    //Conexion cx;
    //Refactoriza clase Factura.java para mejorar modularidad
    public Factura() {
        initComponents();
        this.setSize(new Dimension(800, 600));
        this.setTitle("FACTURACION");
        
        //cargar los clientes en la lista
        this.CargarComboClientes();
        this.CargarComboProductos();
        this.inicializarTablaProducto();
        txt_efectivo.setEnabled(false);
        jButton_calcular_cambio.setEnabled(false);
        txt_subtotal.setText("0.0");
        txt_igv.setText("0.0");
        txt_descuento.setText("0.0");
        txt_totalpagar.setText("0.0");
        //cx=new Conexion();
       // cx.conectar();

        
    }
//metodo para inicializar los productos
    private void inicializarTablaProducto(){
    modeloDatosProductos = new DefaultTableModel();
    modeloDatosProductos.addColumn("N°");
    modeloDatosProductos.addColumn("NOMBRE");
    modeloDatosProductos.addColumn("CANTIDAD");
    modeloDatosProductos.addColumn("P.UNITARIO");
    modeloDatosProductos.addColumn("SUBTOTAL");
    modeloDatosProductos.addColumn("DESCUENTO");
    modeloDatosProductos.addColumn("IGV");
    modeloDatosProductos.addColumn("TOTAL PAGAR");
    modeloDatosProductos.addColumn("ACCION");
    // agregar dato tabla
    this.jTable1_productos.setModel(modeloDatosProductos);
    
    }
//metodo para presentar informacion de la tabla 
private void listaTablaProductos(){
        this.modeloDatosProductos.setRowCount(listaProductos.size());
        for(int i=0; i< listaProductos.size(); i++){
            this.modeloDatosProductos.setValueAt(i+1, i, 0);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getNombre(), i, 1);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getCantidad(), i, 2);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getPrecioUnitario(), i, 3);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getSubTotal(), i, 4);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getDescuento(), i, 5);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getigv(), i, 6);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getTotalPagar(), i, 7);
            this.modeloDatosProductos.setValueAt("Eliminar", i, 8);
            
        }
        // añadir jtable
        jTable1_productos.setModel(modeloDatosProductos);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1_cliente = new javax.swing.JComboBox<>();
        jComboBox1_producto = new javax.swing.JComboBox<>();
        txt_cliente_buscar = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        jButton1_busca_cliente = new javax.swing.JButton();
        jButton1_añadir_producto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        txt_igv = new javax.swing.JTextField();
        txt_totalpagar = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        jButton_calcular_cambio = new javax.swing.JButton();
        jButton_Registrarventa = new javax.swing.JButton();
        jLabel1_walpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("FACTURACION");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cliente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 80, -1));

        jComboBox1_cliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox1_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Cliente:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 170, -1));

        jComboBox1_producto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox1_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Producto:", "Item 2", "Item 3", "Item 4" }));
        jComboBox1_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 170, -1));

        txt_cliente_buscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_cliente_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cliente_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(txt_cliente_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 130, -1));

        txt_cantidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 160, -1));

        jButton1_busca_cliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1_busca_cliente.setText("Buscar");
        jButton1_busca_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_busca_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_busca_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 80, -1));

        jButton1_añadir_producto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1_añadir_producto.setText("Añadir Producto ");
        jButton1_añadir_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_añadir_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_añadir_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 140, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 760, 210));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Subtotal:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Descuento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("IGV:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Total a Pagar");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Cambio:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_subtotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_subtotal.setEnabled(false);
        jPanel2.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 120, -1));

        txt_descuento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_descuento.setEnabled(false);
        jPanel2.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 120, -1));

        txt_igv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_igv.setEnabled(false);
        jPanel2.add(txt_igv, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 120, -1));

        txt_totalpagar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_totalpagar.setEnabled(false);
        jPanel2.add(txt_totalpagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 120, -1));

        txt_efectivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.add(txt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 120, -1));

        txt_cambio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cambio.setEnabled(false);
        jPanel2.add(txt_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 120, -1));

        jButton_calcular_cambio.setBackground(new java.awt.Color(51, 255, 255));
        jButton_calcular_cambio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_calcular_cambio.setText("Calcular Cambio");
        jButton_calcular_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcular_cambioActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_calcular_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 130, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 380, 210));

        jButton_Registrarventa.setBackground(new java.awt.Color(51, 255, 255));
        jButton_Registrarventa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_Registrarventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        jButton_Registrarventa.setText("Registrar Venta");
        jButton_Registrarventa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Registrarventa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Registrarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarventaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Registrarventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 170, 100));

        jLabel1_walpaper.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel1_walpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1_busca_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_busca_clienteActionPerformed
// Obtener y limpiar el texto ingresado por el usuario
// Obtener y limpiar el texto ingresado por el usuario
    String clienteBuscar = txt_cliente_buscar.getText().trim();

    // Validación básica: evitar consultas vacías
    if (clienteBuscar.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese un nombre de cliente.");
        return; // Se detiene el flujo si no hay texto
    }

    // Conexión a la base de datos usando try-with-resources para cerrar automáticamente
    try (Connection cn = new Conexion().getConnection()) {

        // Consulta segura con PreparedStatement para evitar inyección SQL
        String sql = "SELECT nombre FROM clientes WHERE nombre = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, clienteBuscar); // Se inserta el valor de forma segura

        // Ejecutar la consulta
        ResultSet rs = pst.executeQuery();

        // Si se encuentra el cliente, se selecciona en el combo
        if (rs.next()) {
            jComboBox1_cliente.setSelectedItem(rs.getString("nombre"));
        } else {
            // Si no se encuentra, se muestra mensaje y se reinicia el combo
            jComboBox1_cliente.setSelectedItem("Seleccione cliente:");
            JOptionPane.showMessageDialog(null, "Nombre de cliente incorrecto.");
        }

        // Limpiar el campo de búsqueda
        txt_cliente_buscar.setText("");

    } catch (SQLException e) {
        // Manejo de errores con mensaje visible al usuario
        JOptionPane.showMessageDialog(null, "Error al buscar cliente: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton1_busca_clienteActionPerformed

    private void jButton1_añadir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_añadir_productoActionPerformed
// Obtener el producto seleccionado del combo
    String combo = jComboBox1_producto.getSelectedItem().toString();

    // 🔍 Validación: evitar que se procese si no se ha seleccionado un producto
    if (combo.equalsIgnoreCase("Seleccione producto")) {
        JOptionPane.showMessageDialog(null, "Seleccione un producto");
        return; // Se detiene el flujo si no hay selección válida
    }

    // 🔍 Validación: verificar que el campo de cantidad no esté vacío
    String cantidadTexto = txt_cantidad.getText().trim();
    if (cantidadTexto.isEmpty()) {
        JOptionPane.showConfirmDialog(null, "Ingrese la cantidad de productos");
        return;
    }

    // 🔍 Validación: verificar que el texto ingresado sea numérico
    boolean validacion = validar(cantidadTexto); // Método personalizado
    if (!validacion) {
        JOptionPane.showConfirmDialog(null, "La cantidad no admite caracteres");
        return;
    }

    // 🔍 Validación: verificar que la cantidad sea mayor a cero
    cantidad = Integer.parseInt(cantidadTexto);
    if (cantidad <= 0) {
        JOptionPane.showConfirmDialog(null, "La cantidad no puede ser cero ni negativa");
        return;
    }

    // 🔄 Obtener datos del producto desde la base de datos o estructura interna
    this.DatosDelProducto();

    // 🔍 Validación: verificar que la cantidad no supere el stock disponible
    if (cantidad > cantidadProducto) {
        JOptionPane.showMessageDialog(null, "La cantidad supera el stock disponible");
        return;
    }

    // 🧮 Cálculo de montos
    subtotal = precioUnitario * cantidad;
    totalPagar = subtotal + igv + descuento;

    // 🔄 Redondeo de valores a dos decimales
    subtotal = Math.round(subtotal * 100) / 100.0;
    igv = Math.round(igv * 100) / 100.0;
    descuento = Math.round(descuento * 100) / 100.0;
    totalPagar = Math.round(totalPagar * 100) / 100.0;

    // 🧱 Creación del objeto DetalleVenta con todos los datos
    producto = new DetalleVenta(
        auxIdDetalle,
        1,
        idProducto,
        nombre,
        cantidad,
        precioUnitario,
        subtotal,
        descuento,
        igv,
        totalPagar,
        1
    );

    // ➕ Añadir el producto a la lista de ventas
    listaProductos.add(producto);
    JOptionPane.showMessageDialog(null, "Producto agregado");

    // 🔄 Actualización de estado y limpieza de campos
    auxIdDetalle++;
    txt_cantidad.setText("");
    this.CargarComboProductos();
    this.CalcularTotalPagar();
    txt_efectivo.setEnabled(true);
    jButton_calcular_cambio.setEnabled(true);

    // 📋 Actualizar la tabla visual de productos
    this.listaTablaProductos();


    }//GEN-LAST:event_jButton1_añadir_productoActionPerformed

    private void jComboBox1_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1_productoActionPerformed

    private void jButton_calcular_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcular_cambioActionPerformed
    if(!txt_efectivo.getText().isEmpty()){
        // validamos 
        boolean validacion =validarDouble(txt_efectivo.getText());
        if(validacion==true){
            // validar el efecitvo que ingresamos sea mayor a total a pagar
            double efc=Double.parseDouble(txt_efectivo.getText().trim());
            double top=Double.parseDouble(txt_totalpagar.getText().trim());
            if (efc < top){
                JOptionPane.showConfirmDialog(null, "el dinero en efectivo no es suficiente");
                
            }else {
                double cambio=(efc - top);
                double cambi = (double)Math.round(cambio * 100d)/100;
                String camb=String.valueOf(cambi);
                txt_cambio.setText(camb);
            }
            
        }else{
            JOptionPane.showConfirmDialog(null, "no se permite caracteres no numericos");
        }
    }else{
        JOptionPane.showConfirmDialog(null, "ingrese dinero en efectivo");
    }
    }//GEN-LAST:event_jButton_calcular_cambioActionPerformed
int idArrayList=0;
    private void jTable1_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_productosMouseClicked
    // 📌 Obtener la fila seleccionada en la tabla
    int filaSeleccionada = jTable1_productos.rowAtPoint(evt.getPoint());
    int columnaID = 0;

    // 🔍 Validar que se haya hecho clic sobre una fila válida
    if (filaSeleccionada > -1) {
        // 🆔 Obtener el ID del producto desde la primera columna
        idArrayList = (int) modeloDatosProductos.getValueAt(filaSeleccionada, columnaID);

        // 🗑️ Mostrar cuadro de confirmación para eliminar
        int opcion = JOptionPane.showConfirmDialog(null, "¿Eliminar producto?");

        // 🎯 Procesar la respuesta del usuario
        switch (opcion) {
            case 0: // Sí
                listaProductos.remove(idArrayList - 1); // Elimina el producto de la lista
                this.CalcularTotalPagar();              // Recalcula el total
                this.listaTablaProductos();             // Actualiza la tabla visual
                break;

            case 1: // No
                // No se realiza ninguna acción
                break;

            default: // Cancelar o cerrar
                // No se realiza ninguna acción
                break;
        }
    }
    }//GEN-LAST:event_jTable1_productosMouseClicked

    private void jButton_RegistrarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarventaActionPerformed
// Mejora: se agrega encabezado personalizado en la factura PDF
        // 🧱 Instanciar objetos necesarios
    CabeceraVenta cabeceraVenta = new CabeceraVenta();
    DetalleVenta detalleVenta = new DetalleVenta();
    Ctrl_RegistrarVenta controlVenta = new Ctrl_RegistrarVenta();

    // 📅 Obtener fecha actual en formato yyyy/MM/dd
    String fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(new Date());

    // 🔍 Validar selección de cliente
    if (jComboBox1_cliente.getSelectedItem().equals("Seleccione cliente:")) {
        JOptionPane.showMessageDialog(null, "¡Seleccione un cliente!");
        return;
    }

    // 🔍 Validar que haya productos en la lista
    if (listaProductos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "¡Seleccione un producto!");
        return;
    }

    // 🆔 Obtener ID del cliente
    this.ObtenerIdCliente();

    // 🧾 Configurar cabecera de venta
    cabeceraVenta.setIdCabeceraventa(0);
    cabeceraVenta.setIdCliente(idCliente);
    cabeceraVenta.setValorPagar(Double.parseDouble(txt_totalpagar.getText()));
    cabeceraVenta.setFechaVenta(fechaActual);
    cabeceraVenta.setEstado(1);

    // 💾 Registrar cabecera en la base de datos
    if (!controlVenta.guardar(cabeceraVenta)) {
        JOptionPane.showMessageDialog(null, "¡Error al guardar cabecera de venta!");
        return;
    }

    JOptionPane.showMessageDialog(null, "¡Venta Registrada!");

    // 🧾 Generar factura PDF
    VentaPDF pdf = new VentaPDF();
    pdf.DatosCliente(idCliente);
    pdf.generarFacturaPDF();

    // 🧩 Registrar cada detalle de producto
    for (DetalleVenta elemento : listaProductos) {
        detalleVenta.setIdDetalleVenta(0);
        detalleVenta.setIdCabeceraVenta(0); // Se puede actualizar si se obtiene el ID real
        detalleVenta.setIdProducto(elemento.getIdProducto());
        detalleVenta.setCantidad(elemento.getCantidad());
        detalleVenta.setPrecioUnitario(elemento.getPrecioUnitario());
        detalleVenta.setSubTotal(elemento.getSubTotal());
        detalleVenta.setDescuento(elemento.getDescuento());
        detalleVenta.setigv(elemento.getigv());
        detalleVenta.setTotalPagar(elemento.getTotalPagar());
        detalleVenta.setEstado(1);

        // 💾 Guardar detalle en la base de datos
        if (!controlVenta.guardarDetalle(detalleVenta)) {
            JOptionPane.showMessageDialog(null, "¡Error al guardar detalle de venta!");
            continue;
        }

        // 🔄 Actualizar interfaz y stock
        txt_subtotal.setText("0.0");
        txt_igv.setText("0.0");
        txt_descuento.setText("0.0");
        txt_totalpagar.setText("0.0");
        txt_efectivo.setText("");
        txt_cambio.setText("0.0");
        auxIdDetalle = 1;

        this.CargarComboClientes();
        this.RestarStockProductos(elemento.getIdProducto(), elemento.getCantidad());
    }

    // 🧹 Limpiar lista y actualizar tabla
    listaProductos.clear();
    listaTablaProductos();

    }//GEN-LAST:event_jButton_RegistrarventaActionPerformed

    private void txt_cliente_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cliente_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cliente_buscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_añadir_producto;
    private javax.swing.JButton jButton1_busca_cliente;
    private javax.swing.JButton jButton_Registrarventa;
    private javax.swing.JButton jButton_calcular_cambio;
    private javax.swing.JComboBox<String> jComboBox1_cliente;
    private javax.swing.JComboBox<String> jComboBox1_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel1_walpaper;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1_productos;
    private javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cliente_buscar;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_igv;
    private javax.swing.JTextField txt_subtotal;
    public static javax.swing.JTextField txt_totalpagar;
    // End of variables declaration//GEN-END:variables

// metodo para cargar clientes
    private void CargarComboClientes(){
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        String sql="select * from clientes";
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox1_cliente.removeAllItems();
            jComboBox1_cliente.addItem("Selecione cliente:");
            while (rs.next()){
                jComboBox1_cliente.addItem(rs.getString("nombre"));
                //jComboBox1_cliente.addItem(rs.getString("nombre")+" "+rs.getString("apellido"));
            }

} catch (SQLException e){
    System.out.println("Error al cargar cliente, !"+e);
}
    }
    // metodo para cargar productos
    private void CargarComboProductos(){
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        String sql="select * from productos";
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox1_producto.removeAllItems();
            jComboBox1_producto.addItem("Selecione producto:");
            while (rs.next()){
                jComboBox1_producto.addItem(rs.getString("nombre"));
            }

} catch (SQLException e){
    System.out.println("Error al cargar producto, !"+e);
}
    
    
    
    }
    
    // metodo para validar que el usuario no ingrese caracteres no numericos
    private boolean validar(String valor){
    try {
    int num= Integer.parseInt(valor);
    return true;
    
    }catch(NumberFormatException e){
    return false;
            } 
    }
    
        // metodo para validar que el usuario no ingrese caracteres no numericos
    private boolean validarDouble(String valor){
    try {
    double num= Double.parseDouble(valor);
    return true;
    
    }catch(NumberFormatException e){
    return false;
            } 
    }
    
    
  private void DatosDelProducto(){
      try {
          String sql="select * from productos where nombre= '"+ this.jComboBox1_producto.getSelectedItem() + "'";
          Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
          Statement st;
          st=cn.createStatement();
          ResultSet rs=st.executeQuery(sql);
          while (rs.next()){
            idProducto=rs.getInt("idProducto");
            nombre=rs.getString("nombre");
            cantidadProducto=rs.getInt("cantidad");
            precioUnitario=rs.getDouble("precio");
            porcentajeigv=rs.getInt("porcentajeigv");
            this.Calcularigv(precioUnitario, porcentajeigv);
          }
      }catch (SQLException e){
          System.out.println("Error al obtener datos del producto");
      }
  }  
    
  //Metodo para calcular igv
  private double Calcularigv(double precio, int porcentajeigv){
      int p_igv=porcentajeigv;
      switch (p_igv){
          case 0:
              igv=0.0;
              break;
          case 12:
              igv=(precio * cantidad)*0.12;
          case 14:
              igv=(precio*cantidad)*0.14;
              break;
          default:
              break;
      }
      return igv;
  }
  // metodo para calcular total a pagar los productos
  private void CalcularTotalPagar(){
  subtotalGeneral =0;
  descuentoGeneral = 0;
  igvGeneral = 0;
  totalPagarGeneral = 0;
  for(DetalleVenta elemento : listaProductos){
      subtotalGeneral +=elemento.getSubTotal();
      descuentoGeneral +=elemento.getDescuento();
      igvGeneral +=elemento.getigv();
      totalPagarGeneral +=elemento.getTotalPagar();
  }
  //REDONDEAR DECIMALES
  subtotalGeneral= (double) Math.round(subtotalGeneral *100)/100;
  igvGeneral =(double) Math.round(igvGeneral *100)/100;
  descuentoGeneral =(double) Math.round(descuentoGeneral *100)/100;
  totalPagarGeneral =(double) Math.round(totalPagarGeneral *100)/100;
  //enviar datos a la vista
  txt_subtotal.setText(String.valueOf(subtotalGeneral));
  txt_igv.setText(String.valueOf(igvGeneral));
  txt_descuento.setText(String.valueOf(descuentoGeneral));
  txt_totalpagar.setText(String.valueOf(totalPagarGeneral));
  }
    private void ObtenerIdCliente() {
        try {
            String sql = "select * from clientes where concat(nombre) = '" + this.jComboBox1_cliente.getSelectedItem() + "'";
         Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idCliente = rs.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener id del cliente, " + e);
        }
    }
      private void RestarStockProductos(int idProducto, int cantidad) {
        int cantidadProductosBaseDeDatos = 0;
        try {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
            String sql = "select idProducto, cantidad from productos where idProducto = '" + idProducto + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cantidadProductosBaseDeDatos = rs.getInt("cantidad");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 1, " + e);
        }

        try {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
            PreparedStatement consulta = cn.prepareStatement("update productos set cantidad=? where idProducto = '" + idProducto + "'");
            int cantidadNueva = cantidadProductosBaseDeDatos - cantidad;
            consulta.setInt(1, cantidadNueva);
            if(consulta.executeUpdate() > 0){
                //System.out.println("Todo bien");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 2, " + e);
        }
    }
}
