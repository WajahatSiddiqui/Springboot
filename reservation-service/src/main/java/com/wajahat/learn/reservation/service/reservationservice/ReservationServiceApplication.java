package com.wajahat.learn.reservation.service.reservationservice;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.data.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.stream.Stream;

@SpringBootApplication
public class ReservationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}
}


@Component
class CommandLineRunnerImpl implements CommandLineRunner {

	private ReservationRepository reservationRepository;

	@Autowired
	public CommandLineRunnerImpl(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// save
		Stream.of("Wajahat", "Raj", "Abdul", "Roy", "Tom", "Authur")
				.forEach(new Consumer<String>() {
					@Override
					public void accept(String reservationName) {
						reservationRepository.save(new Reservation(reservationName));
					}
				});
		// retrieve
		reservationRepository.findAll()
				.forEach(System.out::println);
	}
}


/*
@RestController
class ReservationController {
	private ReservationRepository reservationRepository;

	@Autowired
	public ReservationController(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public List<Reservation> getReservations() {
		return reservationRepository.findAll();
	}
}
*/

@RestController
class ReservationMvcController {
	private ReservationRepository reservationRepository;

	@Autowired
	public ReservationMvcController(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reservations.php")
	public String page(Model model) {
		model.addAttribute("reservations", reservationRepository.findAll());
		return "reservations"; // this needs to be in src/resources/templates
	}
}


@RepositoryRestResource
interface ReservationRepository extends JpaRepository<Reservation, Long> {

	// select * from reservations where reservationName = 'name';
	@RestResource(path = "by-name")
	Collection<Reservation> findByReservationName(@Param("name") String name);
}


@SpringUI(path = "/ui")
@Theme("valo")
class ReservationUI extends UI {
	@Override
	protected void init(VaadinRequest request) {
		Grid<Reservation> grid = new Grid<>();
		grid.setItems(reservationRepository.findAll());
		grid.setSizeFull();
		setContent(grid);
	}

	private ReservationRepository reservationRepository;

	@Autowired
	public ReservationUI(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}
}

@Entity
// table: reservations
class Reservation {
	@Id
	@GeneratedValue
	private Long Id; // column: Id

	private String reservationName; // column: reservationName

	Reservation() {}

	public Reservation(String reservationName) {
		this.reservationName = reservationName;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	@Override
	public String toString() {
		return "Reservation{" +
				"Id=" + Id +
				", reservationName='" + reservationName + '\'' +
				'}';
	}
}