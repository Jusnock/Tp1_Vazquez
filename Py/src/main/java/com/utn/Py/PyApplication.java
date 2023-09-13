package com.utn.Py;

import com.utn.Py.Repositorios.*;
import com.utn.Py.entidades.Cliente;
import com.utn.Py.entidades.DetallePedido;
import com.utn.Py.entidades.Domicilio;
import com.utn.Py.entidades.Pedido;
import com.utn.Py.entidades.Factura;
import com.utn.Py.entidades.Rubro;
import com.utn.Py.entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class PyApplication {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	RubroRepository rubroRepository;




	public static void main(String[] args) {
		SpringApplication.run(PyApplication.class, args);
	}

@Bean
CommandLineRunner init(ClienteRepository clienteRepository) {
	return args -> {
		System.out.println("ESTOY FUNCIONANDO");
		//carga de datos
		Cliente cliente1 = Cliente.builder()
				.nombre("Huevo")
				.apellido("Pelaterca")
				.telefono("2613615007")
				.email("Tachomovil@gmail.com")
				.build();
		Cliente cliente2=Cliente.builder()
				.nombre("Lagarto")
				.apellido("Catinga")
				.telefono("3613615007")
				.email("LagartoTerca@gmail.com")
				.build();

		Domicilio domicilio1 = Domicilio.builder()
				.calle("Tirasso")
				.numero("2669")
				.localidad("Rodeo del Medio")
				.build();

		Domicilio domicilio2 = Domicilio.builder()
				.calle("Barrio Unimev")
				.numero("1224")
				.localidad("Guaymallen")
				.build();
		Domicilio domicilio3= Domicilio.builder()
				.calle("Valle Iberluzea")
				.numero("465")
				.localidad("Godoy Cruz")
				.build();
		cliente1.agregarDomicilio(domicilio1);
		cliente1.agregarDomicilio(domicilio2);
		cliente2.agregarDomicilio(domicilio3);


		Pedido pedido1= Pedido.builder()
				.fecha(LocalDate.now())
				.estado("En preparacion")
				.tipoEnvio("A domicilio")
				.total(2000)
				.build();
		Pedido pedido2= Pedido.builder()
				.fecha(LocalDate.now())
				.estado("Recibido")
				.tipoEnvio("Retiro en local")
				.total(1000)
				.build();
		cliente1.agregarPedido(pedido1);
		cliente1.agregarPedido(pedido2);


		DetallePedido detalle1= DetallePedido.builder()
				.cantidad(1000)
				.subtotal(200)
				.build();
		DetallePedido detalle2= DetallePedido.builder()
				.cantidad(50000)
				.subtotal(10000)
				.build();
		pedido1.agregarDetalle(detalle1);
		pedido1.agregarDetalle(detalle2);
		Factura factura1=Factura.builder()
				.numero(1213)
				.fecha(LocalDate.now())
				.descuento(10)
				.total(100)
				.build();
		pedido1.setFactura(factura1);
		Factura factura2=Factura.builder()
				.numero(2113)
				.fecha(LocalDate.now())
				.descuento(20)
				.total(200)
				.build();
		pedido2.setFactura(factura2);



		Rubro rubro1=Rubro.builder()
				.denominacion("RUBRO 1")
				.build();
		Producto producto1= Producto.builder()
				.tipo("Insumo")
				.tiempoEstimadoCocina(1)
				.denominacion("Pan")
				.precioCompra(100)
				.precioVenta(200)
				.stockActual(12)
				.stockMinimo(2)
				.unidadMedida("KG")
				.receta("Harina y huevos")
				.build();

		Rubro rubro2=Rubro.builder()
				.denominacion("RUBRO 2")
				.build();
		Producto producto2= Producto.builder()
				.tipo("Insumo")
				.tiempoEstimadoCocina(1)
				.denominacion("Hamburgesa")
				.precioCompra(230)
				.precioVenta(600)
				.stockActual(120)
				.stockMinimo(26)
				.unidadMedida("unidad")
				.receta("Carne molida")
				.build();

		detalle1.setProducto(producto1);
		detalle2.setProducto(producto1);
		rubro1.agregarProductos(producto1);
		rubro2.agregarProductos(producto2);
		rubroRepository.save(rubro1);
		rubroRepository.save(rubro2);
		clienteRepository.save(cliente1);
		clienteRepository.save(cliente2);

		//consultas
		System.out.println("Cliente 1");
		Cliente clienterecuperado=clienteRepository.findById(cliente1.getId()).orElse(null);
		if(clienterecuperado!=null){
			System.out.println(("Nombre: "+clienterecuperado.getNombre()));
			System.out.println(("Apellido: "+clienterecuperado.getApellido()));
			System.out.println(("Telefono: "+clienterecuperado.getTelefono()));
			System.out.println(("Email: "+clienterecuperado.getEmail()));
			clienterecuperado.mostrarDomicilios();
		}




		};

	}

}
