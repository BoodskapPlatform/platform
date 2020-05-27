package io.boodskap.iot.model.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.model.IPerson;

@MappedSuperclass
public abstract class AbstractPerson extends AbstractContact implements IPerson {

	private static final long serialVersionUID = -8823527511832428112L;

	@Column(name="firstname", length=120)
	private String firstName = null;
	
	@Column(name="lastname", length=120)
	private String lastName = null;
	
	@Column(name="workstart")
	private int workHourStart = 8;
	
	@Column(name="workend")
	private int workHourEnd = 18;
	
	@ElementCollection(targetClass=Integer.class)
	@Column(name="workdays")
	private List<Integer> workDays = new ArrayList<>();

	public AbstractPerson(){
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final int getWorkHourStart() {
		return workHourStart;
	}

	public final void setWorkHourStart(int workHourStart) {
		this.workHourStart = workHourStart;
	}

	public final int getWorkHourEnd() {
		return workHourEnd;
	}

	public final void setWorkHourEnd(int workHourEnd) {
		this.workHourEnd = workHourEnd;
	}

	public final Collection<Integer> getWorkDays() {
		return workDays;
	}

	public final void setWorkDays(Collection<Integer> workDays) {
		this.workDays.clear();
		this.workDays.addAll(workDays);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((workDays == null) ? 0 : workDays.hashCode());
		result = prime * result + workHourEnd;
		result = prime * result + workHourStart;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractPerson other = (AbstractPerson) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (workDays == null) {
			if (other.workDays != null)
				return false;
		} else if (!workDays.equals(other.workDays))
			return false;
		if (workHourEnd != other.workHourEnd)
			return false;
		if (workHourStart != other.workHourStart)
			return false;
		return true;
	}
	
}
