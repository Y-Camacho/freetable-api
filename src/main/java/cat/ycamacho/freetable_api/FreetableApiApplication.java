package cat.ycamacho.freetable_api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cat.ycamacho.freetable_api.models.Admin;
import cat.ycamacho.freetable_api.models.Client;
import cat.ycamacho.freetable_api.models.Reservation;
import cat.ycamacho.freetable_api.models.Restaurant;
import cat.ycamacho.freetable_api.repositories.AdminRepository;
import cat.ycamacho.freetable_api.repositories.ClientRespository;
import cat.ycamacho.freetable_api.repositories.ReservationReposiroty;
import cat.ycamacho.freetable_api.repositories.RestaurantRepository;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class FreetableApiApplication implements CommandLineRunner {

	@Autowired
	private ClientRespository _ClientRespository;

	@Autowired
	private RestaurantRepository _RestaurantRepository;

	@Autowired
	private AdminRepository _AdminRepository;

	@Autowired
	private ReservationReposiroty _ReservationRepository;

	public static void main(String[] args) {
		SpringApplication.run(FreetableApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		seed();
	}

	@Transactional
	public void seed() {

		Admin admin = new Admin();
		admin.setName("Yostin Camacho");
		admin.setEmail("super@gmail.com");
		admin.setPassword("12345");

		_AdminRepository.save(admin);

		// RESTAURANTES
		Restaurant res1 = new Restaurant();
		res1.setAdmin(admin);
		res1.setAddress("Calle l'ensenyanza 23");
		res1.setName("El refujio del sabor");
		res1.setEmail("restaurant1@email.com");
		res1.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res1.setNumDiners(25);
		res1.setTagsString("mediterraneo,asiatico");
		res1.setImages(Arrays.asList("res_1_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res1);

		Restaurant res2 = new Restaurant();
		res2.setAdmin(admin);
		res2.setAddress("Calle l'ensenyanza 23");
		res2.setName("La Cueva del Chef");
		res2.setEmail("restaurant2@email.com");
		res2.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res2.setNumDiners(25);
		res2.setTagsString("parrilla,asiatico");
		res2.setImages(Arrays.asList("res_2_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res2);

		Restaurant res3 = new Restaurant();
		res3.setAdmin(admin);
		res3.setAddress("Calle l'ensenyanza 23");
		res3.setName("El Jardín de los Sabores");
		res3.setEmail("restaurant3@email.com");
		res3.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res3.setNumDiners(25);
		res3.setTagsString("vegano,vegetariano");
		res3.setImages(Arrays.asList("res_3_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res3);

		Restaurant res4 = new Restaurant();
		res4.setAdmin(admin);
		res4.setAddress("Calle l'ensenyanza 23");
		res4.setName("Sabores de la Tierra");
		res4.setEmail("restaurant4@email.com");
		res4.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res4.setNumDiners(25);
		res4.setTagsString("parrilla,italiano");
		res4.setImages(Arrays.asList("res_4_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res4);

		Restaurant res5 = new Restaurant();
		res5.setAdmin(admin);
		res5.setAddress("Calle l'ensenyanza 23");
		res5.setName("La Taberna de la Abuela");
		res5.setEmail("restaurant5@email.com");
		res5.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res5.setNumDiners(25);
		res5.setTagsString("parrilla,mediterraneo");
		res5.setImages(Arrays.asList("res_5_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res5);

		Restaurant res6 = new Restaurant();
		res6.setAdmin(admin);
		res6.setAddress("Avenida del Mar 10");
		res6.setName("Sabores del Sur");
		res6.setEmail("restTest6@gmail.com");
		res6.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res6.setNumDiners(25);
		res6.setTagsString("parrilla,mediterraneo");
		res6.setImages(Arrays.asList("res_5_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res6);

		Restaurant res7 = new Restaurant();
		res7.setAdmin(admin);
		res7.setAddress("Calle Sol Naciente 5");
		res7.setName("El Rincón de los Sabores");
		res7.setEmail("restTest7@gmail.com");
		res7.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res7.setNumDiners(25);
		res7.setTagsString("parrilla,mediterraneo");
		res7.setImages(Arrays.asList("res_5_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res7);

		Restaurant res8 = new Restaurant();
		res8.setAdmin(admin);
		res8.setAddress("Calle de la Esperanza 18");
		res8.setName("Fuego y Sabor");
		res8.setEmail("restTest8@gmail.com");
		res8.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res8.setNumDiners(25);
		res8.setTagsString("parrilla,mediterraneo");
		res8.setImages(Arrays.asList("res_5_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res8);

		Restaurant res9 = new Restaurant();
		res9.setAdmin(admin);
		res9.setAddress("Calle del Río 21");
		res9.setName("Brasa y Aroma");
		res9.setEmail("restTest9@gmail.com");
		res9.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res9.setNumDiners(25);
		res9.setTagsString("parrilla,mediterraneo");
		res9.setImages(Arrays.asList("res_5_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res9);

		Restaurant res10 = new Restaurant();
		res10.setAdmin(admin);
		res10.setAddress("Calle de las Flores 3");
		res10.setName("Sazón Mediterránea");
		res10.setEmail("restTest10@gmail.com");
		res10.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res10.setNumDiners(25);
		res10.setTagsString("parrilla,mediterraneo");
		res10.setImages(Arrays.asList("res_5_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res10);

		Restaurant res11 = new Restaurant();
		res11.setAdmin(admin);
		res11.setAddress("Paseo de la Luna 7");
		res11.setName("La Cazuela");
		res11.setEmail("restTest11@gmail.com");
		res11.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res11.setNumDiners(25);
		res11.setTagsString("parrilla,mediterraneo");
		res11.setImages(Arrays.asList("res_5_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res11);

		Restaurant res12 = new Restaurant();
		res12.setAdmin(admin);
		res12.setAddress("Calle del Bosque 12");
		res12.setName("Monte y Mar");
		res12.setEmail("restTest12@gmail.com");
		res12.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res12.setNumDiners(25);
		res12.setTagsString("parrilla,mediterraneo");
		res12.setImages(Arrays.asList("res_5_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res12);

		Restaurant res13 = new Restaurant();
		res13.setAdmin(admin);
		res13.setAddress("Camino Viejo 9");
		res13.setName("Raíces del Sabor");
		res13.setEmail("restTest13@gmail.com");
		res13.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res13.setNumDiners(25);
		res13.setTagsString("parrilla,mediterraneo");
		res13.setImages(Arrays.asList("res_5_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res13);

		Restaurant res14 = new Restaurant();
		res14.setAdmin(admin);
		res14.setAddress("Calle del Buen Gusto 15");
		res14.setName("El Fogón de Lola");
		res14.setEmail("restTest14@gmail.com");
		res14.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res14.setNumDiners(25);
		res14.setTagsString("parrilla,mediterraneo");
		res14.setImages(Arrays.asList("res_5_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res14);

		Restaurant res15 = new Restaurant();
		res15.setAdmin(admin);
		res15.setAddress("Plaza del Encuentro 4");
		res15.setName("Delicias del Puerto");
		res15.setEmail("restTest15@gmail.com");
		res15.setDescription("Un restaurante acogedor que ofrece una experiencia culinaria única, combinando ingredientes frescos y sabores tradicionales con un toque moderno. El ambiente relajado y la decoración rústica te invitan a disfrutar de cada plato como si estuvieras en casa.");
		res15.setNumDiners(25);
		res15.setTagsString("parrilla,mediterraneo");
		res15.setImages(Arrays.asList("res_5_banner.jpg", "res_default_1.jpg", "res_default_2.jpg", "res_default_3.jpg"));
		_RestaurantRepository.save(res15);


		// CLIENTES
		Client client1 = new Client();
		client1.setAdmin(admin);
		client1.setName("Juan Perez");
		client1.setEmail("juanPerez@gmail.com");
		client1.setNumberPhone("123456789");
		_ClientRespository.save(client1);
		
		Client client2 = new Client();
		client2.setAdmin(admin);
		client2.setName("Carlos Martin");
		client2.setEmail("carlosmartin@gmail.com");
		client2.setNumberPhone("123456789");
		_ClientRespository.save(client2);
		
		Client client3 = new Client();
		client3.setAdmin(admin);
		client3.setName("Maria Becerra");
		client3.setEmail("mariabecerra@gmail.com");
		client3.setNumberPhone("123456789");
		_ClientRespository.save(client3);
		
		Client client4 = new Client();
		client4.setAdmin(admin);
		client4.setName("Luisa Onail");
		client4.setEmail("luisaonail@gmail.com");
		client4.setNumberPhone("123456789");
		_ClientRespository.save(client4);
		
		Client client5 = new Client();
		client5.setAdmin(admin);
		client5.setName("Michael Jordan");
		client5.setEmail("Michael Jordan@gmail.com");
		client5.setNumberPhone("123456789");
		_ClientRespository.save(client5);
		
		// RESERVAS

		Reservation reserva1 = new Reservation();
		reserva1.setNumDiners(2);				
		reserva1.setDate(LocalDate.now());
		reserva1.setHour(LocalTime.now());
		reserva1.setClient(client1);
		reserva1.setRestaurant(res1);		

		Reservation reserva2 = new Reservation();
		reserva2.setNumDiners(4);			
		reserva2.setDate(LocalDate.now());
		reserva2.setHour(LocalTime.now());
		reserva2.setClient(client2);
		reserva2.setRestaurant(res2);		

		Reservation reserva3 = new Reservation();
		reserva3.setNumDiners(4);			
		reserva3.setDate(LocalDate.now());
		reserva3.setHour(LocalTime.now());
		reserva3.setClient(client3);
		reserva3.setRestaurant(res3);		

		Reservation reserva4 = new Reservation();
		reserva4.setNumDiners(5);			
		reserva4.setDate(LocalDate.now());
		reserva4.setHour(LocalTime.now());
		reserva4.setClient(client4);
		reserva4.setRestaurant(res4);		

		Reservation reserva5 = new Reservation();
		reserva5.setNumDiners(6);				
		reserva5.setDate(LocalDate.now());
		reserva5.setHour(LocalTime.now());
		reserva5.setClient(client1);
		reserva5.setRestaurant(res5);		

		Reservation reserva6 = new Reservation();
		reserva6.setNumDiners(3);			
		reserva6.setDate(LocalDate.now());
		reserva6.setHour(LocalTime.now());
		reserva6.setClient(client2);
		reserva6.setRestaurant(res1);		

		Reservation reserva7 = new Reservation();
		reserva7.setNumDiners(2);			
		reserva7.setDate(LocalDate.now());
		reserva7.setHour(LocalTime.now());
		reserva7.setClient(client3);
		reserva7.setRestaurant(res2);

		// Asignación de reservas

		// List<Reservation> cliente1Res = new ArrayList<>();
		// cliente1Res.add(reserva1);
		// cliente1Res.add(reserva5);
		
		// client1.setReservations(cliente1Res);

		// List<Reservation> cliente2Res = new ArrayList<>();
		// cliente2Res.add(reserva2);
		// cliente2Res.add(reserva6);
	
		// client2.setReservations(cliente2Res);

		// List<Reservation> cliente3Res = new ArrayList<>();
		// cliente3Res.add(reserva3);
		// cliente3Res.add(reserva7);
	
		// client3.setReservations(cliente3Res);

		// List<Reservation> cliente4Res = new ArrayList<>();
		// cliente4Res.add(reserva4);
		
		// client4.setReservations(cliente4Res);

		
		// List<Reservation> restaurante1Res = new ArrayList<>();
		// restaurante1Res.add(reserva1);
		// restaurante1Res.add(reserva6);

		// res1.setReservations(restaurante1Res);
		
		// List<Reservation> restaurante2Res = new ArrayList<>();
		// restaurante2Res.add(reserva2);
		// restaurante2Res.add(reserva7);

		// res2.setReservations(restaurante2Res);
		
		// List<Reservation> restaurante3Res = new ArrayList<>();
		// restaurante3Res.add(reserva3);

		// res3.setReservations(restaurante3Res);
		
		// List<Reservation> restaurante4Res = new ArrayList<>();
		// restaurante4Res.add(reserva4);

		// res4.setReservations(restaurante4Res);
		
		// List<Reservation> restaurante5Res = new ArrayList<>();
		// restaurante5Res.add(reserva5);

		// res5.setReservations(restaurante5Res);

		// PERSISTENCIA

		_RestaurantRepository.save(res1);
		_RestaurantRepository.save(res2);
		_RestaurantRepository.save(res3);
		_RestaurantRepository.save(res4);
		_RestaurantRepository.save(res5);

		_ClientRespository.save(client1);
		_ClientRespository.save(client2);
		_ClientRespository.save(client3);
		_ClientRespository.save(client4);
		_ClientRespository.save(client5);

		_ReservationRepository.save(reserva1);
		_ReservationRepository.save(reserva2);
		_ReservationRepository.save(reserva3);
		_ReservationRepository.save(reserva4);
		_ReservationRepository.save(reserva5);
		_ReservationRepository.save(reserva6);
		_ReservationRepository.save(reserva7);

	}

	

}
