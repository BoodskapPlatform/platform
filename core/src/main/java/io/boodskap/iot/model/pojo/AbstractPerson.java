package io.boodskap.iot.model.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.boodskap.iot.model.IPerson;

public abstract class AbstractPerson extends AbstractContact implements IPerson {

	private static final long serialVersionUID = -8823527511832428112L;

	private String firstName = null;
	private String lastName = null;
	private int workHourStart = 8;
	private int workHourEnd = 18;
	private List<Integer> workDays = new ArrayList<>();

	public AbstractPerson(){
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getWorkHourStart() {
		return workHourStart;
	}

	public void setWorkHourStart(int workHourStart) {
		this.workHourStart = workHourStart;
	}

	public int getWorkHourEnd() {
		return workHourEnd;
	}

	public void setWorkHourEnd(int workHourEnd) {
		this.workHourEnd = workHourEnd;
	}

	public Collection<Integer> getWorkDays() {
		return workDays;
	}

	public void setWorkDays(Collection<Integer> workDays) {
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
