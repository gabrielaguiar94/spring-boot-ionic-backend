package com.gabrielaguiar.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabrielaguiar.cursomc.domain.Address;
import com.gabrielaguiar.cursomc.domain.Category;
import com.gabrielaguiar.cursomc.domain.City;
import com.gabrielaguiar.cursomc.domain.Client;
import com.gabrielaguiar.cursomc.domain.Order;
import com.gabrielaguiar.cursomc.domain.OrderItem;
import com.gabrielaguiar.cursomc.domain.Payment;
import com.gabrielaguiar.cursomc.domain.PaymentWithBill;
import com.gabrielaguiar.cursomc.domain.PaymentWithCard;
import com.gabrielaguiar.cursomc.domain.Product;
import com.gabrielaguiar.cursomc.domain.State;
import com.gabrielaguiar.cursomc.domain.enums.StatePayment;
import com.gabrielaguiar.cursomc.domain.enums.TypeClient;
import com.gabrielaguiar.cursomc.repositories.AddressRepository;
import com.gabrielaguiar.cursomc.repositories.CategoryRepository;
import com.gabrielaguiar.cursomc.repositories.CityRepository;
import com.gabrielaguiar.cursomc.repositories.ClientRepository;
import com.gabrielaguiar.cursomc.repositories.OrderItemRepository;
import com.gabrielaguiar.cursomc.repositories.OrderRepository;
import com.gabrielaguiar.cursomc.repositories.PaymentRepository;
import com.gabrielaguiar.cursomc.repositories.ProductRepository;
import com.gabrielaguiar.cursomc.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoriaRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		Category cat3 = new Category(null, "Bed, table, bath");
		Category cat4 = new Category(null, "Electronics");
		Category cat5 = new Category(null, "Garden");
		Category cat6 = new Category(null, "Decoration");
		Category cat7 = new Category(null, "Perfumery");

		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategory().addAll(Arrays.asList(cat1));
		p2.getCategory().addAll(Arrays.asList(cat1, cat2));
		p3.getCategory().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		State st1 = new State(null, "Minas Gerais");
		State st2 = new State(null, "São Paulo");

		City c1 = new City(null, "Uberlandia", st1);
		City c2 = new City(null, "São Paulo", st2);
		City c3 = new City(null, "Campinas", st2);

		st1.getCities().addAll(Arrays.asList(c1));
		st2.getCities().addAll(Arrays.asList(c2, c3));

		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

		Client cli1 = new Client(null, "Maria", "maria@gmail.com", "36378912377", TypeClient.PESSOAFISICA);

		cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));

		Address ad1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Address ad2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

		cli1.getAdresses().addAll(Arrays.asList(ad1, ad2));

		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(ad1, ad2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Order ord1 = new Order(null, sdf.parse("30/09/2017 10:32"), cli1, ad1);
		Order ord2 = new Order(null, sdf.parse("10/10/2017 19:35"), cli1, ad2);

		Payment pay1 = new PaymentWithCard(null, StatePayment.QUITADO, ord1, 6);
		ord1.setPayment(pay1);

		Payment pay2 = new PaymentWithBill(null, StatePayment.PENDENTE, ord2, sdf.parse("20/10/2017 00:00"), null);
		ord2.setPayment(pay2);

		cli1.getOrders().addAll(Arrays.asList(ord1, ord2));

		orderRepository.saveAll(Arrays.asList(ord1, ord2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));

		OrderItem oi1 = new OrderItem(ord1, p1, 0.00, 1, 2000.00);
		OrderItem oi2 = new OrderItem(ord1, p3, 0.00, 2, 80.00);
		OrderItem oi3 = new OrderItem(ord2, p2, 100.0, 1, 800.00);

		ord1.getItems().addAll(Arrays.asList(oi1, oi2));
		ord2.getItems().addAll(Arrays.asList(oi3));

		p1.getItems().addAll(Arrays.asList(oi1));
		p2.getItems().addAll(Arrays.asList(oi2));
		p3.getItems().addAll(Arrays.asList(oi3));

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));

	}

}
