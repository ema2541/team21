package se.g21.backend.employeesystem.entities;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Date;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Employee")
public class Employee {
	@Id
	@SequenceGenerator(name = "Employee_seq", sequenceName = "Employee_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Employee_seq")
	@Column(name = "Employee_ID", unique = true, nullable = true)
	private @NonNull Long id;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Nametitle.class)
	@JoinColumn(name = "Nametitle_ID", insertable = true)
	private @NonNull Nametitle nametitle;

	@Column(name = "Fullname")
	private @NonNull String fullname;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
	@JoinColumn(name = "Gender_ID", insertable = true)
	private @NonNull Gender gender;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Position.class)
	@JoinColumn(name = "Position_ID", insertable = true)
	private @NonNull Position position;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
	@JoinColumn(name = "Province_ID", insertable = true)
	private @NonNull Province province;

	@Column(name = "Address")
	private @NonNull String address;

	@Column(name = "Username")
	private @NonNull String username;

	@Column(name = "Password")
	private @NonNull String password;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "RecordDate")
	private @NonNull Date recorddate;

}