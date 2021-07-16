package aplicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelos.Cliente;
import modelos.Factura;
import modelos.Producto;
import modelos.Proveedor;

public final class aplicacion {

    private static final int SALIR = 0;
    private static final int GESTION_CLIENTES = 1;
    private static final int GESTION_PROVEEDORES = 2;
    private static final int GESTION_PRODUCTOS = 3;
    private static final int GESTION_FACTURAS = 4;
    private static final int CREAR = 1;
    private static final int BUSCAR = 2;
    private static final int ACTUALIZAR = 3;
    private static final int ELIMINAR = 4;

    public static Scanner teclado;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        teclado = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        List<Proveedor> provedores = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();
        List<Factura> facturas = new ArrayList<>();

        int opcion;
        int opcionSubMenu;
        Cliente cliente;

        do {
            do {
                mostrarMenuPrincipal();
                opcion = capturarNumeroEntero("Digite la operacion a Realizar: ");
                if (opcion < SALIR || opcion > GESTION_FACTURAS) {
                    System.out.println("MENSAJE: Debe Digitar un Valor entre 0 y 4.");
                }
            } while (opcion < SALIR || opcion > GESTION_FACTURAS);

            if (opcion == SALIR) {
                break;
            }
            switch (opcion) {
                case GESTION_CLIENTES:

                    do {
                        mostrarSubMenu("Clientes");
                        opcionSubMenu = capturarNumeroEntero("Digite la operacion a Realizar: ");
                        if (opcionSubMenu < SALIR || opcionSubMenu > ELIMINAR) {
                            System.out.println("MENSAJE: Debe Digitar un Valor entre 0 y 4.");
                        }
                    } while (opcionSubMenu < SALIR || opcionSubMenu > ELIMINAR);

                    if (opcionSubMenu == SALIR) {
                        break;
                    }
                    switch (opcionSubMenu) {
                        case CREAR:
                            cliente = crearCliente(clientes);
                            clientes.add(cliente);
                            break;
                        case BUSCAR:
                            cliente = buscarCliente(clientes);

                            if (clientes != null) {
                                actualizarCliente(cliente);
                            } else {
                                System.out.println("MENSAJE: No se ha encontrado un cliente con ese número de cedula");
                            }
                            break;
                        case ACTUALIZAR:
                            cliente = buscarCliente(clientes);

                            if (clientes != null) {
                                mostrarDatosCliente(cliente);
                            } else {
                                System.out.println("MENSAJE: No se ha encontrado un cliente con ese número de cedula");
                            }
                            break;
                        case ELIMINAR:
                            eliminarCliente(clientes, facturas);
                            break;
                    }

                case GESTION_PROVEEDORES:
                    mostrarSubMenu("Proveedores");
                    break;
                case GESTION_PRODUCTOS:
                    mostrarSubMenu("Productos");
                    break;
                case GESTION_FACTURAS:
                    mostrarSubMenuFacturacion();
                    break;
            }

        } while (opcion != SALIR);

    }

    private static void eliminarCliente(List<Cliente> clientes, List<Factura> facturas) {
        int numeroCedula;
        String cedula;

        do {
            numeroCedula = capturarNumeroEntero("Digite el numero de la cedula del cliente");
            if (numeroCedula <= 0) {
                System.out.println("La cedula debe ser un número entero positivo");
                numeroCedula = 0;
                continue;
            }

        } while (numeroCedula <= 0);

        cedula = String.valueOf(numeroCedula);

        Cliente cliente = buscarClientePorCedula(clientes, cedula);

        if (cliente != null) {
            Factura factura = buscarFacturaPorCedula(facturas, cedula);
            if (factura == null) {
                clientes.remove(cliente);
                System.out.printf("MENSAJE: Se ha eliminado el cliente con el numero de cedula %s \n", cedula);
            } else {
                System.out.println("MENSAJE: No se puede eliminar el cliente. tiene una o mas facturas asignadas");
            }
        } else {
            System.out.println("MENSAJE: No se encontro un cliente con ese numero de cedula");
        }
    }

    private static Factura buscarFacturaPorCedula(List<Factura> facturas, String cedula) {
        for (Factura factura : facturas) {
            if (factura.getCedulaCliente().equals(cedula)) {
                return factura;
            }
        }
        return null;
    }

    private static void actualizarCliente(Cliente cliente) {
        System.out.println("---3. Actualizar Cliente---");
        int numeroCedula;
        int numeroTelefono;
        String cedula = "";
        String email;

        String nombres = capturarCadenaDeCaracteres("Digite el nuevo nombre del cliente");
        String apellidos = capturarCadenaDeCaracteres("Digite los nuevos apellidos del cliente");

        do {
            numeroTelefono = capturarNumeroEntero("Digite el nuevo número de telefono del cliente");
            if (numeroTelefono <= 0) {
                System.out.println("El número de telefono debe ser un número entero positivo");
                numeroTelefono = 0;
                continue;
            }
        } while (numeroTelefono <= 0);

        String direccion = capturarCadenaDeCaracteres("Digite la nueva dirección del cliente");

        while (true) {
            email = capturarCadenaDeCaracteres("Digite el nuevo email del cliente");
            if (!correoElectronicoValido(email)) {
                System.out.println("El correo electronico debe ser valido");
                continue;
            }
            break;
        }

        cliente.setNombres(nombres);
        cliente.setApellidos(apellidos);
        cliente.setTelefono(String.valueOf(numeroTelefono));
        cliente.setDireccion(direccion);
        cliente.setEmail(email);

    }

    private static void mostrarDatosCliente(Cliente cliente) {
        System.out.println("Datos del cliente");
        System.out.println("Cedula " + cliente.getCedula());
        System.out.println("Nombres " + cliente.getNombres());
        System.out.println("Apellido " + cliente.getApellidos());
        System.out.println("Telefono " + cliente.getTelefono());
        System.out.println("Dirección " + cliente.getDireccion());
        System.out.println("Email " + cliente.getEmail());
    }

    private static Cliente buscarCliente(List<Cliente> clientes) {
        int numeroCedula;
        String cedula;

        do {
            numeroCedula = capturarNumeroEntero("Digite el numero de la cedula del cliente");
            if (numeroCedula <= 0) {
                System.out.println("La cedula debe ser un número entero positivo");
                numeroCedula = 0;
                continue;
            }

        } while (numeroCedula <= 0);

        cedula = String.valueOf(numeroCedula);

        return buscarClientePorCedula(clientes, cedula);
    }

    private static Cliente crearCliente(List<Cliente> clientes) {
        System.out.println("---1. Crear Cliente---");
        int numeroCedula;
        int numeroTelefono;
        String cedula = "";
        String email;
        Cliente cliente;

        do {
            numeroCedula = capturarNumeroEntero("Digite el numero de la cedula del cliente nuevo");
            if (numeroCedula <= 0) {
                System.out.println("La cedula debe ser un número entero positivo");
                numeroCedula = 0;
                continue;
            }
            cedula = String.valueOf(numeroCedula);
            cliente = buscarClientePorCedula(clientes, cedula);
            if (cliente != null) {
                System.out.printf("MENSAJE: Ya existe otro cliente con numero de cedula: %s\n", cedula);
                numeroCedula = 0;
            }

        } while (numeroCedula <= 0);

        String nombres = capturarCadenaDeCaracteres("Digite el nombre del cliente nuevo");
        String apellidos = capturarCadenaDeCaracteres("Digite los apellidos del cliente nuevo");

        do {
            numeroTelefono = capturarNumeroEntero("Digite el número de telefono del cliente nuevo");
            if (numeroTelefono <= 0) {
                System.out.println("El número de telefono debe ser un número entero positivo");
                numeroTelefono = 0;
                continue;
            }
        } while (numeroTelefono <= 0);

        String direccion = capturarCadenaDeCaracteres("Digite la dirección del cliente nuevo");

        while (true) {
            email = capturarCadenaDeCaracteres("Digite el email del cliente nuevo");
            if (!correoElectronicoValido(email)) {
                System.out.println("El correo electronico debe ser valido");
                continue;
            }
            break;
        }

        cliente = new Cliente(cedula, nombres, apellidos, String.valueOf(numeroTelefono), direccion, email);
        return cliente;
    }

    private static Cliente buscarClientePorCedula(List<Cliente> clientes, String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    static boolean correoElectronicoValido(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("==MENU PRINCIPAL==");
        System.out.println("1. Gestion Clientes");
        System.out.println("2. Gestion Proveedores");
        System.out.println("3. Gestion Productos");
        System.out.println("4. Gestion Facturacion");
        System.out.println("0. Salir");
    }

    public static void mostrarSubMenu(String tipoMenu) {
        System.out.printf("**Menu Gestion %s**\n", tipoMenu);
        System.out.println("1. Crear");
        System.out.println("2. Buscar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.println("0. Salir");
    }

    public static void mostrarSubMenuFacturacion() {
        System.out.printf("**Menu Gestion Facturacion**\n");
        System.out.println("1. Crear");
        System.out.println("2. Buscar");
        System.out.println("3. Eliminar");
        System.out.println("0. Salir");
    }

    public static int capturarNumeroEntero(String mensaje) {
        while (true) {
            try {
                System.out.printf("%s: ", mensaje);
                return Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("MENSAJE: Digite un valor que corresponda con un número entero");
            }
        }
    }

    public static double capturarNumeroReal(String mensaje) {
        while (true) {
            try {
                System.out.printf("%s: ", mensaje);
                return Double.parseDouble(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("MENSAJE: Digite un valor que corresponda con un número real");
            }
        }
    }

    public static String capturarCadenaDeCaracteres(String mensaje) {
        String resultado;

        while (true) {
            System.out.printf("%s: ", mensaje);
            resultado = teclado.nextLine().strip();

            if (!resultado.isEmpty()) {
                return resultado;
            }
            System.out.println("MENSAJE: Especifique un valor correcto.");

        }
    }
}