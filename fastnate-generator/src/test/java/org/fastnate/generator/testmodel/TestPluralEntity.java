package org.fastnate.generator.testmodel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import lombok.Getter;
import lombok.Setter;

/**
 * An entity for testing collections in SQL generation.
 *
 * @author Tobias Liefke
 */
@Entity
@Getter
@Setter
public class TestPluralEntity {

	@Id
	private Long id;

	@ElementCollection
	private Set<String> stringSet = new HashSet<>();

	@ElementCollection
	@CollectionTable(name = "STRING_LIST", joinColumns = @JoinColumn(name = "myEntityId"))
	@Column(name = "stringColumn")
	private List<String> stringList = new ArrayList<>();

	@ElementCollection
	@OrderColumn
	private List<String> orderedStringList = new ArrayList<>();

	@ElementCollection
	@Embedded
	@OrderColumn
	private List<TestPluralEntityProperty> embeddedList = new ArrayList<>();

	@ManyToMany
	private Set<TestSingularEntity> entitySet = new HashSet<>();

	@OneToMany
	@JoinTable(name = "ENTITY_LIST")
	private List<TestSingularEntity> entityList = new ArrayList<>();

	@OneToMany
	@JoinTable(name = "OE_LIST", joinColumns = @JoinColumn(name = "join_id"))
	@OrderColumn(name = "sorting")
	private List<TestSingularEntity> orderedEntityList = new ArrayList<>();

}
