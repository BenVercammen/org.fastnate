package org.fastnate.generator.testmodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity to test primitive properties and .
 * 
 * @author Tobias Liefke
 */
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NamedQuery(name = TestSingularEntity.NQ_ENTITY_BY_NAME, query = "SELECT e FROM TestSingularEntity e WHERE e.name = :name")
public class TestSingularEntity {

	/**
	 * Name query to find entity by :name.
	 */
	public static final String NQ_ENTITY_BY_NAME = "singularEntityByName";

	private static final int NAME_LENGTH = 30;

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = NAME_LENGTH, unique = true)
	@NotNull
	@Size(min = 1)
	private String name;

	@Transient
	private String transient1;

	private transient String transient2;

	private String description;

	private char testChar;

	private boolean testBoolean;

	private byte testByte;

	private short testShort;

	private int testInt;

	private long testLong;

	private float testFloat;

	private double testDouble;

	@Temporal(TemporalType.DATE)
	private Date testDate;

	@Temporal(TemporalType.TIME)
	private Date testTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date testTimestamp;

	@Lob
	private char[] manyCharacters;

	@Lob
	private byte[] manyBytes;

	/**
	 * Creates a new instance of {@link TestSingularEntity}.
	 * 
	 * @param name
	 *            the name of the entity
	 */
	public TestSingularEntity(final String name) {
		this.name = name;
	}

	@Override
	public boolean equals(final Object obj) {
		return this.id == null ? this == obj : obj instanceof TestSingularEntity
				&& this.id.equals(((TestSingularEntity) obj).id);
	}

	@Override
	public int hashCode() {
		return this.id == null ? super.hashCode() : this.id.hashCode();
	}

	@Override
	public String toString() {
		return "TestSingularEntity: " + (this.id == null ? '@' + hashCode() : this.id);
	}

}
