package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import io.boodskap.iot.model.IRecordField;

@Embeddable
public class RecordField extends AbstractField implements IRecordField {

	private static final long serialVersionUID = 2617723620254661858L;

	@Column(name="indexed")
	private boolean indexed;

	@Column(name="fullindexed")
	private boolean fulltextIndexed;
	
	public RecordField(){
	}

	public boolean isIndexed() {
		return indexed;
	}

	public void setIndexed(boolean indexed) {
		this.indexed = indexed;
	}

	public boolean isFulltextIndexed() {
		return fulltextIndexed;
	}

	public void setFulltextIndexed(boolean fulltextIndexed) {
		this.fulltextIndexed = fulltextIndexed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (fulltextIndexed ? 1231 : 1237);
		result = prime * result + (indexed ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecordField other = (RecordField) obj;
		if (fulltextIndexed != other.fulltextIndexed)
			return false;
		if (indexed != other.indexed)
			return false;
		return true;
	}

}
